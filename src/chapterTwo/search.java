package chapterTwo;

/**
 * 二叉查找树
 */
public class search {
    public static Node root;
    /**
     * 查找节点
     * 时间复杂度O(logn)
     * 空间复杂度O(1)
     * @param data
     * @return
     */
    public Node search(int data){
        Node targetNode = root;
        while (targetNode != null && targetNode.data != data){
            if (data > targetNode.data){
                targetNode = targetNode.right;
            }else {
                targetNode = targetNode.left;
            }
        }
        if(targetNode == null){
            System.out.println("未找到节点：" + data);
        }else {
            System.out.println("已找到节点：" + data);
        }
        return targetNode;
    }

    /**
     * 插入节点
     * @param data
     * @return
     */
    public boolean insert(int data){
        Node node = new Node(data);
        if (root == null){
            root = node;
            return true;
        }
        Node targetNode = root;
        while (targetNode != null){
            //比节点大走右侧，比节点小，走左侧，为空直接插入
            if (data == targetNode.data){
                System.out.println("二叉查找树中已有重复的节点：" + data);
                return false;
            }else if (data > targetNode.data) {
                if (targetNode.right == null) {
                    targetNode.right = node;
                    return true;
                }
                targetNode = targetNode.right;
            }else {
                if (targetNode.left == null){
                    targetNode.left = node;
                    return true;
                }
                targetNode = targetNode.left;
            }
        }
        return true;
    }

    /**
     * jie点
     */
    private class Node{
        int data;
        Node right;
        Node left;

        Node(int data){
            this.data = data;
        }
    }
}
