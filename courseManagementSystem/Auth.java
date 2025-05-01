package courseManagementSystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Auth {
	private static PreparedStatement checkEmailStmt;
	private static PreparedStatement retrieveRoleStmt;
	private static PreparedStatement checkEmailExistenceStmt;
	private static PreparedStatement addCredentialStmt;
	
	private static PreparedStatement addCourseStmt;
	private static PreparedStatement deleteCourseStmt;
	
	private static PreparedStatement addModuleStmt;
	private static PreparedStatement deleteModuleStmt;
	
	private static PreparedStatement addTeachStmt;
	private static PreparedStatement deleteTeachStmt;
	
	private static PreparedStatement addResultsStmt;
	private static PreparedStatement addComboItemsStmt;
	
	public Auth(DbManager db) throws SQLException {
		checkEmailStmt = db.getConnection().prepareStatement("SELECT count(*) FROM auth WHERE email=?");
		retrieveRoleStmt = db.getConnection()
				.prepareStatement("SELECT name,role FROM auth WHERE email=? AND BINARY password=?");
		checkEmailExistenceStmt = db.getConnection().prepareStatement("SELECT email FROM auth WHERE email=?");
		addCredentialStmt = db.getConnection()
				.prepareStatement("INSERT INTO auth (name, email, phoneNo, role, password, course) VALUES (?,?,?,'Student',?,?)");
		
		addCourseStmt = db.getConnection().prepareStatement("INSERT INTO courses(course_name) VALUES (?)");
		deleteCourseStmt = db.getConnection().prepareStatement("DELETE FROM courses WHERE course_name = ?");
		
		addModuleStmt = db.getConnection().prepareStatement("INSERT INTO modules(module_name, module_type, course_id) VALUES (?,?,?)");
		deleteModuleStmt = db.getConnection().prepareStatement("DELETE FROM modules WHERE module_name = ?");
		
		addTeachStmt =  db.getConnection().
				prepareStatement("INSERT INTO auth (name, email, phoneNo, role, password, course) VALUES (?,?,?,'Teacher',?,?)");
		deleteTeachStmt = db.getConnection().prepareStatement("DELETE FROM auth WHERE email = ?");
		
		addResultsStmt = db.getConnection()
				.prepareStatement("INSERT INTO results(`student_id`, `module_id`, `marks`) VALUES (?,?,?)");
		
		addComboItemsStmt = db.getConnection()
				.prepareStatement("SELECT course_name FROM courses");
	
	}

	public ArrayList<String> login(String email, String password) throws Exception {
		ArrayList<String> arrayList = new ArrayList<String>();
		try {
			checkEmailStmt.setString(1, email);
			ResultSet rs = checkEmailStmt.executeQuery();
			int count = 0;
			if (rs.next()) {
			}
				count = rs.getInt(1);
			if (count == 0)
				throw new Exception("No user with this email found!");
			else {
				retrieveRoleStmt.setString(1, email);
				retrieveRoleStmt.setString(2, password);
				rs = retrieveRoleStmt.executeQuery();
				if (rs.next()) {
					arrayList.add(rs.getString("name"));
					arrayList.add(rs.getString("role"));
					return arrayList;
				} else
					throw new Exception("Password not valid!");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new Exception("An error occurred while checking the email and password!");
		}
	}

	public void addCredential(String name, String email, String password, String phoneNo, String comboBox) throws Exception {
		try {
			checkEmailExistenceStmt.setString(1, email);
			ResultSet rs = checkEmailExistenceStmt.executeQuery();
			if (rs.next()) {
				throw new Exception("Email already in use!");
			} else {
				addCredentialStmt.setString(1, name);
				addCredentialStmt.setString(2, email);
				addCredentialStmt.setString(3, password);
				addCredentialStmt.setString(4, phoneNo);
				addCredentialStmt.setString(5, comboBox);
				addCredentialStmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addCourse(String course_name) throws Exception {
		try {	
				addCourseStmt.setString(1,course_name);
				addCourseStmt.executeUpdate();
			}
		 catch (SQLException e) {
			 System.out.println(e.getMessage());
				throw new Exception("An error occurred while adding new course!");
			
		}
	}
	
	public static void deleteCourse(String course_name) throws Exception {
	          try {
	            deleteCourseStmt.setString(1, course_name);
	            deleteCourseStmt.executeUpdate();
	          } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            throw new Exception("An error occurred trying to delete the course!");
	          }
	        }
	
	public static void addModule(String module_name, String module_type, String course_ID) throws Exception {
		try {	
			addModuleStmt.setString(1,module_name);
			addModuleStmt.setString(2,module_type);
			addModuleStmt.setString(3,course_ID);
			addModuleStmt.executeUpdate();
			}
		 catch (SQLException e) {
			 System.out.println(e.getMessage());
				throw new Exception("An error occurred while adding module!");
			
		}
	}
	
	public static void deleteModule(String module_name) throws Exception {
		try {	
			deleteModuleStmt.setString(1,module_name);
			deleteModuleStmt.executeUpdate();
			}
		 catch (SQLException e) {
			 System.out.println(e.getMessage());
				throw new Exception("An error occurred while deleting module!");
			
		}
	}
	
	public static void addTeach(String name, String email, String password, String phoneNo, String comboBox) throws Exception {
		try {
			addTeachStmt.setString(1, name);
			addTeachStmt.setString(2, email);
			addTeachStmt.setString(3, password);
			addTeachStmt.setString(4, phoneNo);
			addTeachStmt.setString(5, comboBox);
			addTeachStmt.executeUpdate();
			}
		  catch (SQLException e) {
			  System.out.println(e.getMessage());
				throw new Exception("An error occurred while adding teacher!");
		}
	}
	
	public static void deleteTeach(String email) throws Exception {
		try {	
			deleteTeachStmt.setString(1,email);
			deleteTeachStmt.executeUpdate();
			}
		 catch (SQLException e) {
			 System.out.println(e.getMessage());
				throw new Exception("An error occurred while deleting module!");
			
		}
	}
	

	public static void addResults(String student_id, String module_id, String marks) throws Exception {
		try {	
			addResultsStmt.setString(1, student_id);
			addResultsStmt.setString(2, module_id);
			addResultsStmt.setString(3, marks);
			addResultsStmt.executeUpdate();
			}
		 catch (SQLException e) {
			 System.out.println(e.getMessage());
				throw new Exception("An error occurred while deleting module!");
			
		}
	}
	
	public PreparedStatement getAddComboItemsStmt() {
	    return addComboItemsStmt;
	  }
}
