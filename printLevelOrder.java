package btree;
import java.util.Queue;
import java.util.Scanner;



import java.util.LinkedList;

public class printLevelOrder {

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> pendingNodes=new LinkedList<>();//creating a queue to get every node traversed levelwise
	        pendingNodes.add(root);//adding node root
	        pendingNodes.add(null);//for detecting new level
	        while(pendingNodes.peek()!=null)//loop end condition
	        {BinaryTreeNode<Integer>currentNode=pendingNodes.poll();
	         System.out.print(currentNode.data+" ");
	         if(currentNode.left!=null)//add to queue if not null
	         pendingNodes.add(currentNode.left);
	         if(currentNode.right!=null)//add to queue if not null
	         pendingNodes.add(currentNode.right);
	         if(pendingNodes.peek()==null)//if upcoming queue element is null start new line
	         {
	             pendingNodes.poll();
	             System.out.println();
	             pendingNodes.add(null);//adding null for the next level as well

	         }
	         


	            
	        }
	        


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
	printLevelWise(root);
	}

}
