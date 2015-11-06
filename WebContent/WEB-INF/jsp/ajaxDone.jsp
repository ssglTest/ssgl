<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
{
	"statusCode":"${statusCode}", 
	"message":"${param.callbackType ne 'forwardConfirm' ? message : ''}", 
	"confirmMsg":"${param.callbackType eq 'forwardConfirm' ? message : ''}",
	"navTabId":"${navTabId}", 
	"rel":"${rel}",
	"callbackType":"${callbackType}",
	"forwardUrl":"${empty forwardUrl ? param.forwardUrl : forwardUrl}"
}

