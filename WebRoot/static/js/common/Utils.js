var NULL_VALUE = '-';
/**
 * 显示操作结果，并在指定时间后自动消失
 */
function showMessage(msg, delay) {
	$("#messageDiv").html(msg);
	$("#messageDiv").delay(200).fadeIn().delay(delay || 2000).fadeOut(2000);
}

/**
 * <pre>
 * 	getTop():获取最顶层window
 * 	tranDateStr(dateStr):转yyyyMMddHHmmss为yyyy-MM-dd
 * </pre>
 */
(function() {
	if (!window.Utils) {
		window.Utils = {};
	}
	window.Utils = {

		getTop : function() {
			return top;
		},

		tranDateStr : function(dateStr) {
			return dateStr && dateStr.length == 14 ? dateStr.substr(0, 4) + '-' + dateStr.substr(4, 2) + '-' + dateStr.substr(6, 2): NULL_VALUE;
		},
		
		tranTimeStr : function(dateStr) {
			return dateStr && dateStr.length == 14 ? dateStr.substr(0, 4) + '-' + dateStr.substr(4, 2) + '-' + dateStr.substr(6, 2) + ' ' + dateStr.substr(8,2) + ':' + dateStr.substr(10,2) + ':' + dateStr.substr(12,2): NULL_VALUE;
		},
		isInt : function(val,zeroFlag){
			var exp = zeroFlag?/^[0-9][0-9]*$/:/^[1-9][0-9]*$/;
			return exp.test(val);
		},
		isDecimal : function(val){
			var exp = /^[0-9]+(.[0-9]+)?$/;
			return exp.test(val);
		}

	};
})();