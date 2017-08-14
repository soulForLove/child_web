/*
 *https://github.com/filamentgroup/jQuery-File-Download/blob/master/jQuery.download.js
 */
jQuery(document).ready(function($){
	jQuery.download = function(url, data, method){
		if( url && data ){
			data = typeof data == 'string' ? data : jQuery.param(data,true);
			var inputs = '';
			jQuery.each(data.split('&'), function(){
				var pair = this.split('=');
				inputs+='<input type="hidden" name="'+ pair[0] +'" value="'+ pair[1] +'" />';
			});
			if($("#exportIframe").length==0){
				jQuery('<iframe id="exportIframe" name="exportIframe" style="display: none;"></iframe>').appendTo('body');
			}
			jQuery('<form  target="exportIframe" action="'+ url +'" method="'+ (method||'post') +'">'+inputs+'</form>').appendTo('body').submit().remove();
		};
	};
});