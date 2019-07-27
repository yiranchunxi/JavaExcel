<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表详情</title>
</head>
<body>
<table border="1" width="100%" class="tab">
    <tr>
        <c:forEach var="excelheader" items="${tableHeader}">
                <th>${excelheader}</th>
        </c:forEach>
    </tr>
    <c:forEach var="entity" items="${templateExcel}">
        <tr>
            <td>${entity.id}</td>
            <td>${entity.sid}</td>
            <td>${entity.sdate}</td>
            <td>${entity.today}</td>
            <td>${entity.templateId}</td>
            <td>${entity.templateInfo}</td>
            <td>${entity.workNumber}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>