<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:admin title="Cadastro de funcionário">
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <div class="row">
                        <div class="col s12 form" height="550px">
                            <div class="content-form">
                                <div class="title-form">Cadastro de funcionário</div>
                                <form method="post">
                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">person</i>
                                            <input id="name" name="name" type="text">
                                            <label for="name">Nome completo</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">map</i>
                                            <select id="addrress" name="addrress">
                                                <option value="" disabled selected>Selecione</option>
                                                <c:forEach var="a" items="${addresses}">
                                                    <option value="${a.id}">${a.street}, ${a.number}, ${a.city}</option>
                                                </c:forEach>
                                            </select>
                                            <label>Endereço</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">phone</i>
                                            <input id="phone" name="phone" type="text">
                                            <label for="phone">Telefone</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">phone_android</i>
                                            <input id="cellular" name="cellular" type="text">
                                            <label for="cellular">Celular</label>
                                        </div>
                                    </div>
                                    <h5 class="header">Dados de acesso</h5>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix">email</i>
                                        <input id="email" type="email" class="validate">
                                        <label for="email">Email</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix">lock</i>
                                        <input id="password" type="password" class="validate">
                                        <label for="password">Senha</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix">done_all</i>
                                        <input id="reemail" type="email" class="validate">
                                        <label for="reemail">Confirmação de email</label>
                                        <span class="helper-text" data-error="incorreto" data-success="correto"></span>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix">done_all</i>
                                        <input id="repassword" type="password" class="validate">
                                        <label for="repassword">Confirmação de senha</label>
                                    </div>

                                    <div class="action-form">
                                        <button type="submit" class="btn-flat">Cadastrar funcionário</button>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:admin>