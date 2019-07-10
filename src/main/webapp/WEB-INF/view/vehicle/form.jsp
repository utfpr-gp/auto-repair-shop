<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="Cadastrar veículos">
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
                                                    <option value="${c.id}">${c.name}</option>
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
                                            <select id="client" name="client">
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
                                                    <input name="type" type="radio" value="car"/>
                                                    <span>Carro</span>
                                                </label>

                                                <label>
                                                    <input name="type" type="radio" value="moto"/>
                                                    <span>Moto</span>
                                                </label>
                                                <label>
                                                    <input name="type" type="radio" value="truck"/>
                                                    <span>Caminhão</span>
                                                </label>
                                            </div>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">color_lens</i>
                                            <label for="color">Cor</label>
                                            <input id="color" name="color" type="text" value="${dto.color}">
                                        </div>
                                        <h6 class="header" style="margin-left: 15px;">Imagem</h6>
                                        <div class="file-field input-field col s4">

                                            <div>
                                                <input type="file">
                                            </div>
                                            <div class="file-path-wrapper">
                                                <i class="material-icons prefix">image</i>
                                                <input placeholder="Imagem.png" class="file-path validate" type="text">
                                            </div>
                                        </div>
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
