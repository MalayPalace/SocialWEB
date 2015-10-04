function getXMLObject(){
	var obj;
	try{
		obj=new XMLHttpRequest();
	}
	catch(er1){
		try{
			obj=new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch(er2){
			try{
				obj=new ActiveXObject("Microsoft.XMLHTTP");
			}catch(er3)
			{
				obj=false;
			}
		}
	}
	return obj;
}

var my=getXMLObject();

function getUser(usr){
	var url="UserDupCheck.jsp";
	var rn=parseInt(Math.random()*99999);
	var murl=url+"?user="+usr+"&rno="+rn;
	my.open("GET",murl,true);
	my.onreadystatechange=getAjaxResponse;
 	my.send(null);
 	document.getElementById("userchk").innerHTML="<img src='images/ajax-loader.gif' />";
}

function getAjaxResponse(){
	var write=document.getElementById("userchk");
	if(my.readyState==4){
		if(my.status==200){
			var res=my.responseText;
			write.innerHTML=res;
		}
	}
}

function register()
{
	var a=document.frm.username.value;
	var b=document.frm.pwd.value;
	var a1=a.charAt(0);
	
//	validation for name
	if(a==null || a=="")       //Checking for empty
	{
		alert("Please Enter Username");
		return false;
	}

//	Validation for Password
	if(b==null || b=="")       //Checking for empty
	{
		alert("Please Enter Password");
		return false;
	}
	if(b.length<5 || b.length>=20)
	{
		alert("Password should be between 5-20 characters");
		return false;
	}

//	Validating Email-ID
	var mail=document.frm.email.value;
	var index_dot=mail.lastIndexOf(".");
	var index_at=mail.indexOf("@");
	if(mail==null || mail=="")
	{
		alert("Please Enter Email-ID");
		return false;
	}
	if(index_dot==-1 || index_at==-1 || index_at==0)
	{
		alert("Invalid Email-ID");
		return false;
	}
	if(index_dot>=mail.length)
	{
		alert("Invalid EMAIL-ID");
		return false;
	}
	if(index_at+3>index_dot)
	{
		alert("Invalid EMAIL-ID");
		return false;
	}

//	Validating NAME
	if(!((a1>='a' && a1<='z')  || (a1>='A' && a1<='Z')))
	{
		alert("Username should start with an alphabet");
		return false;
	}
	return true;
}

function registerCheck(){
	var retCheck=register();
	var usercheck=document.getElementById("userchk").innerHTML;
	if(retCheck){
		//Validating Return Username Field
		if (!(usercheck.contains("success.png"))){
			alert("User name is already taken");
			return false;
		}
		return true;
	}else{
		return false;
	}
}

function profileCheck(){
	var retCheck=register();
	var usercheck=document.getElementById("userchk").innerHTML;
	if(retCheck){
		var errorMsg=document.getElementById("message-placeholder");
		var email=document.frm.email.value;
		var hid_email=document.frm.hid_email.value;
		var username=document.frm.username.value;
		var hid_username=document.frm.hid_username.value;
		var pwd=document.frm.pwd.value;
		var hid_pwd=document.frm.hid_pwd.value;
		if(email==hid_email && username==hid_username && pwd==hid_pwd){
			errorMsg.innerHTML="<div id='message-holder'>No Change to Update anything</div>";
			return false;
		}
		
		if ((usercheck.contains("error.png"))){
			errorMsg.innerHTML="<div id='message-holder'>User name is already taken</div>";
			return false;
		}
		return true;
	}else{
		return false;
	}
}

function getStr(){
	var text=getURLString("filter");
	if(!(text=="null") && text==-1){
		var str=document.getElementById("message-placeholder");
		str.innerHTML="<div id='message-holder'>User Details Updated Successfully!!</div>";
	}
	if(!(text=="null") && text==-2){
		var str=document.getElementById("message-placeholder");
		str.innerHTML="<div id='message-holder'>Some Error occured while Updating User Details</div>";
	}
}

function getURLString(fieldname){
	var queryStr="null";
	var query = window.location.href.split("?");
	if(typeof query[1]==="undefined"){
		return "null";
	}
	var vars = query[1].split("&");
	for (var i=0;i<vars.length;i++) {
		var pair = vars[i].split("=");
		if(pair[0]===fieldname){
			queryStr=pair[1];
		}
	}
	if(queryStr=="null"){
		return "null";
	}else{
		return queryStr;
	}
}
