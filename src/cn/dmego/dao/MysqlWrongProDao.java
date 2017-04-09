package cn.dmego.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * �Դ�������ݲ���
 */
import java.util.ArrayList;
import cn.dmego.domain.WrongPro;
import cn.dmego.util.JDBCUtils;

public class MysqlWrongProDao implements WrongProDao{

	@Override //��Ӵ���
	public void addWrongPro(ArrayList<WrongPro> wrongpro) {
		String sql = "insert into wrongPro values (?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn(); //��ȡ����
			for(int i = 0; i< wrongpro.size(); i++){ //ͨ��ѭ��������Ӵ��⼯�д浽�������
				ps = conn.prepareStatement(sql);
				ps.setString(1, wrongpro.get(i).getProblem());
				ps.setString(2, wrongpro.get(i).getRightAns());
				ps.setString(3, wrongpro.get(i).getYourAns());
				ps.setInt(4, wrongpro.get(i).getChecks());
				ps.setInt(5, wrongpro.get(i).getTimes());
				ps.executeUpdate();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}

	@Override //ɾ��������жԵ���
	public void delWrongPro() {
		String sql = "delete from wrongPro where checks = 1 ";
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			stat.execute(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, stat, conn);
		}
	}

	@Override //ȡ�����д���
	public ArrayList<WrongPro> getWrongPro() {
		
		ArrayList<WrongPro> wrongpro = new ArrayList<WrongPro>();
		String sql = "select * from wrongPro";
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				String problem = rs.getString("problem");
				String rightAns = rs.getString("rightans");
				String yourAns = rs.getString("yourans");  
				int checks = rs.getInt("checks");  
				int times = rs.getInt("times");
				WrongPro wrong = new WrongPro(problem, rightAns, yourAns, checks, times);
				wrongpro.add(wrong);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, stat, conn);
		}
		
		return wrongpro;
	}

	@Override //���ô����
	public void resertWro() {
		String sql = "truncate table wrongPro";
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
			try{	
				conn = JDBCUtils.getConn();
				stat = conn.createStatement();
				stat.execute(sql);
			}catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				JDBCUtils.close(rs, stat, conn);
			}
		
	}

}
