$(document).ready(function(){
	$("#signup").click(function(){
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
		
		if(name.length != "" && email.length != "" && pass.length != "" && re_pass != ""){
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/signUp/signUp",
				data: {"name": name, "email": email, "pass": pass, "re_pass": re_pass},
				dataType: "JSON",
				success: function(feedback){
					console.log("SUCCESS: ", feedback);
					var result = "";
					
				} 
				
			})
		}
		
		if(name.equals(re_pass)){
			
		}
		
	})
	
	$("#signin").click(function(){
		const name = $("#name").val();
		const pass = $("#pass").val();
		
		
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
		
	})
})

function signUp(){
	var name = $("#name").val();
	var email = $("#email").val();
	var pass = $("#pass").val();
	var re_pass = $("#re_pass").val();
	
	if(name.length != "" && email.length != "" && pass.length != "" && re_pass != ""){
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/signUp/signUp",
				data: {"name": name, "email": email, "pass": pass, "re_pass": re_pass},
				dataType: "JSON",
				success: function(feedback){
					
				} 
				
			})
		}
}

function getAllProducts(){
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/products",
		success: function(){
//			console.log(products)
			alert("Success");
//			displayProduct(products);
		}
	})
}

function displayProduct(array){
	let res = ""
	for(let i = 0; i < array.length; i++){
		res += array[i].name + "<br>";
	}
	document.getElementById("display").innerHTML = res;
}
