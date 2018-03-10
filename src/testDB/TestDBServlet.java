package testDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user="springstudent";
		String password = "springstudent";
		String jdbcURL="jdbc:mysql://localhost:3306/web_customer_tracker?SSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		PrintWriter out = response.getWriter();
		out.println("Connecting to DB:"+jdbcURL);
		
		
		try {
			Class.forName(driver);
			Connection myConnection = (Connection) DriverManager.getConnection(jdbcURL,user,password);
			out.println("Connection succesful!");
			myConnection.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
