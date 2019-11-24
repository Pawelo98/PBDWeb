package testDB;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/TestDB")
public class TestDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user = "stud";
		String password = "stud";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/club_management?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to: " + jdbcUrl);
			
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
			
			out.println("Connected");
			
			conn.close();
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
