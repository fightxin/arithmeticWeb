package cn.dmego.produce;
import cn.dmego.domain.Transmit;
/************************
 * ��������������
 * @author dmego
 * 
 ***********************/
public class ProperFra {
	Transmit tran1 = new Transmit();
	Transmit tran2 = new Transmit();
	
	
	 // ��������֮������Լ��  
		public static int getGCD(int max, int min) {
			int gcd = 1;
			if(min >= max) {
				int temp = max;
				max = min;
				min = temp;
			}
			for(int i = min;i>=1;i--) {
				if(max % i == 0 && min % i == 0) {
					gcd = i;
					break;
				}
			}
			return gcd;
		}
		
		//����һ������
		public String createZS(int range) {
			int min =(int)(Math.random()* range);
		     return min + "";
		}
		
		//���������
		public String createFS( int range) {		
		     while(true){
		    	 int max =(int)(Math.random()* range);
			     int min =(int)(Math.random()* range);
			     if(max==0 || min==0 || max == min) { //�����һ��Ϊ0,�������ɵ���������ȣ� continue;
			    	 continue;
			     } else {
				     if(max <= min ) //�ȱ�֤max��ֵ����min��ֵ
					     {
					         int temp=min;
					         min=max;
					         max=temp;
					     }
				     //�����Լ��
				     int gcd = getGCD(max, min);
				     max = max / gcd;
				     min = min / gcd;
					     return(min+"/"+max);
				     }
			     }
		}
		
		//��������������
		public void excreteZF(String data, Transmit tran) {
			if( data.matches("[0-9]+") ) { //�����ַ���������
				tran.setNumerator(Integer.parseInt(data));
				tran.setDenominator(1);
			}else {
				int index = data.indexOf("/");
				tran.setNumerator(Integer.parseInt( data.substring(0, index) ) );
				tran.setDenominator(Integer.parseInt(data.substring(index+1)));
			}
			
		}
		
		//����������
		public String simplify (int midMax, int midMin) {
			int gcd = getGCD(midMax, midMin);//�����Լ��
			midMax = midMax / gcd;
			midMin = midMin / gcd;
			if(midMax == midMin) {
				return 1 + ""; //���ӵ��ڷ�ĸ ���� 1
			}
			if(midMax == 1) {
				return midMin+""; //��ĸ���� 1 ������������
			}
			if(midMin == 0 ) {
				return 0+"";  //����Ϊ 0 ���� 0
			}
			return(midMin+"/"+midMax);
		}
		
		//���ٷ�������������
		public String falseToTrue(String result){
				Transmit tran = new Transmit();
			 	excreteZF(result, tran);
		        int midMax = tran.getDenominator();
		        int midMin  = tran.getNumerator();
			if(midMax < midMin && midMax != 1) { //���Ӵ��ڷ�ĸ��Ϊ�ٷ���������Ϊ������
					int ys = (midMin % midMax);
					int flag = (midMin-ys) / midMax;
					result = flag+"'" +ys+"/"+midMax;	
				}
				return result;
		}
		
		//��������������
		public String opGrsAdd(String data1,String data2) {
			
			excreteZF(data1, tran1);
			excreteZF(data2, tran2);
			int midMin = tran1.getNumerator() * tran2.getDenominator() + tran1.getDenominator() * tran2.getNumerator();
			int midMax = tran1.getDenominator() *  tran2.getDenominator();
			return simplify(midMax, midMin);
		}        
		
		 //��������������
		public String opGrsMult(String data1,String data2) {
			excreteZF(data1, tran1);
			excreteZF(data2, tran2);
			int midMin = tran1.getNumerator() * tran2.getNumerator();
			int midMax = tran1.getDenominator()* tran2.getDenominator();
			return simplify(midMax, midMin);
		}
		
		 //��������������
		public String opGrsSubt(String data1,String data2) {
				excreteZF(data1, tran1);
				excreteZF(data2, tran2);
				int midMin = tran1.getNumerator() * tran2.getDenominator() - tran1.getDenominator() * tran2.getNumerator();
				int midMax = tran1.getDenominator() *  tran2.getDenominator();
				return simplify(midMax, midMin);
			}
			
		 //��������������
		public String opGrsDivi(String data1,String data2) { //tran1��������tran2����
				Transmit tran1 = new Transmit();
				Transmit tran2 = new Transmit();	
				excreteZF(data1, tran1);
				excreteZF(data2, tran2);
				int midMin = tran1.getNumerator() * tran2.getDenominator();
				int midMax = tran1.getDenominator()* tran2.getNumerator();
				return simplify(midMax, midMin);
			}
		
		//���������������������
		public String opIntDivInt(String data1,String data2) {
			int data11 = Integer.parseInt(data1);
			int data22 = Integer.parseInt(data2);
			int remainder = data11 % data22;
			int quotient = (data11-remainder) / data22;
			if(remainder == 0) {
				return quotient +"";
			}else {
				return quotient + "......" + remainder;
			}
		}
}
