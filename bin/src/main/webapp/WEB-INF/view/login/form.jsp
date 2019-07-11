<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:login title="Oficina">
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
                        <div class="col s12 m10 offset-m1 l6 offset-l3 form" style="height: 455px">
                            <div class="content-form">
                                <div class="title-form">Login</div>
                                <form method="post" action="login">
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <i class="material-icons prefix">email</i>
                                            <input id="email" type="email" class="validate" value="${dto.email}">
                                            <label for="email">Email</label>
                                            <span class="helper-text" data-error="incorreto" data-success="correto"></span>

                                        </div>
                                        <div class="input-field col s12">
                                            <i class="material-icons prefix">lock</i>
                                            <input id="password" type="password" class="validate">
                                            <label for="password">Senha</label>
                                        </div>
                                        <div class="input-field col s11 offset-s1">
                                            <p>
                                                <label>
                                                    <input type="checkbox" checked="checked" />
                                                    <span>Lembrar-me</span>
                                                </label>
                                            </p>
                                            <a href="#!">Esqueci minha senha</a>
                                        </div>
                                    </div>
                                    <div class="action-form">
                                        <button class="btn-flat" type="submit">Entrar</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:login>