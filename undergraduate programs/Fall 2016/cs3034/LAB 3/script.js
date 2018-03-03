var UserInput = function (id){
	return document.getElementById(id)
}

function SubmitRequest(){
	var F_Name = UserInput("first_name_id").value;
	var L_Name = UserInput("last_name_id").value;
	var Email = UserInput("email_id").value;

	
	if(F_Name == ""){
		UserInput("first_name_error").firstChild.nodeValue = "This field cannot be empty.";
	}
	
	else
		UserInput("first_name_error").firstChild.nodeValue = "";
	
	if(L_Name == ""){
		UserInput("last_name_error").firstChild.nodeValue = "This field cannot be empty.";
	}
	
	else
		UserInput("last_name_error").firstChild.nodeValue = "";
	
	if(Email == ""){
		UserInput("email_error").firstChild.nodeValue = "This field cannot be empty.";
	}
	
	else
		UserInput("email_error").firstChild.nodeValue = "";
}

window.onload = function(){
	UserInput("submit_request").onclick = SubmitRequest;
}