function login()
{
	var write=document.getElementById("err_msg");
	var a=document.frm.user.value;
	var b=document.frm.pwd.value;
	var a1=a.charAt(0);
	if(a==null || a=="")
	{
		write.innerHTML="Please Enter Username";
		return false;
	}
	if(b==null || b=="")
	{
		write.innerHTML="Please Enter Password";
		return false;
	}
	if(b.length<5 || b.length>=20)
	{
		write.innerHTML="Password should be between 5-20 characters";
		return false;
	}
	if(((a1>='a') && (a1<='z'))  || ((a1>='A') && (a1<='Z')))
	{
		return true;
	}
	else
	{
		write.innerHTML="First character of Name should be Alphabet";
		return false;
	}
	return true;
}
