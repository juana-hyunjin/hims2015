<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.json.simple.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1522:XE";
	String id = "whatsup";
	String pwd = "tiger";
	/* int nRecord = 0; */
	
	String minor = request.getParameter("minor");
	String time = request.getParameter("time");
	String userid = request.getParameter("userid");
	
	System.out.println(minor + " : " + time + " : " + userid);
	
	try {
		Class.forName(driver).newInstance();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		return;
	}
	
   Connection conn = DriverManager.getConnection(url, id, pwd);
   String sql = "update time_event set winner=? where beacon_minor = ? and event_time = ?";
   PreparedStatement pstmt = null;
   
   try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, userid);
      pstmt.setString(2, minor);
      pstmt.setString(3, time);

      pstmt.executeUpdate();
      
   } catch (SQLException e) {
      e.printStackTrace();
      return;
   } finally {
      pstmt.close();
      conn.close();
   }
%>