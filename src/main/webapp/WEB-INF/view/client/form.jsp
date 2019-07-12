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
            <c:if test="${not empty passwordError}">
                <div class="card-panel red">
                        <span class="white-text">${passwordError}</span><br>
                </div>
            </c:if>
            <c:if test="${not empty emailError}">
                <div class="card-panel red">
                    <span class="white-text">${emailError}</span><br>
                </div>
            </c:if>
            <div class="row">
                <div class="col s12">
                    <div class="row">
                        <div class="col s12 form" height="850px">
                            <div class="content-form">
                                <div class="title-form">Cadastro de cliente</div>
                                <c:if test="${dto.id == null}">
                                <form action="clientes" method="post">
                                </c:if>
                                    <c:if test="${dto.id != null}">
                                    <form action="clientes/${dto.id}" method="post">
                                        <input type="hidden" name="_method" value="PUT" />
                                    </c:if>
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <i class="material-icons prefix">person</i>
                                            <input id="name" name="name" type="text" value="${dto.name}">
                                            <label for="name">Nome completo</label>

                                        </div>
                                        <div class="input-field col s6">
                                            <label for="cep">Cep</label>
                                            <input id="cep" name="cep" type="text" value="${addressDto.cep}" maxlength="8">
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="state" name="state" type="text" value="${addressDto.state}" maxlength="2">
                                            <label for="state">Estado</label>
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="city" name="city" type="text" value="${addressDto.city}">
                                            <label for="city">Cidade</label>
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="street" name="street" type="text" value="${addressDto.street}">
                                            <label for="street">Rua</label>
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="number" name="number" type="text" value="${addressDto.number}">
                                            <label for="number">Numero</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">date_range</i>
                                            <label for="birthDate">Data de Nascimento</label>
                                            <fmt:formatDate value="${dto.birthDate}" var="dateFormatted" type="date" pattern="dd/MM/yyyy"/>
                                            <input id="birthDate" name="birthDate"  type="text" value="${dateFormatted}" readonly="true"/>
                                        </div>

                                    </div>

                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">phone</i>
                                            <input id="telephone" name="telephone" type="text" value="${dto.telephone}" maxlength="11">
                                            <label for="telephone">Telefone</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">mail</i>
                                        <c:if test="${dto.id == null}">
                                            <input id="email" name="email" type="text" value="${credentialDto.email}">
                                        </c:if>
                                            <c:if test="${dto.id != null}">
                                                <input id="email" name="email" type="text" readonly value="${credentialDto.email}">
                                            </c:if>
                                            <label for="email">Email</label>
                                        </div>

                                        <c:if test="${dto.id == null}">
                                            <div class="input-field col s6">
                                                <input id="password" name="password" type="password" value="" required>
                                                <label for="password">Senha</label>
                                            </div>
                                            <div class="input-field col s6">
                                                <input id="passwordConfirmation" required name="passwordConfirmation" type="password" value="">
                                                <label for="passwordConfirmation">Confirmação Senha</label>
                                            </div>
                                        </c:if>
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