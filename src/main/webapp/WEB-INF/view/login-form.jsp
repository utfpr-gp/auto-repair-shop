<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template title="Login">
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <div class="row">
                        <div class="col s12 m10 offset-m1 l6 offset-l3 form" height="455px">
                            <div class="content-form">
                                <div class="title-form">Login</div>
                                <form method="post">
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <i class="material-icons prefix">email</i>
                                            <input id="email" type="email" class="validate">
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
                                                    <input id="remember" name="remember" type="checkbox" checked="checked" />
                                                    <span>Lembrar-me</span>
                                                </label>
                                            </p>
                                            <a href="#!">Esqueci minha senha</a>
                                        </div>
                                    </div>
                                    <div class="action-form">
                                        <button type="submit" class="btn-flat">Entrar</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:template>