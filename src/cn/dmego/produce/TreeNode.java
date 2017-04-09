package cn.dmego.produce;
/*****************************
 * �������Ľ���࣬��Ҫ�����У�
 * 	���ý��ת��Ϊ�������ʽ���������Ч����
 * Transmit.java
 *
 */

public class TreeNode {
		 private  TreeNode lchild;
		 private TreeNode rchild;
		 private String data;
		 public TreeNode() {};
		public TreeNode(String data){
			lchild = null;
			rchild = null;
			this.data = data;
		}
	
	//���øý������Һ���
		public void setChild(TreeNode lchild, TreeNode rchild) { 
			this.lchild = lchild;
			this.rchild = rchild;
		}
		
		public TreeNode getLchild() {
			return lchild;
		}
	
		public void setLchild(TreeNode lchild) {
			this.lchild = lchild;
		}
	
		public TreeNode getRchild() {
			return rchild;
		}
	
		public void setRchild(TreeNode rchild) {
			this.rchild = rchild;
		}
	
		public String getData() {
			return data;
		}
	
		public void setData(String data) {
			this.data = data;
		}
	
	//�жϸý���Ƿ��к���
		public boolean hasChild() {
			if(lchild == null && rchild == null) 
				return false;
			else
				return true;
		}
		
		//�жϱ��ʽ���Ƿ��и���
		public boolean hasSubt( String result) {
			if(result.indexOf("-") == -1) { //�������ڸ��ţ�����false
				return false;
			}else //���򷵻�true
				return true;
		}
	
		/**
		 * �����Ըý��Ϊ���ı��ʽ�������������ַ�����ʽ���ؼ�����
		 * @return
		 */
		public String getResult(int g){
			ProperFra fractin = new ProperFra();
	        if(hasChild()){  
	            switch(data){  
		                case "+": 		                		
		                		return fractin.opGrsAdd(getLchild().getResult(g), getRchild().getResult(g));		                		
		                case "-":  		                	
			                	if( hasSubt( fractin.opGrsSubt(getLchild().getResult(g), getRchild().getResult(g)) ) ) {
			                			setChild(getRchild(), getLchild()); //�������������Ϊ��������ֻ��Ҫ�����Һ��ӽ���һ�¾�����
			                	}
			                	return fractin.opGrsSubt(getLchild().getResult(g), getRchild().getResult(g));		                    
		                case "��": 
		                		return fractin.opGrsMult(getLchild().getResult(g), getRchild().getResult(g));  		
		                case "��":  
			                    if(getRchild().getResult(g).equals("0")){  //������0�����
				                        if(data.equals("��")){ 
				                        	if(!getLchild().getResult(g).equals("0")){ //������Ϊ 0 ʱ,�ұ�������Ϊ0ʱ
				                        		setChild(getRchild(), getLchild()); //������Ϊ 0 ʱ���������Һ��ӣ�������Ϊ 0 �����Ϊ 0  			            
				                        	}else if(getLchild().getResult(g).equals("0")){//��������뱻������Ϊ0�����������һ������
				                        		String symbol[] = {"+","-","��","��"};
				                        		int symNum = (int) (Math.random()* 4 );
				                        		data = symbol[symNum];
				                        	}
				                        	return this.getResult(g);  
				                        }  
				                       
			                    } else 
			                    	if(g == 3 || g ==4){
			                    		return fractin.opIntDivInt(getLchild().getResult(g), getRchild().getResult(g));
			                    	}else{
			                    		return fractin.opGrsDivi(getLchild().getResult(g), getRchild().getResult(g));
			                    	}
		            }  
	        }   
	        return data;  //����ý��û�к��ӣ�˵���ý����Ҷ�ӣ�������ظ�Ҷ�ӽ���ֵ
	    }   
		
		/**
		 * Ϊ�Ըý��Ϊ���ı��ʽ�����Ч���ţ������ַ�����ʽ����
		 */
		public String toString()
		    {  
		        String Lstr = "", Rstr = "", Str = "";  
		        if(hasChild())
		        {  
		        		//-------------------������ȥ���Ų���---------------------------------------------------------
		        		//����������к��ӣ�˵����������һ�����ʽ�����������ֽڵ㡣  
			            if(getRchild().hasChild())
			            {                           
				                //�ж��������ŵ��������op���Ƿ�Ϊ'/'  
				                if(data.equals("��"))
				                {  
				                    //��ȡ�������ı��ʽ����������  
				                    Rstr = getRchild().toString();                
				                }  
				                //�ж��������ŵ��������op���Ƿ�Ϊ'*'��'-'  
				                else if(data.equals("��") || data.equals("-"))
				                	{  
					                    //�жϣ�op2���Ƿ�Ϊ'+'��'-'  
					                    if(getRchild().data.equals("+") || getRchild().data.equals("-"))
						                    {  
						                    	//��ȡ�������ı��ʽ����������  
						                        Rstr = getRchild().toString();            
						                    }
					                    else {  
							                     //��ȡ�������ı��ʽ������ȥ����
						                    	//����ʼȡ�Ӵ���ȡ�������� 2 ���ַ�����һ���������ţ�������һ���������ţ���   
							                    Rstr = getRchild().toString().substring(1, getRchild().toString().length()-1);    
						                    }  
				                	}
				                else{  
				                    //����������֮�ⶼ�ǿ���ȥ���ŵġ�  
				                    Rstr = getRchild().toString().substring(1, getRchild().toString().length()-1);        
				                }   
		            } //--getRchild().hasChild()
		            else {  
		                Rstr = getRchild().data;  //��������������ֽڵ㡣�򷵻ظý���ֵ 
		            }
			              
			        //-------------------������ȥ���Ų���---------------------------------------------------------
		            //�����������ͬ����������---
			        //�����ж������Ƿ��к���
		            if(getLchild().hasChild()){
		            	//�ж����ڽ���������Ƿ�Ϊ ��*�� ���� ��/��
		                if(data.equals("��") || data.equals("��")){  
		                	//�����op1���Ƿ�Ϊ ��+�� ���� ��-��
		                    if(getLchild().data.equals("+") || getLchild().data.equals("-")){
		                    	//��ȡ�������ı��ʽ����������  
		                        Lstr = getLchild().toString();  
		                    }  else{ //��ȡ�������ı��ʽ������ȥ����
		                        Lstr = getLchild().toString().substring(1, getLchild().toString().length()-1);  
		                    }  
		                }  
		                else{  //����������֮�ⶼ�ǿ���ȥ���ŵġ� 
		                    Lstr = getLchild().toString().substring(1, getLchild().toString().length()-1);  
		                }  
		            }  
		            else{  
		                Lstr = getLchild().data;  //��������������ֽڵ㡣�򷵻ظý���ֵ 
		            }  
		            
		            //��ȡ��ǰ������ʽ������������  
		            Str = "(" + Lstr +" " +data+" " + Rstr + ")";                                      
		        }  
		        else{  
		            //��û�к��ӣ�˵�������ֽڵ㣬ֱ�ӷ�������  
		            Str = data;  
		        }  
		        return Str;  
		    }	
	}	

