package btree;

import java.util.Scanner;
import java.util.LinkedList;



public class constructLinkedList {
	
	
	public static Pair<LinkedListNode<Integer>> helper(BinaryTreeNode<Integer> root)
	{
		if(root==null)//base case
		{
		Pair<LinkedListNode<Integer>> output=new Pair<>();
		 output.head=null;
		output.tail=null;
		return output;
		}

		

		Pair<LinkedListNode<Integer>>lout=helper(root.left);//yielding the sorted LL from left tree
		Pair<LinkedListNode<Integer>>rout=helper(root.right);//yielding the sorted LL from right tree
		LinkedListNode<Integer>rn=new LinkedListNode<>(root.data);//creating a LL Node of the remaining mid character
			if(lout.tail!=null)//when lout is not null
			lout.tail.next=rn;
			if(lout.head==null)//when lout returns null
			lout.head=rn;
			
		rn.next=rout.head;
		if(rout.tail==null)//when rout is null
		rout.tail=rn;
			Pair<LinkedListNode<Integer>> output=new Pair<>();//adding in the fresh output
		 output.head=lout.head;
		output.tail=rout.tail;
		return output;


	}
	

static class Pair<T>{
	T head;
	T tail;
}

	
	 
	  static class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
	  right;
	  
	  public BinaryTreeNode(T data) { this.data = data; } }
	 


	 
	 
	 
	 static class LinkedListNode<T> { T data; LinkedListNode<T> next;
	  
	  public LinkedListNode(T data) { this.data = data; } }
	

	 public static BinaryTreeNode<Integer> takeInput(Scanner s)//adding Scanner in input since we don't want recursion to create a new Scanner everytime
		{System.out.println("Enter the root data");
		int a=s.nextInt();//Taking the data of the node
		if(a==-1)
		return null;
		BinaryTreeNode<Integer>root=new BinaryTreeNode<>(a);//creating the node
		root.left=takeInput(s);//recursion on left node
		root.right=takeInput(s);//recursion on right node
		return root;}
	public static void main(String[] args) {
	

	}

}
