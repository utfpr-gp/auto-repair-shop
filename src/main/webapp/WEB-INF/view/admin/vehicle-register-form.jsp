<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:admin title="Cadastro de veiculo">
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <div class="row">
                        <div class="col s12 form" height="500px">
                            <div class="content-form">
                                <div class="title-form">Cadastro de veiculo</div>
                                <form method="post">
                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">person</i>
                                            <select id="client" name="client">
                                                <option value="" disabled selected>Selecione</option>
                                                <c:forEach var="c" items="${clients}">
                                                    <option value="${c.id}">${c.name}</option>
                                                </c:forEach>
                                            </select>
                                            <label>Dono</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">crop_7_5</i>
                                            <input placeholder="ABC-1234" id="plate" name="plate" type="text">
                                            <label for="plate">Placa</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">local_offer</i>
                                            <input id="brand" name="brand" type="text">
                                            <label for="brand">Marca</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">directions_car</i>
                                            <input id="model" name="model" type="text">
                                            <label for="model">Modelo</label>
                                        </div>

                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">loyalty</i>
                                            <select>
                                                <option value="" disabled selected>Selecione</option>
                                                <option value="1">CARRO</option>
                                                <option value="2">MOTO</option>
                                            </select>
                                            <label>Tipo</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">color_lens</i>
                                            <select id="color" name="color">
                                                <option value="" disabled selected>Selecione</option>
                                                <option value="1">BRANCO</option>
                                                <option value="2">PRETO</option>
                                            </select>
                                            <label>Cor</label>
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
                                            <button type="submit" class="btn-flat">Cadastrar veiculo</button>
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
</t:admin>