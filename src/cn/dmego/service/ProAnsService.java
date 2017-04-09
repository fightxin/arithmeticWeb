package cn.dmego.service;



import java.util.ArrayList;

import cn.dmego.dao.MysqlProAnsDao;
import cn.dmego.domain.ProAns;
import cn.dmego.domain.WrongPro;
import cn.dmego.produce.BinaryTree;
import cn.dmego.produce.CreatePro;
import cn.dmego.produce.ProperFra;

/************************
 * 业务逻辑处理
 * @author dmego
 *
 */
public class ProAnsService {
	CreatePro cre = new CreatePro();
	ProperFra fractin = new ProperFra();
	MysqlProAnsDao mpd = new MysqlProAnsDao();
	WrongProService wroService = new WrongProService();
	/**
	 * 将本次答题情况存入数据库中 
	 * @param proBean
	 */
	public void saveToDB(ProAns[] proBean){
		mpd.resert();
		mpd.addAll(proBean);
	}
	/**
	 * 检查用户输入的答案是否正确，然后为Bean中的check变量赋值
	 * （-1：答错了；1：答对了）
	 * 如果答错了，将该题存入错题表中
	 * @param proBean 题目对象数组（增加了用户输入的答案）
	 * @return 校验完成的题目对象数组
	 */
	public ProAns[] checkAnswer(ProAns[] proBean){
		ArrayList<WrongPro> wrongBean = new ArrayList<WrongPro>();
		//wrongBean = wroService.showWrong();
		for(int i = 0 ; i < proBean.length; i++){
			if(proBean[i].getYourAns().equals(proBean[i].getRightAns()))
				proBean[i].setChecks(1);
			else{
				proBean[i].setChecks(-1);
				//----将错题存入错题表中----
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
	 * 根据用户输入的年级生成题目（按照年级答题）
	 * @param num 默认生成10道题
	 * @param grade 年级
	 * @return 生成好的题目对象数组（包括题目表达式和正确答案）
	 */
	public ProAns[] produce(int grade){
		mpd.resert(); //重置数据表
		String rightAns = ""; //程序计算出来的正确答案
		String problem = ""; //生成的随机表达式
		int num = 10;
		ProAns[] proBean = new ProAns[num]; //javaBean数组，用来封装生成的题目和正确答案
		for(int i = 0; i< num;i++){
			String[] array = cre.proArraryG(grade);//生成一个运算符+数字的数组
	        BinaryTree tree = new BinaryTree(array); //把数组作为参数传入生成一棵二叉树的方法
	        rightAns = tree.CalAndVal(grade); //计算正确结果，得到的是假分数
	        if(grade != 3 && grade != 4){
	        	rightAns = fractin.falseToTrue(rightAns); //将结果的假分数化简为带分数	
	        }
	        //生成的题目字符串（必须放在计算结果后，因为在计算结果时，该树结构还会因为 负数 或者 除数为0 而变化）
	        problem = tree.toString(); 
	        proBean[i] = new ProAns(); //数组中每个元素都必须要new成一个对象否则会抛出空指针异常
	        proBean[i].setId(i+1);
	        proBean[i].setProblem(problem);
	        proBean[i].setRightAns(rightAns);
		}
		return proBean;
	}
	

	/**
	 * 根据用户输入的参数生成题目（按参数答题）
	 * @param hasmd 指定有无乘除法（Y/N）
	 * @param hasfs	指定有无真分数（Y/N）
	 * @param hasgd 指定运算符个数是否固定（Y/N）
	 * @param range 指定运算式取值范围
	 * @param num 指定出题个数
	 * @param synum 指定固定的运算符个数或者最大运算符个数
	 * @return 生成好的题目对象数组（包括题目表达式和正确答案）
	 */
	public ProAns[] produce(String hasmd,String hasfs,String hasgd,int range,int num,int synum){
		mpd.resert(); //重置数据表
		String rightAns = ""; //程序计算出来的正确答案
		String problem = ""; //生成的随机表达式
		int grade = 0;
		ProAns[] proBean = new ProAns[num]; //javaBean数组，用来封装生成的题目和正确答案
		for(int i = 0; i< num;i++){
				String[] array = cre.proArrary( range, hasmd, hasfs,hasgd,synum); //生成一个运算符+数字的数组
		        BinaryTree tree = new BinaryTree(array); //把数组作为参数传入生成一棵二叉树的方法
		        rightAns = tree.CalAndVal(grade); //计算正确结果，得到的是假分数
		        rightAns = fractin.falseToTrue(rightAns); //将结果的假分数化简为带分数
		        //生成的题目字符串（必须放在计算结果后，因为在计算结果时，该树结构还会因为 负数 或者 除数为0 而变化）
		        problem = tree.toString(); 
		        proBean[i] = new ProAns(); //数组中每个元素都必须要new成一个对象否则会抛出空指针异常
		        proBean[i].setId(i+1);
		        proBean[i].setProblem(problem);
		        proBean[i].setRightAns(rightAns);
			}
		return proBean;
	}
}
