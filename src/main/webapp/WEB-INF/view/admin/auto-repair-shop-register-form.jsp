<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:admin title="Cadastro de oficinas">
    <jsp:body>
        <div class="container">
            <%--<c:if test="${not empty message}">
                <div class="card-panel green lighten-1">
                    <span class="white-text">${message}</span>
                </div>
            </c:if>

            <c:if test="${not empty errors}">
                <div class="card-panel red">
                    <c:forEach var="e" items="${errors}">
                        <span class="white-text">${e.getDefaultMessage()}</span><br>
                    </c:forEach>
                </div>
            </c:if>--%>
            <div class="row">
                <div class="col s12">
                    <div class="row">
                        <div class="form" height="700px">
                            <div class="content-form">
                                <div class="title-form">Cadastro de oficina</div>
                                <form method="post">
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <i class="material-icons prefix">label_outline</i>
                                            <input id="name" name="name" type="text">
                                            <label for="name">Nome da oficina</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">credit_card</i>
                                            <input id="cnpj" name="cnpj" type="text">
                                            <label for="cnpj">CNPJ</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">map</i>
                                            <select id="addrress" name="addrress">
                                                <option value="" disabled selected>Selecione</option>
                                                <option value="1">CIDADE DOS LAGOS</option>
                                                <option value="2">PRIPYAT</option>
                                            </select>
                                            <label>Endereço</label>
                                        </div>
                                        <div class="input-field col s12">
                                            <i class="material-icons prefix">person</i>
                                            <input id="manager-name" name="manager-name" type="text">
                                            <label for="manager-name">Nome completo do responsável</label>
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
                                        <button type="submit" class="btn-flat">Cadastrar oficina</button>
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