
var mixin = {
		ajax : {
			data : function(){
				return {
					error:0,
					loading:true,
					result:[]
				}
			},
			methods :{
				getData : function(){
					var _this = this;
					_this.loading = true;
					
					var xhr = new XMLHttpRequest();
					xhr.onload = function(){
						if(xhr.status === 200 || xhr.status === 201) {
							console.log(xhr.responseText);
						}else {
							console.error(xhr.responseText);
						}
					}
					
					if(this._optValidation()){
						xhr.open(_this.request.method,_this.request.url);
						xhr.setRequestHeader('Content-Type', 'application/json');
						var data = JSON.stringify(_this.request.data);
						xhr.send(JSON.stringify(_this.request.data));
					}
					
				},
				_optValidation : function(obj){
					var _request = this.request;
					
					if(!_request.dataType){
						alert("dataType 누락");
						console.error("dataType 누락");
						return false;
					}
					
					if(!_request.method ){
						alert("method 누락");
						console.error("method 누락");
						return false;
					}
					
					if(!_request.url ){
						alert("url 누락");
						console.error("url 누락");
						return false;
					}
					
					if(_request.method =="GET" &&  _request.dataType.toUpperCase() =="JSON"){
						alert("JSON 전송방식에서 GET방식은 사용할 수 없습니다.");
						console.error("JSON 전송방식에서 GET방식은 사용할 수 없습니다.");
						return false;
					}
					
					return true;
				}
			
			}
		}
}

Vue.mixin(mixin.ajax);
