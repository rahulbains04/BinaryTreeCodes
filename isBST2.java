package btree;

import java.util.Scanner;



public class isBST2 {

	public static Pair<Boolean,Pair<Integer,Integer>>isBST2(BinaryTreeNode<Integer> root)
	{if(root==null)
	{
		Pair<Boolean,Pair<Integer,Integer>>output=new Pair<>();
		output.first=true;
		output.second=new Pair<>();
		output.second.first=Integer.MAX_VALUE;
		output.second.second=Integer.MIN_VALUE;
		return output;
	}
	Pair<Boolean, Pair<Integer,Integer>>leftOutput=isBST2(root.left);
	Pair<Boolean, Pair<Integer,Integer>>rightOutput=isBST2(root.right);
	int min=Math.min(root.data,Math.min(leftOutput.second.first,rightOutput.second.first));
	int max=Math.max(root.data,Math.max(leftOutput.second.second,rightOutput.second.second));
	boolean isBST=(root.data>leftOutput.second.second)&&
			(root.data<rightOutput.second.first)&&
			leftOutput.first&&
			rightOutput.first;
	Pair<Boolean,Pair<Integer,Integer>>output=new Pair<>();
	output.first=isBST;
	output.second=new Pair<>();
	output.second.first=min;
	output.second.second=max;
	return output;
	
	
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
	System.out.println(isBST2(root));
	
	}
}
