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
                    <h3 class="page-title col-md-4">Categories</h3>
                    <div class="input-group col-md-8">
                        <input type="text" value="" class="form-control" id="searchInput" placeholder="Recherche..." onkeyup="search()">
                    </div>
                </div>
                    <div class="panel">
                        <div class="panel-body">
                                <table class="table table-striped" id="searchTable">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Libelle</th>
                                            <th>Modifier</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% 
                                         for(int i=0; i<categories.size(); i++) { 
                                            Categorie cat = categories.get(i);
                                        %>
                                            <tr>
                                                <td><%= cat.getId() %></td>
                                                <td><%= cat.getLibelle() %></td>
                                                <td><a href="modifier-categorie.jsp?id=<%= cat.getId() %>" class="btn btn-primary"><i class="fa fa-pencil"></i> Modifier</a></td>
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
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
              tr[i].style.display = "";
            } else {
              tr[i].style.display = "none";
            }
          } 
        }
    }
</script>
                                        
<c:import url="footer.jsp" />