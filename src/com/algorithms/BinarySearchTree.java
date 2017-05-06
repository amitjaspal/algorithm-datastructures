package com.algorithms;

import java.util.*;
import java.util.LinkedList;


/**
 * Created by ajaspal on 3/22/17.
 */
public class BinarySearchTree {

  class TreeNode
  {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode neighbour;
    TreeNode(int x){
      this.val = x;
      this.left = null;
      this.right = null;
      this.neighbour = null;
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

  public List<List<Integer>> verticalOrder() {
    Map<Integer, List<Integer>> nodesPerLevel = new TreeMap<>();
    traverseTree(nodesPerLevel,root);
    List<List<Integer>> answer = new ArrayList<>();
    for(Map.Entry<Integer, List<Integer>> e : nodesPerLevel.entrySet()){
      //System.out.println(e.getKey());
      System.out.println(Arrays.toString(e.getValue().toArray()));
      answer.add(e.getValue());
    }
    return answer;
  }

  class VerticalNode{
    TreeNode n;
    int level;
    VerticalNode(TreeNode n, int level){
      this.n = n;
      this.level = level;
    }
  }
  private void traverseTree(Map<Integer, List<Integer>> nodesPerLevel, TreeNode root) {
    if (root != null) {
      Queue<VerticalNode> q = new LinkedList<>();
      q.add(new VerticalNode(root, 0));
      while (q.size() > 0) {
        VerticalNode tmp = q.poll();
        List<Integer> l = nodesPerLevel.getOrDefault(tmp.level, new ArrayList<Integer>());
        l.add(tmp.n.val);
        nodesPerLevel.put(tmp.level, l);
        if (tmp.n.left != null) q.add(new VerticalNode(tmp.n.left, tmp.level - 1));
        if (tmp.n.right != null) q.add(new VerticalNode(tmp.n.right, tmp.level + 1));
      }
    }
  }

  public List<List<Integer>> levelOrder() {
    List<List<Integer>> ans = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while(q.size() > 0){
      Queue<TreeNode> tmp = new LinkedList<>();
      List<Integer> x = new ArrayList<>();
      while(q.size() > 0){
        TreeNode n = q.poll();
        x.add(n.val);
        if(n.left != null)tmp.add(n.left);
        if(n.right != null)tmp.add(n.right);
      }
      q = tmp;
      System.out.println(Arrays.toString(x.toArray()));
      ans.add(x);
    }
    return ans;
  }


  public void connect() {
    Queue<VerticalNode> q = new LinkedList<>();
    q.add(new VerticalNode(root, 0));
    VerticalNode prev = null;
    while(q.size() > 0){
      VerticalNode tmp = q.poll();
      if(prev != null && prev.level == tmp.level){
        prev.n.neighbour = tmp.n;

      }
      if(tmp.n.left != null) q.add(new VerticalNode(tmp.n.left, tmp.level + 1));
      if(tmp.n.right != null) q.add(new VerticalNode(tmp.n.left, tmp.level + 1));
      prev = tmp;
    }
  }
}
