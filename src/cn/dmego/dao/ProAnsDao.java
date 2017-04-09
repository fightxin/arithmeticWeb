package cn.dmego.dao;

import java.util.ArrayList;

import cn.dmego.domain.ProAns;

public interface  ProAnsDao {
		/**
		 * 将题目，答案等一系列数据存到数据库中
		 * @param proans
		 */
		public void addProAns(ProAns proans); 
		/**
		 * 一次把所有数据存在表中
		 * @param pas
		 */
		public void addAll(ProAns[] pas);
		public void addAll(ArrayList<ProAns> pas);
		/**
		 * 读取表中的所有数据
		 */
		public void  readAll( ArrayList<ProAns> pas );
		
		/**
		 * 重置表数据
		 */
		public void resert();
		
}
