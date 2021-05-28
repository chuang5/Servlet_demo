<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
      <div>
        <h1>Welcome to add department</h1>
      </div>
      <div>
        <form class="department_form" action="./addDepartment" method="POST">
          <label>Department: </label
          ><input type="text" name="department" /><br />
          <!-- <label>Email: </label><input type="text" name="email" /><br /> -->
          <input type="submit" value="Save" />
          <input
            type="button"
            value="Cancel"
            onclick="window.location.href=`./home`"
          />
        </form>
        <p style="color: red">${result}</p>
      </div>
      <div>
        <table>
          <tr>
            <th>Id</th>
            <th>Department</th>
            <th>Email</th>
            <th>Employees count</th>
          </tr>
          <c:forEach items="${departments}" var="department">
            <tr>
              <th>${department.getId()}</th>
              <th>${department.getName()}</th>
              <th>${department.getEmail()}</th>
              <th>${department.getEList().size()}</th>
            </tr>
          </c:forEach>
        </table>
      </div>
    </div>
  </body>
</html>
