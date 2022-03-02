package com.DataStructure;



import java.util.ArrayDeque;

public class BinaryTree{
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(1);
        binaryTree.insert(3);
        binaryTree.insert(4);
        binaryTree.insert(2);
        binaryTree.insert(1);
        binaryTree.insert(5);
        binaryTree.insert(0);
        binaryTree.insert(-1);
        binaryTree.insert(-2);
        binaryTree.midOrder();
        System.out.println("--------------------");
        binaryTree.remove2(1);
        binaryTree.midOrder();
        System.out.println(binaryTree.contains(2));
    }
    class BinaryNode {

        int element;
        BinaryNode left ;
        BinaryNode right ;

        public BinaryNode() {
            left = null;
            right = null;
        }

        public BinaryNode(int element) {
            this.element = element;
        }

        public BinaryNode(int element, BinaryNode left, BinaryNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    BinaryNode root ;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(BinaryNode root) {
        this.root = root;
    }


    public void insert(int x){
        if(this.root!=null) insert(x,this.root);
        else this.root=new BinaryNode(x);
    }

    private BinaryNode insert(int x, BinaryNode binaryNode){
        if(binaryNode==null) return new BinaryNode(x);
        if(x==binaryNode.element) return binaryNode;
        if(x<binaryNode.element) binaryNode.left = insert(x,binaryNode.left);
        if(x>binaryNode.element) binaryNode.right = insert(x,binaryNode.right);
        return binaryNode;
    }


    public boolean contains(int x){
        if(this.root==null) return false;
        BinaryNode temp = this.root;
        while(temp!=null) {
            if (x < temp.element) temp = temp.left;
            else if (x > temp.element) temp = temp.right;
            else return true;
        }
        return false;
    }

    public BinaryNode remove(int x){
        if(this.root==null) return null;
        return remove(x, this.root);
    }

    public BinaryNode remove(int x, BinaryNode t){
        if(t==null) return null;
        if(x<t.element) t.left= remove(x,t.left);
        if(x>t.element) t.right= remove(x,t.right);
        else {
            if(t.right!=null && t.left!=null) {
                t.element = findMin(t.right).element;
                t.right=remove(t.element,t.right);
            }
            else {
                t= (t.left!=null)? t.left:t.right;
            }
        }
        return t;
    }

    public void remove2(int x){
        remove2(x, this.root);
    }
    //在函数内部为对象赋值不起作用
    public void remove2(int x, BinaryNode t){
        if(t!=null) {
            if (x < t.element) remove2(x, t.left);
            else if (x > t.element) remove2(x, t.right);
            else {
                if (t.right != null && t.left != null) {
                    t.element = findMin(t.right).element;//寻找后继数
                    remove2(t.element, t.right);//移除后继数
                } else {
                    if(t.left!=null) t=t.left;
                    if(t.right!=null) t=t.right;
                    else t.element = 1999999;

                }
            }
        }
    }

    private void makeNull(){
        this.root = null;
    }
    private BinaryNode findMin(BinaryNode t){
        if(t==null) return null;
        BinaryNode temp = t;
        while(temp.left!=null) {
            temp = temp.left;
        }
        return temp;
    }

    public void preOrder(){
        preOrder2(this.root);
    }

    public void preOrder(BinaryNode t){
        if(t!=null) printOne(t);
        if(t.left!=null) preOrder(t.left);
        if(t.right!=null) preOrder(t.right);
    }

    public void preOrder2(BinaryNode t){
        ArrayDeque<BinaryNode> stack = new ArrayDeque();
        stack.push(t);
        for(;;){

            BinaryNode temp = stack.pop();
            printOne(temp);

            if(temp.right!=null) stack.push(temp.right);
            if(temp.left!=null) stack.push(temp.left);
            if(stack.size()==0) break;
        }
    }

    public void postOrder(){
        postOrder2(this.root);
    }

    public void postOrder(BinaryNode t){
        if(t.left!=null) postOrder(t.left);
        if(t.right!=null) postOrder(t.right);
        if(t!=null) printOne(t);

    }


/**
 * 后续遍历栈方式
 * 需要增加一个节点记录，用于记录上次出栈的节点
 * 1、如果栈顶元素非空且左节点存在，将其入栈，重复该过程。若不存在则进入第2步（该过程和中序遍历一致）
 * 2、判断上一次出栈节点是否当前节点的右节点，或者当前节点是否存在右节点，满足任一条件，将当前节点输出，并出栈。否则将右节点压栈。跳至第1步
 */
    public void postOrder2(BinaryNode t){
        ArrayDeque<BinaryNode> stack = new ArrayDeque();
        stack.push(t);
        BinaryNode lastNode = null;
        while(stack.size()!=0){
            while(stack.peek().left!=null) stack.push(stack.peek().left);
            while(stack.size()!=0){
            if(lastNode==stack.peek().right || stack.peek().right==null){
                lastNode = stack.pop();
                printOne(lastNode);
            }
            else if(stack.peek().right!=null) {
                stack.push(stack.peek().right);
                break;
            }
            }
        }
    }

    public void midOrder(){
        midOrder2(this.root);
    }

    public void midOrder(BinaryNode t){
        if(t.left!=null) midOrder(t.left);
        if(t!=null) printOne(t);
        if(t.right!=null) midOrder(t.right);
    }
    /**
     * 中序遍历栈方式
     * 栈的中序遍历需要套两层循环，由于需要先输出左节点，必须向下查找直到左节点为空才能输出。
     * 1、如果栈顶元素非空且左节点存在，将其入栈，重复该过程。若不存在则进入第2步
     * 2、若栈非空，输出栈顶元素并出栈。判断刚出栈的元素的右节点是否存在，不存在重复第2步，存在则将右节点入栈，跳至第1步
     */
    public void midOrder2(BinaryNode t){
        ArrayDeque<BinaryNode> stack = new ArrayDeque();
        stack.push(t);
        BinaryNode temp=null;
        while(stack.size()!=0){
            while(stack.peek().left!=null) stack.push(stack.peek().left);

            while(stack.size()!=0){
                temp = stack.pop();
                printOne(temp);
                if(temp.right!=null) {
                    stack.push(temp.right);
                    break;
                }
            }
        }
    }

    private static void printOne(BinaryNode t){
        System.out.println(t.element);
    }

}
