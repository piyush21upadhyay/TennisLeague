
/*  This function is to select all options in a multi-valued <select> */
function selectAll(elementId) {
    var element = document.getElementById(elementId);
	len = element.length;
	if (len != 0) {
		for (i = 0; i < len; i++) {
			element.options[i].selected = true;
		}
	}
}

// This function is used by the login screen to validate user/pass
// are entered. 
function validateRequired(form) {                                    
    var bValid = true;
    var focusField = null;
    var i = 0;                                                                                          
    var fields = new Array();                                                                           
    oRequired = new required();                                                                         
                                                                                                        
    for (x in oRequired) {                                                                              
        if ((form[oRequired[x][0]].type == 'text' || form[oRequired[x][0]].type == 'textarea' || form[oRequired[x][0]].type == 'select-one' || form[oRequired[x][0]].type == 'radio' || form[oRequired[x][0]].type == 'password') && form[oRequired[x][0]].value == '') {
           if (i == 0)
              focusField = form[oRequired[x][0]]; 
              
           fields[i++] = oRequired[x][1];
            
           bValid = false;                                                                             
        }                                                                                               
    }                                                                                                   
                                                                                                       
    if (fields.length > 0) {
        cglAlert("Required Fields", fields.join('<br/>'), 400, function() {
            focusField.focus();
        });                                                                      
    }                                                                                                   
                                                                                                       
    return bValid;                                                                                      
}

function confirmDelete(obj) {   
    var msg = "Are you sure you want to delete this " + obj + "?";
    ans = cglConfirm("Confirm Delete", msg);
    if (ans) {
        return true;
    } else {
        return false;
    }
}

function highlightFormElements() {
    // add input box highlighting
    addFocusHandlers(document.getElementsByTagName("input"));
    addFocusHandlers(document.getElementsByTagName("textarea"));
}

function addFocusHandlers(elements) {
    for (i=0; i < elements.length; i++) {
        if (elements[i].type != "button" && elements[i].type != "submit" &&
            elements[i].type != "reset" && elements[i].type != "checkbox" && elements[i].type != "radio") {
            if (!elements[i].getAttribute('readonly') && !elements[i].getAttribute('disabled')) {
                elements[i].onfocus=function() {this.style.backgroundColor='#ffd';this.select()};
                elements[i].onmouseover=function() {this.style.backgroundColor='#ffd'};
                elements[i].onblur=function() {this.style.backgroundColor='';}
                elements[i].onmouseout=function() {this.style.backgroundColor='';}
            }
        }
    }
}

(function($) {
	$.cglalerts = {
		alert: function(title, message, width, callback, param) {
			if (title == null) title = 'Alert';
			$.cglalerts._show('alert', title, message, width, function(result) {
				if (callback) callback(result, param);
			});
		},
		
		confirm: function(title, message, width, callback, param) {
			if (title == null) title = 'Confirm';
			$.cglalerts._show('confirm', title, message, width, function(result) {
				if (callback) callback(result, param);
			});
		},
		
		_show: function(type, title, msg, width, callback) {
			
			$("body").append('<div id="cgl-alert"></div>');
			if (null == width) width = 400;
			
			switch (type) {
				case 'alert':
					$("#cgl-alert").dialog({
						bgiframe: true,
						modal: true,
						resizable: true,
						autoOpen: false,
						width: width,
						overlay: {
							backgroundColor: '#000',
							opacity: 0.5
						},
						buttons: {
							OK: function() {
								$(this).dialog('close');
								if (callback) callback(true);
							}
						},
						close: function(evt, ui) {
						    $(this).remove();
						}
					});
					break;
					
				case 'confirm':
					$("#cgl-alert").dialog({
						bgiframe: true,
						modal: true,
						resizable: true,
						autoOpen: false,
						width: width,
						overlay: {
							backgroundColor: '#000',
							opacity: 0.5
						},
						buttons: {
							No: function() {
								$(this).dialog('close');
								if (callback) callback(false);
							},
							Yes: function() {
								$(this).dialog('close');
								if (callback) callback(true);
							}
						},
						close: function(evt, ui) {
						    $(this).remove();
						} 
					});
					break;
			}
			$('#cgl-alert').data("title.dialog", title);
			$('#cgl-alert').html(msg);
			$('#cgl-alert').dialog("open");

		}
	}
	
	cglAlert = function(title, message, width, callback, param) {
		$.cglalerts.alert(title, message, width, callback, param);
	}
	
	cglConfirm = function(title, message, width, callback, param) {
		$.cglalerts.confirm(title, message, width, callback, param);
	};
	
})(jQuery);

window.onload = function() {
    highlightFormElements();
   $('#command').insertBefore('#top-nav .right');
}

