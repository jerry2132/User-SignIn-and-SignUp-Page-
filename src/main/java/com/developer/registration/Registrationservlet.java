package com.developer.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registrationservlet
 */
@WebServlet("/register")
public class Registrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int t=0;
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upwd = request.getParameter("pass");
		String umobile = request.getParameter("contact");
		String repwd = request.getParameter("re_pass");
		

		
		RequestDispatcher dispatcher = null;
		
        if(true)
        {
        
        if(uname==null||uname.equals(""))
        {
        	++t;
        	request.setAttribute("status","invaliduname");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request,response);
			    
			}
        if(uemail==null||uemail.equals(""))
        {
        	++t;
        	request.setAttribute("status","invalidemail");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request,response);
			
        }
        if(upwd==null || upwd.equals(""))
        {
        	++t;
        	request.setAttribute("status","invalidpwd");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request,response);
			
        }
        if(!upwd.equals(repwd))
        {
        	++t;
        	request.setAttribute("status","invalidrepwd");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request,response);
			
        }
        if(umobile==null||umobile.equals(""))
        {
        	++t;
        	request.setAttribute("status","invalidmobile");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request,response);
		
        }
        if(!(umobile.length()<=10))
        {
        	++t;
        	request.setAttribute("status","invalidlength");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request,response);
			
        }
        }
		
        
       if(t==0)
       {
        Connection con = null;
		String url = "jdbc:mysql://localhost:3306/project?useSSL=false";
        String userName = "root";
        String pass = "00000000";
		
				
				try {
					 Class.forName("com.mysql.cj.jdbc.Driver");
			            con = DriverManager.getConnection(url, userName, pass);
					PreparedStatement pst = con.prepareStatement("insert into registrationtable (UNAME,UPASSWORD,UEMAIL,UMOBILE) values(?,?,?,?)");
					pst.setString(1, uname);
					pst.setString(2, upwd);
					pst.setString(3, uemail);
					pst.setString(4, umobile);
					
					
					int rowCount = pst.executeUpdate();
					dispatcher = request.getRequestDispatcher("registration.jsp");
					if(rowCount>0) {
						
						request.setAttribute("status", "success");
					}
					else
					{
						request.setAttribute("status", "failed");
					}
					dispatcher.forward(request,response);
					
					
					}
				 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				finally {
					
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				

	}
	}
	}


