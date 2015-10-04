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

function chgTxt(){
	var i=document.searchFrm.searchType.selectedIndex;
	var combo=document.searchFrm.searchType.options[i].value;
	if(combo=="Username"){
		document.searchFrm.searchTxt.placeholder="Enter first few characters to search";
	}else if(combo=="Email"){
		document.searchFrm.searchTxt.placeholder="Enter Email ID to Search";
	}
}

function dataChange(userID){
	clrMessage();
	var username=document.searchFrm.searchTxt.value;
	var leng=username.length;
	var i=document.searchFrm.searchType.selectedIndex;
	var combo=document.searchFrm.searchType.options[i].value;
	if(combo=="Username"){
		if(leng>=3){
			var url="SearchUser";
			var rn=parseInt(Math.random()*999);
			var murl=url+"?type=USER&user="+username+"&userid="+userID+"&rno="+rn;
			my.open("GET",murl,true);
			my.onreadystatechange=getAjaxUserResponse;
		 	my.send(null);
		 	document.getElementById("mainData").innerHTML="&nbsp;&nbsp;&nbsp;<img src='images/ajax-loader.gif' width='40' height='40' />";
		}else{
			messagePrint("Enter Atleast 3 characters to search");
		}
	}else if(combo=="Email"){
		var email=document.searchFrm.searchTxt.value;
		var url="SearchUser";
		var rn=parseInt(Math.random()*999);
		var murl=url+"?type=EMAIL&user="+email+"&userid="+userID+"&rno="+rn;
		my.open("GET",murl,true);
		my.onreadystatechange=getAjaxUserResponse;
	 	my.send(null);
	 	document.getElementById("mainData").innerHTML="&nbsp;&nbsp;&nbsp;<img src='images/ajax-loader.gif' width='40' height='40' />";
	}
}

function getAjaxUserResponse(){
	var write=document.getElementById("mainData");
	if(my.readyState==4){
		if(my.status==200){
			var res=my.responseText;
			if(res.contains("<msg>messagePrint</msg>")){
				messagePrint("No User Found with your Search Query");
			 	write.innerHTML="";
			}else{
				write.innerHTML=res;
			}
		}
	}
}

//Once User send Friend Request
function sendReq(frndID,frndName){
	clrMessage();
	var url="AddFriendRelation";
	var rn=parseInt(Math.random()*999);
	var murl=url+"?friendID="+frndID+"&rno="+rn;
	my.open("GET",murl,true);
	my.onreadystatechange=function(){
		if(my.readyState==4){
			if(my.status==200){
				var res=my.responseText;
				if(res.contains("<msg>Successfull</msg>")){
					messagePrint("Friend Request sent to "+frndName);
					var writeContext=document.getElementById("user"+frndName+"Button");
					writeContext.innerHTML="<i>Friend Request Sent</i>";
				}else{
					messagePrint("Some error occur while sending Friend Request. Please try again");
				}
			}
		}
	};
	my.send(null);
}

function messagePrint(msg){
	var str=document.getElementById("message-placeholder");
	str.innerHTML="<div id='message-holder'>"+msg+"</div>";
}

function clrMessage(){
	var str=document.getElementById("message-placeholder");
	str.innerHTML="";
}