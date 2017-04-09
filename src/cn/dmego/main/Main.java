package cn.dmego.main;
/**
 * 主程序
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
	static int Num = 10; //题目数量
	static int Range = 10; //数值范围
	static int Numsy = 2;
	static String function = "3";  //选择菜单功能项
	static String hasMD = "",hasFS ="",hasGD="";  //标记是否有乘除，是否有真分数
	static String answer = ""; //用户输入的答案
	static String result = ""; //程序计算出来的正确答案
	static String problem =""; //生成的随机表达式
	static String[][] BigArray;
	static int[] Long;
	static Scanner intPut = new Scanner(System.in);
	static Scanner strPut = new Scanner(System.in);
	static MysqlProAnsDao mpd = new MysqlProAnsDao();

	//主菜单
	public static void mainMenu() {
		System.out.println("================================");
		System.out.println("-------------------小学四则运算程序-------------------");
		System.out.println("=== ============================");
		System.out.println("*********************请选择功能项**********************");
		System.out.println("~~~~1~~开始在线答题~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~2~~ 从文件导入题与答案并检查答案正确性~~");
		System.out.println("~~~~3~~ 查看上一次在线答题情况~~~~~~~~~~");
		System.out.println("================================");
		System.out.print("请输入功能项的编号：");
		function = strPut.next();
	}
	//一级子菜单
	public static void menu() {
		if(function.equals("1")) {
			System.out.println("********************请设置出题参数*********************");
			System.out.print("~~~是否有乘除参与运算（Y/N 或者 y/n）：");
			hasMD = strPut.next();
			System.out.print("~~~是否有真分数参与运算（Y/N 或者 y/n）：");
			hasFS = strPut.next();
			System.out.print("~~~运算符个数是否固定（Y/N 或者 y/n）：");
			hasGD = strPut.next();
			System.out.print("~~~请输入运算符个数：");
			Numsy = intPut.nextInt();
			System.out.print("~~~请输入出题数值范围：");
			Range = intPut.nextInt();
			System.out.print("~~~请输入出题数量：");
			Num  = intPut.nextInt();

			System.out.println("================================");
			System.out.println("***********************开始答题！***********************");
			
		}else if( function.equals("2")) {
			System.out.println("******************请设置题目与答案路径****************");
			System.out.print("~~~请输入题目路径名：");
			Range = intPut.nextInt();
			System.out.print("~~~请输入答案路径名：");
			Num  = intPut.nextInt();
			System.out.println("================================");
			System.out.println("***********************开始答题！***********************");
			
			
		}else if(function.equals("3")) {
			ArrayList<ProAns> pas = new ArrayList<ProAns>();
			  mpd.readAll(pas);
			  System.out.println("================================");
			  System.out.println("**************上一次在线答题情况**********************");
			  System.out.println();
			  if(pas.isEmpty()){
				  System.out.println("没有上一次在线答题记录！");
			  }else {
				  for(ProAns tmp:pas){
			            System.out.println(tmp.toString());
				  }
			  }
			  System.out.println();
			  System.out.println("================================");
		}
	}
	
//	//封装javaBean的方法, 然后调用 dao 层的方法将数据写入到数据库中 
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
		ArrayList<Integer> falseNum = new ArrayList<Integer>(); //记录用户错题
		ArrayList<Integer> trueNum = new ArrayList<Integer>(); //记录用户正确题
		
		CreatePro cre = new CreatePro();
		ProperFra fractin = new ProperFra();

		int check[] = new int[Num];  //记录用户每一题的正确性
		ArrayList<ProAns> pas = new ArrayList<ProAns>();
		//-----------------------------选择开始在线答题
		if(function.equals("1")) {
			mpd.resert(); //重置数据表
			for(int i = 0; i< Num;i++){
					int grade = 0;
					String[] array = cre.proArrary( Range, hasMD, hasFS,hasGD,Numsy); //生成一个运算符+数字的数组
			        BinaryTree tree = new BinaryTree(array); //把数组作为参数传入生成一棵二叉树的方法
			        result = tree.CalAndVal(grade); //计算正确结果，得到的是假分数
			        result = fractin.falseToTrue(result); //将结果的假分数化简为带分数
			        //生成的题目字符串（必须放在计算结果后，因为在计算结果时，该树结构还会因为 负数 或者 除数为0 而变化）
			        problem = tree.toString(); 
			        System.out.print("第"+(i+1) +"题：");
			        System.out.print(problem +" = ");
			        Date date1 = new Date(); //开始答题时间
			        answer = strPut.next();
			        if(answer.equals(result)) {
			        		trueNum.add(i);
			        		check[i] = 1;
				        	System.out.print("恭喜你，答对了！");
				        }else {
				        	falseNum.add(i);
				        	check[i] = -1;
				        	System.out.print("真遗憾，答错了，正确答案是 "+ result +"！");
				   }
			        Date date2 = new Date(); //结束答题时间
			        System.out.println("，本题用时"+( date2.getTime() - date1.getTime() )/1000.0 +"秒");
			        pas.add( new ProAns(i+1, problem, result, answer, check[i]));//将本道题的数据用Bean封装
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
			System.out.println("***********************答题结束！***********************");
			System.out.println("*******************写入数据库结束！********************");
			System.out.println("写入数据库耗时："+time+"毫秒！");
			System.out.println("本次共出题"+Num+"道！");
			System.out.println("答对了"+trueNum.size()+"道题"+",	题号为："+ strT);
			System.out.println("答错了"+falseNum.size()+"道题"+",	题号为："+ strF);
			System.out.println("================================");
			System.gc() ;
		}
	}
}
