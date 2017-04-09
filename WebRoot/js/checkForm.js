/**
 *检查表单输入是否有效
 */
function checkForm(){
			    var hasmd = document.getElementById("md").value;
			    var hasfs = document.getElementById("fs").value;
			    var hasgd = document.getElementById("gd").value;
			    var numsy = document.getElementById("numsy").value;
			    var range = document.getElementById("range").vlaue;
			    var num = document.getElementById("num").value;
			    var reg = new RegExp("^[0-9]*$");
			    if(hasmd == "" || hasfs == "" ||hasgd == "" || numsy == "" || range == "" || num == ""){
			        alert("请检查参数是否全部设置!");
			        return false;
			    }
		    return true;
		}
	