<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <title>PLT | User</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/plt.css">
        <link rel="stylesheet" type="text/css" href="css/user.css" >
    </head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>
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

                        <div class="signed-user" class="nav-header">
                            <a href="#"></a>
                        </div>

                        <div class="translator-link-container">
                            <a href="translator.jsp">Start</a>
                        </div>
                    </div>
                </nav>


            </div>

            <div id="content">
                <div class="user-account-box">
                    <div id="user-image" class="user-image"><img src="/images/profile-icon180.png" width="180" height="180"/></div>

                    <div class="welcome-title">

                        <h2>Welcome <span class="username">${username}</span></h2>

                        <div class="github">
                            <p>Download source codes in <span id="gitHubLink" class="gitHubLink">Github</span></p>
                        </div>
                        
                    </div>

                    <div class="user-email-box">
                        <p class="send-message">Send your source code to <span class="admin-email">vang@plt.com</span> for a request.</p>

                        <div class="user-email">
                            <div class="list-group">
                                <a href="#" class="list-group-item active">Inbox</a>
                                <a href="#" class="list-group-item">Send</a>
                                <a href="#" class="list-group-item">Others</a>
                                <a href="#" class="list-group-item">Trash</a>
                            </div>

                            <div class="list-results">
                                <form id="searchForm" method="GET" action="">

                                    <div class="col-lg-6">
                                        <div class="input-group">
                                            <input id="search_txt" type="text" class="form-control" placeholder="Search">

                                            <span class="input-group-btn">
                                                <button id="search_btn" class="btn btn-default" type="button"></button>
                                            </span>

                                        </div>
                                        <!-- /input-group -->
                                    </div>
                                    <!-- /.col-lg-6 -->
                                </form>
                                <!-- searchForm -->
                                <div id="tabs">
                                    <ul>
                                        <c:forEach var="message" items="${messages}">
                                            <li id="<c:out value='${message.getMessageId()}' />" class="message">
                                                <c:out value="${message.getSubject()}"/>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>

                            </div>
                            <!-- list-results -->

                            <div id="display-result" class="display-result">

                                <div id="description"></div>
                            </div>
                        </div>
                        <!-- user-email -->
                    </div>
                    <!-- user-email-box -->
                </div>
                <!-- user-account-box -->
            </div>

            <div id="footer">
                <h3>PLT</h3>
            </div>
        </div>
    </body>

    <script
            src="https://code.jquery.com/jquery-3.1.1.js"
            integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script type="text/javascript">
        $(function() {

            $(".message").on('click', function () {
                $.get('GetMessage', {messageId : this.id}, function(responseText) {
                    $("#description").text(responseText);
                    console.log(responseText);
                })
            })

        })
    </script>
</html>
