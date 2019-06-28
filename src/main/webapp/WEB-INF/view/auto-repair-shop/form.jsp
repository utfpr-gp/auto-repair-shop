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
                                <form action="oficinas" method="post" enctype="multipart/form-data">
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
                                            <i class="material-icons prefix">telephone</i>
                                            <input id="telephone" name="telephone" type="text">
                                            <label for="telephone">Telefone</label>
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