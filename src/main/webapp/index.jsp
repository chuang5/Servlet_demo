
<html>
  <head>
    <link rel="stylesheet" href="css/style.css" />
  </head>
  <body>
    <div class="topnav"></div>
    <div class="container">
      <h2>Hello World!</h2>
      <form action="./login" method="POST">
        <label>Username: </label><input type="text" name="username" /><br />
        <label>Password: </label><input type="password" name="password" /><br />
        <input type="submit" value="OK" />
      </form>
      <p style="color: red">${result}</p>
    </div>
  </body>
</html>
