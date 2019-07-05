<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="Funcionarios">
    <jsp:body>
        <div class="container">
                    <c:if test="${not empty message}">
                <script>M.toast({html: "${message}", classes: 'rounded'})</script>
            </c:if>
            
            <h1 class="header">Funcionários</h1>
            <a href="funcionarios/novo" class="btn-floating btn-small waves-effect waves-light blue"><i
                    class="material-icons" title="Cadastrar Funcionário">add</i></a>
            <c:if test="${not empty employees}">
                <table>
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Telefone</th>
                        <th></th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="employee" items="${employees}">
                        <tr>
                            <td>${employee.id}</td>
                            <td>${employee.name}</td>
                            <td>${employee.telephone}</td>
                            <td>
                                <a href="funcionarios/${employee.id}"><i class="material-icons">edit</i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty employee}">
                <h3 class="header">Sem Funcionários cadastrados</h3>
            </c:if>
        </div>
    </jsp:body>
</t:template>