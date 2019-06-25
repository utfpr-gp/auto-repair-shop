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
</head>
<body>
<header>
    <div class="navbar-fixed" style="z-index: 999">
        <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper blue">
                    <a href="" class="brand-logo">
                        <img class="utf-logo" src="assets/res/img/logo.png"/>
                    </a>
                    <a href="#" data-activates="mobile-demo" class="right button-collapse sidenav-trigger"><i
                            class="material-icons">menu</i></a>
                    <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <li><a href="">Início</a></li>
                        <li><a href="veiculos">Veículos</a></li>
                    </ul>
                </div>
            </nav>
            <ul class="sidenav" id="mobile-demo">
                <li><a href="">Início</a></li>
                <li><a href="veiculos">Veículos</a></li>
            </ul>
        </div>
    </div>
</header>
<main id="content" class="container">
    <jsp:doBody/>
</main>
<!-- rodape-->
<footer class="page-footer blue darken-5">
    <div class="container">
        <div class="row">
            <div class="col s12 center">
                <a href="http://www.utfpr.edu.br/guarapuava"> <img
                        src="assets/res/img/utfpr.png" id="utfpr-footer"
                        class=" img-responsive" height="70px"/>
                </a>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">
            &#169; Copyright <span id="year"></span> - Todos os direitos
            reservados
        </div>
    </div>
</footer>

<script src="assets/lib/jquery/jquery-3.3.1.min.js"></script>
<script src="assets/lib/materialize/js/materialize.js"></script>
<script src="assets/res/js/index.js"></script>
</body>
</html>
