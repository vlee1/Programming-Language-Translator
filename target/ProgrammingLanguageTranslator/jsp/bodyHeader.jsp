
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
					  <button type="submit" class="btn btn-default">Sign in</button>
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