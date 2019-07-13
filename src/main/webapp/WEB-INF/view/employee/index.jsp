<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template title="Funcionarios">
	<jsp:body>
        <div class="container"> 
            <h1 class="header">Funcionários</h1>
            <a href="funcionarios/novo"
				class="btn-floating btn-small waves-effect waves-light blue"><i
				class="material-icons" title="Cadastrar Funcionário">add</i></a>
            <c:if test="${not empty employees}">
                <table>
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Telefone</th>
                        <th>Cidade</th>
                        <th>Estado</th>
                        <th>Rua</th>
                        <th>Número</th>
                        <th>CEP</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="employee" items="${employees}">
                        <tr>
                            <td>${employee.id}</td>
                            <td>${employee.name}</td>
                            <td>${employee.telephone}</td>
                            <td>${employee.addressDto.city}</td>
                            <td>${employee.addressDto.state}</td>
                            <td>${employee.addressDto.street}</td>
                            <td>${employee.addressDto.number}</td>
                            <td>${employee.addressDto.cep}</td>
                            <td>
                                <a href="funcionarios/${employee.id}"><i
										class="material-icons">edit</i></a>
                            	<a href="#modal-delete"
									class="modal-trigger"
									data-url="${pageContext.request.contextPath}/funcionarios/${employee.id}"
									data-name="${employee.name}"><i
										class="material-icons red-text">delete</i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty employees}">
                <h3 class="header">Sem Funcionários cadastrados</h3>
            </c:if>
            
            <div id="modal-delete" class="modal">
            	<form action="" method="post">
				<input type="hidden" name="_method" value="DELETE" />
		            <div class="modal-content">
       		        	<h4>Você tem certeza que deseja remover <strong
								id="strong-name"></strong>?</h4>
					</div>
                    <div class="modal-footer">
                    	<button type="button"
							class="modal-close btn-flat waves-effect waves-light grey">Cancelar</button>
                        <button type="submit"
							class="modal-close btn waves-effect waves-light gray">Sim</button>
                    </div>
               	</form>
           </div>
        </div>
    </jsp:body>
</t:template>