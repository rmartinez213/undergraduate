//Problem1
function ask(){
	var number = prompt("Enter a number between 10 - 20");
	if(number >= 10 && number <= 20){
		alert("Thank you!");
	}
	else{
		alert("Try Again");
		ask();
	}
};
ask();

//Problem2

function bizzbuzz(){
	
for(var i = 0; i <= 100 ; i++){
		if((i % 3 === 0) && (i % 5 === 0) && (i % 4 === 0) && (i % 6 === 0)){
			console.log(i + ": fizz buzz crackle pop");
		}
		else if(i % 3 === 0){
			console.log(i + ": fizz");
		}
		else if(i % 5 === 0){
			console.log(i + ": buzz");
		}
		else if(i % 4 === 0){
			console.log(i + ": crackle");
		}
		else if(i % 6 === 0){
			console.log(i + ": pop");
		}	
		else{
			console.log(i);
		}
	}
}
bizzbuzz();

//Problem3
var scenery = function(){
	var result = "";
	var lakes = function(size){
		for(var count = 0 ; count < size ; count++){
			result += "~";
		};
	};
	var forest = function(size){
		for(var count = 0 ; count < size ; count++){
			result += "A";
		};
	};
	var mountain = function(size){
		result += "/";
		for(var count = 0 ; count < size ; count++){
			result += "'";
		};
		result += "\\";
	};
	var flat = function(size){
		for(var count = 0 ; count < size ; count++){
			result += "_";
		};
	};
	
	lakes(4);
	forest(2);
	flat(6);
	mountain(4);
	return result;
};
console.log(scenery());

//Problem4
var PowerExp = function(exp){
	var result = 1;
	return function(LowNum){
		for(var count = 1 ; count < exp ; count++){
			result *= LowNum;
		};
		return result;
	};
};
var exp = PowerExp(4);
console.log(exp(2));