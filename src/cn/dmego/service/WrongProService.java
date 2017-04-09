package cn.dmego.service;
/************************
 * 错题表业务逻辑处理
 * @author dmego
 *
 */
import java.util.ArrayList;

import cn.dmego.dao.MysqlWrongProDao;
import cn.dmego.domain.WrongPro;

public class WrongProService {
	MysqlWrongProDao mwp = new MysqlWrongProDao();
	/**
	 * 将所有错题显示出来
	 * @return 错题Bean
	 */
	public ArrayList<WrongPro> showWrong(){
		return mwp.getWrongPro();
	}
	
	/**
	 * 从错题表中删除题
	 * @param wrongBean
	 */
	public void wipeWrongInDB(){
		mwp.delWrongPro();
	}
	
	/**
	 * 先重置错题表，然后将本次答题中的错题存入错题表中
	 * @param wrongBean
	 */
	public void reSaveWrongToDB(ArrayList<WrongPro> wrongBean){
		mwp.resertWro(); //先重置 数据表
		mwp.addWrongPro(wrongBean);
	}
	/**
	 * 将本次答题中的错题存入错题表中
	 * @param wrongBean
	 */
	public void saveWrongToDB(ArrayList<WrongPro> wrongBean){
		mwp.addWrongPro(wrongBean);
	}
	
	/**
	 * 检查练习错题时的答题情况，
	 * @param wrongBean 错题集（增加了用户输入的答案）
	 * @return 校验完成的错题集
	 */
	public ArrayList<WrongPro> checkWrAnswer(ArrayList<WrongPro> wrongBean){
		
		for(int i= 0;i < wrongBean.size(); i++){
			if(wrongBean.get(i).getYourAns().equals(wrongBean.get(i).getRightAns())){
				wrongBean.get(i).setChecks( 1 );
			}
			else{
				//----将该题的答错次数加1----
				wrongBean.get(i).setTimes( wrongBean.get(i).getTimes() + 1 );	
				wrongBean.get(i).setChecks( -1 );
			}
		}
		return wrongBean;
	}
}
