<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>


<br>
<div class="container text-center">
    <div class="row m-3">
        <div class="col">
            <h1>${product.description}</h1>
        </div>
    </div>

    <div class="row m-3">
        <div class="col">
            <img src="http://icons.iconarchive.com/icons/sonya/swarm/256/Shopping-icon.png" class="img-responsive"
                 alt="Image">
        </div>
        <div class="col">
            <div class="row">
                <div class="col">
                    <h4>Price: ${product.value} ${product.currency}</h4>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <p>${product.fullDescription}</p>
                </div>
            </div>
        </div>
    </div>
</div>
<a href = "<c:url value = "/editProduct?id=${product.id}"/>">Edit Product</a>

<jsp:include page="footer.jsp"></jsp:include>