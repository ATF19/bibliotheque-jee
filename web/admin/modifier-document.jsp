<%@page import="com.Bibliotheque.Model.Document"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Bibliotheque.Model.Categorie"%>
<%@page import="com.Bibliotheque.Model.Liste"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp" />
<c:import url="sidebar.jsp" />

<% 
    if(request.getParameter("id") == null || request.getParameter("id").equals("")) { %>
        <script type="text/javascript">
            window.location.href = "http://localhost:8080/Bibliotheque/admin/documents.jsp";
        </script>
<%   } else {
    int id = Integer.parseInt(request.getParameter("id"));
    Document doc = new Document();
    doc.setId(id);
    doc.obtenir();
%>

<% 
    Liste listeDocuments = new Liste();
    listeDocuments.obtenirCategories();
    ArrayList<Categorie> categories = listeDocuments.getCategories();
%>

<div class="main">
    <!-- MAIN CONTENT -->
    <div class="main-content">
            <div class="container-fluid">
                <div class="row">
                    <h3 class="page-title col-md-4">Modifier un document</h3>
                </div>
                    <div class="panel">
                        <div class="panel-body">
                            <form method="POST" action="/Bibliotheque/ModifierDocument?id=<%= doc.getId() %>" enctype="multipart/form-data">
                                Categorie
                                <select name="categorie" class="form-control input-lg">
                                    <% 
                                    for(int i=0; i<categories.size(); i++) { 
                                        Categorie cat = categories.get(i);
                                    %>
                                        <option value="<%= cat.getId() %>" <% if(doc.getIdCategorie() == cat.getId()) { %> selected <% } %> ><%= cat.getLibelle() %></option>
                                    <% } %>
                                </select>
                                <br />
                                Libelle <input name="libelle" class="form-control input-lg" placeholder="Libelle" value="<%= doc.getLibelle() %>" type="text"><br />
                                Langue 
                                <select name="langue" class="form-control input-lg">
                                    <option value="francais" <% if(doc.getLangue().equals("francais")) { %> selected <% } %>>Francais</option>
                                    <option value="anglais" <% if(doc.getLangue().equals("anglais")) { %> selected <% } %>>Anglais</option>
                                    <option value="arabe" <% if(doc.getLangue().equals("arabe")) { %> selected <% } %>>Arabe</option>
                                    <option value="espagnol" <% if(doc.getLangue().equals("espagnol")) { %> selected <% } %>>Espagnol</option>   
                                </select>
                                <br />
                                Description <textarea name="description" class="form-control input-lg" rows="4" placeholder="Description" type="text"><%= doc.getDescription() %></textarea><br />
                                Image <input name="image" class="form-control input-lg" accept="image/*" placeholder="Image" type="file"><br />
                                Nobmre de pages <input name="nbrPages" value="<%= doc.getNbrPages() %>" class="form-control input-lg" placeholder="Pages" type="number"><br />
                                <br />
                                <div>
                                    <% if(doc.getType().equals("livre")) { %>
                                    Auteur <input value="<%= doc.getLivre().getAuteur() %>" name="auteur" class="form-control input-lg" placeholder="Auteur" type="text"><br />
                                    ISBN <input value="<%= doc.getLivre().getISBN() %>" name="isbn" class="form-control input-lg" placeholder="ISBN" type="text"><br />
                                    <% } %>
                                </div>
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

<c:import url="footer.jsp" />
<script>
    function supprimer() {
        var res = confirm("Vous voulez supprimer ce document ?");
        if(res === true) {
            window.location.replace("http://localhost:8080/Bibliotheque/ModifierDocument?id=<%= doc.getId() %>");
        }
    }
</script>
<% } %>