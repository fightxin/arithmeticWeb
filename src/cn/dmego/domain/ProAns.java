package cn.dmego.domain;
/*****************************************************
 * 用来封装生成的题目，经过计算的答案，用户输入的
 * 答案，以及题号和用户答题情况的 javaBean
 * @author dmego
 ******************************************************/
public class ProAns {
	private int id ; //题目号
	private String problem ; //题目的算术表达式
	private String rightAns ; //程序计算出的正确答案
	private String yourAns ;  //用户输入的答案
	private int checks;  //记录用户该题是否答题正确
	public ProAns(){}
	public ProAns(int id, String problem,String rightAns, String yourAns, int checks) {
		this.id = id;
		this.problem = problem;
		this.rightAns = rightAns;
		this.yourAns = yourAns;
		this.checks = checks;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	 public String toString(){
		 String temp = null;
		 if(checks == 1){
			temp = "， 答案正确！";
		 }else if(checks == -1){
			 temp = "， 答案错误！";
		 }
		 return "第"+id+"题："+problem+" = "+"; 正确答案："+rightAns+", 你的答案："+yourAns +temp;
	 }
	
}
