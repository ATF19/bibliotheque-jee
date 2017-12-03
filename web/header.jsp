<%@page import="java.util.ArrayList"%>
<%@page import="com.Bibliotheque.Model.Categorie"%>
<%@page import="com.Bibliotheque.Model.Liste"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    Liste listeCat = new Liste();
    listeCat.obtenirCategories();
    ArrayList<Categorie> categories = listeCat.getCategories();
%>
<!DOCTYPE html>
<html>
<head>
<title>Bibliotheque en ligne | ULT</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Shopin Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndroId Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--theme-style-->
<link href="css/style4.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<script src="js/jquery.min.js"></script>
<!--- start-rate---->
<script src="js/jstarbox.js"></script>
	<link rel="stylesheet" href="css/jstarbox.css" type="text/css" media="screen" charset="utf-8" />
		<script type="text/javascript">
			jQuery(function() {
			jQuery('.starbox').each(function() {
				var starbox = jQuery(this);
					starbox.starbox({
					average: starbox.attr('data-start-value'),
					changeable: starbox.hasClass('unchangeable') ? false : starbox.hasClass('clickonce') ? 'once' : true,
					ghosting: starbox.hasClass('ghosting'),
					autoUpdateAverage: starbox.hasClass('autoupdate'),
					buttons: starbox.hasClass('smooth') ? false : starbox.attr('data-button-count') || 5,
					stars: starbox.attr('data-star-count') || 5
					}).bind('starbox-value-changed', function(event, value) {
					if(starbox.hasClass('random')) {
					var val = Math.random();
					starbox.next().text(' '+val);
					return val;
					} 
				})
			});
		});
		</script>
<!---//End-rate---->

</head>
<body>
<!--header-->
<div class="header">
<div class="container">
		<div class="head">
			<div class=" logo">
				<a href="Index"><img src="images/logo.png" alt=""></a>	
			</div>
		</div>
	</div>
	<div class="header-top">
		<div class="container">
		<div class="col-sm-5 col-md-offset-2  header-login">
                    <c:if test="${ cookie.email.value != null && cookie.email.value != '' }">
                        <ul>
                            <li><a>${ cookie.email.value }</a></li>
                            <li><a href="#" onClick="logout()">Deconnecter</a></li>
                        </ul>
                    </c:if>
                    <c:if test="${ cookie.email.value == null || cookie.email.value == '' }">
                        <ul>
                            <li><a href="connecter.jsp">Connecter</a></li>
                            <li><a href="inscrire.jsp">S'inscrire</a></li>
                        </ul>
                    </c:if>
      
                </div>
				

				<div class="clearfix"> </div>
		</div>
		</div>
		
		<div class="container">
		
			<div class="head-top">
			
		 <div class="col-sm-8 col-md-offset-2 h_menu4">
				<nav class="navbar nav_bottom" role="navigation">
 
 <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header nav_2">
      <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
     
   </div> 
 
 
   <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
        <ul class="nav navbar-nav nav_1">
            <li><a class="color" href="Index">Accueil</a></li>
            <%
                for(int i=0; i<categories.size(); i++) {
                    Categorie cat = categories.get(i);
                    out.print("<li><a class='color' href='categorie.jsp?id="+cat.getId()+"'>"+cat.getLibelle()+"</a></li>");
                }
            %>
        </ul>
     </div><!-- /.navbar-collapse -->

</nav>
			</div>
			<div class="col-sm-2 search-right">
                            <ul class="heart">
                                <li><a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i class="glyphicon glyphicon-search"> </i></a></li>
                            </ul>
                            <c:if test="${ cookie.email.value != null && cookie.email.value != '' }">
                                    <div class="cart box_1">
						<a href="panier.jsp">
						<h3>
							<img src="images/cart.png" alt=""/></h3>
						</a>
						<p><a href="panier.jsp" class="simpleCart_empty">Panier</a></p>

					</div>
                                </c:if>
					
					<div class="clearfix"> </div>
					
						<!----->

						<!---pop-up-box---->					  
			<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
			<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
			<!---//pop-up-box---->
			<div id="small-dialog" class="mfp-hide">
				<div class="search-top">
					<div class="login-search">
                                            <form onsubmit="window.location.href = 'search.jsp?titre='+document.getElementById('recherche').value; return false;">
						<input type="submit" value="">
						<input id="recherche" type="text" value="Chercher un document.." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Chercher un document..';}">		
                                            </form>
                                        </div>
				</div>				
			</div>
		 <script>
			$(document).ready(function() {
			$('.popup-with-zoom-anim').magnificPopup({
			type: 'inline',
			fixedContentPos: false,
			fixedBgPos: true,
			overflowY: 'auto',
			closeBtnInside: true,
			preloader: false,
			midClick: true,
			removalDelay: 300,
			mainClass: 'my-mfp-zoom-in'
			});
																						
			});
		</script>
                <script>
                    function logout() {
                        var res = confirm("Vous voulez deconnecter ?");
                        if(res == true) {
                            window.location.replace("Logout");
                        }
                    }
                    
                </script>
						<!----->
			</div>
			<div class="clearfix"></div>
		</div>	
	</div>	
</div>