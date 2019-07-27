<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表格列表</title>
</head>
<body>
<table border="1" width="100%" class="tab">
    <tr>
        <th>表名</th>
        <th>操作</th>
    </tr>
    <c:forEach var="entity" items="${excelList}">
        <tr>

            <td>${entity}</td>
            <td>
              <%--  <a href="<c:url value="/goods/"/>delete/${entity.id}?pageNO=${pageNO}" class="abtn">删除</a>
                <a href="<c:url value="/goods/"/>edit/${entity.id}" class="abtn">编辑</a>
                <a href="<c:url value="/goods/"/>upPicture/${entity.id}" class="abtn">上传</a>--%>
                  <a href="${pageContext.request.contextPath}/excel/viewDetail">预览表格</a>
                <a href="${pageContext.request.contextPath}/notify/download">下载表格</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>