<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template title="Cadastro de atendimento">
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
                        <div class="col s12 form">
                            <div class="content-form">
                                <div class="title-form">Cadastro de atendimento</div>
                                <form method="post">
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
                                            <select>
                                                <option value="" disabled selected>Selecione</option>
                                                <c:forEach var="v" items="${vehicles}">
                                                    <option value="${v.id}">${v.model} - ${v.placa} - ${v.client}</option>
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
                                    <div class="input-field col s12">
                                        <h5 class="header">Peças</h5>
                                        <p>
                                            <label>
                                                <input type="checkbox" name="pieces[]" value="1" />
                                                <span>Motor</span>
                                            </label>
                                        </p>
                                        <p>
                                            <label>
                                                <input type="checkbox" name="pieces[]" value="2" />
                                                <span>Radiador</span>
                                            </label>
                                        </p>
                                        <p>
                                            <label>
                                                <input type="checkbox" name="pieces[]" value="3" />
                                                <span>Pneus</span>
                                            </label>
                                        </p>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">attach_money</i>
                                            <input id="pieces-price" name="pieces-price" type="text">
                                            <label for="pieces-price">Preço das peças ou produtos</label>

                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">monetization_on</i>
                                            <input id="price" name="price" type="text">
                                            <label for="price">Mão de obra</label>

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