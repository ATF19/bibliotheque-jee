<%@page import="com.Bibliotheque.Model.Document"%>
<%@page import="com.Bibliotheque.Model.Liste"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp" />

<c:if test="${ cookie.email.value == null || cookie.email.value == '' }">
    <%
        response.sendRedirect("connecter.jsp");
    %>
</c:if>
<%
    Liste listeDocs = new Liste();
    Cookie[] cookies = request.getCookies();
    String email = "";
    if(cookies != null) {
        for(int i=0; i<cookies.length; i++) {
            if(cookies[i].getName().equals("email")) {
                email = cookies[i].getValue();
                break;
            }
        }
        
        listeDocs.obtenirDocumentsParEtudiant(email);
    }
    else {
        response.sendRedirect("connecter.jsp");
    }   
%>

<div class="banner-top">
<div class="container">
        <h1>Mes documents reservés</h1>
        <em></em>
</div>
</div>

<div class="check-out">
<div class="container">
	
	<div class="bs-example4" data-example-id="simple-responsive-table">
    <div class="table-responsive">
    	    <table class="table-heading simpleCart_shelfItem">
		  <tr>
			<th class="table-grid">Document</th>
					
			<th>Type</th>
			<th >Langue </th>
			<th>Pages</th>
		  </tr>
                  <%
                      for(int i=0; i<listeDocs.getDocumentsParEtudiant().size();i++) {
                          Document document = listeDocs.getDocumentsParEtudiant().get(i);
                  %>
                    <tr class="cart-header">

                          <td class="ring-in"><a href="document.jsp?id=<%= document.getId() %>" class="at-in"><img src="upload/<%= document.getImage() %>" class="img-responsive" alt=""></a>
                          <div class="sed">
                                  <h5><a href="document.jsp?id=<%= document.getId() %>"><%= document.getLibelle() %></a></h5>
                                  <p><%= document.getDescription() %></p>

                          </div>
                          <div class="clearfix"> </div>
                          </td>
                          <td><%= document.getType() %></td>
                          <td><%= document.getLangue() %></td>
                          <td class="item_price"><%= document.getNbrPages() %></td>
                          <!-- <td class="add-check"><a class="item_add hvr-skew-backward" href="#">Annuler reservation</a></td> -->
                    </tr>
		  <% } %>
	</table>
	</div>
	</div>

</div>
</div>


<%@include file="footer.jsp" %>