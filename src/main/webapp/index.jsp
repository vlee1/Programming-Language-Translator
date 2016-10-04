<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>PLT</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/plt.css">
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
				    <!-- Button trigger modal -->
					<button id="sign-up_btn" type="button" class="btn btn-default " data-toggle="modal" data-target="#myModal">
					  Sign up
					</button>

					<form id="form-sign-in" class="form-inline">
					  <div class="form-group">

					    <input type="text" class="form-control" id="email" placeholder="Email">
					  </div>
					  <div class="form-group">

					    <input type="password" class="form-control" id="exampleInputPassword3" placeholder="Password">
					  </div>
					  <button id="sign-in_btn" type="submit" class="btn btn-default">Sign in</button>
					</form>

					<!-- Modal -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" id="myModalLabel">Programming Language Translator Sign up</h4>
					      </div>
					      <div id="modal-body" class="modal-body">

							  <form id="form-sign-up" class="form-inline" method="POST" action="/signup">
								  <div class="form-group">
									  <input type="text" class="form-control" id="new_email" placeholder="Enter your email">
								  </div>
								  <br />
								  <div class="form-group">
									  <input type="text" class="form-control" id="create_userName" placeholder="Create your username">
								  </div>
								  <br />
								  <div class="form-group">
									  <input type="password" class="form-control" id="create_password" placeholder="Create your password">
								  </div>
								  <br />
								  <div class="form-group">
									  <input type="password" class="form-control" id="confirm_password" placeholder="Confirm your password">
								  </div>
								  <br />
								  <div class="checkbox">
									  <label>
										  <input type="checkbox"> I agree with PLT <a href="#">Terms and Policies</a>.
									  </label>
								  </div>

								  <div id="modal-footer-line" class="modal-footer">
									  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
									  <input type="submit" id="signup_btn" name="signup_btn" class="btn btn-primary" value="Sign up">
								  </div>
							  </form>

					      </div>

					    </div>
					  </div>
					</div>

				  </div>
				</nav>
				

			</div>

			<div id="content">

				<div id="content-main">
					<h2 id="main-message">Programming Language Translator allows you to translate six languages, Java, JavaScript, PHP, HTML, C Sharp and C. Sign up to add more languages in PLT, otherwise, click <span>start</span> to begin.</h2>

					<a id="start-link_btn" href="#">Start</a>
					<p class="version">PLT v1.0</p>
				</div>

				<div id="content-features">
					<div id="feature-upload">
						<h3 class="features">
							Upload Your File
						</h3>

						<p>
							Got a file that needs to be translate it? Well, Programming Language Translator will translate your file on the fly.
						</p>
						<ul>
							<li><img src="images/jsFile21.png"></li>
							<li class="center-list"><img src="images/arrow50.png"></li>
							<li><img src="images/phpfile23.png"></li>
						</ul>
					</div>

					<div id="feature-create">
						<h3>Write In The Translator</h3>

						<p>
							Write any programming language and Programming Language Translator will create a translated file for you to download.
						</p>
						<ul>
							<li><img src="images/edit20.png"></li>
							<li class="center-list"><img src="images/arrow50.png"></li>
							<li><img src="images/process.png"></li>
							<li class="center-list"><img src="images/arrow50.png"></li>
							<li><img src="images/downloadfile90.png"></li>
						</ul>
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