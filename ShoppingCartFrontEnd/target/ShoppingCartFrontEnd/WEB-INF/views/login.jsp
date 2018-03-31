
<h2>Login Form</h2>

<form action="validate" method="post">
  <div class="imgcontainer">
    <!-- <img src="img_avatar2.png" alt="Avatar" class="avatar"> -->
    <img alt="Avatar" src="resources/images/avatar.png">
  </div>

  <div class="container">
    <label for="uname"><b>Email Id</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>

    <label for="pswd"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="pswd" required>
        
    <button type="submit">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
</form>
