package in.ineuron.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.ineuron.dto.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {
     
	private static final String SQLINSERTQUERY = "insert into employee8(eid,ename,eage,email,mobile) values(?,?,?,?,?)";
	@Override
	public String insert(Employee employee) {
		Connection connection=null;
		PreparedStatement pstmt = null;
		String status = null;
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafsj", "root", "nopassword");
			if(connection!=null)
				pstmt =connection.prepareStatement(SQLINSERTQUERY);
			if(pstmt != null){
				pstmt.setString(1, employee.getEid());
				pstmt.setString(2, employee.getEname());
				pstmt.setInt(3, employee.getEage());
				pstmt.setString(4, employee.getEmail());
				pstmt.setString(5, employee.getMobile());
				
				int rowCount = pstmt.executeUpdate();
				if(rowCount==1)
				{
					status = "success";
				}
				else
				{
					status = "failure";
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	
}


//CREATE TABLE `javafsj`.`employee8` (
//		  `eid` VARCHAR(45) NOT NULL,
//		  `ename` VARCHAR(45) NULL,
//		  `eage` INT NULL,
//		  `email` VARCHAR(45) NULL,
//		  `mobile` VARCHAR(45) NULL,
//		  PRIMARY KEY (`eid`));