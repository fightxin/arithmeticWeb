package cn.dmego.produce;
/**
 * �������һ������+���ֵ�����
 * @author dmego
 *
 */
public class CreatePro {
	
	/**
	 * �����꼶�������һ������
	 * @param grade �꼶
	 * @return  һ��������ɵ�����
	 */
	public String[] proArraryG(int grade){
		int Num =  1; //����������̶�Ϊ1λ
		String symbol[] = {"+","-","��","��"};
		int symNum = (int) (Math.random()* 4 );
		
		String[] arrary = new String[3];
		ProperFra fractin = new ProperFra();
		if(grade == 1){ //---һ�꼶---��Ҫ��20���ڵ� +��-��
			
			String symbol_2[] = {"+","-"};
			int symNum_2 = (int) (Math.random()* 2 );
			String ZS_1 = fractin.createZS(20); //���������� 20���ڵ�����
			String ZS_2 = fractin.createZS(20);
			
			arrary[0] = symbol_2[symNum_2];
			arrary[1] =ZS_1; 
			arrary[2] = ZS_2;

		}else if(grade == 2){//---���꼶---��Ҫ��100���� +��-���˷���ĳ˳�����
			arrary[0] = symbol[symNum];
			if(symNum == 0 || symNum == 1){ //������� +��-
				String ZS_1 = fractin.createZS(100); //�������� 100���ڵ�����
				String ZS_2 = fractin.createZS(100); 
				arrary[1] = ZS_1;
				arrary[2] = ZS_2;
					
			}else if(symNum == 2 ){//������� �� 
				String ZS_1 = fractin.createZS(10); //�������� 10���ڵ�����
				String ZS_2 = fractin.createZS(10);
				arrary[1] = ZS_1;
				arrary[2] = ZS_2;
				
			}else if(symNum == 3){//�������  ��
				String ZS_1 = fractin.createZS(10); //�������� 10���ڵ�����
				String ZS_2 = fractin.createZS(10);
				while( ZS_2.equals("0") ){
					ZS_2 = fractin.createZS(10);
				}
				arrary[1] = String.valueOf( Integer.parseInt(ZS_1) * Integer.parseInt(ZS_2) );
				arrary[2] = ZS_2;
			}
		}else if(grade == 3){//---���꼶---��Ҫ����λ���˷���һλ�������������������
			String symbol_2[] = {"��","��"};
			int symNum_2 = (int) (Math.random()* 2 );
			arrary[0] = symbol_2[symNum_2];
			if(symNum_2 == 0){ //�˷�
				String ZS_1 = fractin.createZS(100); //�������� 100���ڵ�����
				String ZS_2 = fractin.createZS(100);
				arrary[1] = ZS_1;
				arrary[2] = ZS_2;
			}else if(symNum_2 == 1){ //����
				String ZS_1 = fractin.createZS(100); //����һ�� 100���ڵ���������Ϊ������
				String ZS_2 = fractin.createZS(10); //����һ�� 10���ڵ���������Ϊ����
				while( ZS_2.equals("0") ){
					ZS_2 = fractin.createZS(10);
				}
				arrary[1] = ZS_1;
				arrary[2] = ZS_2;
			}
	
		}else if(grade == 4){//---���꼶---��Ҫ����λ���˷�����λ�������������������
			String symbol_2[] = {"��","��"};
			int symNum_2 = (int) (Math.random()* 2 );
			arrary[0] = symbol_2[symNum_2];
			if(symNum_2 == 0){ //�˷�
				String ZS_1 = fractin.createZS(200); //�������� 500���ڵ�����
				String ZS_2 = fractin.createZS(200);
				arrary[1] = ZS_1;
				arrary[2] = ZS_2;
			}else if(symNum_2 == 1){ //����
				String ZS_1 = fractin.createZS(100); //����һ�� 100���ڵ���������Ϊ������
				String ZS_2 = fractin.createZS(100); //����һ�� 100���ڵ���������Ϊ����
				while( ZS_2.equals("0") || Integer.parseInt(ZS_2)> Integer.parseInt(ZS_1)){
					ZS_2 = fractin.createZS(100);
				}
				arrary[1] = ZS_1;
				arrary[2] = ZS_2;
			}
			
		}else if(grade == 5){//---���꼶---��Ҫ�󣺷����� +��-��
			String symbol_2[] = {"+","-"};
			int symNum_2 = (int) (Math.random()* 2 );
			String FS_1 = fractin.createFS(20); //�������� 20���ڵķ���
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
		}else if(grade == 6){//---���꼶---��Ҫ������������ +��-���˳�����
			arrary[0] = symbol[symNum];
			String FS_1 = fractin.createFS(20); //�������� 20���ڵķ���
			String FS_2 = fractin.createFS(20);
			String ZS = fractin.createZS(10);
			String ZS_1 = fractin.createZS(100); //��������100�ڵ��������������Ӽ��˳�
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
	 * ���ݴ���Ĳ����������һ������ 
	 * @param Num ������ĸ���
	 * @param range ��ֵ��Χ
	 * @param hasMD �Ƿ��г˳�
	 * @param hasFS �Ƿ������������
	 * @param hasGD ������Ƿ�̶�
	 * @param Numsy �̶��������������������������
	 * @return һ��������ɵ�����
	 */
	public  String[] proArrary( int range, String hasMD, String hasFS,String hasGD,int Numsy){
		int Num = Numsy;
		if(hasGD.equals("N") || hasGD.equals("n")){ //���̶�������������������
			 Num =  (int) (1 + Math.random()* Numsy); //����������������������1��, ���Num��;
		}else if(hasGD.equals("Y") || hasGD.equals("y")){
			Num = Numsy;
		}
		int Size = Num * 2 +1; // �����б�ʾ�ܽ�������Ҳ�ǽ�㼯�ĳ���
		
		String symbol[] = {"+","-","��","��"};
		String[] arrary = new String[Size];
		ProperFra fractin = new ProperFra();
		// ��������������úõ�����������뵽������
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
		//�ڽ����ɵ��������߷������뵽������
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
			if(rand == 0) { //��������������
				arrary[i] =ZS;
			}else if(rand == 1) { //�������������
				arrary[i] = FS;
			}
		}
		return arrary;
	}
	
	
	
	
	
	
}
