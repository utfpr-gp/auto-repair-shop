<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<t:template title="Novo Cliente">
    <jsp:body>


    <h1>Cadastro Cliente</h1>
        <c:if test="${not empty errors}">
            <div class="card-panel red">
                <c:forEach var="e" items="${errors}">
                    <span class="white-text">${e.getDefaultMessage()}</span><br>
                </c:forEach>
            </div>
        </c:if>

        <div class="row col s12">
            <form action="clientes/cadastro" method="post">
                <label for="name">Nome Completo</label>
                <input name="name" type="text" value="${dto.name}">

                <label for="cep">Cep</label>
                <input name="cep" type="text" value="${dto.cep}">

                <label for="state">Estado</label>
                <input name="state" type="text" value="${dto.state}">

                <label for="city">Cidade</label>
                <input name="city" type="text" value="${dto.city}">

                <label for="street">Rua</label>
                <input name="street" type="text" value="${dto.street}">

                <label for="number">Numero</label>
                <input name="number" type="text" value="${dto.number}">

                <label for="birthDate">Data Nascimento</label>
                <input name="birthDate" type="date" value="${dto.birthDate}">

                <label for="telephone">Telefone</label>
                <input name="telephone" type="text" value="${dto.telephone}">

                <label for="email">Email</label>
                <input name="email" type="text" value="${dto.email}">

                <label for="password">Senha</label>
                <input name="password" type="password">

                <button class="btn waves-effect right" type="submit">Proximo
                    <i class="material-icons right">save</i>
                </button>
            </form>
        </div>


    </jsp:body>
</t:template>