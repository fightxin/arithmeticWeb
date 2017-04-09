package cn.dmego.util;
/**********************
 * 数据库连接工具类
 * @author dmego
**********************/
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.Properties;

public class JDBCUtils {
	static Properties prop = null;
	private JDBCUtils(){
	}
	//为了保证只读取一次配置文件，将读取步骤放在静态代码块中
	static {
			try {
					prop = new Properties();
					prop.load(new FileReader(JDBCUtils.class.getClassLoader().getResource("config.properties").getPath()));
			} catch (Exception e) {
					e.printStackTrace();
			}
	}
	//------------提供两个方法，连接数据库和关闭连接-----------------
	/**
	 * 获取连接
	 * @return Connection对象
	 * @throws Exception
	 */
	public static Connection getConn() throws Exception{
		Class.forName(prop.getProperty("driver"));
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
	}
	
	/**
	 * 关闭连接
	 * @param rs
	 * @param stat
	 * @param conn
	 */
	public static void close(ResultSet rs, Statement stat, Connection conn) {
		if(rs != null){
				try {
						rs.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}finally {
						rs = null;
				}
			}
		if(stat != null){
			try {
					stat.close();
			} catch (SQLException e) {
					e.printStackTrace();
			}finally {
					stat = null;
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
					e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}	
} //--class
