package com.demoREST.RESTfulCRUD_Employee.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.sql.*;

import java.util.concurrent.atomic.AtomicInteger;
import com.demoREST.RESTfulCRUD_Employee.model.Employee;

public class EmployeeDAO {

	private static final Map<Integer, Employee> empMap = new HashMap<Integer, Employee>();
	private static final List<String> skillset = Arrays.asList("JavaScript", "Java", "Sql");

	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/~/mc;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	private static final AtomicInteger aId = new AtomicInteger(0);
	
	//static block to load employee records in database
	static {
		initEmps();
	}

	private static void registerDriver() {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			;
		}
	}

	private static Connection getConnection() {
		try {
			// for H2 database
			return (DriverManager.getConnection(
					"jdbc:h2:tcp://localhost:9092/~/mc;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false", USER, PASSWORD));
		} catch (SQLException e) {
			e.printStackTrace();
			return (null);
		}
	}

	private static void closeConnection(Connection c) {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
			}
		}
	}

	private static void commit(Connection c) {
		if (c != null) {
			try {
				c.commit();
			} catch (SQLException e) {
			}
		}
	}

	private static void rollback(Connection c) {
		if (c != null) {
			try {
				c.rollback();
			} catch (SQLException e) {
			}
		}
	}

	private static void closeStatement(Statement s) {
		if (s != null) {
			try {
				s.close();
			} catch (SQLException e) {
			}
		}
	}

	private static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
	}

	private static boolean dropTables() {
		String sCreateSQL = "drop table if exists employee";
		Connection c = null;
		Statement s = null;
		boolean rc = false;
		try {
			c = getConnection();
			s = c.createStatement();
			s.execute(sCreateSQL);
			commit(c);
			rc = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement(s);
			closeConnection(c);
		}
		return (rc);
	}

	private static boolean createTables() {
		String sCreateSQL = "create table if not exists employee(" + "id int primary key," + "first_name text,"
				+ "last_name text," + "email text," + "phone text," + "skill_set text" + ")";
		Connection c = null;
		Statement s = null;
		boolean rc = false;
		try {
			c = getConnection();
			s = c.createStatement();
			s.execute(sCreateSQL);
			commit(c);
			rc = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement(s);
			closeConnection(c);
		}
		return (rc);
	}

	private static String getSkillSetInCSV(List<String> skillSet) {
		if (skillSet == null)
			return ("");
		StringBuilder sb = new StringBuilder(128);
		for (String s : skillSet) {
			sb.append(s).append(",");
		}
		sb.setLength(sb.length() - 1);
		return (sb.toString());
	}

	private static List<String> getSkillSetInList(String skillSet) {
		if (skillSet == null)
			return (null);
		List<String> l = new ArrayList<String>();
		String[] skillSetArray = skillSet.split(",");
		for (String s : skillSetArray) {
			l.add(s);
		}
		return (l);
	}

	//insert employee record into the database
	public static boolean insertEmployeeInDB(Employee e) {
		Connection c = null;
		Statement s = null;
		boolean rc = false;
		try {
			StringBuilder sb = new StringBuilder(1024);
			sb.append("insert into employee(id, first_name, last_name, email, phone, skill_set) values(");
			sb.append(aId.incrementAndGet()).append(",");
			sb.append('\'').append(e.getFirstName()).append('\'').append(",");
			sb.append('\'').append(e.getLastName()).append('\'').append(",");
			sb.append('\'').append(e.getEmail()).append('\'').append(",");
			sb.append('\'').append(e.getPhone()).append('\'').append(",");
			sb.append('\'').append(getSkillSetInCSV(e.getSkillSet())).append('\'').append(")");
			//System.out.println(sb.toString());

			c = getConnection();
			s = c.createStatement();
			s.execute(sb.toString());
			commit(c);
			rc = true;
		} catch (SQLException _e) {
			_e.printStackTrace();
		} finally {
			closeStatement(s);
			closeConnection(c);
		}
		return (rc);
	}

	//update employee record from database with given id
	public static boolean updateEmployeeInDB(Employee e) {
		Connection c = null;
		Statement s = null;
		boolean rc = false;
		try {
			StringBuilder sb = new StringBuilder(1024);
			sb.append("update employee set\n");
			sb.append("first_name=").append('\'').append(e.getFirstName()).append('\'').append(",\n");
			sb.append("last_name=").append('\'').append(e.getLastName()).append('\'').append(",\n");
			sb.append("email=").append('\'').append(e.getEmail()).append('\'').append(",\n");
			sb.append("phone=").append('\'').append(e.getPhone()).append('\'').append(",\n");
			sb.append("skill_set=").append('\'').append(getSkillSetInCSV(e.getSkillSet())).append('\'').append("\n");
			sb.append("where id = " + e.getId());
			//System.out.println(sb.toString());
			c = getConnection();
			s = c.createStatement();
			s.execute(sb.toString());
			commit(c);
			rc = true;
		} catch (SQLException _e) {
			_e.printStackTrace();
		} finally {
			closeStatement(s);
			closeConnection(c);
		}
		return (rc);
	}

	////delete employee record from database with given id
	public static boolean deleteEmployeeInDB(int empId) {
		Connection c = null;
		Statement s = null;
		boolean rc = false;
		try {
			StringBuilder sb = new StringBuilder(1024);
			sb.append("delete from employee\n");
			sb.append("where id = " + empId);
			//System.out.println(sb.toString());
			c = getConnection();
			s = c.createStatement();
			s.execute(sb.toString());
			commit(c);
			rc = true;
		} catch (SQLException _e) {
			_e.printStackTrace();
		} finally {
			closeStatement(s);
			closeConnection(c);
		}
		return (rc);
	}
 
	//fetch employee record from database with given id
	public static Employee selectEmployeeFromDB(int id) {
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		Employee e = null;
		try {
			StringBuilder sb = new StringBuilder(1024);
			sb.append("select first_name, last_name, email, phone, skill_set from employee\n");
			sb.append("where id = " + id);
			//System.out.println(sb.toString());
			c = getConnection();
			s = c.createStatement();
			rs = s.executeQuery(sb.toString());
			if (rs == null || !rs.next())
				return (null);
			e = new Employee();
			e.setId(id);
			e.setFirstName(rs.getString(1));
			e.setLastName(rs.getString(2));
			e.setEmail(rs.getString(3));
			e.setPhone(Integer.parseInt(rs.getString(4)));
			e.setSkillSet(getSkillSetInList(rs.getString(5)));
		} catch (SQLException _e) {
			_e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStatement(s);
			closeConnection(c);
		}
		return (e);
	}

	//fetch employee records from database
	public static List<Employee> selectEmployeesFromDB() {
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		Employee e = null;
		List<Employee> l = null;
		try {
			StringBuilder sb = new StringBuilder(1024);
			sb.append("select id, first_name, last_name, email, phone, skill_set from employee\n");
			//System.out.println(sb.toString());
			c = getConnection();
			s = c.createStatement();
			rs = s.executeQuery(sb.toString());
			if (rs == null)
				return (null);
			l = new ArrayList<Employee>();
			while (rs.next()) {
				e = new Employee();
				e.setId(Integer.parseInt(rs.getString(1)));
				e.setFirstName(rs.getString(2));
				e.setLastName(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setPhone(Integer.parseInt(rs.getString(5)));
				e.setSkillSet(getSkillSetInList(rs.getString(6)));
				l.add(e);
			}
		} catch (SQLException _e) {
			_e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStatement(s);
			closeConnection(c);
		}
		return (l);
	}

	private static void initEmps() {
		Employee emp1 = new Employee(1, "Bob", "Smith", "Bob@gmail.com", 1000000001, skillset);
		Employee emp2 = new Employee(2, "Allen", "Day", "Allen@gmail.com", 1000000002, skillset);
		Employee emp3 = new Employee(3, "Jones", "Berg", "Jones@gmail.com", 1000000003, skillset);

		// for H2 database
		registerDriver();
		dropTables();
		createTables();
		insertEmployeeInDB(emp1);
		insertEmployeeInDB(emp2);
		insertEmployeeInDB(emp3);
		
		for (Employee e : selectEmployeesFromDB()) {
			System.out.println(e);
		}
	}

	public static Employee getEmployee(int id) {
		return empMap.get(id);
	}

	public static Employee addEmployee(Employee emp) {
		empMap.put(emp.getId(), emp);
		return emp;
	}

	public static Employee updateEmployee(Employee emp) {
		empMap.put(emp.getId(), emp);
		return emp;
	}

	public static void deleteEmployee(int id) {
		empMap.remove(id);
	}

	public static List<Employee> getAllEmployees() {
		Collection<Employee> c = empMap.values();
		List<Employee> list = new ArrayList<Employee>();
		list.addAll(c);
		return list;
	}

	List<Employee> list;

	public static void main(String[] args) {
		
	}
}
