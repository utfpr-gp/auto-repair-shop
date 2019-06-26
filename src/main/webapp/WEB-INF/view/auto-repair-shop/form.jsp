<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template title="Cadastro de oficinas">
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
                        <div class="form" height="900px">
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
                                            <label for="cep">Cep</label>
                                            <input id="cep" name="cep" type="text">
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="state" name="state" type="text">
                                            <label for="state">Estado</label>
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="city" name="city" type="text">
                                            <label for="city">Cidade</label>
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="street" name="street" type="text">
                                            <label for="street">Rua</label>
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="number" name="number" type="text">
                                            <label for="number">Numero</label>
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
</t:template>