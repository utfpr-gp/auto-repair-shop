<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template title="Veículos">
    <jsp:body>
        <div class="container">
            <h1 class="header">Meus Veículos</h1>
            <a href="veiculos/novo" class="btn-floating btn-small waves-effect waves-light blue"><i
                    class="material-icons" title="Cadastrar veículo">add</i></a>
            <c:if test="${not empty vehicles}">
                <table>
                    <thead>
                    <tr>
                        <th>Cliente</th>
                        <th>Modelo</th>
                        <th>Marca</th>
                        <th>Placa</th>
                        <th></th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="vehicle" items="${vehicles}">
                        <tr>
                            <td>${vehicle.client.getName()}</td>
                            <td>${vehicle.model}</td>
                            <td>${vehicle.color}</td>
                            <td>${vehicle.placa}</td>
                            <td>
                                <a href="veiculos/${vehicle.registration}"><i class="material-icons">edit</i></a>
                                <a href="#modal-delete" class="modal-trigger" data-url="${pageContext.request.contextPath}/veiculos/${vehicle.id}" data-name="${vehicle.placa}"><i class="material-icons red-text">delete</i></a>

                            </td>
                        </tr>
                    </c:forEach>
                    <div id="modal-delete" class="modal">
                        <form action="" method="post">

                            <input type="hidden" name="_method" value="DELETE"/>

                            <div class="modal-content">
                                <h4>Você tem certeza que deseja remover o veículo com a placa <strong id="strong-name"></strong>?</h4>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="modal-close btn-flat waves-effect waves-light grey">Cancelar</button>
                                <button type="submit" class="modal-close btn waves-effect waves-light gray">Sim</button>
                            </div>
                        </form>
                    </div>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty vehicles}">
                <h3 class="header">Sem veículos cadastrados</h3>
            </c:if>
        </div>
    </jsp:body>
</t:template>