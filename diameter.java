package btree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import btree.printBinaryTreeLevelWise.BinaryTreeNode;

public class diameter {
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		
        Queue<BinaryTreeNode<Integer>>queue=new LinkedList<>();
        queue.add(root);//Adding the root to the queue
        while(!queue.isEmpty())
        {
            BinaryTreeNode<Integer>pendingNodes=queue.poll();
           
            if(pendingNodes.left!=null)//Adding the available children to the queue
                queue.add(pendingNodes.left);
            if(pendingNodes.right!=null)//Adding the available children to the queue
                queue.add(pendingNodes.right);
            if(pendingNodes.left==null&&pendingNodes.right==null)//Printing according to the available children
                  System.out.println(pendingNodes.data+":L:-1,R:-1");
             else if(pendingNodes.left==null)//Printing according to the available children
                  System.out.println(pendingNodes.data+":L:-1,R:"+pendingNodes.right.data);
            else if(pendingNodes.right==null)//Printing according to the available children
                 System.out.println(pendingNodes.data+":L:"+pendingNodes.left.data+",R:-1");
            else//Printing according to the available children
                 System.out.println(pendingNodes.data+":L:"+pendingNodes.left.data+",R:"+pendingNodes.right.data);

        }
        
	}
	public static BinaryTreeNode<Integer> takeInput(Scanner s)
	{System.out.println("Enter the root data");
	int a=s.nextInt();//Taking the data of the node
	if(a==-1)
	return null;
	BinaryTreeNode<Integer>root=new BinaryTreeNode<>(a);//creating the node
	root.left=takeInput(s);//recursion on left node
	root.right=takeInput(s);//recursion on right node
	return root;}
	
	
	public static int height(BinaryTreeNode<Integer>root)
	{
	  if(root==null)
		  return 0;
	  return 1+Math.max(height(root.left), height(root.right));
	}
	public static int diameter(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return 0;
		int option1=height(root.left)+height(root.right);
		int option2=diameter(root.left);
		int option3=diameter(root.right);
		return Math.max(option1, Math.max(option2, option3));
	}

	public static void main(String[] args)
	{Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer>root=takeInput(s);
		printLevelWise(root);
		System.out.println("The diameter is "+diameter(root));
		
	}
	

}
