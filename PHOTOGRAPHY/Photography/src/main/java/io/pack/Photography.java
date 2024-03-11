package io.pack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Photography extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");//content is of text in html
			PrintWriter pw=resp.getWriter();
			
			Class.forName("com.mysql.cj.jdbc.Driver");//syntax for connection
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/photography","root","root");
			
			PreparedStatement ps=con.prepareStatement("insert into customers values(?,?,?,?)");//data connection query
			System.out.println("success");
			
			ps.setString(1,req.getParameter("Fname"));
			ps.setString(2,req.getParameter("name"));
			ps.setString(3,req.getParameter("Mname"));
			ps.setString(4,req.getParameter("password"));
			
			int i=ps.executeUpdate();
			pw.println(i+"rows inserted");
			
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
