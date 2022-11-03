package btree;

import java.util.ArrayList;
import java.util.Scanner;



public class findPathBinaryTree {
	
	
	public static ArrayList<Integer> findPath(BinaryTreeNode<Integer> root,int data)
	{if(root==null)//side case
		return null;
	if(root.data==data)//base case
	{
		ArrayList<Integer> output=new ArrayList<>();
		output.add(root.data);
		return output;
	}
	
	ArrayList<Integer>leftOutput=findPath(root.left,data);//if the node is in the left tree
	if(leftOutput!=null)//the returned ArrayList won't be null
		{leftOutput.add(root.data);//add the node to the path
		return leftOutput;
		}
	
	ArrayList<Integer>rightOutput=findPath(root.right,data);//if the node is in the right tree
	if(rightOutput!=null)//the returned ArrayList won't be null
		{rightOutput.add(root.data);//the returned ArrayList won't be null
		return rightOutput;
		}
	
	else 
		return null;
	
		
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
	ArrayList<Integer>path=findPath(root,4);

	

}
	
}
