<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȣ�����հ����ý���(HIMS)</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/adminApproval.css"/>
</head>
<body>
<!-- ��� ���� -->
<header>
<jsp:include page="../common/header.jsp" />
</header>
<!-- ���� ���� ����-->
<div class="content" align="center">
	<table id="selectAPlist" align="center" class="table table-striped">
		<thead>
			<tr>
				<th>���̵�</th>
				<th>�̸�</th>
				<th>�޴���</th>
				<th>�̸���</th>
				<th width="50px">����</th>
				<th width="50px">����</th>
			</tr>
		</thead>
		<c:choose>
		<c:when test="${!empty list}">
			<c:forEach var="ap" items="${list}" varStatus="status">
				<tr>
					<td id="userid" name="userid"><c:out value="${ap.userid}"/></td>
					<td><c:out value="${ap.username}"/></td>
					<td><c:out value="${ap.mobile}"/></td>
					<td><c:out value="${ap.email}"/></td>
					<td>
						<button id="approvalBtn" class="btn btn-danger btn-md" onClick="location.href='member.adminApproval.do?userid=${ap.userid}'">����</button>
					</td>
					<td>
						<button id="rejectBtn" class="btn btn-default btn-md" onClick="location.href='member.adminReject.do?userid=${ap.userid}'">����</button>
					</td>
				</tr>
			</c:forEach>
		</c:when>
		</c:choose>
	</table>
</div>
<!-- //���� ���� �� -->
<!-- Ǫ�� ���� -->
<footer>
<jsp:include page="../common/footer.jsp" />
</footer>
</body>
</html>