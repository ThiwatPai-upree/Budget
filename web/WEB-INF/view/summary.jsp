<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>Summary</h1>
<h3>Project: ${project_name}</h3>
<h4>Skills</h4>
<ul>
    <c:forEach var="skill" items="${skills}">
        <li>${skill.skill}</li>
    </c:forEach>
</ul>
<h4>Employees</h4>
<ul>
    <c:forEach var="employee" items="${employees}">
        <li>${employee.name}</li>
    </c:forEach>
</ul>
<p>Hours: ${hours}</p>
<p>Budget: ${budget}</p>