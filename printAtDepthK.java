package btree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import btree.printBinaryTreeLevelWise.BinaryTreeNode;


public class printAtDepthK {
	public static void printAtDepth(BinaryTreeNode<Integer> root,int k)//Code to print all nodes below the node at depth k
    {
        if(root==null)//side case
            return;
      if(k==0)//base case
      { System.out.println(root.data);
       return;
      }
printAtDepth(root.left,k-1);//decreasing k with every level descended
        printAtDepth(root.right,k-1);//decreasing k with every level descended
    }
    
    public static int nodesAtDistanceKhelper(BinaryTreeNode<Integer> root, int node, int k) {
	  if(root==null)//In case the target is not found
          return -1;
     
        if(root.data==node)//In case the target is found
      {
          printAtDepth(root,k);//simply printing all nodes below the target at depth k
          return 0;
      }
       
      int ld=nodesAtDistanceKhelper(root.left,node,k);//going for recursion in the left tree
      if(ld!=-1)//In case the node is found in the remaining left tree
      {if(k==ld+1)//if root is at k distance from the target
        {  System.out.println(root.data);
        }
        else
    printAtDepth(root.right,k-ld-2);//subtracting the distance of target from root and using the remaining distance as input on the right tree
      return ld+1;}
int  rd=nodesAtDistanceKhelper(root.right,node,k);//going for recursion in the left tree
        if(rd!=-1)//In case the node is found in the remaining left tree
{
   
        if(k==rd+1)//if root is at k distance from the target
            System.out.println(root.data);
    else
     printAtDepth(root.left,k-rd-2);//subtracting the distance of target from root and using the remaining distance as input on the right tree
    
    return rd+1;

}
        return -1;//in case the target is not found anywhere
        
            }
    
    
    
     
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k)
    {
   nodesAtDistanceKhelper(root,node,k);
      

        
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

    	public static void main(String[] args)  {
    	
    Scanner s=new Scanner(System.in);
	BinaryTreeNode<Integer> root = takeInput(s);
    int target=s.nextInt();
    int k=s.nextInt();
    

    	
    		nodesAtDistanceK(root, target, k);
    	}
    }


