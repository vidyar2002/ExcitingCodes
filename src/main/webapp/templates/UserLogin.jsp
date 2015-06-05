<!-- ======== @Region: #content ======== -->
<div id="content" ng-controller="LoginController">
  <div class="container">
    <!-- Login form -->
    <form role="form" class="form-login form-wrapper form-narrow" action="login" method="post">
      <h3>
        <span>Login</span>         
      </h3>
      <%
      if(request.getParameter("error") != null)
      {
    	  %>
    	   <p class="alert-danger">Authentication failed. Please try again</p>
    	  <%
      }
      %>        
      
      <div class="form-group">
        <label class="sr-only" for="login-email-page">Email</label>
        <input type="email" id="login-email-page" name ="email" class="form-control email" placeholder="Email" ng-model="userDto.email" required>
      </div>
      <div class="form-group">
        <label class="sr-only" for="login-password-page">Password</label>
        <input type="password" id="login-password-page" name="password" class="form-control password" placeholder="Password"  ng-model="userDto.password" required>
      </div>
       <button type="submit" class="btn btn-primary" >Login</button>
      | <small>Not signed up? <a href="signup">Sign up here</a>.</small>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
  </div>
</div>
