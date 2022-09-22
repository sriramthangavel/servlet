import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.dbms.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Test","root","root");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return con;		
	}
	
//	                                             ----------------save-----------
	
	  public static int save(Emp e) {
		int status = 0;
		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into user(name,password,email,country)value(?,?,?,?)");
			ps.setString(1,e.getName());
			ps.setString(2,e.getEmail());
			ps.setString(3,e.getPassword());
			ps.setString(4,e.getCountry());
			
		status=ps.executeUpdate();
		con.close();
		}
		
		catch(Exception ex){
		ex.printStackTrace();	
		}
		return status;
	
//		                                      -------------update-----------
		
		 public static int update(Emp e) {
				int status = 0;
				try {
					Connection con = EmpDao.getConnection();
					PreparedStatement ps = con.prepareStatement("update user set name=?,email=?,password=?,country=? where id=?");
					ps.setString(1,e.getName());
					ps.setString(2,e.getEmail());
					ps.setString(3,e.getPassword());
					ps.setString(4,e.getCountry());
					
				status=ps.executeUpdate();
				con.close();
				}
				
				catch(Exception ex){
				ex.printStackTrace();	
				}
				return status;
	}
		 
//		                                      -----------------delete--------------
		 
		 
		 public static int delete(int id) {
				int status = 0;
				try {
					Connection con = EmpDao.getConnection();
					PreparedStatement ps = con.prepareStatement("delete from user  where id=?");
					ps.setInt(1, id);
				status=ps.executeUpdate();
				con.close();
				}
				
				catch(Exception e){
				e.printStackTrace();	
				}
				return status;
	}
		 
//		                                    ---------------get element by id-------------

		 public static Emp getEmployeeById(int id) {
				Emp e = new Emp();
				
				try {
					Connection con = EmpDao.getConnection();
					PreparedStatement ps = con.prepareStatement("Select * from user where id=?");
					ps.setInt(1, id);
					ResultSet rs=ps.executeQuery();
					if(rs.next()) {
						e.setId(rs.getInt(1));
						e.setName(rs.getString(2));
						e.setEmail(rs.getString(3));
						e.setPassword(rs.getString(4));
						e.setCountry(rs.getString(5));
					}	
				con.close();
				}
				
				catch(Exception ex){
				ex.printStackTrace();	
				}
				return e;
	}
	  
//	                                   ------------------Get All Elements----------------

		 public static List<Emp> getAllEmployee() {
				List<Emp> list=new ArrayList();
				
				try {
					Connection con = EmpDao.getConnection();
					PreparedStatement ps = con.prepareStatement("Select * from user");
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						Emp e = new Emp();
						e.setId(rs.getInt(1));
						e.setName(rs.getString(2));
						e.setEmail(rs.getString(3));
						e.setPassword(rs.getString(4));
						e.setCountry(rs.getString(5));
						list.add(e);
					}
						
						
				con.close();
				}
				
				catch(Exception ex){
				ex.printStackTrace();	
				}
				return list;
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  }
