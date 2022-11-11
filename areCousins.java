package btree;

import java.util.Scanner;





public class areCousins {
	 static class BinaryTreeNode<T> {
			T data;
			BinaryTreeNode<T> left;
			BinaryTreeNode<T> right;

			public BinaryTreeNode(T data) {
				this.data = data;
				this.left = null;
				this.right = null;
			}}
	 static class Pair<T,U>{
		 T level;
		 U parent;
	 }

	 public static Pair<Integer,BinaryTreeNode<Integer>>find(BinaryTreeNode<Integer>root,int x)
	 {
		 if(root==null){//side case
		 Pair<Integer,BinaryTreeNode<Integer>>output=new Pair<>();
		 output.level=0;
		 output.parent=null;
		 return output;
				 }
		 
		 if(root.left!=null&&root.left.data==x||root.right!=null&&root.right.data==x)//base case if root has our node
		 { Pair<Integer,BinaryTreeNode<Integer>>output=new Pair<>();
		 output.level=1;
		 output.parent=root;
		 return output;
			 
		 }
		 Pair<Integer,BinaryTreeNode<Integer>>lout=find(root.left, x);//left recursion
		 Pair<Integer,BinaryTreeNode<Integer>>rout=find(root.right, x);//right recursion
		 if(lout.parent!=null)//if found in the left subtree
		 {Pair<Integer,BinaryTreeNode<Integer>>output=new Pair<>();
		 output.level=lout.level+1;//output will have just one level more than lout
		 output.parent=lout.parent;//the parent will be same
		 return output;
			 
		 }
		 else
		 {
			 Pair<Integer,BinaryTreeNode<Integer>>output=new Pair<>();
			 output.level=rout.level+1;//level one more
			 output.parent=rout.parent;//same parent
			 return output;
		 }	  
		 }
		 
	 
	public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
		if(root==null)//null case
		return false;
		Pair<Integer,BinaryTreeNode<Integer>>x=find(root,p);//find parent and level
		Pair<Integer,BinaryTreeNode<Integer>>y=find(root,q);//find parent and level
		if(x.level==y.level&&x.parent!=y.parent)//compare parent and level
		return true;
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
	
	
	public static void main(String[] args) {
		Scanner s=new Scanner (System.in);
		BinaryTreeNode<Integer>root=takeInput(s);
		int p=s.nextInt();
		int q=s.nextInt();
		if(isCousin(root,p,q))
			System.out.println("yes they are cousins");
		else
			System.out.println("No they are not cousins");

	}

}
