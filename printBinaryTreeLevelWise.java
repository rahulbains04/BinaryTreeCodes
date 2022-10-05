package btree;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class printBinaryTreeLevelWise {
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
	return root;
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer>root=takeInput(s);
		printLevelWise(root);
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


}
