package cn.dmego.domain;
/**
 * ����Bean
 * @author dmego
 *
 */
public class WrongPro {
	private String problem ; //��Ŀ���������ʽ
	private String rightAns ; //������������ȷ��
	private String yourAns ;  //�û�����Ĵ�
	private int checks;  //��¼�û������Ƿ������ȷ
	private int times; //��¼����������
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
		return problem+" = "+"������������"+times+"�Σ�";
	}
	
}
