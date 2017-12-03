<%@page import="com.Bibliotheque.Model.Document"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Bibliotheque.Model.Liste"%>
<%@page import="com.Bibliotheque.Model.Categorie"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp" />

<%
    Categorie cat = new Categorie();
    cat.setId(Integer.parseInt(request.getParameter("id")));
    cat.obtenir();
    Liste listeDocument = new Liste();
    listeDocument.obtenirDocumentsParCategorie(cat.getId());
    ArrayList<Document> documents = listeDocument.getDocumentsParCategorie();
%>

<div class="banner-top">
    <div class="container">
        <h1><%= cat.getLibelle() %></h1>
        <em></em>
    </div>
</div>

<div class="product">
			<div class="container">
			<div class="col-md-9">
				<div class="mid-popular">
                                    <% if(documents.size() < 1) { %>
                                        <div class="text-center">
                                            Pas de resultat !
                                        </div>
                                    <% } %>
                                    <% 
                                        for(int i=0; i<documents.size(); i++) {
                                          Document document = documents.get(i);
                                    %>
                                            <div class="col-md-4 item-grid simpleCart_shelfItem">
                                                <div class=" mid-pop">
                                                    <div class="pro-img">
                                                        <img src="upload/<%= document.getImage() %>" class="img-responsive" style="height: 300px" alt="">
                                                        <div class="zoom-icon ">
                                                            <a class="picture" href="upload/<%= document.getImage() %>" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                                            <a href="document.jsp?id=<%= document.getId() %>"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                                                        </div>
                                                    </div>
                                                    <div class="mid-1">
                                                        <div class="women">
                                                            <div class="women-top">
                                                                <span><c:out value="<%= document.getLangue() %>" /></span>
                                                                <h6><a href="document.jsp?id=<%= document.getId() %>"><c:out value="<%= document.getLibelle() %>" /></a></h6>
                                                            </div>

                                                            <div class="clearfix"></div>
                                                        </div>
                                                        <div class="mid-2">
                                                            <p ><em class="item_price"><c:out value="<%= document.getNbrPages() %>" /> pages</em></p>
                                                            <div class="block">
                                                                <span><c:out value="<%= document.getType() %>" /></span>
                                                            </div>

                                                            <div class="clearfix"></div>
                                                        </div>

                                                    </div>
                                            </div>
                                            </div>
                                    <% } %>
                                    </div>	
			</div>
			<div class="col-md-3 product-bottom">
			<!--categories-->
				<div class=" rsidebar span_1_of_left">
                                    <h4 class="cate">Categories</h4>
                                    <ul class="menu-drop">
                                        <% 
                                            Liste listeCat = new Liste();
                                            listeCat.obtenirCategories();
                                            ArrayList<Categorie> categories = listeCat.getCategories();
                                            for(int i=0; i<categories.size(); i++) {
                                                Categorie c = categories.get(i);
                                                out.print("<li class='item1'><a href='categorie.jsp?id="+c.getId()+"'>"+c.getLibelle()+"</a></li>");
                                            }
                                        %>
                                    </ul>
                                </div>
						
		</div>
			<div class="clearfix"></div>
			</div>
			
			
		</div>


<%@include file="footer.jsp" %>