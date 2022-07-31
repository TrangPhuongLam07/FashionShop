<!-- Config page -->
<%-- <%@include file="../framePage/config-page.jsp" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<jsp:include page="../framePage/head.jsp"></jsp:include>


</head>
<body>
<!-- Preloader -->
<jsp:include page="../framePage/preloader-page.jsp"></jsp:include>

 <!-- Humberger -->
<jsp:include page="../framePage/humberger.jsp"></jsp:include>

<!--     Header -->
<jsp:include page="../framePage/header.jsp"></jsp:include>





  <!-- Hero -->
<jsp:include page="../framePage/hero.jsp"></jsp:include>

<!-- Banner Hero -->
<jsp:include page="banner-hero.jsp"></jsp:include>

<!--     Categories -->
<jsp:include page="categories.jsp"></jsp:include>
    
 <!-- Featured Product -->
<jsp:include page="featured-product.jsp"></jsp:include>
    
<!-- Banner -->
<jsp:include page="banner.jsp"></jsp:include>
    
<!-- Latest, Top rate, Review Product -->
<jsp:include page="latest-topRate-review-product.jsp"></jsp:include>
    
<!-- Blog News -->
<jsp:include page="blog-news.jsp"></jsp:include>
    
<!--         Footer -->
<jsp:include page="../framePage/footer.jsp"></jsp:include>

</body>

</html>