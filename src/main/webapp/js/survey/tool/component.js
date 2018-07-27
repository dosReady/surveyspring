
var componentForm =  {
		data : function (){
			return {
				resultArry : []
			}
		},
		methods : {
			echo : function(){
				console.log("super");
			}
		}
}


var textType = {
		mixins: [componentForm],
		methods : {
			echo : function(){
				console.log("child");
			}
		},
		template :  `
			<div style="
				border: solid 1px;
				padding: 10px;
				width:  300px;">
			<label for ="text-type">텍스트 타입</label>
			<input type="text" id="text-type" v-on:click="echo"/>
			</div>
			` ,
		
		
		
};
var selectType = {
		template : 
			'<h1>선택 타입</h1>'
};

new Vue({
	el : '#tool-container',
	components : {
		'select-type' : selectType,
		'text-type' : textType
	}
});