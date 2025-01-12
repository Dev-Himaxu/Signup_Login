package operation;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbconnection.Getconnection;
import ui.CredPojo;

public class OperationSignup  implements Operations{

	@Override
	public void Submit(CredPojo obj) {
		try {
			PreparedStatement ps = Getconnection.getConnection()
					.prepareStatement(("insert into signup values (?,?,?,?,?)"));
			
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getContact());
			ps.setString(3, obj.getGender());
			ps.setString(4, obj.getComment());
			ps.setString(5, obj.getCity());
			
			ps.executeUpdate();
			System.out.println("Data inserted in signup db");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void Discard(CredPojo obj) {
		try {
			PreparedStatement ps = Getconnection.getConnection()
					.prepareStatement("delete from signup where contact no =?");
			ps.setString(1, obj.getContact());
			ps.executeUpdate();
			System.out.println("Data deleted from signup db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
