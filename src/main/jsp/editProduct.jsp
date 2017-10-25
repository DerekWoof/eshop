<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>


<br>
<div class="container text-center">
    <div class="row m-3">
        <div class="col">
            <h1>EDIT PRODUCT</h1>
        </div>
    </div>

    <div class="row m-3" style="text-align: left">
        <div class="col">
            <div class="row">
                <div class="col">
                    <b>Product description :</b> ${product.description}
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <b>Product full description :</b> ${product.fullDescription}
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <b>Product price :</b> ${product.value}
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <b>Product currency :</b> ${product.currency}
                </div>
            </div>

        </div>
        <div class="col" style="text-align: left">
            <form action="/editProduct" method="post">
                <label>Product description</label><br>
                <input type="text" name="description"><br>
                <label>Product full description :</label><br>
                <input type="text" name="product.fullDescription"><br>
                <label>Product price </label><br>
                <input type="number" name="value"><br>
                <label>Currency</label><br>
                <select class="form-control" id="currency" name="currency">
                    <option>PLN</option>
                    <option>EUR</option>
                    <option>USD</option>
                    <option>GBP</option>
                </select><br>

                <textarea class="form-control" id="idDis" rows="1" name="idDis" readonly>${product.id}</textarea>
                <button type="submit" class="btn btn-outline-success">Edit product</button>
            </form>
            </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>