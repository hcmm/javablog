<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1>Latest new From the java world:</h1>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>date</th>
			<th>item</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${items }" var="item">
			<tr>
				<td><c:out value="${item.publishedDate }" /></td>
				<td><strong> <a href="<c:out value="${item.link }"/>"
						target="_link"> <c:out value="${item.title }" />
					</a>
				</strong> <br /> ${item.description }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
