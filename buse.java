package btree;

import java.util.Scanner;

import btree.printBinaryTreeLevelWise.BinaryTreeNode;

public class buse {
	
	public static void print(BinaryTreeNode<Integer>root) {
		if(root==null)//base case
			return;
		String s=root.data+":";//Creating string since new recursion outputs on new line
		if(root.left!=null)//Adding non null child data to string
		s=s+root.left.data+"L ,";
		if(root.right!=null)//Adding non null child data to string
		s=s+root.right.data+"R";
		System.out.println(s);
		print(root.left);//Using recursion on children
		print(root.right);//Using recursion on children
	}

public static BinaryTreeNode<Integer> takeInput(Scanner s)
{System.out.println("Enter the root data");
int a=s.nextInt();//Taking the data of the node
if(a==-1)
return null;
BinaryTreeNode<Integer>root=new BinaryTreeNode<>(a);//creating the node
root.left=takeInput(s);//recursion on left node
root.right=takeInput(s);//recursion on right node
return root;
	
}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer>root=takeInput(s);
		print(root);
		
		
		

	}

}
