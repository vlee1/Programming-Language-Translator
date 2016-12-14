var init = function() {
	readAndDisplay();
	isResultsExist();

}

function isResultsExist() {
	var resultContent = document.getElementById('result_script');
	var downloadLink = document.getElementById('download');

	if (resultContent.childNodes.length == 0) {Display
		downloadLink.className = "disable-download";
	}
	else {
		downloadLink.className = "enable-download";
	}
}

function readAndDisplay() {

	var textarea = document.getElementById("sourceCode").valueOf().split("\n");



}