<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp" />

<%
    if(request.getAttribute("documents") == null) {
        request.getRequestDispatcher("/Index").forward(request, response);
    }
%>

<div class="banner">
<div class="container">
<section class="rw-wrapper">
    <h1 class="rw-sentence">
            <span>Bibliotheque ULT</span>
            <div class="rw-words rw-words-1">
                    <span>Documents</span>
                    <span>Livres</span>
                    <span>Théses</span>
                    <span>Publications</span>
                    <span>Cours</span>
                    <span>Et d'autre...</span>
            </div>
    </h1>
</section>
</div>
</div>

<div class="container">
    <div class="content-mid">
        <h3>Derniers documents</h3>
        <label class="line"></label>
        <div class="mid-popular">
        <c:forEach items="${ requestScope.documents }" var="document">
                <div class="col-md-3 item-grid simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="upload/${ document.image }" class="img-responsive" style="height: 300px" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="upload/${ document.image }" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                <a href="document.jsp?id=${document.getId()}"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                    <span><c:out value="${ document.langue }" /></span>
                                    <h6><a href="document.jsp?id=${document.getId()}"><c:out value="${ document.libelle }" /></a></h6>
                                </div>
                                
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p ><em class="item_price"><c:out value="${ document.nbrPages }" /> pages</em></p>
                                <div class="block">
                                    <span><c:out value="${ document.type }" /></span>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                </div>
                </div>
        </c:forEach>
        </div>							
    </div>


</div>

<%@include file="footer.jsp"%>