package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DBCon {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	
	// 전체조회
	public List<Employee> getEmpList() {
		List<Employee> empList = new ArrayList<>();
		conn = DBCon.getConnect();
		String sql = "select * from empl_demo";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id")); //데이터의 컬럼명..?인 듯..?
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date").substring(0, 10));
				empList.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	} // end of getEmpList()
	
	
	
}
