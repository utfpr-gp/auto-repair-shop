<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Histórico de atendimento">
	<jsp:body>
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <div class="row">
                        <div class="col s12 form" height="100%">
                            <div class="content-form">
                                <div class="title-form left">Histórico de atendimento</div>
                                <div class="input-field col s4 right">
                                    <form action="atendimentos/pesquisa"
										method="get">
                                        <i class="material-icons prefix">search</i>
                                        <input name="search" id="search"
											placeholder="Pesquisar por placa" type="text"
											class="validate">
                                        <button type="submit"
											class="btn-flat right">Buscar</button>
                                    </form>
                                </div>
                                <div class="col s12">
                                	<form action="atendimentos/filtro" method="get">
		                                <div class="input-field col s6">
		                                	<i class="material-icons prefix">account_balance</i>
		                                    <select id="autoRepairShop" name="autoRepairShop">
		                                        <option value="" disabled selected>Selecione</option>
		                                        <c:forEach var="autoRepairShopDto" items="${autoRepairShopDto}">
		                                           <option <c:if test="${dto.autoRepairShop.id == autoRepairShopDto.id}"> selected="selected"</c:if>
		                                            value="${autoRepairShopDto.id}">${autoRepairShopDto.name}</option>
		                                        </c:forEach>
		                                    </select>
		                                    <label>Oficina</label>
		                                </div>
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
	                             	   <button type="submit" class="btn-flat right">Filtrar</button>
                             	   </form>
	                            </div>
                                <table class="highlight centered">
                                    <thead>
                                    <tr>
                                        <th>Veiculo</th>
                                        <th>Descrição</th>
                                        <th>Preço das partes</th>
                                        <th>Preço da mão-de-obra</th>
                                        <th>Preço total</th>
                                        <th>Data</th>
                                        <th>Hora</th>
                                        <th></th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <c:forEach var="s"
											items="${maintenances}">
                                        <tr>
                                            <td>${s.vehicle.placa}</td>
                                            <td>${s.description}</td>
                                            <td>R$ ${s.priceParts}</td>
                                            <td>R$ ${s.priceHandWork}</td>
                                            <td>R$ ${s.totalPrice}</td>
                                            <td>${s.date}</td>
                                            <td>${s.hour}</td>
                                            <td>
                                				<a href="atendimentos/${s.id}"><i
														class="material-icons">edit</i></a>
                            					<a href="#modal-delete"
													class="modal-trigger"
													data-url="${pageContext.request.contextPath}/atendimentos/${s.id}"><i
														class="material-icons red-text">delete</i></a>
                            				</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
<%--       Mostrar informações do veiculo em um modal quando clicar na placa                   --%>
<%--                                <c:forEach var="s" items="${services}">--%>
<%--                                    <div id="modal-vehicle-${s.id}" class="modal">--%>
<%--                                        <div class="modal-content">--%>
<%--                                            <h4 class="header">Informações do veiculo</h4>--%>
<%--                                            <table class="highlight">--%>
<%--                                                <tbody>--%>
<%--                                                <tr>--%>
<%--                                                    <td><b>Modelo</b></td>--%>
<%--                                                    <td>${s.vehicle.model}</td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <td><b>Placa</b></td>--%>
<%--                                                    <td>${s.vehicle.placa}</td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <td><b>Marca</b></td>--%>
<%--                                                    <td>${s.vehicle.brand}</td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <td><b>Cor</b></td>--%>
<%--                                                    <td>${s.vehicle.color}</td>--%>
<%--                                                </tr>--%>
<%--                                                </tbody>--%>
<%--                                            </table>--%>
<%--                                        </div>--%>

<%--                                        <div class="modal-footer">--%>
<%--                                            <a href="#!" class="modal-close waves-effect waves-green btn-flat">OK</a>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </c:forEach>--%>
                            </div>
                            <div id="modal-delete" class="modal">
            	<form action="" method="post">
				<input type="hidden" name="_method" value="DELETE" />
		            <div class="modal-content">
       		        	<h4>Você tem certeza que deseja remover?</h4>
					</div>
                    <div class="modal-footer">
                    	<button type="button"
											class="modal-close btn-flat waves-effect waves-light grey">Cancelar</button>
                        <button type="submit"
											class="modal-close btn waves-effect waves-light gray">Sim</button>
                    </div>
               	</form>
            </div>
        </div>
	
	</jsp:body>
</t:template>
