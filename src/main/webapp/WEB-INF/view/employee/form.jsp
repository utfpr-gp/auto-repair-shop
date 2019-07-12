<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template title="Cadastro de funcionário">
    <jsp:body>
        <div class="container">
            <c:if test="${not empty message}">
                <script>M.toast({html: "${message}", classes: 'rounded'})</script>
            </c:if>
            
            <c:if test="${not empty messageError}">
                <div class="card-panel red">
                	<span class="white-text">${messageError}</span><br>                    
                </div>
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
                        <div class="col s12 form" height="750px">
                            <div class="content-form">
                                <div class="title-form">Cadastro de funcionário</div>
                                <form action="funcionarios" method="post">
                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">person</i>
                                            <input id="name" name="name" type="text" value="${dto.name}">
                                            <label for="name">Nome completo</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">markunread_mailbox</i>
                                            <label for="cep">Cep</label>
                                            <input id="cep" name="cep" type="text" value="${addressDto.cep}">
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">map</i>
                                            <input id="state" name="state" type="text" value="${addressDto.state}">
                                            <label for="state">Estado</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">location_city</i>
                                            <input id="city" name="city" type="text" value="${addressDto.city}">
                                            <label for="city">Cidade</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">view_day</i>
                                            <input id="street" name="street" type="text" value="${addressDto.street}">
                                            <label for="street">Rua</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">filter_9_plus</i>
                                            <input id="number" name="number" type="text" value="${addressDto.number}">
                                            <label for="number">Numero</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">phone</i>
                                            <input id="telephone" name="telephone" type="text" placeholder="(DD) ?XXXX-XXXX" value="${dto.telephone}">
                                            <label for="telephone">Telefone</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">phone_android</i>
                                            <input id="cellular" name="cellular" type="text" placeholder="(DD) ?XXXX-XXXX" value="${dto.cellular}">
                                            <label for="cellular">Celular</label>
                                        </div>
                                    </div>
                                    <h5 class="header">Dados de acesso</h5>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix">email</i>
                                        <input id="email" type="email" name="email" class="validate" value="${credentialDto.email}">
                                        <label for="email">Email</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix">lock</i>
                                        <input id="password" type="password" name="password" class="validate" value="${credentialDto.password}">
                                        <label for="password">Senha</label>
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
</t:template>