package teamProject;

import java.sql.*;
import java.util.ArrayList;

public class DAO {
	Connection conn = null;
	ResultSet rs = null;
	Statement st = null;
	PreparedStatement ps = null;

	public DAO() {
		try {
			String id = "sys as sysdba";
			String pw = "Tnwltkfkd1012!";
			String url = "jdbc:oracle:thin:@192.168.0.131:1521/xe";

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		}
	}

	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			System.out.println(e + "=> dbClose fail");
		}
	}

	public void insertData(Data data) {
		try {
			String que = "insert into duduTable(duduname , duduscore) values(?, ?)";
			ps = conn.prepareStatement(que);
			ps.setString(1, data.name);
			ps.setInt(2, data.score);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	public ArrayList<Data> readData() {
		ArrayList<Data> arr = new ArrayList<Data>();
		System.out.println(arr);
		try {
			st = conn.createStatement();
			String sql = "SELECT * FROM duduTable ORDER BY duduscore DESC";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				arr.add(new Data(rs.getString(1), rs.getInt(2)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}