<%--
  Created by IntelliJ IDEA.
  User: Vang Lee
  Date: 9/23/16
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>PLT</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <link rel="stylesheet" type="text/css" href="css/user.css">
    </head>
    <body>
        <div id="wrapper">
            <div id="header">

                <nav id="header-nav" class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">
                                PLT
                            </a>
                        </div>

                        <div id="signed-user" class="nav-header">
                            <a href="#"></a>
                        </div>

                        <div id="translator-link-container">
                            <a href="translator.jsp">Start</a>
                        </div>
                    </div>
                </nav>


            </div>

            <div id="content">
                <div class="form-group">
                    <label for="fileUpload">Upload your file</label>
                    <input type="file" id="fileUpload">
                    <p class="help-block">Only programming language files (.js, .java, .php, etc.)</p>
                </div>

                <div id="input-box-container">
                    <div id="language-list">
                        <div class="dropdown">
                            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                Dropdown
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>

            <div id="footer">
                <h3>PLT</h3>
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</html>