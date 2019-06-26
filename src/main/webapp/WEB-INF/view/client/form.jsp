<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                                <form action="clientes/cadastro" method="post">
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <i class="material-icons prefix">person</i>
                                            <input id="name" name="name" type="text" value="${dto.name}">
                                            <label for="name">Nome completo</label>

                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">credit_card</i>
                                            <input id="cpf" name="cpf" type="text">
                                            <label for="cpf">CPF</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">art_track</i>
                                            <input id="rg" name="rg" type="text">
                                            <label for="rg">RG</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <label for="cep">Cep</label>
                                            <input id="cep" name="cep" type="text" value="${dto.cep}">
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="state" name="state" type="text" value="${dto.state}">
                                            <label for="state">Estado</label>
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="city" name="city" type="text" value="${dto.city}">
                                            <label for="city">Cidade</label>
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="street" name="street" type="text" value="${dto.street}">
                                            <label for="street">Rua</label>
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="number" name="number" type="text" value="${dto.number}">
                                            <label for="number">Numero</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">date_range</i>
                                            <input id="birthDate" name="birthDate" class="datepicker" value="${dto.birthDate}">
                                            <label for="birthDate">Data de nascimento</label>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">phone</i>
                                            <input id="telephone" name="telephone" type="text" value="${dto.telephone}>
                                            <label for="telephone">Telefone</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">phone_android</i>
                                            <input id="cellular" name="cellular" type="text">
                                            <label for="cellular">Celular</label>
                                        </div>
                                    </div>
                                    <div class="input-field col s12">
                                        <h5 class="header">Sexo</h5>
                                        <p>
                                            <label>
                                                <input name="sex" value="m" type="radio" />
                                                <span>Masculino</span>
                                            </label>
                                        </p>
                                        <p>
                                            <label>
                                                <input name="sex" value="f" type="radio" />
                                                <span>Feminino</span>
                                            </label>
                                        </p>
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