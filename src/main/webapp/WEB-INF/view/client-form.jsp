<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template title="Novo Cliente">
    <jsp:body>
    <h1>Cadastro Cliente</h1>

        <div class="row col s12">
            <form action="clientes/cadastro" method="post">
                <label for="name">Nome Completo</label>
                <input name="name" type="text">

                <label for="cep">Cep</label>
                <input name="cep" type="text">

                <label for="state">Estado</label>
                <input name="state" type="text">

                <label for="city">Cidade</label>
                <input name="city" type="text">

                <label for="street">Rua</label>
                <input name="street" type="text">

                <label for="number">Numero</label>
                <input name="number" type="text">

                <label for="birthDate">Data Nascimento</label>
                <input id="birthDate" name="birthDate" type="date">

                <label for="telefone">Telefone</label>
                <input name="telefone" type="text">

                <label for="email">Email</label>
                <input name="email" type="text">

                <label for="password">Senha</label>
                <input name="password" type="password">

                <button class="btn waves-effect" type="submit">Proximo
                    <i class="material-icons right">save</i>
                </button>
                <a class="btn waves-effect" href="/">
                    <i class="material-icons">cancel</i>
                </a>
            </form>
        </div>


    </jsp:body>
</t:template>