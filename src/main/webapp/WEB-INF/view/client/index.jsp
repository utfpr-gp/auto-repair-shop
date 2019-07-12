<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template title="Clientes">
    <jsp:body>
        <div class="container">
            <h1 class="header">Clientes</h1>
            <a href="clientes/novo" class="btn-floating btn-small waves-effect waves-light blue"><i
                    class="material-icons" title="Cadastrar cliente">add</i></a>
            <c:if test="${not empty clients}">
                <table>
                    <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Telefone</th>
                        <th>Email</th>
                        <th></th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="cliente" items="${clients}">
                        <tr>
                            <td>${cliente.name}</td>
                            <td>${cliente.telephone}</td>
                            <td>${cliente.credentialDto.email}</td>
                            <td>
                                <a href="clientes/${cliente.id}"><i class="material-icons">edit</i></a>
                            </td>
                            <td>
                                <a href="#modal-delete" class="modal-trigger" data-url="${pageContext.request.contextPath}/clientes/${cliente.id}" data-name="${cliente.name}"><i class="material-icons red-text">delete</i></a>
                            </td>
                        </tr>
                        <div id="modal-delete" class="modal">
                            <form action="clientes/${cliente.id}" method="post">

                                <input type="hidden" name="_method" value="DELETE"/>

                                <div class="modal-content">
                                    <h4>Você tem certeza que deseja remover <strong id="strong-name"></strong>?</h4>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="modal-close btn-flat waves-effect waves-light grey">Cancelar</button>
                                    <button type="submit" class="modal-close btn waves-effect waves-light gray">Sim</button>
                                </div>
                            </form>
                        </div>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty clients}">
                <h3 class="header">Sem clientes cadastrados</h3>
            </c:if>
        </div>
    </jsp:body>
</t:template>