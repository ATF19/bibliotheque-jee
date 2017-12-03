<%@page import="com.Bibliotheque.Model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Bibliotheque.Model.Etudiant"%>
<%@page import="com.Bibliotheque.Model.Liste"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp" />
<c:import url="sidebar.jsp" />

<% 
    Liste listeDocuments = new Liste();
    listeDocuments.obtenirEtudiants();
    ArrayList<Etudiant> etudiants = listeDocuments.getEtudiants();
%>

<div class="main">
    <!-- MAIN CONTENT -->
    <div class="main-content">
            <div class="container-fluid">
                <div class="row">
                    <h3 class="page-title col-md-4">Etudiants</h3>
                    <div class="input-group col-md-8">
                        <input type="text" value="" class="form-control" id="searchInput" placeholder="Recherche..." onkeyup="search()">
                    </div>
                </div>
                    <div class="panel">
                        <div class="panel-body">
                                <table class="table table-striped" id="searchTable">
                                    <thead>
                                        <tr>
                                            <th>Cin</th>
                                            <th>Carte Etudiant</th>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>Universite</th>
                                            <th>Activer</th>
                                            <th>Modifier</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% 
                                         for(int i=0; i<etudiants.size(); i++) { 
                                            Etudiant etud = etudiants.get(i);
                                            User user = new User();
                                            user.setEmail(etud.getEmail());
                                            user.obtenir();
                                        %>
                                            <tr>
                                                <td><%= etud.getCin() %></td>
                                                <td><%= etud.getCarteE() %></td>
                                                <td><%= etud.getNom() %></td>
                                                <td><%= etud.getPrenom() %></td>
                                                <td><%= etud.getUniversite() %></td>
                                                <td>
                                                    <% if(user.getActif() == 0) { %>
                                                        <a href="/Bibliotheque/AdminUser?op=activer&email=<%= user.getEmail() %>" class="btn btn-warning"><i class="fa fa-check-square"></i> Activer</a>
                                                    <% } else { %>
                                                         <a href="/Bibliotheque/AdminUser?op=desactiver&email=<%= user.getEmail() %>" class="btn btn-warning"><i class="fa fa-lock"></i> Desactiver</a>
                                                    <% } %>
                                                </td>
                                                <td><a href="modifier-etudiant.jsp?id=<%= etud.getId() %>" class="btn btn-primary"><i class="fa fa-pencil"></i> Modifier</a></td>
                                            </tr>
                                        <% } %>
                                    </tbody>
                                </table>
                        </div>

                    </div>
            </div>
    </div>
</div>

<script>
    function search() {
        var input, filter, table, tr, td, i;
        input = document.getElementById("searchInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("searchTable");
        tr = table.getElementsByTagName("tr");

        // Loop through all table rows, and hide those who don't match the search query
        for (i = 0; i < tr.length; i++) {
          td = tr[i].getElementsByTagName("td")[1];
          if (td) {
            if (
                    td.innerHTML.toUpperCase().indexOf(filter) > -1 || tr[i].getElementsByTagName("td")[0].innerHTML.toUpperCase().indexOf(filter) > -1
                    || tr[i].getElementsByTagName("td")[2].innerHTML.toUpperCase().indexOf(filter) > -1 || tr[i].getElementsByTagName("td")[3].innerHTML.toUpperCase().indexOf(filter) > -1
                    || tr[i].getElementsByTagName("td")[4].innerHTML.toUpperCase().indexOf(filter) > -1
                        ) {
              tr[i].style.display = "";
            } else {
              tr[i].style.display = "none";
            }
          } 
        }
    }
</script>
                                        
<c:import url="footer.jsp" />