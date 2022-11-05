package btree;



public class BST {
	 class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}}
private BinaryTreeNode<Integer> root;
private boolean hasDataHelper(int data,BinaryTreeNode<Integer> root)
{
if(root==null)//side case
	return false;
if(root.data==data)//base case
	return true;
else if(data>root.data)//search on right if the data is greater than root
	return hasDataHelper(data,root.right);
else//search on left is data is smaller
	return hasDataHelper(data,root.left);
}
public  boolean hasData(int data)
{return hasDataHelper(data,root);

}


private BinaryTreeNode<Integer> insertHelper(int data,BinaryTreeNode<Integer> root)
{if(root==null)//base case
{
	BinaryTreeNode<Integer> newNode=new BinaryTreeNode<Integer>(data);
	return newNode;
}
if(root.data<data)//insert on right is data is larger
{
	root.right= insertHelper(data, root.right);

}
else//insert on left is data is smaller or equal
{
	
		root.left= insertHelper(data, root.left);
	

}
return root;
}
public void insert(int data)
{
	root=insertHelper(data,root);
}

public BinaryTreeNode<Integer> findSmallest(BinaryTreeNode<Integer> root)
{
	if(root==null)//base case
		return null;
	if(root.left==null)//smaller is on left only 
		return root;
	else
		return findSmallest(root.left);
	
}

private BinaryTreeNode<Integer> delete(int data,BinaryTreeNode<Integer> root)
{
	if(root==null)//base case
		return null;
	if(root.data==data)//major case
	{
		if(root.right==null&&root.left==null)
			return null;
		else if(root.right==null)
			return root.left;
		else if(root.left==null)
			return root.right;
		else//when both children nodes are alive
		{
		BinaryTreeNode<Integer>temp2=findSmallest(root.right);//smallest in the right subtree can be the newNode or largest in the left
		root.data=temp2.data;//switching data values
		root.right=delete(temp2.data,root.right);//deleting the duplicate node
		return root;
			
		}
			
	}
	else if(root.data<data)//look in right if larger
	{
		root.right=delete(data,root.right);
		return root;
		
	}
	else//look in left if smaller
	{
		root.left=delete(data,root.right);
		return root;
		
	}
		
}


public void delete(int data)
{root=delete(data,root);

}

private void printTree(BinaryTreeNode<Integer> root) {
	if(root==null)//base case
		return;
	System.out.print(root.data);
	if(root.left!=null)//if left part alive 
		System.out.print(":L:"+root.left.data);
	if(root.right!=null)//if right alive
		System.out.print(",R:"+root.right.data);
	System.out.println();//for line enter after the root and children print
	printTree(root.left);
	printTree(root.right);
}

public void printTree() {
	printTree(root);
}
}