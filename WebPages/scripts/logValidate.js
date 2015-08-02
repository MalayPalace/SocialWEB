function login()
{
	var a=document.frm.user.value;
	var b=document.frm.pwd.value;
	var a1=a.charAt(0);
	if(a==null || a=="")
	{
		alert("Please Enter Username");
		return false;
	}
	if(b==null || b=="")
	{
		alert("Please Enter Password");
		return false;
	}
	if(b.length<5 || b.length>=20)
	{
		alert("Password should be between 5-20 characters");
		return false;
	}
	if(((a1>='a') && (a1<='z'))  || ((a1>='A') && (a1<='Z')))
	{
		return true;
	}
	else
	{
		alert("First character of Name should be Alphabet");
		return false;
	}
	return true;
}
