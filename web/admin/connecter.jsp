<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${ cookie.adminEmail.value != null && cookie.adminEmail.value != '' }">
    <%
        response.sendRedirect("index.jsp");
    %>
</c:if>

<!DOCTYPE html>
<html lang="en" class="fullscreen-bg">
    <head>
        <title>Biblio ULT | Section Admin</title>
        <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/vendor/linearicons/style.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle">
				<div class="auth-box ">
					<div class="left">
						<div class="content">
							<div class="header">
								<div class="logo text-center"><img src="assets/img/logo-dark.png" alt="Klorofil Logo"></div>
							</div>
							<form class="form-auth-small" method="POST" action="http://localhost:8080/Bibliotheque/AdminLogin">
								<div class="form-group">
									<label for="signin-email" class="control-label sr-only">Email</label>
									<input type="email" class="form-control" id="signin-email" placeholder="Email" name="email">
								</div>
								<div class="form-group">
									<label for="signin-password" class="control-label sr-only">Mot de passe</label>
									<input type="password" class="form-control" id="signin-password" placeholder="Mot de passe" name="password">
								</div>
                                                                <% if(request.getParameter("error") != null) { %>
                                                                    <p>Email ou/et mot de passe incorrect !</p>
                                                                <% } %>
								<button type="submit" class="btn btn-primary btn-lg btn-block">CONNECTER</button>

							</form>
						</div>
					</div>
					<div class="right">
						<div class="overlay"></div>
						<div class="content text">
                                                    <h1 class="heading">Bibliotheque en ligne ULT</h1>
                                                    <p>Administrateur</p>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- END WRAPPER -->
</body>

</html>

