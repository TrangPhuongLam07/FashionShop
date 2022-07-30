<!-- Config page -->
<jsp:include page="../framePage/config-page.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="UTF-8"> -->
<!--     <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<!--     <meta http-equiv="X-UA-Compatible" content="ie=edge"> -->
    <title>Login</title>

<!-- Font Icon -->
    <link rel="stylesheet" href="css/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/css-signup/css/style.css">
     <link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>
<!-- Preloader -->
<jsp:include page="../framePage/preloader-page.jsp"></jsp:include>

    
    <div class="main">

        <!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="img/signin-image.jpg" alt="sing up image"></figure>
                        <a href="/signUp" class="signup-image-link">Create an account</a>
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">Login</h2>
                        <form action="login" method="POST" class="register-form" id="login-form">
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="name" id="your_name" class="form-control name" placeholder="Your Name"/>
                                <div class="invalid-feedback" style="font-size:16px; color: red;">Name is required</div>
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="pass" id="your_pass" class="form-control pass" placeholder="Password"/>
                             <div class="invalid-feedback" style="font-size:16px; color: red;">Password is required</div>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                                <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
                            </div>
                            <button class="form-submit" >Log in</button>
<!--                             <div class="form-group form-button"> -->
<!--                                 <input type="button"  class="form-submit" value="Log in"/> -->
<!--                             </div> -->
                        </form>
                        <div class="social-login">
                            <span class="social-label">Or login with</span>
                            <ul class="socials">
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-facebook"></i></a></li>
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-twitter"></i></a></li>
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-google"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </div>

    


<!-- JS -->
    <script src="js/js-signup/vendor/jquery/jquery.min.js"></script>
    <script src="js/js-signup/js/main.js"></script>
   <script src="js/js-signup/signup.js"></script>
</body>
</html>