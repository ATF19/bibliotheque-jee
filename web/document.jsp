<%@page import="java.util.ArrayList"%>
<%@page import="com.Bibliotheque.Model.Categorie"%>
<%@page import="com.Bibliotheque.Model.Liste"%>
<%@page import="com.Bibliotheque.Model.Document"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp" />

<%
    int id = Integer.parseInt(request.getParameter("id"));
    Document doc = new Document();
    doc.setId(id);
    doc.obtenir();
%>

<div class="banner-top">
    <div class="container">
            <h1><%= doc.getLibelle() %></h1>
            <em></em>
    </div>
</div>

<div class="single">

<div class="container">
<div class="col-md-9">
	<div class="col-md-5 grid">		
		<div class="flexslider">
                    <div class="thumb-image"> <img src="upload/<%= doc.getImage() %>" data-imagezoom="true" class="img-responsive"> </div>
		</div>
	</div>	
<div class="col-md-7 single-top-in">
			<div class="span_2_of_a1 simpleCart_shelfItem">
				<h3><%= doc.getLibelle() %></h3>
                                <% if(doc.getType().equals("livre")) { %>
                                    <p class="in-para"><%= doc.auteur() %></p>
                                    <p class="in-para"><%= doc.isbn() %></p>
                                <% } %>
				<h4 class="quick">Description</h4>
                                <p class="quick_desc"><%= doc.getDescription() %></p>
			    <div class="wish-list">
				 	<ul>
                                            <li class="wish"><a><span class="glyphicon glyphicon-book" aria-hidden="true"></span><%= doc.getNbrPages() %> pages</a></li>
                                            <li class="wish"><a><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span><%= doc.getLangue() %></a></li>
				 	    <li class="compare"><a><span class="glyphicon glyphicon-ok" aria-hidden="true"></span><%= doc.getStatus() %></a></li>
				 	</ul>
				 </div>
	<!--quantity-->
                            
                             <% if(request.getParameter("success") != null && request.getParameter("success")!= "") { %>
                                <br />
                                <p style="color: #2ecc71"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Vous avez reservé ce document !</p>
                                <br />
                            <% } %>
                            <% if(doc.getStatus().equals("disponible")) { %>
                                <a href="Reserver?idDocument=<%= doc.getId() %>" class="add-to item_add hvr-skew-backward">Reserver</a>
                             <% } else { %>
                                <a class="add-to item_add hvr-skew-backward">Ce document n'est pas disponible pour le moment</a>
                             <% } %>
			<div class="clearfix"> </div>
			</div>
		
					</div>
			<div class="clearfix"> </div>
			<!---->
			<div class="tab-head">
			 
	
  <div class="clearfix"></div>
  </div>
			<!---->	
</div>
<!----->

<div class="col-md-3 product-bottom product-at">
			<!--categories-->
				<div class=" rsidebar span_1_of_left">
                                        <h4 class="cate">Categories</h4>
                                            <ul class="menu-drop">
                                                <% 
                                                    Liste listeCat = new Liste();
                                                    listeCat.obtenirCategories();
                                                    ArrayList<Categorie> categories = listeCat.getCategories();
                                                    for(int i=0; i<categories.size(); i++) {
                                                        Categorie cat = categories.get(i);
                                                        out.print("<li class='item1'><a href='categorie.jsp?id="+cat.getId()+"'>"+cat.getLibelle()+"</a></li>");
                                                    }
                                                %>
                                        </ul>
                                </div>
				<!--initiate accordion-->
						<script type="text/javascript">
							$(function() {
							    var menu_ul = $('.menu-drop > li > ul'),
							           menu_a  = $('.menu-drop > li > a');
							    menu_ul.hide();
							    menu_a.click(function(e) {
							        e.preventDefault();
							        if(!$(this).hasClass('active')) {
							            menu_a.removeClass('active');
							            menu_ul.filter(':visible').slideUp('normal');
							            $(this).addClass('active').next().stop(true,true).slideDown('normal');
							        } else {
							            $(this).removeClass('active');
							            $(this).next().stop(true,true).slideUp('normal');
							        }
							    });
							
							});
						</script>
<!--//menu-->
				 				 
				 
					
					 <!---->
					 		
		</div>
		<div class="clearfix"> </div>
	</div>
	
		
	<!--//content-->

<%@include file="footer.jsp" %>