<%@tag description="Template principal" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title" %>


<html>
<head>
    <title>${title}</title>
    <base href="${pageContext.request.contextPath}/">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="icon" type="image/png" href="favicon.png"/>

    <!-- CSS -->
    <%--  <link rel="stylesheet" href="assets/lib/materialize/css/materialize.css"></link>--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.css">
<%--    <link rel="stylesheet" href="assets/lib/font-awesome/css/font-awesome.css">--%>
    <link rel="stylesheet" href="assets/res/css/index.css">
    <link rel="stylesheet" href="assets/res/css/material-icons.css">

<%--    <link rel="stylesheet" href="assets/res/css/template.css">--%>


    <!--Import Google Icon Font-->
<%--    <link href="http://fonts.googleapis.com/icon?family=Material+Icons"--%>
<%--          rel="stylesheet"></link>--%>
<%--    <link href='http://fonts.googleapis.com/css?family=Roboto:200,700'--%>
<%--          rel='stylesheet' type='text/css'></link>--%>

    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
    <script src="assets/res/js/index.js"></script>
    <script src="assets/lib/maskMoney/jquery.maskMoney.min.js" type="text/javascript"></script>
</head>
<body>
<header>
    <c:if test="${not empty message}">
        <script>M.toast({html: "${message}", classes: 'rounded'})</script>
    </c:if>
    <div class="container"><a href="#" data-target="nav-mobile" class="top-nav sidenav-trigger full hide-on-large-only"><i class="material-icons">menu</i></a></div>
    <ul id="nav-mobile" class="sidenav sidenav-fixed light-blue darken-4">
        <li class="logo">
            <img src="assets/res/img/logo2.png" width="100%" style="border: 2px solid rgba(0,0,0,0.14);">
        </li>
        <li class="no-padding">
            <ul class="collapsible collapsible-accordion">
                <sec:authorize access="hasAnyRole('ADMIN')">
                    <li class="auto-repair-shop bold">
                        <a class="collapsible-header waves-effect waves-blue-grey white-text" tabindex="0">Oficinas<i class="material-icons left" style="color: aliceblue">account_balance</i></a>
                        <div class="collapsible-body">
                            <ul>
                                <li class="auto-repair-shop-register">
                                    <a href="oficinas/novo">Cadastro de oficina<i id="auto-repair-shop-register-icon" class="material-icons left">queue</i></a>
                                </li>
                                <li class="auto-repair-shop-list">
                                    <a href="oficinas">Lista de oficinas<i id="auto-repair-shop-list-icon" class="material-icons left">format_list_numbered</i></a>
                                </li>
                            </ul>
                        </div>
                    </li>
                </sec:authorize>
                <li class="maintenance bold">
                    <a class="collapsible-header waves-effect waves-blue-grey white-text" tabindex="0">Atendimentos<i class="material-icons left" style="color: aliceblue">assignment_turned_in</i></a>

                    <div class="collapsible-body">
                        <ul>
                            <sec:authorize access="hasAnyRole('ADMIN') or hasAnyRole('MANAGER') or hasAnyRole('EMPLOYEE')">
                                <li class="maintenance-register">
                                    <a href="atendimentos/novo">Cadastro de atendimento<i id="maintenance-register-icon" class="material-icons left">note_add</i></a>
                                </li>
                                <li class="maintenance-history">
                                    <a href="atendimentos">Histórico de atendimento<i id="maintenance-history-icon" class="material-icons left">assignment</i></a>
                                </li>
                                <li class="maintenance-report">
                                    <a href="#">Relatório de atendimento<i id="maintenance-report-icon" class="material-icons left">assessment</i></a>
                                </li>
                            </sec:authorize>
                            <sec:authorize access="hasAnyRole('CLIENT')">
                                <li class="maintenance-client">
                                    <a href="atendimentos/cliente">Histórico de atendimento<i id="maintenance-client-icon" class="material-icons left">assignment_returned</i></a>
                                </li>
                            </sec:authorize>
                        </ul>
                    </div>
                </li>
                <li class="vehicle bold">
                    <a class="collapsible-header waves-effect waves-blue-grey white-text" tabindex="0">Veículos<i class="material-icons left" style="color: aliceblue">directions_car</i></a>

                    <div class="collapsible-body">
                        <ul>
                            <sec:authorize access="hasAnyRole('ADMIN') or hasAnyRole('MANAGER') or hasAnyRole('EMPLOYEE')">
                                <li class="vehicle-register">
                                    <a href="veiculos/novo">Cadastro de veículo<i id="vehicle-register-icon" class="material-icons left">playlist_add</i></a>
                                </li>
                                <li class="vehicle-list">
                                    <a href="veiculos">Todos os veículos<i id="vehicle-list-icon" class="material-icons left">playlist_add_check</i></a>
                                </li>
                            </sec:authorize>
                            <sec:authorize access="hasAnyRole('CLIENT')">
                                <li class="vehicle-client-list">
                                    <a href="veiculos/cliente">Meus veículos<i id="vehicle-client-icon" class="material-icons left">airport_shuttle</i></a>
                                </li>
                            </sec:authorize>
                        </ul>
                    </div>
                </li>
                <sec:authorize access="hasAnyRole('ADMIN') or hasAnyRole('MANAGER') or hasAnyRole('EMPLOYEE')">
                    <li class="client bold">
                        <a class="collapsible-header waves-effect waves-blue-grey white-text" tabindex="0">Clientes<i class="material-icons left" style="color: aliceblue">group</i></a>

                        <div class="collapsible-body">
                            <ul>
                                <li class="client-register">
                                    <a href="clientes/novo">Cadastro de cliente<i id="client-register-icon" class="material-icons left">person_add</i></a>
                                </li>
                                <li class="client-list">
                                    <a href="clientes">Lista de clintes<i id="client-list-icon" class="material-icons left">format_list_bulleted</i></a>
                                </li>
                            </ul>
                        </div>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ADMIN') or hasAnyRole('MANAGER')">
                    <li class="employee bold">
                        <a class="collapsible-header waves-effect waves-blue-grey white-text" tabindex="0">Funcionários<i class="material-icons left" style="color: aliceblue">supervisor_account</i></a>

                        <div class="collapsible-body">
                            <ul>
                                <li class="employee-register">
                                    <a href="funcionarios/novo">Cadastro de funcionário<i id="employee-register-icon" class="material-icons left">person_add</i></a>
                                </li>
                                <li class="employee-list">
                                    <a href="funcionarios">Lista de funcionários<i id="employee-list-icon" class="material-icons left">format_list_bulleted</i></a>
                                </li>
                            </ul>
                        </div>
                    </li>
                </sec:authorize>
                <li class="bold">
                    <a class="white-text" href="log-out">Sair<i class="material-icons left" style="color: aliceblue">power_settings_new</i></a>
                </li>
            </ul>
        </li>
    </ul>
</header>
<main>
    <jsp:doBody/>

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
</main>

<script type="text/javascript">efeitoMenu();</script>
</body>
</html>
