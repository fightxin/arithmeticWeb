package cn.dmego.produce;
import cn.dmego.domain.Transmit;
/************************
 * 真分数及其操作类
 * @author dmego
 * 
 ***********************/
public class ProperFra {
	Transmit tran1 = new Transmit();
	Transmit tran2 = new Transmit();
	
	
	 // 求两个数之间的最大公约数  
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
		
		//生成一个整数
		public String createZS(int range) {
			int min =(int)(Math.random()* range);
		     return min + "";
		}
		
		//生成真分数
		public String createFS( int range) {		
		     while(true){
		    	 int max =(int)(Math.random()* range);
			     int min =(int)(Math.random()* range);
			     if(max==0 || min==0 || max == min) { //如果有一个为0,或者生成的两个数相等， continue;
			    	 continue;
			     } else {
				     if(max <= min ) //先保证max的值大于min的值
					     {
					         int temp=min;
					         min=max;
					         max=temp;
					     }
				     //求最大公约数
				     int gcd = getGCD(max, min);
				     max = max / gcd;
				     min = min / gcd;
					     return(min+"/"+max);
				     }
			     }
		}
		
		//拆分真分数和整数
		public void excreteZF(String data, Transmit tran) {
			if( data.matches("[0-9]+") ) { //若该字符串是整数
				tran.setNumerator(Integer.parseInt(data));
				tran.setDenominator(1);
			}else {
				int index = data.indexOf("/");
				tran.setNumerator(Integer.parseInt( data.substring(0, index) ) );
				tran.setDenominator(Integer.parseInt(data.substring(index+1)));
			}
			
		}
		
		//分数化简处理
		public String simplify (int midMax, int midMin) {
			int gcd = getGCD(midMax, midMin);//求最大公约数
			midMax = midMax / gcd;
			midMin = midMin / gcd;
			if(midMax == midMin) {
				return 1 + ""; //分子等于分母 返回 1
			}
			if(midMax == 1) {
				return midMin+""; //分母等于 1 返回整数分子
			}
			if(midMin == 0 ) {
				return 0+"";  //分子为 0 返回 0
			}
			return(midMin+"/"+midMax);
		}
		
		//将假分数化简成真分数
		public String falseToTrue(String result){
				Transmit tran = new Transmit();
			 	excreteZF(result, tran);
		        int midMax = tran.getDenominator();
		        int midMin  = tran.getNumerator();
			if(midMax < midMin && midMax != 1) { //分子大于分母，为假分数，化简为带分数
					int ys = (midMin % midMax);
					int flag = (midMin-ys) / midMax;
					result = flag+"'" +ys+"/"+midMax;	
				}
				return result;
		}
		
		//求两个真分数相加
		public String opGrsAdd(String data1,String data2) {
			
			excreteZF(data1, tran1);
			excreteZF(data2, tran2);
			int midMin = tran1.getNumerator() * tran2.getDenominator() + tran1.getDenominator() * tran2.getNumerator();
			int midMax = tran1.getDenominator() *  tran2.getDenominator();
			return simplify(midMax, midMin);
		}        
		
		 //求两个真分数相乘
		public String opGrsMult(String data1,String data2) {
			excreteZF(data1, tran1);
			excreteZF(data2, tran2);
			int midMin = tran1.getNumerator() * tran2.getNumerator();
			int midMax = tran1.getDenominator()* tran2.getDenominator();
			return simplify(midMax, midMin);
		}
		
		 //求两个真分数相减
		public String opGrsSubt(String data1,String data2) {
				excreteZF(data1, tran1);
				excreteZF(data2, tran2);
				int midMin = tran1.getNumerator() * tran2.getDenominator() - tran1.getDenominator() * tran2.getNumerator();
				int midMax = tran1.getDenominator() *  tran2.getDenominator();
				return simplify(midMax, midMin);
			}
			
		 //求两个真分数相除
		public String opGrsDivi(String data1,String data2) { //tran1被除数，tran2除数
				Transmit tran1 = new Transmit();
				Transmit tran2 = new Transmit();	
				excreteZF(data1, tran1);
				excreteZF(data2, tran2);
				int midMin = tran1.getNumerator() * tran2.getDenominator();
				int midMax = tran1.getDenominator()* tran2.getNumerator();
				return simplify(midMax, midMin);
			}
		
		//求两个整数相除，有余数
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
