package cn.dmego.produce;
/**
 * 二叉树类
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
	     String str = root.toString(); //当结点为根结点时的算术表达式 
	     str = str.substring(1, str.length()-1); //去掉该表达式两边的括号  
	     return str;  
    }  
	
	 public String CalAndVal(int grade){  
	      return root.getResult(grade);  
	 }  
	 /**
	  * 创建二叉树
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
	public TreeNode getRoot() { // 得到根节点
        return root;
    }
}
