<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="Cadastro de funcionários">
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

			 <c:if test="${not empty messageError}">
                <div class="card-panel red">
                	<span class="white-text">${messageError}</span><br>                    
                </div>
            </c:if>
            <div class="row">
                <div class="col s12">
                    <div class="row">
                        <div class="form" height="900px">
                            <div class="content-form">
                                <div class="title-form">Cadastro de Funcionário</div>
                                <form action="funcionarios" method="post" enctype="multipart/form-data">
                                <input type="hidden" name="_method" value="PUT"/>
                                 <input name="id" type="hidden" value="${dto.id}"/>
                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">person</i>
                                            <input id="name" name="name" type="text" value="${dto.name}">
                                            <label for="name">Nome completo</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <label for="cep">Cep</label>
                                            <input id="cep" name="cep" type="text" value="${dto.address.cep}">
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="state" name="state" type="text" value="${dto.address.state}">
                                            <label for="state">Estado</label>
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="city" name="city" type="text" value="${dto.address.city}">
                                            <label for="city">Cidade</label>
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="street" name="street" type="text" value="${dto.address.street}">
                                            <label for="street">Rua</label>
                                        </div>
                                        <div class="input-field col s6">

                                            <input id="number" name="number" type="text" value="${dto.address.number}">
                                            <label for="number">Numero</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">phone</i>
                                            <input id="telephone" name="telephone" type="text" value="${dto.telephone}" placeholder="(DD) ?XXXX-XXXX">
                                            <label for="telephone">Telefone</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">phone_android</i>
                                            <input id="cellular" name="cellular" value="${dto.cellular}" type="text" placeholder="(DD) ?XXXX-XXXX">
                                            <label for="cellular">Celular</label>
                                        </div>
                                    </div>
                                    <h5 class="header">Dados de acesso</h5>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix">email</i>
                                        <input id="email" type="email" name="email" value="${dto.credential.email}" class="validate">
                                        <label for="email">Email</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix">lock</i>
                                        <input id="password" type="password" name="password" class="validate">
                                        <label for="password">Senha</label>
                                    </div>
                                    <div class="action-form">
                                        <button type="submit" class="btn-flat">Atualizar funcionário</button>
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