<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="Oficinas">
    <jsp:body>
        <div class="container">
            
            <h1 class="header">Oficinas</h1>
            <a href="oficinas/novo" class="btn-floating btn-small waves-effect waves-light blue"><i
                    class="material-icons" title="Cadastrar Oficina">add</i></a>
            <c:if test="${not empty autoRepairShops}">
                <table>
                    <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Cnpj</th>
                        <th>Telefone</th>
                        <th></th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="autoRepairShop" items="${autoRepairShops}">
                        <tr>
                            <td>${autoRepairShop.name}</td>
                            <td>${autoRepairShop.cnpj}</td>
                            <td>${autoRepairShop.telephone}</td>
                            <td>
                                <a href="oficinas/${autoRepairShop.id}"><i class="material-icons">edit</i></a>
                            	<a href="#modal-delete"
									class="modal-trigger"
									data-url="${pageContext.request.contextPath}/oficinas/${autoRepairShop.id}"
									data-name="${autoRepairShop.name}"><i
										class="material-icons red-text">delete</i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty autoRepairShops}">
                <h3 class="header">Sem Oficinas cadastradas</h3>
            </c:if>
            
            <div id="modal-delete" class="modal">
            	<form action="" method="post">
				<input type="hidden" name="_method" value="DELETE" />
		            <div class="modal-content">
       		        	<h4>Você tem certeza que deseja remover <strong id="strong-name"></strong>?</h4>
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