package chapterTwo;

/**
 * 平衡二叉树
 */
public class AVLTree {
    private TreeNode root;

    /**
     * 获取树的高度
     * @param node
     * @return
     */
    private int height(TreeNode node){
        if (node != null){
            return node.height;
        }
        return 0;
    }
    public int height(){
        return height(root);
    }

    /**
     * 查找结点
     * @param node
     * @param data
     * @return
     */
    public TreeNode search(TreeNode node,int data){
        while (node != null){
            if (data < node.data){
                node = node.left;
            }else if (data > node.data){
                node = node.right;
            }else {
                return node;
            }
        }
        return node;
    }

    /**
     * 左左局面旋转
     * @param node
     * @return
     */
    private TreeNode leftLeftRotation(TreeNode node){
        //leftChildren 对应示意图中的节点B
        TreeNode leftChildrenNode = node.left;
        node.left = leftChildrenNode.right;
        leftChildrenNode.right = node;
        //刷新节点A和节点B的高度
        node.height = Math.max(height(node.left),height(node.right)) + 1;
        leftChildrenNode.height
    }

    //二叉树结点类
    class TreeNode{
        int data;
        int height;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data = data;
            this.height = 0;
        }

        //获得结点的平衡因子
        public int getBalance(){
            int left = (this.left == null ? 0:this.left.height);
            int right = (this.right == null ? 0:this.right.height);
            return left - right;
        }
    }
}
