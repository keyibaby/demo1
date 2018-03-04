$(function(){
	getiframeWH();
})

/*
* 对于iframe操作
* 1、切换
* 2、获取iframe的宽高
*/
function change(url) {
	$("#main").attr("src", url);
}
function getiframeWH(){
	$("#main").width($(".maincontent").width())
	$("#main").height($(".maincontent").height()-3);
	/*$("#main").css("margin","10px 10px 0 0");*/
}
