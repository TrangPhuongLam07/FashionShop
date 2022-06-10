<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Featured Section Begin -->
    <section class="featured spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>Featured Product</h2>
                    </div>
                    <div class="featured__controls">
                        <ul>
                            <li class="active" data-filter="*">All</li>
                            <li data-filter=".ao">Áo</li>
                            <li data-filter=".quan">Quần</li>
                            <li data-filter=".non">Nón</li>
                            <li data-filter=".tui">Túi</li>
                        </ul>
                    </div>
                </div>
            </div>
            <c:forEach items="${list}" var="b">
            <div class="row featured__filter">
                <div class="col-lg-3 col-md-4 col-sm-6 mix ao ">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="${b.image}">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">${b.productname}</a></h6>
                            <h5>${b.price}</h5>
                        </div>
                    </div>
                </div>
                
               
                
                <div class="col-lg-3 col-md-4 col-sm-6 mix quan">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="img/featured/feature-2.jpg">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                
                <div class="col-lg-3 col-md-4 col-sm-6 mix non">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="img/featured/feature-3.jpg">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                
                <div class="col-lg-3 col-md-4 col-sm-6 mix tui">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="img/featured/feature-4.jpg">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                 </c:forEach>
<!--                 <div class="col-lg-3 col-md-4 col-sm-6 mix fresh-meat vegetables"> -->
<!--                     <div class="featured__item"> -->
<!--                         <div class="featured__item__pic set-bg" data-setbg="img/featured/feature-5.jpg"> -->
<!--                             <ul class="featured__item__pic__hover"> -->
<!--                                 <li><a href="#"><i class="fa fa-heart"></i></a></li> -->
<!--                                 <li><a href="#"><i class="fa fa-retweet"></i></a></li> -->
<!--                                 <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li> -->
<!--                             </ul> -->
<!--                         </div> -->
<!--                         <div class="featured__item__text"> -->
<!--                             <h6><a href="#">Crab Pool Security</a></h6> -->
<!--                             <h5>$30.00</h5> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
                
<!--                 <div class="col-lg-3 col-md-4 col-sm-6 mix oranges fastfood"> -->
<!--                     <div class="featured__item"> -->
<!--                         <div class="featured__item__pic set-bg" data-setbg="img/featured/feature-6.jpg"> -->
<!--                             <ul class="featured__item__pic__hover"> -->
<!--                                 <li><a href="#"><i class="fa fa-heart"></i></a></li> -->
<!--                                 <li><a href="#"><i class="fa fa-retweet"></i></a></li> -->
<!--                                 <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li> -->
<!--                             </ul> -->
<!--                         </div> -->
<!--                         <div class="featured__item__text"> -->
<!--                             <h6><a href="#">Crab Pool Security</a></h6> -->
<!--                             <h5>$30.00</h5> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
<!--                 <div class="col-lg-3 col-md-4 col-sm-6 mix fresh-meat vegetables"> -->
<!--                     <div class="featured__item"> -->
<!--                         <div class="featured__item__pic set-bg" data-setbg="img/featured/feature-7.jpg"> -->
<!--                             <ul class="featured__item__pic__hover"> -->
<!--                                 <li><a href="#"><i class="fa fa-heart"></i></a></li> -->
<!--                                 <li><a href="#"><i class="fa fa-retweet"></i></a></li> -->
<!--                                 <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li> -->
<!--                             </ul> -->
<!--                         </div> -->
<!--                         <div class="featured__item__text"> -->
<!--                             <h6><a href="#">Crab Pool Security</a></h6> -->
<!--                             <h5>$30.00</h5> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
<!--                 <div class="col-lg-3 col-md-4 col-sm-6 mix fastfood vegetables"> -->
<!--                     <div class="featured__item"> -->
<!--                         <div class="featured__item__pic set-bg" data-setbg="img/featured/feature-8.jpg"> -->
<!--                             <ul class="featured__item__pic__hover"> -->
<!--                                 <li><a href="#"><i class="fa fa-heart"></i></a></li> -->
<!--                                 <li><a href="#"><i class="fa fa-retweet"></i></a></li> -->
<!--                                 <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li> -->
<!--                             </ul> -->
<!--                         </div> -->
<!--                         <div class="featured__item__text"> -->
<!--                             <h6><a href="#">Crab Pool Security</a></h6> -->
<!--                             <h5>$30.00</h5> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
                
            </div>
        </div>
    </section>
    <!-- Featured Section End -->
</body>
</html>