function acceptClick(ids){
	var urlStr="FriendManager?reqtype="+1+"&info="+ids;
	var enUrl=encodeURI(urlStr);
	alert(enUrl);
}

function rejectClick(ids){
	var urlStr="FriendManager?reqtype="+2+"&info="+ids;
	enurl=encodeURI(urlStr);
	alert(enUrl);
}