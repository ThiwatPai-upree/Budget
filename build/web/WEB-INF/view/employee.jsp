<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>Project:${project_name}</h1>
<h3>Employee List</h3>
<form method="POST" action="/Budget/summary">
    <c:forEach var="employee" items="${employees}">
        <input type="checkbox" name="employeeList" value="${employee.eid}">
        <input type="text" value="${employee.name}">
        <input type="text" value="${employee.position}">
        <br>
    </c:forEach>
    <input type="number" name="hours">Hour(s)<br>
    <input type="submit" value="Submit">    
</form>
