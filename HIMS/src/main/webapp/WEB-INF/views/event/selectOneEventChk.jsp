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
	
	System.out.println("## > " +minor + " : " + time);
	
	try {
		Class.forName(driver).newInstance();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		return;
	}
	System.out.println("## Test Chk 3 ##");
   Connection conn = DriverManager.getConnection(url, id, pwd);
   String sql = "SELECT * FROM time_event where beacon_minor = ? and event_time = ?";
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   System.out.println("## Test Chk 4 ##");
   try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, minor);
      pstmt.setString(2, time);
      
      rs = pstmt.executeQuery();
      
      /* rs.last();
      nRecord = rs.getRow();
      rs.beforeFirst(); */
      int i = 0;
      
      JSONArray jArr = new JSONArray();
      JSONObject jObj[] = new JSONObject[30];
      /* for(i = 0; i < nRecord; i++) {
         jObj[i] = new JSONObject();
      } */
      
      i = 0;
      while (rs.next()) {
    	 jObj[i] = new JSONObject();
         jObj[i].put("beaconMinor", rs.getString("beacon_minor"));
         jObj[i].put("eventTime", rs.getString("event_time"));
         jObj[i].put("winner", rs.getString("winner"));
         jArr.add(0, jObj[i]);
         System.out.println("minor : " + rs.getString("beacon_minor") + "/ time : " + rs.getString("event_time") + "/ winner : " + rs.getString("winner"));
         System.out.println(jArr.toString());
         i++;
      }
     
      JSONObject result = new JSONObject();
      
      if(i == 0) { // 검색된 결과가 없으면
   		result.put("success",0);
      	result.put("message","검색된결과가없다.");
      	result.put("result",null);
      }
      
      /* for(i = 0; i < nRecord; i++) {
         jArr.add(0, jObj[i]);
      } */
      
      result.put("success", 1);
      result.put("message", "성공");
      result.put("result", jArr);
      
      out.println(result.toJSONString());
      
   } catch (SQLException e) {
      e.printStackTrace();
      return;
   } finally {
      rs.close();
      pstmt.close();
      conn.close();
   }
%>