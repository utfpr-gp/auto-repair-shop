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
                                            <input id="cnpj" name="cnpj" type="text" value="${dto.cnpj}" placeholder="XX.XXX.XXX/XXXX-XX">
                                            <label for="cnpj">CNPJ</label>
                                        </div>
                                        <div class="input-field col s6">
                                        	<i class="material-icons prefix">local_phone</i>
                                            <input id="telephone" name="telephone" type="text" value="${dto.telephone}" placeholder="(DD) ?XXXX-XXXX">
                                            <label for="telephone">Telefone</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">markunread_mailbox</i>
                                            <label for="cep">Cep</label>
                                            <input id="cep" name="addressDto.cep" type="text" value="${dto.addressDto.cep}">
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">map</i>
                                            <input id="state" name="addressDto.state" type="text" value="${dto.addressDto.state}">
                                            <label for="state">Estado</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">location_city</i>
                                            <input id="city" name="addressDto.city" type="text" value="${dto.addressDto.city}">
                                            <label for="city">Cidade</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">view_day</i>
                                            <input id="street" name="addressDto.street" type="text" value="${dto.addressDto.street}">
                                            <label for="street">Rua</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">filter_9_plus</i>
                                            <input id="number" name="addressDto.number" type="text" value="${dto.addressDto.number}">
                                            <label for="number">Número</label>
                                        </div>
                                       	<div class="input-field col s6">
                                            <p class="header">Imagem</p>
                                       		<input type="file" name="file" id="file"/>
                                        </div>
                                       <div class="col s12">
                                           <h5 class="header">Dados de acesso</h5>
                                           <div class="input-field col s6">
                                               <i class="material-icons prefix">email</i>
                                               <input id="email" type="email" name="managerDto.email" class="validate" value="${dto.managerDto.email}">
                                               <label for="email">Email</label>
                                           </div>
                                           <div class="input-field col s6">
                                               <i class="material-icons prefix">lock</i>
                                               <input id="password" type="password" name="managerDto.password" class="validate" value="${dto.managerDto.password}">
                                               <label for="password">Senha</label>
                                           </div>
                                       </div>
                                    </div>
                                    <div class="action-form">s
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