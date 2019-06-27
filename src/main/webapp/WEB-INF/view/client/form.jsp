<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<t:template title="Cadastro de clientes">
    <jsp:body>
        <div class="container">
            <c:if test="${not empty message}">
                <script>M.toast({html: "${message}", classes: 'rounded'})</script>
            </c:if>

            <c:if test="${not empty errors}">
                <div class="card-panel red">
                    <c:forEach var="e" items="${errors}">
                        <span class="white-text">${e.getDefaultMessage()}</span><br>
                    </c:forEach>
                </div>
            </c:if>
            <div class="row">
                <div class="col s12">
                    <div class="row">
                        <div class="col s12 form" height="850px">
                            <div class="content-form">
                                <div class="title-form">Cadastro de cliente</div>
                                <form action="clientes/novo" method="post">
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <i class="material-icons prefix">person</i>
                                            <input id="name" name="name" type="text" value="${dtoClient.name}">
                                            <label for="name">Nome completo</label>

                                        </div>
                                        <div class="input-field col s6">
                                            <label for="cep">Cep</label>
                                            <input id="cep" name="cep" type="text" value="${dtoAddress.cep}">
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="state" name="state" type="text" value="${dtoAddress.state}">
                                            <label for="state">Estado</label>
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="city" name="city" type="text" value="${dtoAddress.city}">
                                            <label for="city">Cidade</label>
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="street" name="street" type="text" value="${dtoAddress.street}">
                                            <label for="street">Rua</label>
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="number" name="number" type="text" value="${dtoAddress.number}">
                                            <label for="number">Numero</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">date_range</i>
                                            <label for="birthDate">Data de Nascimento</label>
                                            <fmt:formatDate value="${dtoClient.birthDate}" var="dateFormatted" type="date" pattern="dd/MM/yyyy"/>
                                            <input id="birthDate" name="birthDate"  type="text" value="${dateFormatted}"/>
                                        </div>

                                    </div>

                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">phone</i>
                                            <input id="telephone" name="telephone" type="text" value="${dtoClient.telephone}">
                                            <label for="telephone">Telefone</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">mail</i>
                                            <input id="email" name="email" type="text" value="${dtoCredential.email}">
                                            <label for="email">Email</label>
                                        </div>
                                        <input name="role" type="hidden" value="client">
                                    </div>
                                    <div class="action-form">
                                        <button type="submit" class="btn-flat">Cadastrar cliente</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:template>