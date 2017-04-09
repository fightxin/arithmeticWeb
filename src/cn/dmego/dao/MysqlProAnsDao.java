package cn.dmego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import cn.dmego.domain.ProAns;
import cn.dmego.util.JDBCUtils;

public class MysqlProAnsDao  implements ProAnsDao{
	
	@Override
	public void addAll(ProAns[] pas) {
		String sql = "insert into arithmetci_2 values (?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			for(int i = 0; i< pas.length;i++){
				ps = conn.prepareStatement(sql);
				ps.setInt(1, pas[i].getId());
				ps.setString(2, pas[i].getProblem());
				ps.setString(3, pas[i].getRightAns());
				ps.setString(4, pas[i].getYourAns());
				ps.setInt(5, pas[i].getChecks());
				ps.executeUpdate();
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
	
	@Override
	public void addAll(ArrayList<ProAns> pas) {
		String sql = "insert into arithmetci_2 values (?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			for(int i = 0; i< pas.size();i++){
				ps = conn.prepareStatement(sql);
				ps.setInt(1, pas.get(i).getId());
				ps.setString(2, pas.get(i).getProblem());
				ps.setString(3, pas.get(i).getRightAns());
				ps.setString(4, pas.get(i).getYourAns());
				ps.setInt(5, pas.get(i).getChecks());
				ps.executeUpdate();
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
	
	@Override
	public void addProAns(ProAns proans) {
		String sql = "insert into arithmetci_2 values (?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, proans.getId());
			ps.setString(2, proans.getProblem());
			ps.setString(3, proans.getRightAns());
			ps.setString(4, proans.getYourAns());
			ps.setInt(5, proans.getChecks());
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
	
	@Override
	public void readAll( ArrayList<ProAns> pas) {
		String sql = "select * from arithmetci_2";
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
			try{	
				conn = JDBCUtils.getConn();
				stat = conn.createStatement();
				rs  = stat.executeQuery(sql);
				while(rs.next()){
					ProAns newPas = new ProAns(rs.getInt("id"), rs.getString("problem"),rs.getString("rightAns"),
							rs.getString("yourAns"), rs.getInt("checks") );
					pas.add(newPas);
				}
			}catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				JDBCUtils.close(rs, stat, conn);
			}
	}

	@Override
	public void resert() {
		String sql = "truncate table arithmetci_2";
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
