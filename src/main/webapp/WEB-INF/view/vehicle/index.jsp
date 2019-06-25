<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template title="Veículos">
    <jsp:body>
        <div class="container">
            <h1>Veículos</h1>
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
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty vehicles}">
                <h3>Sem veículos cadastrados</h3>
            </c:if>
        </div>
    </jsp:body>
</t:template>