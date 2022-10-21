package btree;
import java.util.Scanner;



public class rootToLeafPathSumK {
	
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k,String s) {
		
	     if(root==null)//null case
	            return;
	        if(root.data==k&&root.left==null&&root.right==null)//base case
	        {
	            System.out.println(s+" "+root.data);
	            return;
	        }
	        
	         s=s+root.data+" ";//adding the nodes to the path
	        rootToLeafPathsSumToK(root.left,k-root.data,s);//left recursion
	        rootToLeafPathsSumToK(root.right,k-root.data,s);//right recursion
	        
		}
	    
	    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k)
	    {
	        rootToLeafPathsSumToK(root,k,"");//calling the helper function
	    }
	    public static BinaryTreeNode<Integer> takeInput(Scanner s)//adding Scanner in input since we don't want recursion to create a new Scanner everytime
		{System.out.println("Enter the root data");
		int a=s.nextInt();//Taking the data of the node
		if(a==-1)
		return null;
		BinaryTreeNode<Integer>root=new BinaryTreeNode<>(a);//creating the node
		root.left=takeInput(s);//recursion on left node
		root.right=takeInput(s);//recursion on right node
		return root;}
	    
	    static class BinaryTreeNode<T> {
	    	T data;
	    	BinaryTreeNode<T> left;
	    	BinaryTreeNode<T> right;

	    	public BinaryTreeNode(T data) {
	    		this.data = data;
	    		this.left = null;
	    		this.right = null;
	    	}
	    }
	  

	public static void main(String[] args) {
Scanner s=new Scanner(System.in);
BinaryTreeNode<Integer>root=takeInput(s);
System.out.println("Enter the k value");
int k=s.nextInt();
rootToLeafPathsSumToK(root, k);


	}

}
