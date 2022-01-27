import java.sql.Connection;
import java.sql.DriverManager;
//19pd18 & 19pd33 Kavin M & Shankar Subramanian
public class DB {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database_java","root","Mzrh26@#$");
		}
		catch(Exception e){
			System.out.println(e);
		}
		return con;
	}
}
