package cn.dmego.dao;

import java.util.ArrayList;

import cn.dmego.domain.WrongPro;

public interface WrongProDao {
	/**
	 * 显示错题
	 * @return 错题集
	 */
	public ArrayList<WrongPro> getWrongPro();
	/**
	 * 将错题存入错题表中
	 * @param wrongpro
	 */
	public void addWrongPro(ArrayList<WrongPro> wrongpro);
	
	/**
	 * 将答对的题从错题表中删除
	 * @param wrongpro
	 */
	public void delWrongPro();
	
	/**
	 * 重置错题表
	 */
	public void resertWro();
}
