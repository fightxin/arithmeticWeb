package cn.dmego.service;



import java.util.ArrayList;

import cn.dmego.dao.MysqlProAnsDao;
import cn.dmego.domain.ProAns;
import cn.dmego.domain.WrongPro;
import cn.dmego.produce.BinaryTree;
import cn.dmego.produce.CreatePro;
import cn.dmego.produce.ProperFra;

/************************
 * ҵ���߼�����
 * @author dmego
 *
 */
public class ProAnsService {
	CreatePro cre = new CreatePro();
	ProperFra fractin = new ProperFra();
	MysqlProAnsDao mpd = new MysqlProAnsDao();
	WrongProService wroService = new WrongProService();
	/**
	 * �����δ�������������ݿ��� 
	 * @param proBean
	 */
	public void saveToDB(ProAns[] proBean){
		mpd.resert();
		mpd.addAll(proBean);
	}
	/**
	 * ����û�����Ĵ��Ƿ���ȷ��Ȼ��ΪBean�е�check������ֵ
	 * ��-1������ˣ�1������ˣ�
	 * �������ˣ����������������
	 * @param proBean ��Ŀ�������飨�������û�����Ĵ𰸣�
	 * @return У����ɵ���Ŀ��������
	 */
	public ProAns[] checkAnswer(ProAns[] proBean){
		ArrayList<WrongPro> wrongBean = new ArrayList<WrongPro>();
		//wrongBean = wroService.showWrong();
		for(int i = 0 ; i < proBean.length; i++){
			if(proBean[i].getYourAns().equals(proBean[i].getRightAns()))
				proBean[i].setChecks(1);
			else{
				proBean[i].setChecks(-1);
				//----���������������----
				WrongPro wrongTemp = new WrongPro();
				wrongTemp.setProblem(proBean[i].getProblem());
				wrongTemp.setRightAns(proBean[i].getRightAns());
				wrongTemp.setYourAns(proBean[i].getYourAns());
				wrongTemp.setChecks(proBean[i].getChecks());
				wrongTemp.setTimes( 1 );
				wrongBean.add(wrongTemp);
			}
		}
		wroService.saveWrongToDB(wrongBean);
		return proBean;
	}
	
	/**
	 * �����û�������꼶������Ŀ�������꼶���⣩
	 * @param num Ĭ������10����
	 * @param grade �꼶
	 * @return ���ɺõ���Ŀ�������飨������Ŀ���ʽ����ȷ�𰸣�
	 */
	public ProAns[] produce(int grade){
		mpd.resert(); //�������ݱ�
		String rightAns = ""; //��������������ȷ��
		String problem = ""; //���ɵ�������ʽ
		int num = 10;
		ProAns[] proBean = new ProAns[num]; //javaBean���飬������װ���ɵ���Ŀ����ȷ��
		for(int i = 0; i< num;i++){
			String[] array = cre.proArraryG(grade);//����һ�������+���ֵ�����
	        BinaryTree tree = new BinaryTree(array); //��������Ϊ������������һ�ö������ķ���
	        rightAns = tree.CalAndVal(grade); //������ȷ������õ����Ǽٷ���
	        if(grade != 3 && grade != 4){
	        	rightAns = fractin.falseToTrue(rightAns); //������ļٷ�������Ϊ������	
	        }
	        //���ɵ���Ŀ�ַ�����������ڼ���������Ϊ�ڼ�����ʱ�������ṹ������Ϊ ���� ���� ����Ϊ0 ���仯��
	        problem = tree.toString(); 
	        proBean[i] = new ProAns(); //������ÿ��Ԫ�ض�����Ҫnew��һ�����������׳���ָ���쳣
	        proBean[i].setId(i+1);
	        proBean[i].setProblem(problem);
	        proBean[i].setRightAns(rightAns);
		}
		return proBean;
	}
	

	/**
	 * �����û�����Ĳ���������Ŀ�����������⣩
	 * @param hasmd ָ�����޳˳�����Y/N��
	 * @param hasfs	ָ�������������Y/N��
	 * @param hasgd ָ������������Ƿ�̶���Y/N��
	 * @param range ָ������ʽȡֵ��Χ
	 * @param num ָ���������
	 * @param synum ָ���̶����������������������������
	 * @return ���ɺõ���Ŀ�������飨������Ŀ���ʽ����ȷ�𰸣�
	 */
	public ProAns[] produce(String hasmd,String hasfs,String hasgd,int range,int num,int synum){
		mpd.resert(); //�������ݱ�
		String rightAns = ""; //��������������ȷ��
		String problem = ""; //���ɵ�������ʽ
		int grade = 0;
		ProAns[] proBean = new ProAns[num]; //javaBean���飬������װ���ɵ���Ŀ����ȷ��
		for(int i = 0; i< num;i++){
				String[] array = cre.proArrary( range, hasmd, hasfs,hasgd,synum); //����һ�������+���ֵ�����
		        BinaryTree tree = new BinaryTree(array); //��������Ϊ������������һ�ö������ķ���
		        rightAns = tree.CalAndVal(grade); //������ȷ������õ����Ǽٷ���
		        rightAns = fractin.falseToTrue(rightAns); //������ļٷ�������Ϊ������
		        //���ɵ���Ŀ�ַ�����������ڼ���������Ϊ�ڼ�����ʱ�������ṹ������Ϊ ���� ���� ����Ϊ0 ���仯��
		        problem = tree.toString(); 
		        proBean[i] = new ProAns(); //������ÿ��Ԫ�ض�����Ҫnew��һ�����������׳���ָ���쳣
		        proBean[i].setId(i+1);
		        proBean[i].setProblem(problem);
		        proBean[i].setRightAns(rightAns);
			}
		return proBean;
	}
}
