package cn.dmego.domain;
/**
 * 错题Bean
 * @author dmego
 *
 */
public class WrongPro {
	private String problem ; //题目的算术表达式
	private String rightAns ; //程序计算出的正确答案
	private String yourAns ;  //用户输入的答案
	private int checks;  //记录用户该题是否答题正确
	private int times; //记录该题错误次数
	public WrongPro(){}
	public WrongPro(String problem,String rightAns,String yourAns,int checks,int times){
		this.problem = problem;
		this.rightAns = rightAns;
		this.yourAns = yourAns;
		this.checks= checks;
		this.times = times;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getRightAns() {
		return rightAns;
	}
	public void setRightAns(String rightAns) {
		this.rightAns = rightAns;
	}
	public String getYourAns() {
		return yourAns;
	}
	public void setYourAns(String yourAns) {
		this.yourAns = yourAns;
	}
	public int getChecks() {
		return checks;
	}
	public void setChecks(int checks) {
		this.checks = checks;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public String toString(){
		return problem+" = "+"，该题做错了"+times+"次！";
	}
	
}
