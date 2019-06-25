<%@tag description="Template principal" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@attribute name="title" %>


<html>
<head>
    <title>${title}</title>
    <base href="${pageContext.request.contextPath}/">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="icon" type="image/png" href="favicon.png"/>

    <!-- CSS -->
    <link rel="stylesheet" href="assets/lib/materialize/css/materialize.css">
    <link rel="stylesheet" href="assets/lib/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="assets/res/css/index.css">
    <link rel="stylesheet" href="assets/res/css/material-icons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.css">

</head>
<body>
<header>
    <ul id="dropdown1" class="dropdown-content">
        <li><a href="service-register-form.jsp">Cadastro de Atendimento</a></li>
        <li><a href="client-register-form.jsp">Cadastro de Cliente</a></li>
        <li><a href="employee-register-form.jsp">Cadastro de Funcionário</a></li>
        <li><a href="vehicle-register-form.jsp">Cadastro de Veiculo</a></li>
    </ul>
    <nav>
        <div class="nav-wrapper light-blue darken-4">
            <a href="#!" class="brand-logo"><i class="material-icons">directions_car</i>Logo</a>
            <ul class="right hide-on-med-and-down">
                <li><a class="dropdown-trigger" href="#!" data-target="dropdown1">Cadastros<i class="material-icons right">arrow_drop_down</i></a></li>
                <li><a href="service-history.jsp">Histórico de Atendimento</a></li>
                <li><a href="#!">Relatório de Atendimento</a></li>
                <li><a href="login-form.jsp" class="tooltipped" data-position="left" data-tooltip="Sair"><i class="material-icons right">exit_to_app</i></a></li>
            </ul>
        </div>
    </nav>
</header>
<main id="content" class="container">
    <jsp:doBody/>
</main>

<!-- rodape-->
<footer class="page-footer light-blue darken-4">
    <div class="container">
        <div class="row">
            <div class="col l6 s12">
                <h5 class="white-text">Auto Repair Shop</h5>
                <p class="grey-text text-lighten-4">Este sistema está sendo desenvolvido por alunos da disciplina de Desenvolvimento para Web 4 da UTFPR de Guarapuava.</p>
            </div>
            <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Links</h5>
                <ul>
                    <li><a class="grey-text text-lighten-3" href="https://github.com/utfpr-gp/auto-repair-shop/tree/develop">github.com</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">
            © <span id="year"></span> UTFPR GUARAPUAVA
        </div>
    </div>
</footer>

<script src="assets/lib/jquery/jquery-3.3.1.min.js"></script>
<script src="assets/lib/materialize/js/materialize.js"></script>
<script src="assets/res/js/index.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
</body>
</html>
