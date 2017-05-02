<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>Index</h1>
<form method="POST" action="/Budget/employee">
    <input name="pname"><br>
    <c:forEach var="skill" items="${skills}">
        <input type="checkbox" name="skillList" value="${skill.sid}">${skill.skill}<br>
    </c:forEach>
    <input type="submit" value="Next">
</form>