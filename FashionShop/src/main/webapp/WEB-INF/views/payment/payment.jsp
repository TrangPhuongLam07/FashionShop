<!-- Config page -->
<jsp:include page="../framePage/config-page.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../framePage/head.jsp"></jsp:include>
<title>Payment</title>
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
                        <h2>Payment</h2>
                        <div class="breadcrumb__option">
                            <a href="/">Home</a>
                            <span>Payment</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h6><span class="icon_tag_alt"></span> Have a coupon? <a href="#">Click here</a> to enter your code
                    </h6>
                </div>
            </div>
            <div class="checkout__form">
                <h4>Billing Details</h4>
                <form action="payment" method="POST" id="payment-form">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input form-group">
                                        <p>Name<span>*</span></p>
                                        <input type="text" name="name" id="name" class="form-control name" >
                                         <div class="invalid-feedback" style="font-size:16px; color: red;">Name is required</div>
                                    </div> 
                                   
                                </div>
                                
                            </div>
                           
                            <div class="checkout__input form-group">
                                <p>Address<span>*</span></p>
                                <input type="text" name="address" id="address"
                                placeholder="Street Address" class="checkout__input__add form-control address" >
<!--                                 <input type="text" placeholder="Apartment, suite, unite ect (optinal)"> -->
								<div class="invalid-feedback" style="font-size:16px; color: red;">Address is required</div>
                            </div>
                            
                           
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input form-group">
                                        <p>Phone<span>*</span></p>
                                        <input type="text" name="phone" id="phone" class="form-control phone">
                                        <div class="invalid-feedback" style="font-size:16px; color: red;">Phone is required</div>
                                    </div>
                                </div>
                                
                            </div>
                            
                            
<!--                             <div class="checkout__input__checkbox"> -->
<!--                                 <label for="diff-acc"> -->
<!--                                     Ship to a different address? -->
<!--                                     <input type="checkbox" id="diff-acc"> -->
<!--                                     <span class="checkmark"></span> -->
<!--                                 </label> -->
<!--                             </div> -->
                            <div class="checkout__input form-group">
                                <p>Order notes</p>
                                <input type="text" name="notes" id="notes" class="form-control notes"
                                    placeholder="Notes about your order, e.g. special notes for delivery.">
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <div class="checkout__order">
                                <h4>Your Order</h4>
                                <div class="checkout__order__products">Products <span>Total</span></div>
                                <ul>
                                <c:forEach items="${listShowCartItem}" var="a">
                                    <li>${a.productname} <span>${a.price}</span></li>
                                </c:forEach>

                                </ul>
                                <div class="checkout__order__subtotal">Subtotal <span></span></div>
                                <div class="checkout__order__total">Total <span>${totalCart}</span></div>
                                
                                <div class="checkout__input__checkbox">
                                    <label for="payment">
                                        Check Payment
                                        <input type="checkbox" id="payment">
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                                <div class="checkout__input__checkbox">
                                    <label for="paypal">
                                        Paypal
                                        <input type="checkbox" id="paypal">
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                                <button  class="site-btn">PLACE ORDER</button>
                            </div>
                        </div>
                    </div>
                </form>
                
            </div>
        </div>
    </section>
    <!-- Checkout Section End -->


 <!-- Footer -->
<jsp:include page="../framePage/footer.jsp"></jsp:include>
   <script src="js/js-signup/signup.js"></script>
</body>
</html>