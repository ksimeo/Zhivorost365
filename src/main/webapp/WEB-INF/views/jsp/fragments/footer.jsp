<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div>
<h6><b>&copy;2017&nbsp;<a href="mailto:ksimeo@gmail.com">theKsimeoCode</a></b></h6>
</div>

<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<spring:url value="/resources/core/js/hello.js" var="coreJs" />
<spring:url value="/resources/core/js/bootstrap.min.js"
            var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>