var init = function () {

	selectedMessage();
	isUserImageExist();
	var newTabBtn = document.getElementById('gitHubLink');
	newTabBtn.onclick = function() {
		openNewTab("https://github.com/vlee1/Programming-Language-Translator")
	}
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

function openNewTab(url) {
	var win = window.open(url, '_blank');
	win.focus();
}