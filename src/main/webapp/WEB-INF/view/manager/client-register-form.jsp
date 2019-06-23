<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:manager title="Cadastro de clientes">
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <div class="row">
                        <div class="col s12 form" height="655px">
                            <div class="content-form">
                                <div class="title-form">Cadastro de cliente</div>
                                <form method="post">
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <i class="material-icons prefix">person</i>
                                            <input id="name" name="name" type="text">
                                            <label for="name">Nome completo</label>

                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">credit_card</i>
                                            <input id="cpf" name="cpf" type="text">
                                            <label for="cpf">CPF</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">art_track</i>
                                            <input id="rg" name="rg" type="text">
                                            <label for="rg">RG</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">map</i>
                                            <select id="addrress" name="addrress">
                                                <option value="" disabled selected>Selecione</option>
                                                <option value="1">CIDADE DOS LAGOS</option>
                                                <option value="2">PRIPYAT</option>
                                            </select>
                                            <label>Endereço</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">date_range</i>
                                            <input id="birth-date" name="birth-date" class="datepicker">
                                            <label for="birth-date">Data de nascimento</label>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">phone</i>
                                            <input id="phone" name="phone" type="text">
                                            <label for="phone">Telefone</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">phone_android</i>
                                            <input id="cellular" name="cellular" type="text">
                                            <label for="cellular">Celular</label>
                                        </div>
                                    </div>
                                    <div class="input-field col s12">
                                        <h5 class="header">Sexo</h5>
                                        <p>
                                            <label>
                                                <input name="sex" value="m" type="radio" />
                                                <span>Masculino</span>
                                            </label>
                                        </p>
                                        <p>
                                            <label>
                                                <input name="sex" value="f" type="radio" />
                                                <span>Feminino</span>
                                            </label>
                                        </p>
                                    </div>
                                    <div class="action-form">
                                        <button type="submit" class="btn-flat">Cadastrar cliente</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:manager>