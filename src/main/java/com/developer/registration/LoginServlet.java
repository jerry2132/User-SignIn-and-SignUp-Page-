package com.developer.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.mysql.cj.x.protobuf.MysqlxDatatypes.*;
//import com.mysql.cj.x.protobuf.MysqlxDatatypes.;
//import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uemail = request.getParameter("username");
		String upwd = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/project?useSSL=false";
        String userName = "root";
        String pass = "00000000";
        
        if(uemail==null||uemail.equals(""))
        {
        	request.setAttribute("status","invalidEmail");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request,response);
        }
        if(upwd==null||upwd.equals(""))
        {
        	request.setAttribute("status","invalidpwd");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request,response);
        }
		
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(url, userName, pass);
				PreparedStatement pst = con.prepareStatement("select * from registrationtable where UEMAIL = ? and UPASSWORD = ? ");
				pst.setString(1, uemail);
				pst.setString(2, upwd);
				
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					
					session.setAttribute("name",rs.getString("UNAME"));
					dispatcher = request.getRequestDispatcher("index.jsp");
					
				}
				else
				{
					request.setAttribute("status","failed");
					dispatcher = request.getRequestDispatcher("login.jsp");
				}
				dispatcher.forward(request,response);
		
	}
        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
