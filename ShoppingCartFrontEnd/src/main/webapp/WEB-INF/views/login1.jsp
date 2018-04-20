<div class="panel-body">
        <form action="newlogin" method="POST" class="form-horizontal"
         id="loginForm"
        >
         <div class="form-group">
          <label for="username" class="col-md-4 control-label">Email: </label>
          <div class="col-md-8">
           <input type="text" name="username" id="username" class="form-control"/>
          </div>
         </div>
         <div class="form-group">
          <label for="password" class="col-md-4 control-label">Password: </label>
          <div class="col-md-8">
           <input type="password" name="password" id="password" class="form-control"/>
          </div>
         </div>
         <div class="form-group">
          <div class="col-md-offset-4 col-md-8">
           <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
           <input type="submit" value="Login" class="btn btn-primary"/>
          </div>
         </div>
        </form>
       
       </div>