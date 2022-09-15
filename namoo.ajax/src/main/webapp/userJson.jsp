<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="application/json; charset=utf-8"  pageEncoding="utf-8"%>
<%
BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
StringBuilder sb = new StringBuilder();

String json = null;
while((json= in.readLine()) != null ){
	sb.append(json);
}

// 에코
out.print(sb.toString());
in.close();
out.close();
%>