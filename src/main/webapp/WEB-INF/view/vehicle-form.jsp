<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template title="Veiculo Cliente">
    <jsp:body>
        <h1>Cadastro Veiculo Cliente</h1>

        <div class="row col s12">
            <form action="veiculos" method="post" enctype="multipart/form-data">

                <input type="hidden" name="client_id" value="${client.id}">

                <label for="brand">Marca</label>
                <input name="brand" type="text">

                <label for="model">Modelo</label>
                <input name="model" type="text">
                
                <label for="color">Cor</label>
                <input name="color" type="text">

                <label for="placa">Placa</label>
                <input name="placa" type="text">

                <label for="type">Tipo</label>
                <input name="type" type="text">

                <label for="photo">Foto</label>
                <input name="photo" type="file">
                <br>
                <br>

                <button class="btn waves-effect right" type="submit">Salvar
                    <i class="material-icons right">save</i>
                </button>
            </form>
        </div>


    </jsp:body>
</t:template>