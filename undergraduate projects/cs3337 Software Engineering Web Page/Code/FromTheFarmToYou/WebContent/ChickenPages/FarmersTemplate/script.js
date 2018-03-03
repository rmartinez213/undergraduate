var x = function(id){
	return document.getElementById(id);
}

var counter = 0;

var submitInfo = function(){
	counter++;
	num.innerHTML = counter;
}

window.onload = function(){
	x("countnum1").onclick = submitInfo;
	x("countnum2").onclick = submitInfo;
	x("countnum3").onclick = submitInfo;
	x("countnum4").onclick = submitInfo;
}