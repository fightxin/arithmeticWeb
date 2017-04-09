package cn.dmego.service;
/************************
 * �����ҵ���߼�����
 * @author dmego
 *
 */
import java.util.ArrayList;

import cn.dmego.dao.MysqlWrongProDao;
import cn.dmego.domain.WrongPro;

public class WrongProService {
	MysqlWrongProDao mwp = new MysqlWrongProDao();
	/**
	 * �����д�����ʾ����
	 * @return ����Bean
	 */
	public ArrayList<WrongPro> showWrong(){
		return mwp.getWrongPro();
	}
	
	/**
	 * �Ӵ������ɾ����
	 * @param wrongBean
	 */
	public void wipeWrongInDB(){
		mwp.delWrongPro();
	}
	
	/**
	 * �����ô����Ȼ�󽫱��δ����еĴ������������
	 * @param wrongBean
	 */
	public void reSaveWrongToDB(ArrayList<WrongPro> wrongBean){
		mwp.resertWro(); //������ ���ݱ�
		mwp.addWrongPro(wrongBean);
	}
	/**
	 * �����δ����еĴ������������
	 * @param wrongBean
	 */
	public void saveWrongToDB(ArrayList<WrongPro> wrongBean){
		mwp.addWrongPro(wrongBean);
	}
	
	/**
	 * �����ϰ����ʱ�Ĵ��������
	 * @param wrongBean ���⼯���������û�����Ĵ𰸣�
	 * @return У����ɵĴ��⼯
	 */
	public ArrayList<WrongPro> checkWrAnswer(ArrayList<WrongPro> wrongBean){
		
		for(int i= 0;i < wrongBean.size(); i++){
			if(wrongBean.get(i).getYourAns().equals(wrongBean.get(i).getRightAns())){
				wrongBean.get(i).setChecks( 1 );
			}
			else{
				//----������Ĵ�������1----
				wrongBean.get(i).setTimes( wrongBean.get(i).getTimes() + 1 );	
				wrongBean.get(i).setChecks( -1 );
			}
		}
		return wrongBean;
	}
}
