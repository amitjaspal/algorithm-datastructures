package com.algorithms;

import com.sun.deploy.util.StringUtils;
import com.sun.tools.javac.util.ListBuffer;
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

      printTreeInorder(root.left);
      System.out.println(root.val);

      printTreeInorder(root.right);
    }
  }

  // Note : For printing preorder just print the node value before pushing
  // instead of after poping.
  public void printTreeInOrderUsingStack(){
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

  public void printZigZag(){

    List<List<Integer>> answer = new ArrayList<>();
    Stack<TreeNode> st = new Stack<>();
    st.add(root);
    int i = 0;
    while(st.size() > 0){

      Stack<TreeNode> tmp = new Stack<>();
      List<Integer> levelList = new ArrayList<>();
      while(st.size() > 0){
        TreeNode n = st.pop();
        System.out.print(n.val);
        levelList.add(n.val);
        if(i%2 == 0) {
          if (n.left != null) tmp.add(n.left);
          if (n.right != null) tmp.add(n.right);
        }else{
          if (n.right != null) tmp.add(n.right);
          if (n.left != null) tmp.add(n.left);
        }

      }
      answer.add(levelList);
      i++;
      st = tmp;
      System.out.println();
    }
  }

  // Encodes a tree to a single string.
  public String serialize() {
    if(root == null) return "#";

    Queue<TreeNode> q = new LinkedList<TreeNode>();
    StringBuffer answer = new StringBuffer();
    q.add(root);


    while(q.size() > 0){
      Queue<TreeNode> tmp = new LinkedList<>();
      while(q.size() > 0){
        TreeNode n = q.poll();
        if(n != null) {
          answer.append(Integer.toString(n.val));
          answer.append(",");
          tmp.add(n.left);
          tmp.add(n.right);
        }else{
          answer.append("#");
          answer.append(",");
        }
      }
      q = tmp;

    }
    return answer.toString().substring(0, answer.length()-1);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if(data == null || data.length() == 0) return null;
    String []tokens = data.split(",");
    if(tokens.length == 1 && tokens[0].equals("#")) return null;

    TreeNode head = new TreeNode(Integer.parseInt(tokens[0]));
    Queue<TreeNode> q = new LinkedList<>();
    q.add(head);
    int idx = 1;
    while(q.size() > 0 && idx < tokens.length){
      Queue<TreeNode> tmp = new LinkedList<>();
      while(q.size() > 0 && idx < tokens.length ){
        TreeNode n = q.poll();
        System.out.println(n.val);
        if(tokens[idx].equals("#")){
          n.left = null;
        }else{
          n.left = new TreeNode(Integer.parseInt(tokens[idx]));
          tmp.add(n.left);
        }
        idx++;
        if(tokens[idx].equals("#")){
          n.right = null;
        }else{
          n.right = new TreeNode(Integer.parseInt(tokens[idx]));
          tmp.add(n.right);
        }
        idx++;
      }
      q = tmp;
    }
    root = head;
    return head;
  }

  public int inorderSuccessor(int t) {
    TreeNode n = root;
    TreeNode v = null;
    while(n!= null){
      if(n.val == t) {
        v = n;
        break;
      }else if(n.val > t){
        n = n.left;
      }else{
        n = n.right;
      }
    }
    System.out.println(v.val);
    return inorderSuccessor(root, v).val;
  }

  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

    if(p == null || root == null) return null;
    if(p.right != null){
      TreeNode tmp = p.right;
      while(tmp.left != null){
        tmp = tmp.left;
      }
      return tmp;
    }else{
      TreeNode tmp = root;
      TreeNode answer = root;
      while(tmp != null){
        if(tmp == p) break;
        System.out.println(tmp.val);
        if(tmp.val >= p.val){
          answer = tmp;
          tmp = tmp.left;
        }else{
          tmp = tmp.right;
        }
      }
      return answer;
    }
  }

  public void buildBSTFromSortedArray(int []input){
    root = buildBSTFromSortedArrayHelper(0, input.length -1 , input);
  }

  private TreeNode buildBSTFromSortedArrayHelper(int i, int j, int []input){
    if(i > j) return null;

    if(i == j) return new TreeNode(input[i]);

    int mid = i + (j-i)/2;
    TreeNode n = new TreeNode(input[mid]);
    n.left = buildBSTFromSortedArrayHelper(i, mid-1, input);
    n.right = buildBSTFromSortedArrayHelper(mid + 1, j, input);
    return n;
  }

  // To be copied to the document



  // Serialize and Deserialize using preorder traversal

  public String serializeUsingPreOrder(){
    StringBuffer result = new StringBuffer();
    serializeHelper(root, result);
    return result.substring(0, result.length()-1).toString();
  }

  private void serializeHelper(TreeNode root, StringBuffer result){
    if(root != null){
      result.append(root.val + ",");
      serializeHelper(root.left, result);
      serializeHelper(root.right, result);
    }else{
      result.append("#,");
    }
  }

  int index;
  public void deSerializeUsingPreOrder(String input){
    String[]tokens = input.split(",");
    index = 0;
    root = deSerializeHelper(tokens);

  }

  private TreeNode deSerializeHelper(String []tokens){
    if(index > tokens.length) return null;
    if(tokens[index].equals("#")) {
      index++;
      return null;
    }
    TreeNode n = new TreeNode(Integer.parseInt(tokens[index]));
    index++;
    n.left = deSerializeHelper(tokens);

    n.right = deSerializeHelper(tokens);
    return n;
  }

  TreeNode head = null;
  public void bst2DLL(){
    if(root != null){
      TreeNode p = bst2DLLHelper(root.left, true);
      TreeNode q = bst2DLLHelper(root.right, false);
      root.left = p;
      root.right = q;
      if(p != null) p.right = root;
      if(q != null) q.left = root;

      TreeNode current = head;
      while(current != null){
        System.out.println(current.val);
        current = current.right;
      }
    }
  }

  private TreeNode bst2DLLHelper(TreeNode n, boolean isLeft){
    if(n != null){
      TreeNode tmp = bst2DLLHelper(n.left, true);
      if(head == null){
        head = n;
      }
      TreeNode tmp2 = bst2DLLHelper(n.right, false);
      n.left = tmp;
      n.right = tmp2;
      if(tmp != null) tmp.right = n;
      if(tmp2 != null) tmp2.left = n;
      if(isLeft && tmp2 != null) return tmp2;
      if(!isLeft && tmp != null) return tmp;
      return n;
    }else{
      return null;
    }
  }

  int preIndex = 0;
  public void printInorderFromPreorder(int [] input){
    root = constructBSTFromPreorder(input, Integer.MIN_VALUE, Integer.MAX_VALUE);

    printTreeInorder();
  }

  private TreeNode constructBSTFromPreorder(int [] input, int min, int max){
    //System.out.println(preIndex);
    if(preIndex >= input.length) return null;
    if(input[preIndex] < min || input[preIndex] > max) return null;
    int val = input[preIndex];
    TreeNode n = new TreeNode(input[preIndex]);
    preIndex++;
    n.left = constructBSTFromPreorder(input, min, val);
    n.right = constructBSTFromPreorder(input, val, max);
    return n;
  }

  int minDistance;
  public int findDistance(int a, int b){
    minDistance = Integer.MAX_VALUE;
    if(a == b) return 0;
    findDistanceHelper(root, a, b);
    return minDistance;
  }


  private int findDistanceHelper(TreeNode n, int a, int b){
    if(n == null) return -1;

    int x = findDistanceHelper(n.left, a, b);
    int y = findDistanceHelper(n.right, a, b);

    if(x != -1 && y != -1 && minDistance == Integer.MAX_VALUE){
      minDistance = x + y;
      return -1;
    }
    else if((n.val == a || n.val == b) && (x != -1 || y != -1) && minDistance == Integer.MAX_VALUE){
      minDistance = x != -1 ? x :y;
      return -1;
    }
    else if(n.val == a || n.val == b){
      return 1;
    }
    else if(x != -1 || y != -1 ){
      return x!= -1 ? x + 1 : y +1;
    }
    return -1;


  }

}

