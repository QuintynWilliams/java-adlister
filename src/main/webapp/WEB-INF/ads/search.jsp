<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/logout-navbar.jsp" />

<div class="page-wrapper">
    <div class="container">
        <div class="row">
            <div class="column">
                <c:if test="${empty search}">
                    <h3>Here are all the ads</h3>
                </c:if>
                <c:if test="${not empty search}">
<%--                allow malicious dangerous crosssite scripting--%>
<%--                <h3>Finding ${search}</h3>--%>
                    <h3>Finding <c:out value="${search}"/></h3>
                </c:if>
                <h1>Find an ad!</h1>
                <form action="/ads/search" method="post">
                    <input class="rounded" type="text" name="search" placeholder="search">
                    <button class="btn btn-primary" role="button">Search</button>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>