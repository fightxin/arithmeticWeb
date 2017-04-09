package cn.dmego.produce;
/**
 * ��������
 * @author dmego
 *
 */
public class BinaryTree {
	private TreeNode root;
	private int size;
	private String[] data;
	
	public BinaryTree(String[] array) {
		this.data = array;
		size = array.length;
		root = createTree(0);
	}
	
	public String toString(){  
	     String str = root.toString(); //�����Ϊ�����ʱ���������ʽ 
	     str = str.substring(1, str.length()-1); //ȥ���ñ��ʽ���ߵ�����  
	     return str;  
    }  
	
	 public String CalAndVal(int grade){  
	      return root.getResult(grade);  
	 }  
	 /**
	  * ����������
	  * @param index
	  * @return
	  */
	public TreeNode createTree(int index) {
		if(index >= size)
			return null;
		TreeNode node = new TreeNode(data[index]);
		node.setLchild(createTree(2*index + 1));
		node.setRchild(createTree(2* index +2));
		return node;
	}
	public TreeNode getRoot() { // �õ����ڵ�
        return root;
    }
}
