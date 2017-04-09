package cn.dmego.produce;
/*****************************
 * 二叉树的结点类，主要方法有：
 * 	将该结点转化为算术表达式，并添加有效括号
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
	
	//设置该结点的左右孩子
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
	
	//判断该结点是否有孩子
		public boolean hasChild() {
			if(lchild == null && rchild == null) 
				return false;
			else
				return true;
		}
		
		//判断表达式中是否有负号
		public boolean hasSubt( String result) {
			if(result.indexOf("-") == -1) { //若不存在负号，返回false
				return false;
			}else //否则返回true
				return true;
		}
	
		/**
		 * 计算以该结点为根的表达式运算结果，并以字符串形式返回计算结果
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
			                			setChild(getRchild(), getLchild()); //如果减法运算结果为负数，则只需要将左右孩子交换一下就行了
			                	}
			                	return fractin.opGrsSubt(getLchild().getResult(g), getRchild().getResult(g));		                    
		                case "×": 
		                		return fractin.opGrsMult(getLchild().getResult(g), getRchild().getResult(g));  		
		                case "÷":  
			                    if(getRchild().getResult(g).equals("0")){  //除数是0的情况
				                        if(data.equals("÷")){ 
				                        	if(!getLchild().getResult(g).equals("0")){ //当除数为 0 时,且被除数不为0时
				                        		setChild(getRchild(), getLchild()); //当除数为 0 时，交换左右孩子，被除数为 0 ，结果为 0  			            
				                        	}else if(getLchild().getResult(g).equals("0")){//如果除数与被除数都为0，则从新生成一个符号
				                        		String symbol[] = {"+","-","×","÷"};
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
	        return data;  //如果该结点没有孩子，说明该结点是叶子，结果返回该叶子结点的值
	    }   
		
		/**
		 * 为以该结点为根的表达式添加有效括号，并以字符串形式返回
		 */
		public String toString()
		    {  
		        String Lstr = "", Rstr = "", Str = "";  
		        if(hasChild())
		        {  
		        		//-------------------右子树去括号操作---------------------------------------------------------
		        		//右子树如果有孩子，说明右子树是一个表达式，而不是数字节点。  
			            if(getRchild().hasChild())
			            {                           
				                //判断左邻括号的运算符（op）是否为'/'  
				                if(data.equals("÷"))
				                {  
				                    //获取右子树的表达式，保留括号  
				                    Rstr = getRchild().toString();                
				                }  
				                //判断左邻括号的运算符（op）是否为'*'或'-'  
				                else if(data.equals("×") || data.equals("-"))
				                	{  
					                    //判断（op2）是否为'+'或'-'  
					                    if(getRchild().data.equals("+") || getRchild().data.equals("-"))
						                    {  
						                    	//获取右子树的表达式，保留括号  
						                        Rstr = getRchild().toString();            
						                    }
					                    else {  
							                     //获取右子树的表达式，并且去括号
						                    	//符开始取子串，取到倒数第 2 个字符（第一个是左括号，倒数第一个是右括号））   
							                    Rstr = getRchild().toString().substring(1, getRchild().toString().length()-1);    
						                    }  
				                	}
				                else{  
				                    //右子树除此之外都是可以去括号的。  
				                    Rstr = getRchild().toString().substring(1, getRchild().toString().length()-1);        
				                }   
		            } //--getRchild().hasChild()
		            else {  
		                Rstr = getRchild().data;  //如果右子树是数字节点。则返回该结点的值 
		            }
			              
			        //-------------------左子树去括号操作---------------------------------------------------------
		            //左子树的情况同右子树类似---
			        //首先判断左结点是否有孩子
		            if(getLchild().hasChild()){
		            	//判断右邻结点的运算符是否为 ‘*’ 或者 ‘/’
		                if(data.equals("×") || data.equals("÷")){  
		                	//如果（op1）是否为 ‘+’ 或者 ‘-’
		                    if(getLchild().data.equals("+") || getLchild().data.equals("-")){
		                    	//获取左子树的表达式，保留括号  
		                        Lstr = getLchild().toString();  
		                    }  else{ //获取左子树的表达式，并且去括号
		                        Lstr = getLchild().toString().substring(1, getLchild().toString().length()-1);  
		                    }  
		                }  
		                else{  //左子树除此之外都是可以去括号的。 
		                    Lstr = getLchild().toString().substring(1, getLchild().toString().length()-1);  
		                }  
		            }  
		            else{  
		                Lstr = getLchild().data;  //如果左子树是数字节点。则返回该结点的值 
		            }  
		            
		            //获取当前的运算式，并加上括号  
		            Str = "(" + Lstr +" " +data+" " + Rstr + ")";                                      
		        }  
		        else{  
		            //若没有孩子，说明是数字节点，直接返回数字  
		            Str = data;  
		        }  
		        return Str;  
		    }	
	}	

