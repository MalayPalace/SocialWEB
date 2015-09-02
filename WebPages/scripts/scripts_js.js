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
	var usercheck=document.getElementById("userchk").innerHTML;
	
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

	//Validating Hidden Field
	if (!(usercheck.contains("success.png"))){
		alert("User name is already taken");
		return false;
	}
	return true;
}
