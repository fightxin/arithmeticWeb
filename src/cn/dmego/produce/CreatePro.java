package cn.dmego.produce;
/**
 * 随机生成一个符号+数字的数组
 * @author dmego
 *
 */
public class CreatePro {
	
	/**
	 * 根据年级随机生成一个数组
	 * @param grade 年级
	 * @return  一个随机生成的数组
	 */
	public String[] proArraryG(int grade){
		int Num =  1; //运算符个数固定为1位
		String symbol[] = {"+","-","×","÷"};
		int symNum = (int) (Math.random()* 4 );
		
		String[] arrary = new String[3];
		ProperFra fractin = new ProperFra();
		if(grade == 1){ //---一年级---（要求：20以内的 +，-）
			
			String symbol_2[] = {"+","-"};
			int symNum_2 = (int) (Math.random()* 2 );
			String ZS_1 = fractin.createZS(20); //生成两个个 20以内的整数
			String ZS_2 = fractin.createZS(20);
			
			arrary[0] = symbol_2[symNum_2];
			arrary[1] =ZS_1; 
			arrary[2] = ZS_2;

		}else if(grade == 2){//---二年级---（要求：100以内 +，-；乘法表的乘除法）
			arrary[0] = symbol[symNum];
			if(symNum == 0 || symNum == 1){ //运算符是 +，-
				String ZS_1 = fractin.createZS(100); //生成两个 100以内的整数
				String ZS_2 = fractin.createZS(100); 
				arrary[1] = ZS_1;
				arrary[2] = ZS_2;
					
			}else if(symNum == 2 ){//运算符是 × 
				String ZS_1 = fractin.createZS(10); //生成两个 10以内的整数
				String ZS_2 = fractin.createZS(10);
				arrary[1] = ZS_1;
				arrary[2] = ZS_2;
				
			}else if(symNum == 3){//运算符是  ÷
				String ZS_1 = fractin.createZS(10); //生成两个 10以内的整数
				String ZS_2 = fractin.createZS(10);
				while( ZS_2.equals("0") ){
					ZS_2 = fractin.createZS(10);
				}
				arrary[1] = String.valueOf( Integer.parseInt(ZS_1) * Integer.parseInt(ZS_2) );
				arrary[2] = ZS_2;
			}
		}else if(grade == 3){//---三年级---（要求：两位数乘法，一位数除法，结果带余数）
			String symbol_2[] = {"×","÷"};
			int symNum_2 = (int) (Math.random()* 2 );
			arrary[0] = symbol_2[symNum_2];
			if(symNum_2 == 0){ //乘法
				String ZS_1 = fractin.createZS(100); //生成两个 100以内的整数
				String ZS_2 = fractin.createZS(100);
				arrary[1] = ZS_1;
				arrary[2] = ZS_2;
			}else if(symNum_2 == 1){ //除法
				String ZS_1 = fractin.createZS(100); //生成一个 100以内的整数，作为被除数
				String ZS_2 = fractin.createZS(10); //生成一个 10以内的整数，作为除数
				while( ZS_2.equals("0") ){
					ZS_2 = fractin.createZS(10);
				}
				arrary[1] = ZS_1;
				arrary[2] = ZS_2;
			}
	
		}else if(grade == 4){//---四年级---（要求：三位数乘法，两位数除法，结果带余数）
			String symbol_2[] = {"×","÷"};
			int symNum_2 = (int) (Math.random()* 2 );
			arrary[0] = symbol_2[symNum_2];
			if(symNum_2 == 0){ //乘法
				String ZS_1 = fractin.createZS(200); //生成两个 500以内的整数
				String ZS_2 = fractin.createZS(200);
				arrary[1] = ZS_1;
				arrary[2] = ZS_2;
			}else if(symNum_2 == 1){ //除法
				String ZS_1 = fractin.createZS(100); //生成一个 100以内的整数，作为被除数
				String ZS_2 = fractin.createZS(100); //生成一个 100以内的整数，作为除数
				while( ZS_2.equals("0") || Integer.parseInt(ZS_2)> Integer.parseInt(ZS_1)){
					ZS_2 = fractin.createZS(100);
				}
				arrary[1] = ZS_1;
				arrary[2] = ZS_2;
			}
			
		}else if(grade == 5){//---五年级---（要求：分数的 +，-）
			String symbol_2[] = {"+","-"};
			int symNum_2 = (int) (Math.random()* 2 );
			String FS_1 = fractin.createFS(20); //生成两个 20以内的分数
			String FS_2 = fractin.createFS(20);
			String ZS = fractin.createZS(10);
			arrary[0] = symbol_2[symNum_2];
			for(int i = 1; i < 3; i++ ){
				int rand = (int) (Math.random() * 2);
				if(rand == 0){
					arrary[1] = FS_1; 
					arrary[2] = FS_2;
				}else if(rand == 1){
					for(int j = 1; j < 3; j++ ){
						int ranb = (int) (Math.random() * 2);
						if(ranb == 0){
							arrary[1] = ZS; 
							arrary[2] = FS_2;
						}else if(ranb == 1){
							arrary[1] = FS_1; 
							arrary[2] = ZS;
						}
					}
				}
			}	
		}else if(grade == 6){//---六年级---（要求：整数分数的 +，-，乘除法）
			arrary[0] = symbol[symNum];
			String FS_1 = fractin.createFS(20); //生成两个 20以内的分数
			String FS_2 = fractin.createFS(20);
			String ZS = fractin.createZS(10);
			String ZS_1 = fractin.createZS(100); //生成两个100内的整数用于整数加减乘除
			String ZS_2 = fractin.createZS(100);

			for(int i = 1; i < 3; i++ ){
				int rand = (int) (Math.random() * 3);
				if(rand == 2){
					arrary[1] = ZS_1; 
					arrary[2] = ZS_2;
				}else if(rand == 0){
					arrary[1] = FS_1; 
					arrary[2] = FS_2;
				}else if(rand == 1){
					for(int j = 1; j < 3; j++ ){
						int ranb = (int) (Math.random() * 2);
						if(ranb == 0){
							arrary[1] = ZS; 
							arrary[2] = FS_2;
						}else if(ranb == 1){
							arrary[1] = FS_1; 
							arrary[2] = ZS;
						}
					}
				}
			}	
		}
		return arrary;
	}
	
	/**
	 * 根据传入的参数随机生成一个数组 
	 * @param Num 运算符的个数
	 * @param range 数值范围
	 * @param hasMD 是否有乘除
	 * @param hasFS 是否有真分数参与
	 * @param hasGD 运算符是否固定
	 * @param Numsy 固定的运算符个数或者最大运算符数
	 * @return 一个随机生成的数组
	 */
	public  String[] proArrary( int range, String hasMD, String hasFS,String hasGD,int Numsy){
		int Num = Numsy;
		if(hasGD.equals("N") || hasGD.equals("n")){ //不固定则随机生成运算符个数
			 Num =  (int) (1 + Math.random()* Numsy); //随机产生运算符个数，最少1个, 最多Num个;
		}else if(hasGD.equals("Y") || hasGD.equals("y")){
			Num = Numsy;
		}
		int Size = Num * 2 +1; // 在树中表示总结点个数，也是结点集的长度
		
		String symbol[] = {"+","-","×","÷"};
		String[] arrary = new String[Size];
		ProperFra fractin = new ProperFra();
		// 首先随机产生设置好的运算符，传入到数组中
		for(int i =0 ; i< Num ; i++){
			int symNum = 0;
			if(hasMD.equals("Y") || hasMD.equals("y")) {
				 symNum = (int) (Math.random()* 4 );
			}else if(hasMD.equals("N") || hasMD.equals("n")) {
				 symNum = (int) (Math.random()* 2 );
			}
			//int symNum=3;
			arrary[i] = symbol[symNum];	
			
		}
		//在将生成的整数或者分数传入到数组中
		for(int i = Num; i< Size;i++  ){
			int rand = 0;
			if(hasFS.equals("Y") || hasFS.equals("y")) {
				 rand = (int) (Math.random() * 2);
			}else if(hasFS.equals("N") || hasFS.equals("n")) {
				rand = 0;
			}		
			//int rand = 0;
			String FS = fractin.createFS(range);
			String ZS = fractin.createZS(range);
			if(rand == 0) { //传入整数到数组
				arrary[i] =ZS;
			}else if(rand == 1) { //传入分数到数组
				arrary[i] = FS;
			}
		}
		return arrary;
	}
	
	
	
	
	
	
}
