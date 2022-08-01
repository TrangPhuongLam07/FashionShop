//
//$(document).ready(function(){
//	$("#signup").click(function(){
//		const name = $("#name").val();
//		const account = $("#account").val();
//		const email = $("#email").val();
//		const pass = $("#pass").val();
//		const re_pass = $("#re_pass").val();
//		
//		if(name.length == ""){
//			$(".name").addClass("is-invalid");
//		}else{
//			$(".name").removeClass("is-invalid");
//		}
//		
//		if(account.length == ""){
//			$(".account").addClass("is-invalid");
//		}else{
//			$(".account").removeClass("is-invalid");
//		}
//		
//		if(email.length == ""){
//			$(".email").addClass("is-invalid");
//		}else{
//			$(".email").removeClass("is-invalid");
//		}
//		
//		if(pass.length == ""){
//			$(".pass").addClass("is-invalid");
//		}else{
//			$(".pass").removeClass("is-invalid");
//		}
//		
//		if(re_pass.length == ""){
//			$(".re_pass").addClass("is-invalid");
//		}else{
//			$(".re_pass").removeClass("is-invalid");
//		}
//		
//		if(name.length != "" && email.length != "" && pass.length != "" && re_pass != ""){
//			$.ajax({
//				type: "POST",
//				contentType: "application/json",
//				url: "/signUp/signUp",
//				data: {"name": name, "email": email, "pass": pass, "re_pass": re_pass},
//				dataType: "JSON",
//				success: function(feedback){
//					console.log("SUCCESS: ", feedback);
//					var result = "";
//					
//				} 
//				
//			})
//		}
//		
//		if(name.equals(re_pass)){
//			
//		}
//		
//	})
//	
//	$("#signin").click(function(){
//		const name = $("#name").val();
//		const pass = $("#pass").val();
//		
//		
//		if(name.length == ""){
//			$(".name").addClass("is-invalid");
//		}else{
//			$(".name").removeClass("is-invalid");
//		}
//		
//		if(pass.length == ""){
//			$(".pass").addClass("is-invalid");
//		}else{
//			$(".pass").removeClass("is-invalid");
//		}
//		
//	})
//})
//
//function signUp(){
//	var name = $("#name").val();
//	var email = $("#email").val();
//	var pass = $("#pass").val();
//	var re_pass = $("#re_pass").val();
//	
//	if(name.length != "" && email.length != "" && pass.length != "" && re_pass != ""){
//			$.ajax({
//				type: "POST",
//				contentType: "application/json",
//				url: "/signUp/signUp",
//				data: {"name": name, "email": email, "pass": pass, "re_pass": re_pass},
//				dataType: "JSON",
//				success: function(feedback){
//					
//				} 
//				
//			})
//		}
//}
//
//function getAllProducts(){
//	$.ajax({
//		type: "GET",
//		url: "http://localhost:8080/products",
//		success: function(){
////			console.log(products)
//			alert("Success");
////			displayProduct(products);
//		}
//	})
//}
//
//function displayProduct(array){
//	let res = ""
//	for(let i = 0; i < array.length; i++){
//		res += array[i].name + "<br>";
//	}
//	document.getElementById("display").innerHTML = res;
//}
//

$(document).ready(function(){
	console.log("page is ready............")
		$("#register-form").one('submit', function (event) {
			event.preventDefault();
			
			var f = $(this).serialize();
			
			console.log(f);
		const name = $("#name").val();
		const account = $("#account").val();
		const email = $("#email").val();
		const pass = $("#pass").val();
		const re_pass = $("#re_pass").val();
		
		if(name.length == ""){
			$(".name").addClass("is-invalid");
		}else{
			$(".name").removeClass("is-invalid");
		}
		
		if(account.length == ""){
			$(".account").addClass("is-invalid");
		}else{
			$(".account").removeClass("is-invalid");
		}
		
		if(email.length == ""){
			$(".email").addClass("is-invalid");
		}else{
			$(".email").removeClass("is-invalid");
		}
		
		if(pass.length == ""){
			$(".pass").addClass("is-invalid");
		}else{
			$(".pass").removeClass("is-invalid");
		}
		
		if(re_pass.length == ""){
			$(".re_pass").addClass("is-invalid");
		}else{
			$(".re_pass").removeClass("is-invalid");
		}
			
			
		if(name.length != "" && email.length != "" && pass.length != "" && re_pass != "" &&
		 pass === re_pass){
			
				$.ajax({
				url: "signUp",
				data: f,
				type:'POST',
				success: function (data, textStatus, jqXHR){
					console.log(data);
					console.log("success..............")
					
					
				},
				error: function(jqXHR, texStatus, errorThrown){
					console.log(data);
					console.log("error...............")
				}
			})
			$(".re_pass").removeClass("is-invalid");
//			$(this).unbind(event);  
			}else{
				$(".re_pass").addClass("is-invalid");
			}
			
})

$("#login-form").one('submit', function (event) {
			event.preventDefault();
			
			var f = $(this).serialize();
			
			console.log(f);
		const name = $("#your_name").val();
		
		const pass = $("#your_pass").val();
		
		if(name.length == ""){
			$(".name").addClass("is-invalid");
		}else{
			$(".name").removeClass("is-invalid");
		}
		
		
		if(pass.length == ""){
			$(".pass").addClass("is-invalid");
		}else{
			$(".pass").removeClass("is-invalid");
		}
		
			
			
		if(name.length != ""  && pass.length != ""){
			
				$.ajax({
				url: "login",
				data: f,
				type:'POST',
				success: function (data, textStatus, jqXHR){
					console.log(data);
					console.log("success..............")
					
				},
				error: function(jqXHR, texStatus, errorThrown){
					console.log(data);
					console.log("error...............")
				}
			})
			}
			
})

$("#logout").one('submit', function (event){
	event.preventDefault();
	var f = $(this).serialize();
	console.log(f);
	
	$(".login").hide();
	$(".name").show();
	
	$.ajax({
				url: "logout",
				data: f,
				type:'GET',
				success: function (data, textStatus, jqXHR){
					console.log(data);
					console.log("success..............")
					
					
				},
				error: function(jqXHR, texStatus, errorThrown){
					console.log(data);
					console.log("error...............")
				}
			})
})


		$("#payment-form").one('submit', function (event) {
			event.preventDefault();
			
			var f = $(this).serialize();
			
			console.log(f);
		const name = $("#name").val();
		const address = $("#address").val();
		const phone = $("#phone").val();
		const notes = $("#notes").val();
		
		if(name.length == ""){
			$(".name").addClass("is-invalid");
		}else{
			$(".name").removeClass("is-invalid");
		}
		
		if(address.length == ""){
			$(".address").addClass("is-invalid");
		}else{
			$(".address").removeClass("is-invalid");
		}
		
		
		
		if(phone.length == ""){
			$(".phone").addClass("is-invalid");
		}else{
			$(".phone").removeClass("is-invalid");
		}
		
			
			
		if(name.length != ""  && address.length != "" && phone != "" ){
			
				$.ajax({
				url: "payment",
				data: f,
				type:'POST',
				success: function (data, textStatus, jqXHR){
					console.log(data);
					console.log("success..............")
					
					
				},
				error: function(jqXHR, texStatus, errorThrown){
					console.log(data);
					console.log("error...............")
				}
			})
			}
			
})

//		$("#signup").click(function(){
//			const name = $("#name").val();
//		const account = $("#account").val();
//		const email = $("#email").val();
//		const pass = $("#pass").val();
//		const re_pass = $("#re_pass").val();
//		
//		if(name.length == ""){
//			$(".name").addClass("is-invalid");
//		}else{
//			$(".name").removeClass("is-invalid");
//		}
//		
//		if(account.length == ""){
//			$(".account").addClass("is-invalid");
//		}else{
//			$(".account").removeClass("is-invalid");
//		}
//		
//		if(email.length == ""){
//			$(".email").addClass("is-invalid");
//		}else{
//			$(".email").removeClass("is-invalid");
//		}
//		
//		if(pass.length == ""){
//			$(".pass").addClass("is-invalid");
//		}else{
//			$(".pass").removeClass("is-invalid");
//		}
//		
//		if(re_pass.length == ""){
//			$(".re_pass").addClass("is-invalid");
//		}else{
//			$(".re_pass").removeClass("is-invalid");
//		}
//		
//		if(name.length != "" && email.length != "" && pass.length != "" && re_pass != "" &&
//		 pass === re_pass){
//			$.ajax({
//				url: "signUp",
//				data: {name, account, email, pass, re_pass},
//				type:'POST',
//				success: function (data){
//					console.log(data);
//					console.log("success..............");
//				},
//				error: function(error){
//					console.log(error);
//					console.log("error...............");
//				}
//			})
//			$(".re_pass").removeClass("is-invalid");
//			
//			}else{
//				$(".re_pass").addClass("is-invalid");
//			}
//			})
			

			
			
		
		
		
//	$("#signup").click(function() {
//	alert("succeess");
//        $.ajax({
//            url: "signUp",
//            type: "post",
//            data: {
//					fname:$('#fname').val(),
//	                lname:$('#lname').val(),
//	                city_name:$('#city_name').val(),
//	                email:$('#email').val(),
//	                success : function(data){
//	                alert(data);
//	                }
//				  }
//        });
//        });
	
		
	
})