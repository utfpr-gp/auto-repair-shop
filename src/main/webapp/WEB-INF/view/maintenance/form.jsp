<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template title="Cadastro de atendimento">
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
                        <div class="col s12 form">
                            <div class="content-form">
                                <div class="title-form">Cadastro de atendimento</div>
                                <form action="atendimentos" method="post">
                                	<input name="registration" type="hidden" value="${dto.registration}"/>
                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">date_range</i>
                                            <input id="date" name="date" type="text" class="datepicker">
                                            <label for="date">Data</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">access_time</i>
                                            <input id="hour" name="hour" type="text" class="timepicker">
                                            <label for="hour">Horário</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">directions_car</i>
                                            <select id="vehicle" name="vehicle">
                                                <option value="" disabled selected>Selecione</option>
                                                <c:forEach var="v" items="${vehiclesDto}">
                                                    <option value="${v.id}">${v.model} - ${v.placa}</option>
                                                </c:forEach>
                                            </select>
                                            <label>Veiculo</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">person</i>
                                            <select>
                                                <option value="" disabled selected>Selecione</option>
                                                <c:forEach var="e" items="${employees}">
                                                    <option value="${e.id}">${e.name}</option>
                                                </c:forEach>
                                            </select>
                                            <label>Mecânico</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <i class="material-icons prefix">description</i>
                                            <textarea id="description" name="description" class="materialize-textarea" data-length="120"></textarea>
                                            <label for="description">Descrição</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s4">
                                            <i class="material-icons prefix">attach_money</i>
                                            <input id="priceParts" name="priceParts" type="text">
                                            <label for="priceParts">Preço das peças</label>

                                        </div>
                                        <div class="input-field col s4">
                                            <i class="material-icons prefix">monetization_on</i>
                                            <input id="priceHandWork" name="priceHandWork" type="text">
                                            <label for="priceHandWork">Mão de obra</label>
                                        </div>
                                        
                                        <div class="input-field col s4">
                                            <i class="material-icons prefix">monetization_on</i>
                                            <input id="totalPrice" name="totalPrice" type="text">
                                            <label for="totalPrice">Preço total</label>
                                        </div>                                        
                                    </div>                                  
                                    <div class="action-form">
                                        <button type="submit" class="btn-flat">Cadastrar atendimento</button>
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