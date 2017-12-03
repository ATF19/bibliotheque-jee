<%@page import="java.util.ArrayList"%>
<%@page import="com.Bibliotheque.Model.Categorie"%>
<%@page import="com.Bibliotheque.Model.Liste"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp" />
<c:import url="sidebar.jsp" />

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
                    <h3 class="page-title col-md-4">Ajouter un document</h3>
                </div>
                    <div class="panel">
                        <div class="panel-body">
                            <form method="POST" action="/Bibliotheque/AjouterDocument" enctype="multipart/form-data">
                                Categorie
                                <select name="categorie" class="form-control input-lg">
                                    <% 
                                    for(int i=0; i<categories.size(); i++) { 
                                        Categorie cat = categories.get(i);
                                    %>
                                        <option value="<%= cat.getId() %>"><%= cat.getLibelle() %></option>
                                    <% } %>
                                </select>
                                <br />
                                Libelle <input name="libelle" class="form-control input-lg" placeholder="Libelle" type="text"><br />
                                Langue 
                                <select name="langue" class="form-control input-lg">
                                    <option value="francais">Francais</option>
                                    <option value="anglais">Anglais</option>
                                    <option value="arabe">Arabe</option>
                                    <option value="espagnol">Espagnol</option>   
                                </select>
                                <br />
                                Description <textarea name="description" class="form-control input-lg" rows="4" placeholder="Description" type="text"></textarea><br />
                                Image <input name="image" class="form-control input-lg" accept="image/*" placeholder="Image" type="file"><br />
                                Nobmre de pages <input name="nbrPages" class="form-control input-lg" placeholder="Pages" type="number"><br />
                                Type 
                                <select id="type" name="type" class="form-control input-lg">
                                    <option value="cours">Cours</option>
                                    <option value="livre">Livre</option>
                                    <option value="these">These</option>
                                </select>
                                <br />
                                <div id="hide">
                                    Auteur <input name="auteur" class="form-control input-lg" placeholder="Auteur" type="text"><br />
                                    ISBN <input name="isbn" class="form-control input-lg" placeholder="ISBN" type="text"><br />
                                </div>
                                <div class="text-right">
                                    <input type="submit" class="btn btn-primary" value="Ajouter" />
                                </div>
                            </form>  
                        </div>
                        
                    </div>
            </div>
    </div>
</div>


<c:import url="footer.jsp" />
<script>
    $("#hide").hide();
    $('#type').on('change', function() {
      if(this.value == "livre") {
          $("#hide").show(500);
      }
      else {
          $("#hide").hide(500);
      }
    })
</script>