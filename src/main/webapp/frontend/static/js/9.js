webpackJsonp([9],{EQc2:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"select-answer"},[n("ul",[n("li",e._l(e.answerItems,function(t,s){return n("div",{key:s},[n("input",{directives:[{name:"model",rawName:"v-model",value:e.respVal.value,expression:"respVal.value"}],attrs:{type:"radio",name:e.name},domProps:{value:s,checked:e._q(e.respVal.value,s)},on:{change:function(t){e.$set(e.respVal,"value",s)}}}),e._v(" "),n("h4",[e._v(e._s(e.answerItems[s]))])])}))])])},staticRenderFns:[]};var a=n("VU/8")({name:"SelectAnswer",props:["vo"],data:function(){return{name:"answer#"+this.vo.type+"#"+this.vo.index,answerItems:[],respVal:{type:this.vo.type,index:this.vo.index,value:null}}},created:function(){this.answerItems=this.vo.answerItem},updated:function(){this.$eventBus.$emit("tr_inputRespVal",this.respVal)}},s,!1,function(e){n("Ssa4")},"data-v-0f829c48",null);t.default=a.exports},Ssa4:function(e,t){}});
//# sourceMappingURL=9.js.map