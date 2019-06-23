<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="Cadastrar veículos">
    <jsp:body>
        <div class="container">
            <c:if test="${not empty message}">
                <div class="card-panel green lighten-1">
                    <span class="white-text">${message}</span>
                </div>
            </c:if>

            <c:if test="${not empty errors}">
                <div class="card-panel red">
                    <c:forEach var="e" items="${errors}">
                        <span class="white-text">${e.getDefaultMessage()}</span><br>
                    </c:forEach>
                </div>
            </c:if>

            <h1>Cadastro de veículos</h1>
            <div class="row">
                <div class="col s12">
                    <form action="veiculos" method="post" enctype="multipart/form-data">
                        <input name="registration" type="hidden" value="${dto.registration}"/>

                        <div class="col s12">
                            <div class="input-field">
                                <select name="client" id="client">
                                    <option value="" disabled selected>Selecione o cliente</option>
                                    <c:forEach var="client" items="${clientsDto}">
                                        <option value="${client.id}">${client.getName()}</option>
                                    </c:forEach>
                                </select>
                                <label for="client">Cliente</label>
                            </div>
                        </div>

                        <div class="col s6">
                            <label for="placa">Placa</label>
                            <input name="placa" id="placa" type="text" value="${dto.placa}"/>
                        </div>

                        <div class="col s6">
                            <label for="color">Cor</label>
                            <input name="color" id="color" type="text" value="${dto.color}"/>
                        </div>

                        <div class="col s6">
                            <label for="brand">Marca</label>
                            <input name="brand" id="brand" type="text" value="${dto.brand}"/>
                        </div>

                        <div class="col s6">
                            <label for="model">Modelo</label>
                            <input name="model" id="model" type="text" value="${dto.model}"/>
                        </div>

                        <div class="col s12">
                            <label>Tipo</label>
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

                        <div class="row">
                            <button class="btn waves-effect waves-light right" type="submit">Salvar
                                <i class="material-icons right">save</i>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </jsp:body>
</t:template>