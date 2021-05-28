<html>
  <head>
    <link rel="stylesheet" href="css/style.css" />
  </head>
  <body>
    <div class="topnav">
      <form action="./logout" method="POST">
        <input type="submit" value="Logout" />
      </form>
    </div>
    <div class="container">
      <h1>Welcome to Dashboard</h1>
      <p>Successful login</p>
      <p>Hi ${username}</p>
      <a href="./addDepartment"><button>Add Department</button></a>
      <a href="./addEmployee"><button>Add Employee</button></a>
    </div>
  </body>
</html>
