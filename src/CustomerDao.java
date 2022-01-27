import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//19pd18 & 19pd33 Kavin M & Shankar Subramanian
public class CustomerDao {
	public static int addCustomer(String Name, String Mob_Num) {
		int status = 0;
		try {
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into customer(customer_name,mobile_number) values(?,?)");
			ps.setString(1,Name);
			ps.setString(2, Mob_Num);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e) {System.out.println(e);};
		return status;
	}
	public static int delCustomer(int c_id) {
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from customer where customer_id=?");
			ps.setInt(1,c_id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static boolean checkCustomer(int c_id) {
		boolean status = false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from customer where customer_id=?");
			ps.setInt(1,c_id);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
