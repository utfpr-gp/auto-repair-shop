<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:admin title="Relatório de atendimento">
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <div class="row">
                        <div class="col s12 form" height="100%">
                            <div class="content-form">
                                <div class="title-form">Relatório de atendimento</div>
                                <p class="header col s12 m12 l4 left">Selecione o mês no gráfico ou escolha um intervalo de datas específicas, o mês anterior é mostrado por padrão.</p>
                                <div class="row col s12 m12 l6 right">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix">date_range</i>
                                        <input id="initial-date" name="initial-date" type="text" class="datepicker">
                                        <label for="initial-date">Data inicial</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix">date_range</i>
                                        <input id="final-date" name="final-date" type="text" class="datepicker">
                                        <label for="final-date">Data final</label>
                                    </div>
                                </div>

                                <canvas id="myChart" width="400" height="100"></canvas>
                                <h5 class="header">Atendimentos de maio</h5>
                                <table class="striped centered">
                                    <thead>
                                    <tr>
                                        <th>Qantidade total de atendimentos</th>
                                        <th>Valor total de peças e produtos</th>
                                        <th>Valor total de mão de obra</th>
                                        <th>Valor total dos atendimentos</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <tr>
                                        <td>${totalQuantity}</td>
                                        <td>R$ ${totalPriceParts}</td>
                                        <td>R$ ${totalHandWorkPrice}</td>
                                        <td>R$ ${totalPrice}</td>
                                    </tr>
                                    </tbody>
                                </table>
                                <table class="centered">
                                    <thead>
                                    <tr>
                                        <th>Serviços realizados</th>
                                        <th>Quantidade de serviços</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="s" items="${services}">
                                            <tr>
                                                <td>${s.description}</td>
                                                <td>${s.quantity}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>

                                </table>
                                <table class="highlight centered">
                                    <thead>
                                    <tr>
                                        <th>Mecânico</th>
                                        <th>Cliente</th>
                                        <th>Veiculo</th>
                                        <th>Descrição</th>
                                        <th>Lucro</th>
                                        <th>Data</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <c:forEach var="a" items="${allServices}">
                                        <tr>
                                            <td>${s.employee.name}</td>
                                            <td>${s.client.name}</td>
                                            <td>${s.vehicle.name}</td>
                                            <td>${s.description}</td>
                                            <td>R$ ${s.priceHandWork}</td>
                                            <td>${s.date}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%--Grafico do Relatorio--%>

        <script>
            var ctx = document.getElementById('myChart').getContext('2d');
            var myChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho'],
                    datasets: [{
                        label: 'Quantidade de atendimentos',
                        data: [29, 41, 25, 10, 14, 4],
                        backgroundColor: [
                            'rgba(54, 162, 235, 0.2)'
                        ],
                        borderColor: [
                            'rgba(54, 162, 235, 1)'
                        ],
                        borderWidth: 1
                    }]
                }
            });
        </script>
    </jsp:body>
</t:admin>