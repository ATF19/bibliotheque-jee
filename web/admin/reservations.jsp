<%@page import="com.Bibliotheque.Model.Document"%>
<%@page import="com.Bibliotheque.Model.Etudiant"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Bibliotheque.Model.Reservation"%>
<%@page import="com.Bibliotheque.Model.Liste"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp" />
<c:import url="sidebar.jsp" />

<% 
    Liste listeReservation = new Liste();
    listeReservation.obtenirReservers();
    ArrayList<Reservation> reservations = listeReservation.getReservers();
%>

<div class="main">
    <!-- MAIN CONTENT -->
    <div class="main-content">
            <div class="container-fluid">
                <div class="row">
                    <h3 class="page-title col-md-4">Documents</h3>
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
                                            <th>Etudiant</th>
                                            <th>Document</th>
                                            <th>Date Reservation</th>
                                            <th>Date Retour</th>
                                            <th>Retourner</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% 
                                         for(int i=0; i<reservations.size(); i++) { 
                                            Reservation res = reservations.get(i);
                                            Etudiant etud = new Etudiant();
                                            etud.setId(res.getIdEtudiant());
                                            etud.obtenir();
                                            Document doc = new Document();
                                            doc.setId(res.getIdDocument());
                                            doc.obtenir();
                                        %>
                                            <tr>
                                                <td><%= res.getId() %></td>
                                                <td><%= etud.getNom()+" "+etud.getPrenom() %></td>
                                                <td><%= doc.getLibelle() %></td>
                                                <td><%= res.getDateDebut() %></td>
                                                <td><%= res.getDateFin() %></td>
                                                <td>
                                                    <% if(res.getDateFin().equals("-")) { %>
                                                        <a href="/Bibliotheque/Retourner?id=<%= res.getId() %>" class="btn btn-primary"><i class="fa fa-pencil"></i> Document retourn�</a>
                                                    <% } else {%>
                                                        Document deja retourn�
                                                    <% } %>
                                                </td>
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