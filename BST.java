package NoNameTel;

import java.util.*;

public class BST <T extends Comparable<T>,K>
{
   private Node<T,K> root;


   public BST() //Constructor
   {
      root = null;
   }



   public void insert(T key, K data) //Inserts key
   {
	   if(root == null){
		   root = new Node(key, data);
	   }else{
		   root = insert(root, key, data);
	   }
   }
   
   //comparing the "key"(Name of region, Name of customer)
   private Node<T, K> insert(Node<T,K> root, T key, K data)
   {
	   if(key.compareTo(root.key)<=0){ // go left
		   if(root.left==null){
			   root.left = new Node(key, data);
		   }else{
			   insert(root.left,key,data);
		   }
	   }else if(key.compareTo(root.key)>0){ // go right
		   if(root.right == null){
			   root.right = new Node(key, data);
		   }else{
			   insert(root.right, key,data);
		   }
	   }
	   return root;
   }


   public boolean search(T key) //Searches key
   {
      return search(root, key);
   }
   private boolean search(Node<T,K> root, T key)
   {
      if (root == null){
    	  System.out.println("Name was invalid");
         return false;         
      }
      else{
    	  if (root.getKey().compareTo(key) == 0){
    		  System.out.print(root.getKey());
    		  System.out.println(root.getData());
    		  return true;
    	  }
          else{
    		  if (root.getKey().compareTo(key) > 0){
    			  return search(root.left, key);
    		  }
                  else{
    			  return search(root.right, key);
    		  }
    	  }
      }
   }

   public boolean check(T key) //checks if key is valid       
   {
        return check(root, key);
   }
   private boolean check(Node<T,K> root, T key)
   {
         if (root == null){
            return false;         
         }
         else{
            if (root.getKey().compareTo(key) == 0){
       		  return true;
            }
            else{
       		  if (root.getKey().compareTo(key) > 0){
       			  return check(root.left, key);
       		  }
                  else{
       			  return check(root.right, key);
       		  }
            }
         }
   }

   public K get(T key)//gets key
   {
      return get(root, key);
   }
   private K get(Node<T,K> root, T key)
   {
      if (root == null){
    	  System.out.println("Name was invalid");
         return null;         
      }else{
    	  if (root.getKey().compareTo(key) == 0){
    		  return root.getData();
    	  }else{
    		  if (root.getKey().compareTo(key) > 0){
    			  return get(root.left, key);
    		  }else{
    			  return get(root.right, key);
    		  }
    	  }
      }
   }

   //Deletes key
   public void delete(T key)
   {
      root = delete(root, key);
   }
   private Node<T,K> delete(Node<T,K> root, T key)
   {
      if (root == null){
    	  throw new RuntimeException("cannot delete.");
      }else if (key.compareTo(root.getKey()) < 0){
    	  root.left = delete (root.left, key);
      }else if (key.compareTo(root.getKey())  > 0){
    	  root.right = delete (root.right, key);
      }else{
    	  if (root.left == null){
    		  return root.right;
    	  }else if (root.right == null){
    		  return root.left;
    	  }else{
    		  return null;
    	  }
      }
      return root;
   }

   
   //Traversal
   public void preOrderTraversal()
   {
      preOrderHelper(root);
   }
   private void preOrderHelper(Node r)
   {
      if (r != null)
      {
          System.out.print(r.getKey() +"     "+r.getData());
          System.out.println();
         preOrderHelper(r.left);
         preOrderHelper(r.right);
      }
   }

   public void inOrderTraversal()
   {
      inOrderHelper(root);
   }
   private void inOrderHelper(Node r)
   {
      if (r != null)
      {
         inOrderHelper(r.left);
         System.out.print(r.getKey() +"     "+r.getData());
         System.out.println();
         inOrderHelper(r.right);

      }
   }
   
   //Node Class
   private class Node<T,K>
   {
      private T key;
      private K data;
      private Node<T,K> left, right;

      public Node(T key, K data)
      {
         this.data = data;
         this.key = key;
      }

	public T getKey() {
		return key;
	}
 
	
	public K getData() {
		return data;
	}

	public void printNode(){
		System.out.println(data);
	}

   } //end of Node
}//end of BST



//http://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/code/BST.java
//http://www.dreamincode.net/forums/topic/276860-copying-binary-search-tree-problem/
