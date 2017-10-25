<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>

<div class="container-fluid bg-3 text-center">
    <div class="row">
    <c:choose>
    <c:when test="${productList.size() > 0}">
    <c:forEach items="${productList}" var="product">
        <div class="col-sm-3 p-5">
            <a href="/productDescription?product=${product.id}" class="productLink">
                <img src="http://icons.iconarchive.com/icons/sonya/swarm/256/Shopping-icon.png"  class="img-responsive" alt="Image">
                <p>${product.description}</p>
                <p>${product.value} ${product.currency}</p>
            </a>
            <p><button type="button" class="btn btn-outline-success">Add to cart</button></p>
        </div>
    </c:forEach>
    </c:when>
    <c:otherwise>
        <h2>Niestety nie posiadamy takiego produktu :(</h2>
    </c:otherwise>
    </c:choose>
    </div>
</div><br>
<jsp:include page="footer.jsp"></jsp:include>