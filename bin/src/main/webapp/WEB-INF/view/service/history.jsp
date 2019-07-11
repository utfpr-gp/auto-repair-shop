<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template title="Histórico de atendimento">
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <div class="row">
                        <div class="col s12 form" height="100%">
                            <div class="content-form">
                                <div class="title-form left">Histórico de atendimento</div>
                                <div class="input-field col s4 right">
                                    <i class="material-icons prefix">search</i>
                                    <input placeholder="Pesquisar" type="text" class="validate">
                                </div>
                                <table class="highlight centered">
                                    <thead>
                                    <tr>
                                        <th>Mecânico</th>
                                        <th>Cliente</th>
                                        <th>Veiculo</th>
                                        <th>Descrição</th>
                                        <th>Preço total</th>
                                        <th>Data</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <c:forEach var="s" items="${services}">
                                        <tr>
                                            <td><a class="waves-effect waves-light btn-flat modal-trigger tooltipped" data-position="bottom" data-tooltip="Clique para ver informações sobre o mecânico" href="#modal-mechanic-${s.id}">${s.employee.name}</a></td>
                                            <td><a class="waves-effect waves-light btn-flat modal-trigger tooltipped" data-position="bottom" data-tooltip="Clique para ver informações sobre o cliente" href="#modal-client-${s.id}">${s.client.name}</a></td>
                                            <td><a class="waves-effect waves-light btn-flat modal-trigger tooltipped" data-position="bottom" data-tooltip="Clique para ver mais informações sobre este veiculo" href="#modal-vehicle-${s.id}">${s.vehicle.model}</a>
                                            </td>
                                            <td>${s.description}</td>
                                            <td><a class="waves-effect waves-light btn-flat modal-trigger tooltipped" data-position="bottom" data-tooltip="Clique para ver detalhes sobre o custo" href="#modal-price-${s.id}">R$ ${s.totalPrice}</a></td>
                                            <td>${s.date}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>

                                </table>
                                <c:forEach var="s" items="${services}">
                                    <div id="modal-vehicle-${s.id}" class="modal">
                                        <div class="modal-content">
                                            <h4 class="header">Informações do veiculo</h4>
                                            <table class="highlight">
                                                <tbody>
                                                <tr>
                                                    <td><b>Modelo</b></td>
                                                    <td>${s.vehicle.model}</td>
                                                </tr>
                                                <tr>
                                                    <td><b>Placa</b></td>
                                                    <td>${s.vehicle.placa}</td>
                                                </tr>
                                                <tr>
                                                    <td><b>Marca</b></td>
                                                    <td>${s.vehicle.brand}</td>
                                                </tr>
                                                <tr>
                                                    <td><b>Cor</b></td>
                                                    <td>${s.vehicle.color}</td>
                                                </tr>
                                                </tbody>
                                            </table>
                                            <h5 class="header">Imagem do veiculo</h5>
                                            <img class="materialboxed tooltipped" data-position="bottom" data-tooltip="Clique na imagem para expandir ou retornar ao tamanho normal" width="150" src="vehicle${s.vehicle.id}.png">
                                        </div>

                                        <div class="modal-footer">
                                            <a href="#!" class="modal-close waves-effect waves-green btn-flat">OK</a>
                                        </div>
                                    </div>
                                </c:forEach>
                                <ul class="pagination right">
                                    <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
                                    <li class="active"><a href="#!">1</a></li>
                                    <li class="waves-effect"><a href="#!">2</a></li>
                                    <li class="waves-effect"><a href="#!">3</a></li>
                                    <li class="waves-effect"><a href="#!">4</a></li>
                                    <li class="waves-effect"><a href="#!">5</a></li>
                                    <li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:template>