Behaviour.register({
	'#newButton': function(button) {
		button.onclick = function() {
			self.location = pathPrefix + "/editCardType";
		}
	},
	
	'img.details': function(img) {
		setPointer(img);
		img.onclick = function() {
			self.location = pathPrefix + "/editCardType?cardTypeId=" + img.getAttribute("cardTypeId");
		}
	},
	
	'img.remove': function(img) {
		setPointer(img);
		img.onclick = function() {
			if (confirm(removeConfirmation)) {
				self.location = pathPrefix + "/removeCardType?cardTypeId=" + img.getAttribute("cardTypeId");
			}
		}
	}
});