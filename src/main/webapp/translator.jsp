<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8">
        <title>PLT</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/plt.css">
        <link rel="stylesheet" type="text/css" href="css/translator.css">
        <script src="js/translator.js"></script>
    </head>
    <body onload="init()">
        <div id="wrapper">
            <div id="header">

                <nav id="header-nav" class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">
                                PLT
                            </a>
                        </div>

                        <div class="signed-user" class="nav-header">
                            <a href="#">Username</a>
                        </div>
                    </div>
                </nav>


            </div>

            <div id="content">
                <div class="form-group">

                    <!-- TODO: //// Add an 'onclick' event to write file on textbox -->

                    <label for="fileUpload">Upload your file</label>
                    <input type="file" id="fileUpload">
                    <p class="help-block">Only programming language files (.js, .java, .php, etc.)</p>
                </div>

                <div class="input-box-container">
                    
                    <div class="language-list-container">
                        <form id="scriptForm" class="listForm" method="GET" action="">

                            <section class="section1">
                                <select class="language-list1" name="languages1">
                                    <option value="language">Select Language</option>
                                    <option value="languageC">C</option>
                                    <option value="languageCsharp">C Sharp</option>
                                    <option value="languageJava">Java</option>
                                    <option value="languageJavaScript">JavaScript</option>
                                </select>

                                <select class="options" name="options">
                                    <option value="option">Select option</option>
                                    <option value="script">Script</option>
                                    <option value="class">Class</option>
                                    <option value="interface">Interface</option>
                                    <option value="abstract">Abstract</option>
                                    <option value="method">Method</option>
                                    <option value="type">Data Type</option>
                                </select>

                                <input class="fileName_txt" type="text" name="fileName_txt" placeholder="Enter file name"> 

                                <button id="convert" class="convert_btn gen_btn" type="submit" name="convert">Convert</button>

                            </section>
                            <!-- section1 -->

                            <section class="section2">
                                <select class="language-list2" name="languages2">
                                    <option value="language">Select Language</option>
                                    <option value="languageC">C</option>
                                    <option value="languageCsharp">C Sharp</option>
                                    <option value="languageJava">Java</option>
                                    <option value="languageJavaScript">JavaScript</option>
                                </select>   

                                <div id="resultName"></div>

                                <a id="download" href="#" download="results">Download</a>

                            </section>
                            <!-- section2 -->
                        </form>
                        <!-- dropdown -->
                        
                    </div>
                    <!-- language-list -->

                    <textarea class="script1" form="scriptForm" name="script1" spellcheck="false" placeholder="Write your codes here"></textarea>

                    <div id="results">
                        <p id="result_script"></p>  
                    </div>
                </div>

            </div>

            <div id="footer">
                <h3>PLT</h3>
            </div>
        </div>
    </body>
    <script type="text/javascript">
        var textareas = document.getElementsByTagName('textarea');
        var count = textareas.length;
        for(var i=0;i<count;i++) {
            textareas[i].onkeydown = function(e) {

                if(e.keyCode==9 || e.which==9) {
                    e.preventDefault();
                    var s = this.selectionStart;
                    this.value = this.value.substring(0,this.selectionStart) + "\t" + this.value.substring(this.selectionEnd);
                    this.selectionEnd = s+1; 
                }
            }
        }
    </script>
    <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</html>