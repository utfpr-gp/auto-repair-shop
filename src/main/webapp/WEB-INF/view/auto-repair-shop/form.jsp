<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="Cadastro de oficinas">
    <jsp:body>
        <div class="container">

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
                        <div class="form" >
                            <div class="content-form">
                                <div class="title-form">Cadastro de oficina</div>
                                <form action="oficinas" method="post" enctype="multipart/form-data">
                                   <div class="row">
                                        <div class="input-field col s12">
                                            <i class="material-icons prefix">label_outline</i>
                                            <input id="name" name="name" type="text" value="${dto.name}">
                                            <label for="name">Nome da oficina</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">credit_card</i>
                                            <input id="cnpj" name="cnpj" type="text" value="${dto.cnpj}">
                                            <label for="cnpj">CNPJ</label>
                                        </div>
                                        <div class="input-field col s6">
                                        	<i class="material-icons prefix">local_phone</i>
                                            <input id="telephone" name="telephone" type="text" value="${dto.telephone}" placeholder="(DD) ?XXXX-XXXX">
                                            <label for="telephone">Telefone</label>
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
                                            <p class="header">Imagem</p>
                                       		<input type="file" name="file" id="file"/>
                                        </div>
                                       <div class="col s12">
                                           <h5 class="header">Dados de acesso</h5>
                                           <div class="input-field col s6">
                                               <i class="material-icons prefix">email</i>
                                               <input id="email" type="email" name="email" class="validate" value="${managerDto.email}">
                                               <label for="email">Email</label>
                                           </div>
                                           <div class="input-field col s6">
                                               <i class="material-icons prefix">lock</i>
                                               <input id="password" type="password" name="password" class="validate">
                                               <label for="password">Senha</label>
                                           </div>
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