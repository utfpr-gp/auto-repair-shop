<%@tag description="Template login" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <link rel="stylesheet" href="assets/res/css/login.css">
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
</head>
<body>
<header>
    <nav>
        <div class="nav-wrapper light-blue darken-4">
            <a href="#!" class="brand-logo"><i class="material-icons">directions_car</i>Logo</a>
        </div>
    </nav>
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
