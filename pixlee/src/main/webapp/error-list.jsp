<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="col-md-12">
	<c:set var="errors" value="${ errors }" />
	<c:if test="${ errors != null && fn:length(errors) > 0 }">
		<c:forEach var="error" items="${ errors }">
			<div class="alert alert-danger alert-dismissable">
				<button aria-hidden="true" class="close" data-dismiss="alert"
					type="button">&times;</button>
				<b>${error}</b>
			</div>
		</c:forEach>
	</c:if>
</div>


