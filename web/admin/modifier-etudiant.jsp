<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.Bibliotheque.Model.Etudiant"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp" />
<c:import url="sidebar.jsp" />

<% 
    if(request.getParameter("id") == null || request.getParameter("id").equals("")) { %>
        <script type="text/javascript">
                window.location.href = "http://localhost:8080/Bibliotheque/admin/etudiants.jsp";
        </script>
<%   } else {
    int id = Integer.parseInt(request.getParameter("id"));
    Etudiant etud = new Etudiant();
    etud.setId(id);
    etud.obtenir();
    
    SimpleDateFormat stringToDate = new SimpleDateFormat("dd/mm/yyyy");
    Date date = stringToDate.parse(etud.getDateN());
    SimpleDateFormat format = new SimpleDateFormat("yyyyy-mm-dd");
    String dateN = format.format(date);
%>

<div class="main">
    <!-- MAIN CONTENT -->
    <div class="main-content">
            <div class="container-fluid">
                <div class="row">
                    <h3 class="page-title col-md-4">Modifier un etudiant</h3>
                </div>
                    <div class="panel">
                        <div class="panel-body">
                            <form method="POST" action="/Bibliotheque/ModifierEtudiant?id=<%= etud.getId() %>">
                                CIN: <input name="cin" class="form-control input-lg" value="<%= etud.getCin() %>" type="text"><br />
                                Carte Etudiant: <input name="carteE" class="form-control input-lg" value="<%= etud.getCarteE() %>" type="text"><br />
                                Email <input disabled name="email" class="form-control input-lg" value="<%= etud.getEmail() %>" type="text"><br />
                                Nom: <input name="nom" class="form-control input-lg" value="<%= etud.getNom() %>" type="text"><br />
                                Prenom <input name="prenom" class="form-control input-lg" value="<%= etud.getPrenom() %>" type="text"><br />
                                Date Naissance: <input name="dateN" class="form-control input-lg" value="<%= dateN %>" type="date"><br />
                                Universite: <input name="universite" class="form-control input-lg" value="<%= etud.getUniversite() %>" type="text"><br />
                                <br />
                                <div class="text-right">
                                    <input type="submit" class="btn btn-primary" value="Modifier" />
                                </div>
                            </form> 
                                <br />
                            <div class="text-right">
                                <button class="btn btn-danger" onClick="supprimer()">Supprimer</button>
                            </div>
                        </div>
                        
                    </div>
            </div>
    </div>
</div>
<script>
    function supprimer() {
        var res = confirm("Vous voulez supprimer cet etudiant ?");
        if(res === true) {
            window.location.replace("http://localhost:8080/Bibliotheque/ModifierEtudiant?id=<%= etud.getId() %>");
        }
    }
</script>
<% } %>
<c:import url="footer.jsp" />