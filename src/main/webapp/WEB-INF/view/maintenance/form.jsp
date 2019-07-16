<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
                                            <fmt:formatDate value="${dto.date}" var="dateFormatted" type="date"
												pattern="dd/MM/yyyy"/>
                                            <input id="date" name="date" type="text" value="${dateFormatted}" 
                                            readonly="true"/>
                                            <label for="date">Data</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">access_time</i>
                                            <input id="hour" name="hour" type="text" class="timepicker" value="${dto.hour}">
                                            <label for="hour">Horário</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">directions_car</i>
                                            <select id="vehicle" name="vehicle">
                                                <option value="" disabled selected>Selecione</option>
                                                <c:forEach var="vehicleDto" items="${vehiclesDto}">
                                                    <option <c:if test="${dto.vehicle.id == vehicleDto.id}"> selected="selected"</c:if>
                                                    value="${vehicleDto.id}">${vehicleDto.model} - ${vehicleDto.placa}</option>
                                                </c:forEach>
                                            </select>
                                            <label>Veículo</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">person</i>
                                            <select id="employee" name="employee">
                                                <option value="" disabled selected>Selecione</option>
                                                <c:forEach var="employeeDto" items="${employeesDto}">
                                                	<option <c:if test="${dto.employee.id == employeeDto.id}"> selected="selected"</c:if>
                                                	value="${employeeDto.id}">${employeeDto.name}</option>
                                                </c:forEach>
                                            </select>
                                            <label>Mecânico</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <i class="material-icons prefix">description</i>
                                            <textarea id="description" name="description" class="materialize-textarea" data-length="120">${dto.description}</textarea>
                                            <label for="description">Descrição</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s4">
                                            <i class="material-icons prefix">attach_money</i>
                                            <input id="priceParts" name="priceParts" type="text" placeholder="0.00" value="${dto.priceParts}">
                                            <label for="priceParts">Preço das peças</label>

                                        </div>
                                        <div class="input-field col s4">
                                            <i class="material-icons prefix">monetization_on</i>
                                            <input id="priceHandWork" name="priceHandWork" type="text" placeholder="0.00" value="${dto.priceHandWork}">
                                            <label for="priceHandWork">Mão de obra</label>
                                        </div>
                                        
                                        <div class="input-field col s4">
                                            <i class="material-icons prefix">monetization_on</i>
                                            <input id="totalPrice" name="totalPrice" type="text" placeholder="0.00" value="${dto.totalPrice}">
                                            <label for="totalPrice">Preço total</label>
                                        </div>                                        
                                    </div>                                  
                                    <div class="action-form">
                                        <button type="submit" class="btn-flat">Salvar atendimento</button>
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