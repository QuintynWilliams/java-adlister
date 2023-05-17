<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <c:if test="${user}">
            <h1>Welcome, ${user.username}!</h1>
            <h1>Welcome, ${user.email}!</h1>
        </c:if>


    </div>

</body>
</html>