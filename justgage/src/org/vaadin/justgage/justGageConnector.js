window.org_vaadin_justgage_JustGage = function() {
	var justGage = null;

	this.init = function(json) {
		var conf = JSON.parse(json);
		this.getElement().id = conf.id;
		justGage = new JustGage(conf);
	};
	
	this.refresh = function(value, max) {
		justGage.refresh(value, max);
	};
    
};