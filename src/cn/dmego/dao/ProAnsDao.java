package cn.dmego.dao;

import java.util.ArrayList;

import cn.dmego.domain.ProAns;

public interface  ProAnsDao {
		/**
		 * ����Ŀ���𰸵�һϵ�����ݴ浽���ݿ���
		 * @param proans
		 */
		public void addProAns(ProAns proans); 
		/**
		 * һ�ΰ��������ݴ��ڱ���
		 * @param pas
		 */
		public void addAll(ProAns[] pas);
		public void addAll(ArrayList<ProAns> pas);
		/**
		 * ��ȡ���е���������
		 */
		public void  readAll( ArrayList<ProAns> pas );
		
		/**
		 * ���ñ�����
		 */
		public void resert();
		
}
