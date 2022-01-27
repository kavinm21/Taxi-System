import java.sql.Connection;
import java.sql.PreparedStatement;
//19pd18 & 19pd33 Kavin M & Shankar Subramanian
public class BookingDao {
	public static int addBooking(int c_id, String cab_type, int dist, int amt) {
		int status = 0;
		try {
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into booking(customer_id,cab_type,distance,amount) values(?,?,?,?)");
			ps.setInt(1,c_id);
			ps.setString(2, cab_type);
			ps.setInt(3, dist);
			ps.setInt(4, amt);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e) {System.out.println(e);};
		return status;
	}
	public static int delBooking(int b_id) {
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from booking where booking_id=?");
			ps.setInt(1,b_id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
