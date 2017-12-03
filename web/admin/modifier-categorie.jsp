<%@page import="com.Bibliotheque.Model.Categorie"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp" />
<c:import url="sidebar.jsp" />

<% 
    if(request.getParameter("id") == null || request.getParameter("id").equals("")) { %>
        <script type="text/javascript">
            window.location.href = "http://localhost:8080/Bibliotheque/admin/categories.jsp";
        </script>
<%   } else {
    int id = Integer.parseInt(request.getParameter("id"));
    Categorie cat = new Categorie();
    cat.setId(id);
    cat.obtenir();
%>

<div class="main">
    <!-- MAIN CONTENT -->
    <div class="main-content">
            <div class="container-fluid">
                <div class="row">
                    <h3 class="page-title col-md-4">Modifier une categorie</h3>
                </div>
                    <div class="panel">
                        <div class="panel-body">
                            <form method="POST" action="/Bibliotheque/ModifierCategorie?id=<%= cat.getId() %>">
                                Libelle du categorie: <input name="libelle" class="form-control input-lg" value="<%= cat.getLibelle() %>" type="text">
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
        var res = confirm("Vous voulez supprimer cette categorie ?");
        if(res === true) {
            window.location.replace("http://localhost:8080/Bibliotheque/ModifierCategorie?id=<%= cat.getId() %>");
        }
    }
</script>
<% } %>
<c:import url="footer.jsp" />