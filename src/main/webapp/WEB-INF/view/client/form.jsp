<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<t:template title="Cadastro de clientes">
	<jsp:body>
        <div class="container">

            <c:if test="${not empty errors}">
                <div class="card-panel red">
                    <c:forEach var="e" items="${errors}">
                        <span class="white-text">${e.getDefaultMessage()}</span>
						<br>
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
                                <form action="clientes" method="post">
									<input name="id" type="hidden" value="${dto.id}" />
                                    <input name="credentialDto.id" type="hidden" value="${dto.credentialDto.id}"/>
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <i
												class="material-icons prefix">person</i>
                                            <input id="name" name="name"
												type="text" value="${dto.name}">
                                            <label for="name">Nome completo</label>

                                        </div>
                                        <div class="input-field col s6">
                                            <i
												class="material-icons prefix">markunread_mailbox</i>
                                            <label for="cep">Cep</label>
                                            <input id="cep"
												name="addressDto.cep" type="text"
												value="${dto.addressDto.cep}">
                                        </div>
                                        <div class="input-field col s6">
                                            <i
												class="material-icons prefix">map</i>
                                            <input id="state"
												name="addressDto.state" type="text"
												value="${dto.addressDto.state}">
                                            <label for="state">Estado</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i
												class="material-icons prefix">location_city</i>
                                            <input id="city"
												name="addressDto.city" type="text"
												value="${dto.addressDto.city}">
                                            <label for="city">Cidade</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i
												class="material-icons prefix">view_day</i>
                                            <input id="street"
												name="addressDto.street" type="text"
												value="${dto.addressDto.street}">
                                            <label for="street">Rua</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i
												class="material-icons prefix">filter_9_plus</i>
                                            <input id="number"
												name="addressDto.number" type="text"
												value="${dto.addressDto.number}">
                                            <label for="number">Número</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i
												class="material-icons prefix">date_range</i>
                                            <label for="birthDate">Data de Nascimento</label>
                                            <fmt:formatDate
												value="${dto.birthDate}" var="dateFormatted" type="date"
												pattern="dd/MM/yyyy" />
                                            <input id="birthDate"
												name="birthDate" type="text" value="${dateFormatted}"
												readonly="true" />
                                        </div>

                                    </div>
                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i
												class="material-icons prefix">phone</i>
                                            <input id="telephone"
												name="telephone" type="text" value="${dto.telephone}"
												maxlength="11">
                                            <label for="telephone">Telefone</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i
												class="material-icons prefix">mail</i>
                                            <input id="email"
												name="credentialDto.email" type="text"
												value="${dto.credentialDto.email}">
                                            <label for="email">Email</label>
                                        </div>
		                                    <div class="input-field col s6">
		                                        <i
												class="material-icons prefix">lock</i>
		                                        <input id="password"
												type="password" name="credentialDto.password"
												class="validate" value="${dto.credentialDto.password}">
		                                        <label for="password">Senha</label>
		                                    </div>
		                                    <div class="input-field col s6">
		                                    	<i class="material-icons prefix">lock</i>
		                                        <input
												id="passwordConfirmation" required
												name="credentialDto.passwordConfirmation" type="password"
												value="${dto.credentialDto.passwordConfirmation}">
		                                        <label
												for="passwordConfirmation">Confirmação Senha</label>
		                                    </div>
		                            </div>
                                    <div class="action-form">
                                        <button type="submit"
											class="btn-flat">Cadastrar cliente</button>
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