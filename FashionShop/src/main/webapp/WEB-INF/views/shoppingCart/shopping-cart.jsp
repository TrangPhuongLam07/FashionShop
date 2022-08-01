<!-- Config page -->
<jsp:include page="../framePage/config-page.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="../framePage/head.jsp"></jsp:include>
<title>Shopping Cart</title>
</head>
<body>
<!-- Preloader -->
<jsp:include page="../framePage/preloader-page.jsp"></jsp:include>

<!-- Humberger -->
<jsp:include page="../framePage/humberger.jsp"></jsp:include>

    <!-- Header -->
<jsp:include page="../framePage/header.jsp"></jsp:include>

 <!-- Hero -->
<jsp:include page="../framePage/hero.jsp"></jsp:include>

<!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                    
                        <h2>Shopping Cart</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <span>Shopping Cart</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shoping Cart Section Begin -->
    <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                    
                        <table>
                            <thead>
                                <tr>
                                    <th class="shoping__product">Products</th>
                                    <th>Price </th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listShowCartItem}" var="c" >
                            	
                                <tr>
                                    <td class="shoping__cart__item">
                                        <img style="width: 100px; height: 100px" src="${c.image}" alt="">
                                        <h5>${c.productname}</h5>
                                    </td>
                                    <td class="shoping__cart__price">
                                        ${c.price}
                                    </td>
                                    <td class="shoping__cart__quantity">
                                        <div class="quantity">
                                            <div class="pro-qty">
                                                <input type="text" value="${c.quantity}">
                                            </div>
                                        </div>
                                    </td>
                                    <td class="shoping__cart__total">
                                       <c:out value=" ${c.price *c.quantity}"></c:out>
                                    </td>
                                    <td class="shoping__cart__item__close">
                                    <span><a href="/cart/delete/${c.productID}" class="icon_close"></a></span>
                                    	
                                    </td>
                                </tr>
                                
                               
                             </c:forEach>
                                
                               
                            </tbody>
                        </table>
                        
                        
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__btns">
                        <a href="#" class="primary-btn cart-btn">CONTINUE SHOPPING</a>
                        <a href="#" class="primary-btn cart-btn cart-btn-right"><span class="icon_loading"></span>
                            Upadate Cart</a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__continue">
                        <div class="shoping__discount">
                            <h5>Discount Codes</h5>
                            <form action="#">
                                <input type="text" placeholder="Enter your coupon code">
                                <button type="submit" class="site-btn">APPLY COUPON</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__checkout">
                        <h5>Cart Total</h5>
                        <ul>
                            <li>Subtotal <span>0</span></li>
<%--                             <c:set value="0" var="total"></c:set> --%>
<%--                             <c:forEach items="${listShowCartItem}" var="c"> --%>
                            	
<%--                             	${total += c.price*c.quantity}<br/> --%>
<%--                             </c:forEach> --%>
<%--                             <c:out value="${total}"></c:out> --%>
                            
                            <li>Total <span>${totalCart}</span></li>
                        </ul>
                        <a href="/payment" class="primary-btn">PROCEED TO CHECKOUT</a>
                    </div>
                </div>
            </div>
        </div>
        <c:if test="${listShowCartItem} == null" >
        <div>I think you must buy something</div>
        </c:if>
    </section>
    <!-- Shoping Cart Section End -->


 <!-- Footer -->
<jsp:include page="../framePage/footer.jsp"></jsp:include>

</body>
</html>