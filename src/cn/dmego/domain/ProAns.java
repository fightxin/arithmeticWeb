package cn.dmego.domain;
/*****************************************************
 * ������װ���ɵ���Ŀ����������Ĵ𰸣��û������
 * �𰸣��Լ���ź��û���������� javaBean
 * @author dmego
 ******************************************************/
public class ProAns {
	private int id ; //��Ŀ��
	private String problem ; //��Ŀ���������ʽ
	private String rightAns ; //������������ȷ��
	private String yourAns ;  //�û�����Ĵ�
	private int checks;  //��¼�û������Ƿ������ȷ
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
			temp = "�� ����ȷ��";
		 }else if(checks == -1){
			 temp = "�� �𰸴���";
		 }
		 return "��"+id+"�⣺"+problem+" = "+"; ��ȷ�𰸣�"+rightAns+", ��Ĵ𰸣�"+yourAns +temp;
	 }
	
}
