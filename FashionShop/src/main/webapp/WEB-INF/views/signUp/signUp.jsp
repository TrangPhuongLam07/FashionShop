<!-- Config page -->
<jsp:include page="../framePage/config-page.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up</title>

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

        <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Sign up</h2>
                        <form action="signUp" method="POST"  class="register-form" id="register-form">
                        
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="name" id="name" class="form-control name" placeholder="Your Name"/>
                                <div class="invalid-feedback" style="font-size:16px; color: red;">Name is required</div>
                            </div>
                             <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="account" id="account" class="form-control account" placeholder="Account"/>
                                <div class="invalid-feedback" style="font-size:16px; color: red;">Account is required</div>
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="email" name="email" id="email" class="form-control email" placeholder="Your Email"/>
                                 <div class="invalid-feedback" style="font-size:16px; color: red;">Email is required</div>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="pass" id="pass" class="form-control pass" placeholder="Password"/>
                                 <div class="invalid-feedback" style="font-size:16px; color: red;">Password is required</div>
                            </div>
                            <div class="form-group">
                                <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="password" name="re_pass" id="re_pass" class="form-control re_pass" placeholder="Repeat your password"/>
                                 <div class="invalid-feedback" style="font-size:16px; color: red;">Repeat password is required</div>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="agree-term" id="agree-term" class="form-control agree-term" />
                                <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                                 <div class="invalid-feedback" style="font-size:16px; color: red;">You don't agree</div>
                            </div>
                            
                            <button name="signup" id="signup" class="form-submit">Register</button>
<!--                             <div class="form-group form-button"> -->
<!--                                 <input type="button" name="signup" id="signup" class="form-submit" value="Register"/> -->
                               
<!--                             </div> -->
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="img/signup-image.jpg" alt="sing up image"></figure>
                        <a href="/login" class="signup-image-link">I am already member</a>
                    </div>
                </div>
            </div>
        </section>

		
        
    </div>

    


<!-- JS -->
    <script src="js/js-signup/vendor/jquery/jquery.min.js"></script>
<!--     <script src="js/js-signup/js/main.js"></script> -->
    <script src="js/js-signup/signup.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


</body>
</html>