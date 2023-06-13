package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/test" }, initParams = { @WebInitParam(name = "url", value = "jdbc:mysql:///javafsj"),
		@WebInitParam(name = "user", value = "root"), @WebInitParam(name = "password", value = "nopassword") },loadOnStartup = 10)
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection = null;
	private PreparedStatement pstmt = null;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded Successfully!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init() throws ServletException {
		String jdbcUrl = getInitParameter("url");
		String user = getInitParameter("user");
		String password = getInitParameter("password");
		try {
			connection = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("connection established sucessfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String userage = request.getParameter("userage");
		String useraddress = request.getParameter("useraddr");

		String SqlInsertQuery = "INSERT INTO STUDENT(`NAME`,`AGE`,`ADDRESS`) VALUES(?,?,?)";

		try {
			if (connection != null) {
				pstmt = connection.prepareStatement(SqlInsertQuery);
			}
			if (pstmt != null) {
				pstmt.setString(1, username);
				pstmt.setInt(2, Integer.parseInt(userage));
				pstmt.setString(3, useraddress);
			}
			if (pstmt != null) {
				int rowAffected = pstmt.executeUpdate();
				PrintWriter out = null;

				if (rowAffected == 1) {
					out = response.getWriter();
					out.println("<h1 style='color:green;text-align:center'>REGISTRATION SUCCESSFUL</h1>");

				} else {
					out.println("<h1 style='color:green;text-align:center'>REGISTRATION UNSUCCESSFUL TRY AGAIN</h1>");
					out.println("<a href='./reg.html'>|REGISTRATION|</a>");

				}
				out.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void destroy() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
}
