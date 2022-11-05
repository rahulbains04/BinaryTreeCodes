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
if(root==null)
	return false;
if(root.data==data)
	return true;
else if(data>root.data)
	return hasDataHelper(data,root.right);
else
	return hasDataHelper(data,root.left);
}
public  boolean hasData(int data)
{return hasDataHelper(data,root);

}


private BinaryTreeNode<Integer> insertHelper(int data,BinaryTreeNode<Integer> root)
{if(root==null)
{
	BinaryTreeNode<Integer> newNode=new BinaryTreeNode<Integer>(data);
	return newNode;
}
if(root.data<data)
{
	root.right= insertHelper(data, root.right);

}
else
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
	if(root==null)
		return null;
	if(root.left==null)
		return root;
	else
		return findSmallest(root.left);
	
}

private BinaryTreeNode<Integer> delete(int data,BinaryTreeNode<Integer> root)
{
	if(root==null)
		return null;
	if(root.data==data)
	{
		if(root.right==null&&root.left==null)
			return null;
		else if(root.right==null)
			return root.left;
		else if(root.left==null)
			return root.right;
		else
		{
		BinaryTreeNode<Integer>temp2=findSmallest(root.right);
		root.data=temp2.data;
		root.right=delete(temp2.data,root.right);
		return root;
			
		}
			
	}
	else if(root.data<data)
	{
		root.right=delete(data,root.right);
		return root;
		
	}
	else
	{
		root.left=delete(data,root.right);
		return root;
		
	}
		
}


public void delete(int data)
{root=delete(data,root);

}

private void printTree(BinaryTreeNode<Integer> root) {
	if(root==null)
		return;
	System.out.print(root.data);
	if(root.left!=null)
		System.out.print(":L:"+root.left.data);
	if(root.right!=null)
		System.out.print(",R:"+root.right.data);
	System.out.println();
	printTree(root.left);
	printTree(root.right);
}

public void printTree() {
	printTree(root);
}
}