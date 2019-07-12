<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="Cadastrar veículos">
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
                        <div class="col s12 form" height="500px">
                            <div class="content-form">
                                <div class="title-form">Cadastro de veículo</div>
                                <form action="veiculos" method="post" enctype="multipart/form-data">
                                    <input name="registration" type="hidden" value="${dto.registration}"/>
                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">person</i>
                                            <select id="client" name="client">
                                                <option value="" disabled selected>Selecione</option>
                                                <c:forEach var="c" items="${clientsDto}">
                                                    <c:if test="${dto.registration == c.id}">
                                                        <option selected value="${c.id}">${c.name}</option>
                                                    </c:if>
                                                    <c:if test="${dto.registration != c.id || dto.registration == null}">
                                                        <option value="${c.id}">${c.name}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                            <label>Proprietário</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">crop_7_5</i>
                                            <input id="placa" name="placa" type="text" value="${dto.placa}">
                                            <label for="placa">Placa</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">local_offer</i>
                                            <select id="brand" name="brand">
                                                <option value="" disabled selected>Selecione</option>
                                                <c:forEach var="b" items="${brand}">
                                                    <option value="${b}">${b}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">directions_car</i>
                                            <input id="model" name="model" type="text" value="${dto.model}">
                                            <label for="model">Modelo</label>
                                        </div>

                                        <div class="input-field col s6" id="type-vehicle">
                                            <div>
                                                <label>TIPO</label>
                                                <label>
                                                    <c:set var="car" scope="session" value="car"/>
                                                    <c:if test="${dto.type == car}">
                                                        <input name="type" type="radio" checked value="car"/>
                                                    </c:if>
                                                    <c:if test="${dto.type != car || dto.type == null}">
                                                        <input name="type" type="radio" value="car"/>
                                                    </c:if>
                                                    <span>Carro</span>
                                                </label>

                                                <label>
                                                    <c:set var="moto" scope="session" value="moto"/>
                                                    <c:if test="${dto.type == moto}">
                                                        <input name="type" type="radio" checked value="moto"/>
                                                    </c:if>
                                                    <c:if test="${dto.type != moto || dto.type == null}">
                                                        <input name="type" type="radio" value="moto"/>
                                                    </c:if>
                                                    <span>Moto</span>
                                                </label>
                                                <label>
                                                    <c:set var="truck" scope="session" value="truck"/>
                                                    <c:if test="${dto.type == truck}">
                                                        <input name="type" type="radio" checked value="truck"/>
                                                    </c:if>
                                                    <c:if test="${dto.type != truck || dto.type == null}">
                                                        <input name="type" type="radio" value="truck"/>
                                                    </c:if>
                                                    <span>Caminhão</span>
                                                </label>
                                            </div>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">color_lens</i>
                                            <label for="color">Cor</label>
                                            <input id="color" name="color" type="text" value="${dto.color}">
                                        </div>
                                        <h6 class="header" style="margin-left: 15px;">Imagem:</h6>
                                        <div class="input-field col s12">
                                            <div class="input-field col s6">
                                                <input type="file" name="file" id="file"/>
                                            </div>
                                        </div>
                                        <c:if test="${dto.image != null}">
                                            <div class="input-field col s6">
                                                <img class="materialboxed" width="200" src="${dto.image}">
                                            </div>
                                        </c:if>
                                        <div class="action-form">
                                            <button type="submit" class="btn-flat">Cadastrar veículo</button>
                                        </div>
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
