<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>

    <style>
        .card {
            width: 18rem;
        }

        @media (max-width: 768px) {
            .card {
                width: 100%;
            }
        }

    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/logout-navbar.jsp" />

<div class="container">
    <h1 class="mb-5">Here Are all the ads!</h1>

    <div class="d-flex justify-content-center flex-wrap bg-body-secondary rounded overflow-y overflow-scroll"
         style="height: 80vh;">
        <c:forEach var="ad" items="${ads}">
            <div class="card m-3">
                <img src="https://placehold.co/150x100" class="card-img-top" alt="${ad.id}">
                <div class="card-body">
                    <h5 class="card-title">${ad.title}</h5>
                    <p class="card-text">${ad.description}</p>
                    <a href="#" class="btn btn-primary">Details</a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>