<!-- Config page -->
<%-- <%@include file="../framePage/config-page.jsp" %> --%>
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
            
            
            <div class="row featured__filter">
            <c:forEach items="${listProducts}" var="a">
                <div class="col-lg-3 col-md-4 col-sm-6 mix ao ">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="${a.image}">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="/cart/add/${a.productID}/1/${customerID}"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">${a.productname}</a></h6>
                            <h5>${a.price}</h5>
                        </div>
                    </div>
                </div>
                </c:forEach>
               

                 <div>
                 Total Items: ${totalItems} - Page ${currentPage} of ${totalPages}
                 &nbsp;-
                 <c:forEach begin="1" end="${totalPages}" var="i" >
                 	 &nbsp;
                 		<span>
                 		<a href="${i}">${i}</a> &nbsp;&nbsp;

                 		</span>
                 </c:forEach>
                 </div>

                
            </div>
        </div>
    </section>
    <!-- Featured Section End -->
</body>
</html>