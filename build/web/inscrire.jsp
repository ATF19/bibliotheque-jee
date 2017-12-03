<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp" />

<c:if test="${ cookie.email.value != null && cookie.email.value != '' }">
    <%
        response.sendRedirect("Index");
    %>
</c:if>

<div class="banner-top">
    <div class="container">
            <h1>S'inscrire</h1>
            <em></em>
    </div>
</div>

<div class="container">
    <div class="login">
        <form method="POST" action="Signup">
            <div class="col-md-6 login-do">
                <div class="login-mail">
                    <input type="text" placeholder="Nom" required="" name="nom">
                    <i  class="glyphicon glyphicon-user"></i>
                </div>
                <div class="login-mail">
                    <input type="text" placeholder="Prenom" required="" name="prenom">
                    <i  class="glyphicon glyphicon-user"></i>
                </div>
                <div class="login-mail">
                    <input type="text" placeholder="Cin" required="" name="cin">
                    <i  class="glyphicon glyphicon-credit-card"></i>
                </div>
                <div class="login-mail">
                    <input type="text" placeholder="Carte etudiant" required="" name="carteE">
                    <i  class="glyphicon glyphicon-credit-card"></i>
                </div>
                <div class="login-mail">
                    <input placeholder="Date" type="date" required="" name="dateN" >
                    <i  class="glyphicon glyphicon-calendar"></i>
                </div>
                <div class="login-mail">
                    <input type="text" placeholder="Universite" required="" name="universite">
                    <i  class="glyphicon glyphicon-home"></i>
                </div>
                <div class="login-mail">
                    <input type="text" placeholder="Email" required="" name="email">
                    <i  class="glyphicon glyphicon-user"></i>
                </div>
                <div class="login-mail">
                    <input type="password" placeholder="Mot de passe" required="" name="password">
                    <i  class="glyphicon glyphicon-lock"></i>
                </div>
                <% if(request.getParameter("errorCode") != "" && request.getParameter("errorCode") != null) { %>
                <% if(Integer.parseInt(request.getParameter("errorCode")) == 0) { %>
                            <p>Mot de passe top court !</p>
                        <br />
                    <% } %>
                    <% if(Integer.parseInt(request.getParameter("errorCode")) == 1) { %>
                            <p>CIN incorrect !</p>
                        <br />
                    <% } %>
                    <% if(Integer.parseInt(request.getParameter("errorCode")) == 2) { %>
                            <p>Email invalid !</p>
                        <br />
                    <% } %>
                    <% if(Integer.parseInt(request.getParameter("errorCode")) == 3) { %>
                            <p>Email existe deja !</p>
                        <br />
                    <% } %>
                <% } %>
                <c:if test="${ requestScope.error }">
                    <p>Erreur dans l'inscription ! Verifier votre coordonnées</p>
                    <br />
                </c:if>
                <label class="hvr-skew-backward">
                    <input type="submit" value="S'inscrire">
                </label>
            </div>
            <div class="col-md-6 login-right">
                <h3>Créer un compte</h3>

                <p>
                    Créer votre compte sur la bibliotheque de l'université livre de tunis pour accéder a votre espace personnel ou vous pouvez reserver des documents en ligne.
                    L'inscription est facile et gratuite.
                </p>
               <a href="connecter.jsp" class=" hvr-skew-backward">Connecter</a>

            </div>

            <div class="clearfix"> </div>
        </form>
    </div>

</div>


<%@include file="footer.jsp" %>