package cn.dmego.main;
/**
 * ������
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import cn.dmego.dao.MysqlProAnsDao;
import cn.dmego.domain.ProAns;
import cn.dmego.produce.BinaryTree;
import cn.dmego.produce.CreatePro;
import cn.dmego.produce.ProperFra;


public class Main {
	static int Num = 10; //��Ŀ����
	static int Range = 10; //��ֵ��Χ
	static int Numsy = 2;
	static String function = "3";  //ѡ��˵�������
	static String hasMD = "",hasFS ="",hasGD="";  //����Ƿ��г˳����Ƿ��������
	static String answer = ""; //�û�����Ĵ�
	static String result = ""; //��������������ȷ��
	static String problem =""; //���ɵ�������ʽ
	static String[][] BigArray;
	static int[] Long;
	static Scanner intPut = new Scanner(System.in);
	static Scanner strPut = new Scanner(System.in);
	static MysqlProAnsDao mpd = new MysqlProAnsDao();

	//���˵�
	public static void mainMenu() {
		System.out.println("================================");
		System.out.println("-------------------Сѧ�����������-------------------");
		System.out.println("=== ============================");
		System.out.println("*********************��ѡ������**********************");
		System.out.println("~~~~1~~��ʼ���ߴ���~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~2~~ ���ļ���������𰸲�������ȷ��~~");
		System.out.println("~~~~3~~ �鿴��һ�����ߴ������~~~~~~~~~~");
		System.out.println("================================");
		System.out.print("�����빦����ı�ţ�");
		function = strPut.next();
	}
	//һ���Ӳ˵�
	public static void menu() {
		if(function.equals("1")) {
			System.out.println("********************�����ó������*********************");
			System.out.print("~~~�Ƿ��г˳��������㣨Y/N ���� y/n����");
			hasMD = strPut.next();
			System.out.print("~~~�Ƿ���������������㣨Y/N ���� y/n����");
			hasFS = strPut.next();
			System.out.print("~~~����������Ƿ�̶���Y/N ���� y/n����");
			hasGD = strPut.next();
			System.out.print("~~~�����������������");
			Numsy = intPut.nextInt();
			System.out.print("~~~�����������ֵ��Χ��");
			Range = intPut.nextInt();
			System.out.print("~~~���������������");
			Num  = intPut.nextInt();

			System.out.println("================================");
			System.out.println("***********************��ʼ���⣡***********************");
			
		}else if( function.equals("2")) {
			System.out.println("******************��������Ŀ���·��****************");
			System.out.print("~~~��������Ŀ·������");
			Range = intPut.nextInt();
			System.out.print("~~~�������·������");
			Num  = intPut.nextInt();
			System.out.println("================================");
			System.out.println("***********************��ʼ���⣡***********************");
			
			
		}else if(function.equals("3")) {
			ArrayList<ProAns> pas = new ArrayList<ProAns>();
			  mpd.readAll(pas);
			  System.out.println("================================");
			  System.out.println("**************��һ�����ߴ������**********************");
			  System.out.println();
			  if(pas.isEmpty()){
				  System.out.println("û����һ�����ߴ����¼��");
			  }else {
				  for(ProAns tmp:pas){
			            System.out.println(tmp.toString());
				  }
			  }
			  System.out.println();
			  System.out.println("================================");
		}
	}
	
//	//��װjavaBean�ķ���, Ȼ����� dao ��ķ���������д�뵽���ݿ��� 
//	public static ProAns[] dataPackage(int check[]) {
//		ProAns[] pas = new ProAns[Num];
//		for(int i = 0;i< Num;i++) {
//			pas[i] = new ProAns(i+1, problem, result, answer, check[i]);
//		}
//		return pas;
//	}
	
	public static void main(String[] args) {
		mainMenu();
		menu();
		ArrayList<Integer> falseNum = new ArrayList<Integer>(); //��¼�û�����
		ArrayList<Integer> trueNum = new ArrayList<Integer>(); //��¼�û���ȷ��
		
		CreatePro cre = new CreatePro();
		ProperFra fractin = new ProperFra();

		int check[] = new int[Num];  //��¼�û�ÿһ�����ȷ��
		ArrayList<ProAns> pas = new ArrayList<ProAns>();
		//-----------------------------ѡ��ʼ���ߴ���
		if(function.equals("1")) {
			mpd.resert(); //�������ݱ�
			for(int i = 0; i< Num;i++){
					int grade = 0;
					String[] array = cre.proArrary( Range, hasMD, hasFS,hasGD,Numsy); //����һ�������+���ֵ�����
			        BinaryTree tree = new BinaryTree(array); //��������Ϊ������������һ�ö������ķ���
			        result = tree.CalAndVal(grade); //������ȷ������õ����Ǽٷ���
			        result = fractin.falseToTrue(result); //������ļٷ�������Ϊ������
			        //���ɵ���Ŀ�ַ�����������ڼ���������Ϊ�ڼ�����ʱ�������ṹ������Ϊ ���� ���� ����Ϊ0 ���仯��
			        problem = tree.toString(); 
			        System.out.print("��"+(i+1) +"�⣺");
			        System.out.print(problem +" = ");
			        Date date1 = new Date(); //��ʼ����ʱ��
			        answer = strPut.next();
			        if(answer.equals(result)) {
			        		trueNum.add(i);
			        		check[i] = 1;
				        	System.out.print("��ϲ�㣬����ˣ�");
				        }else {
				        	falseNum.add(i);
				        	check[i] = -1;
				        	System.out.print("���ź�������ˣ���ȷ���� "+ result +"��");
				   }
			        Date date2 = new Date(); //��������ʱ��
			        System.out.println("��������ʱ"+( date2.getTime() - date1.getTime() )/1000.0 +"��");
			        pas.add( new ProAns(i+1, problem, result, answer, check[i]));//���������������Bean��װ
			}
			Date da = new Date();
			mpd.addAll(pas);
			Date db = new Date();
			long time =db.getTime()-da.getTime();
			String strF = "", strT = "";
			for(Integer str: falseNum) {
				strF = strF + (str+1)+",	";
			}
			for(Integer str: trueNum) {
				strT = strT + (str+1)+",	";
			}
			System.out.println("***********************���������***********************");
			System.out.println("*******************д�����ݿ������********************");
			System.out.println("д�����ݿ��ʱ��"+time+"���룡");
			System.out.println("���ι�����"+Num+"����");
			System.out.println("�����"+trueNum.size()+"����"+",	���Ϊ��"+ strT);
			System.out.println("�����"+falseNum.size()+"����"+",	���Ϊ��"+ strF);
			System.out.println("================================");
			System.gc() ;
		}
	}
}
