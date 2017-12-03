<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp" />

<c:if test="${ cookie.email.value != null && cookie.email.value != '' }">
    <%
        response.sendRedirect("Index");
    %>
</c:if>

<div class="banner-top">
    <div class="container">
            <h1>Connecter</h1>
            <em></em>
    </div>
</div>

<div class="container">
    <div class="login">
        <form method="POST" action="Login">
            <div class="col-md-6 login-do">
                    <div class="login-mail">
                        <input type="text" name="email" placeholder="Email" required="">
                        <i  class="glyphicon glyphicon-envelope"></i>
                    </div>
                    <div class="login-mail">
                        <input type="password" name="password" placeholder="Mot de passe" required="">
                        <i class="glyphicon glyphicon-lock"></i>
                    </div>
                    <c:if test="${ requestScope.error }">
                        <p>Email ou/et mot de passe incorrect !</p>
                        <p>Et verifier que votre compte est activé par l'administrateur!</p>
                        <br />
                    </c:if>
                    <label class="hvr-skew-backward">
                        <input type="submit" value="Connecter">
                    </label>
            </div>
            <div class="col-md-6 login-right">
                <h3>Créer un compte</h3>

                <p>
                    Créer votre compte sur la bibliotheque de l'université livre de tunis pour accéder a votre espace personnel ou vous pouvez reserver des documents en ligne.
                    L'inscription est facile et gratuite.
                </p>
               <a href="inscrire.jsp" class=" hvr-skew-backward">Creer mon compte</a>

            </div>

            <div class="clearfix"> </div>
        </form>
    </div>
<br /><br />
</div>


<%@include file="footer.jsp" %>