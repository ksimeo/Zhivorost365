<html>
<head><title>Login Page</title></head>
<body onload='document.f.j_username.focus();'>
<h3>Login with Username and Password</h3>
<form name='f' method='POST'
      action='/Spitter/j_spring_security_check'> <!-- Путь к фильтру -->
  <table> <!-- аутентификации -->
    <tr><td>User:</td><td> <!-- Поле ввода имени пользователя -->
      <input type='text' name='j_username' value=''>
    </td></tr>
    <tr><td>Password:</td><td> <!-- Поле ввода пароля -->
      <input type='password' name='j_password'/>
    </td></tr>
    <tr><td colspan='2'>
      <input name="submit" type="submit"/>
    </td></tr>
      <tr><td colspan='2'>
          <input name="reset" type="reset"/>
      </td></tr>
  </table>
</form>
</body>
</html>
