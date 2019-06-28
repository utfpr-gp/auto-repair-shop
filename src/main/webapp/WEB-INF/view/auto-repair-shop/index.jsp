<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template title="Oficinas">
    <jsp:body>
        <div class="container">
            <h1 class="header">Oficinas</h1>
            <a href="oficinas/novo" class="btn-floating btn-small waves-effect waves-light blue"><i
                    class="material-icons" title="Cadastrar Oficina">add</i></a>
            <c:if test="${not empty autoRepairShops}">
                <table>
                    <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Cnpj</th>
                        <th>Telefone</th>
                        <th></th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="autoRepairShop" items="${autoRepairShops}">
                        <tr>
                            <td>${autoRepairShop.name}</td>
                            <td>${autoRepairShop.cnpj}</td>
                            <td>${autoRepairShop.telephone}</td>
                            <td>
                                <a href="oficinas/${autoRepairShop.id}"><i class="material-icons">edit</i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty autoRepairShops}">
                <h3 class="header">Sem Oficinas cadastradas</h3>
            </c:if>
        </div>
    </jsp:body>
</t:template>