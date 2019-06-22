<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template title="Veiculo Cliente">
    <jsp:body>
        <h1>Cadastro Veiculo Cliente</h1>

        <div class="row col s12">
            <form action="" method="post">

                <label for="name">Nome Completo</label>
                <input name="name" type="text">

                <button class="btn waves-effect" type="submit">Proximo
                    <i class="material-icons right">save</i>
                </button>
            </form>
        </div>


    </jsp:body>
</t:template>