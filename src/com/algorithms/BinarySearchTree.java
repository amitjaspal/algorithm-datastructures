package com.algorithms;

import java.util.Stack;


/**
 * Created by ajaspal on 3/22/17.
 */
public class BinarySearchTree {

  class TreeNode
  {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
      this.val = x;
      this.left = null;
      this.right = null;
    }
  }

  TreeNode root;
  public void insert(int []inputs){
    for(int x: inputs){
      root = insert(root, x);
    }
  }

  private TreeNode insert(TreeNode root, int x){
    if(root == null){
      TreeNode leaf = new TreeNode(x);
      return leaf;
    }
    if(x <= root.val){
      root.left = insert(root.left, x);
      return root;
    }else{
      root.right = insert(root.right, x);
      return root;
    }

  }

  public void printTreeInorder(){
    printTreeInorder(root);
  }

  private void printTreeInorder(TreeNode root){
    if(root != null){
      System.out.println(root.val);
      printTreeInorder(root.left);
      printTreeInorder(root.right);
    }
  }

  public void printTreePreOrderUsingStack(){
    Stack<TreeNode> st = new Stack<>();
    TreeNode head = root;
    // Initialize the stack;
    while(head != null){
      st.push(head);
      head = head.left;
    }

    while(st.size() != 0){
      System.out.println(st.peek().val);
      TreeNode tmp = st.pop().right;
      while(tmp != null){
        st.push(tmp);
        tmp = tmp.left;
      }
    }
  }


  public boolean isValidBST(){
    return isValidBSTHelper(root, -Double.MAX_VALUE, Double.MAX_VALUE);
  }

  private boolean isValidBSTHelper(TreeNode root, Double min, Double max){
    if(root != null){
      if(Double.compare(min, (double)root.val) < 0 && Double.compare((double)root.val, max) < 0 ){
        return isValidBSTHelper(root.left, min, (double)root.val) && isValidBSTHelper(root.right, (double)root.val, max);
      }else{
        return false;
      }
    }else{
      return true;
    }
  }

  TreeNode lca;

  public int lowestCommonAncestor( int p, int q) {
    lca = null;
    lowestCommonAncestor(root, p, q);
    return lca.val;
  }

  private TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
    if(root == null) return null;

    TreeNode n1 = lowestCommonAncestor(root.left, p, q);
    TreeNode n2 = lowestCommonAncestor(root.right, p, q);

    if(lca == null){
      if(n1 != null && n2 != null){
        lca = root;
      }
      if((n1 != null || n2 != null) && (root.val == p || root.val == q)){
        lca = root;
      }
    }
    if(n1 != null) return n1;
    if(n2 != null) return n2;
    if(root.val == p || root.val == q) return root;
    return null;
  }
}
