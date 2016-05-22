package conexaoTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conexaoTest {
	public static String driverHSQLDB = "org.hsqldb.jdbcDriver";
	public static String user = "SA";
	public static String password = "123456";

	public static Connection getConexao() throws SQLException {

		System.out.println("Conectando ao banco");

		String path = System.getProperty("user.dir") + "\\bancoDados\\empresaComercial";
		try {
			Class.forName(driverHSQLDB);
			return DriverManager.getConnection("jdbc:hsqldb:file:" + path, user, password);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}

		return null;
	}

	public static void close(Connection conn, PreparedStatement pstm, ResultSet rs) {

		System.out.println("Desconectado ao banco!!!");

		try {
			if (conn != null) {
				conn.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws SQLException {
		getConexao();
		close(null, null, null);
	}

}
