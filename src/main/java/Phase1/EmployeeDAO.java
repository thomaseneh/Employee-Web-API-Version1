package Phase1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeDAO {
	
	private static String url = "jdbc:mysql://localhost:3306/company";
	private static String username = "root";
	private static String password = "password";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public EmployeePojo create(EmployeePojo dataIn) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "insert into employee(name, email, department) values(?,?,?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, dataIn.getName());
			stmt.setString(2, dataIn.getEmail());
			stmt.setString(3, dataIn.getDepartment());
			
			stmt.executeUpdate();
			
			ResultSet primarykey = stmt.getGeneratedKeys();
			while(primarykey.next()) {
				int id = primarykey.getInt(1);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
			
			
		return dataIn;
			
		}
	
Set<EmployeePojo>findAll(){
	Set<EmployeePojo> dataOut = new TreeSet<>();
	
	try(Connection conn = DriverManager.getConnection(url, username, password)){
		String sql = "select * from employee";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String department = rs.getString("department");
			
			EmployeePojo pojo = new EmployeePojo(id, name, email, department);
			dataOut.add(pojo);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return dataOut;
	
}

}
