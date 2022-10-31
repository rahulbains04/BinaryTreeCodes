package btree;

import java.util.Scanner;



public class isBST {
	  public static int largest(BinaryTreeNode<Integer>root)
	    {if(root==null)//return the smallest integer value if root is null
	        return Integer.MIN_VALUE;
	    
	      
	     return Math.max(root.data,Math.max(largest(root.right),largest(root.left))); //returning back the largest value in the whole tree       
	    }
	    public static int smallest(BinaryTreeNode<Integer>root)
	    {
	        if(root==null)//return the largest integer value
	            return Integer.MAX_VALUE;
	         
	     
	   
	        return Math.min(root.data,Math.min(smallest(root.right),smallest(root.left)));//returning back the smallest value in the whole tree
	    }
	    public static boolean isBST(BinaryTreeNode<Integer> root)
	    {
	    	if(root==null)//base case
	    		return true;
	    	if(root.data<=largest(root.left)||root.data>smallest(root.right))//comparing the root value from the largest in left subtree and vice versa
	    		return false;
	    	boolean b=isBST(root.left);//recursion on left
	    	boolean c=isBST(root.right);//recursion on right
	    	return b&&c;//is a BST if both return true
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
	Scanner s=new Scanner (System.in);
	BinaryTreeNode<Integer>root=takeInput(s);
	System.out.println(isBST(root));
	
	}


}
