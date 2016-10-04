var init = function () {

	selectedMessage();
	isUserImageExist();
}

function selectedMessage() {
	var display = document.getElementById('display-result');
	
	if (display.childNodes.length == 0) {
		
		var content = document.createTextNode('Select a message to read');
		var displayContent = document.createElement('div');
		displayContent.className = "no-content";
		display.appendChild(displayContent);
		displayContent.appendChild(content);

	}
}
function isUserImageExist() {
	var imageDisplay = document.getElementById('user-image');

	if (imageDisplay.childNodes.length == 0)
	{
		var imageContent = document.createElement('div');
		imageContent.className = 'image-content';
		imageDisplay.appendChild(imageContent);
	}
}