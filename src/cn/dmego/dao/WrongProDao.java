package cn.dmego.dao;

import java.util.ArrayList;

import cn.dmego.domain.WrongPro;

public interface WrongProDao {
	/**
	 * ��ʾ����
	 * @return ���⼯
	 */
	public ArrayList<WrongPro> getWrongPro();
	/**
	 * ���������������
	 * @param wrongpro
	 */
	public void addWrongPro(ArrayList<WrongPro> wrongpro);
	
	/**
	 * ����Ե���Ӵ������ɾ��
	 * @param wrongpro
	 */
	public void delWrongPro();
	
	/**
	 * ���ô����
	 */
	public void resertWro();
}
