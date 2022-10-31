package btree;

import java.util.Scanner;



public class isBST3 {
	public static boolean isBST3(BinaryTreeNode<Integer>root,int min,int max)
	{
		if(root==null)
			return true;
		if(root.data>min&&root.data<=max)
		{
		boolean b=isBST3(root.left, min, root.data-1);
		boolean c=isBST3(root.right, root.data, max);
		return b&&c;}
		else
		return false;
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
	    
     
    static class Pair<T,U>{
 	   T first;
 	   U second;
    }

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
	System.out.println(isBST3(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
	
	}


}
