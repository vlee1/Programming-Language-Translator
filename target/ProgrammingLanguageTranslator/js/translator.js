var init = function() {
	isResultsExist();
}

function isResultsExist() {
	var resultContent = document.getElementById('result_script');
	var downloadLink = document.getElementById('download');

	if (resultContent.childNodes.length == 0) {
		downloadLink.className = "disable-download";
	}
	else {
		downloadLink.className = "enable-download";
	}
}