<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp" />
<c:import url="sidebar.jsp" />

<div class="main">
    <!-- MAIN CONTENT -->
    <div class="main-content">
            <div class="container-fluid">
                <div class="row">
                    <h3 class="page-title col-md-4">Ajouter une categorie</h3>
                </div>
                    <div class="panel">
                        <div class="panel-body">
                            <form method="POST" action="/Bibliotheque/AjouterCategorie">
                                Libelle du categorie: <input name="libelle" class="form-control input-lg" placeholder="Libelle" type="text">
                                <br />
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