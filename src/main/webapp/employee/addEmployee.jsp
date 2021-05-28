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
        <h1>Welcome to add employee</h1>
      </div>
      <div>
        <form class="employee_form" action="./addEmployee" method="POST">
          <label>First name: </label
          ><input type="text" name="firstname" /><br />
          <label>Last name: </label><input type="text" name="lastname" /><br />
          <label>Age: </label><input type="text" name="age" /><br />
          <label>Department: </label>
          <select name="department">
            <c:forEach items="${options}" var="option">
              <option value="${option.getName()}">${option.getName()}</option>
            </c:forEach>
          </select>
          <br />
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
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
            <th>Department</th>
          </tr>
          <c:forEach items="${employees}" var="employee">
            <tr>
              <th>${employee.getId()}</th>
              <th>${employee.getFirstName()}</th>
              <th>${employee.getLastName()}</th>
              <th>${employee.getAge()}</th>
              <th>${employee.getDepartment()}</th>
            </tr>
          </c:forEach>
        </table>
      </div>
    </div>
  </body>
</html>
