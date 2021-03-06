package com.leetcode;

/**
 * Created by Andiz
 * 2018/10/3 22:20
 * coding For love and Peace
 * 297二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例:
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，
 * 你也可以采用其他的方法解决这个问题。
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */
public class _297_SerializeandDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        preOrder(root, res);
        System.out.println(res.toString().trim());
        return res.toString().trim();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;
        String[] str = data.split(" ");
        int[] index = new int[]{0};
        TreeNode root = reCreateTree(str, index);
        return root;
    }

    //这里int[] index = new int[]{0}; 就是用来计数的？
    public TreeNode reCreateTree(String[] str, int[] index) {
        TreeNode root = null;
        if (index[0] < str.length) {
            int val = 0;
            if (str[index[0]].equals("#")) {
                return null;
            } else {
                val = Integer.parseInt(str[index[0]]);
                root = new TreeNode(val);
                index[0]++;
                root.left = reCreateTree(str, index);
                index[0]++;
                root.right = reCreateTree(str, index);
            }
        }
        return root;
    }

    public void preOrder(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("# ");
            return;
        }
        int val = root.val;
        res.append(val + " ");
        preOrder(root.left, res);
        preOrder(root.right, res);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //LeetCode提供  第一种与以上类似
    //第二种
    //    // Encodes a tree to a single string.
    //    public List<Integer> serialize(TreeNode root) {
    //        List<Integer> res = new ArrayList<>();
    //        dfs(res, root);
    //        return res;
    //    }
    //
    //    private void dfs(List<Integer> res, TreeNode root) {
    //        if (root == null) {
    //            res.add(null);
    //        } else {
    //            res.add(root.val);
    //            dfs(res, root.left);
    //            dfs(res, root.right);
    //        }
    //    }
    //
    //    // Decodes your encoded data to tree.
    //    public TreeNode deserialize(List<Integer> data) {
    //        int index[] = {0};
    //        TreeNode root = build(index, data);
    //        return root;
    //    }
    //
    //    private TreeNode build(int[] index, List<Integer> data) {
    //        Integer val = data.get(index[0]);
    //        index[0] = index[0] + 1;
    //        if (val == null) {
    //            return null;
    //        } else {
    //            TreeNode node = new TreeNode(val);
    //            node.left = build(index, data);
    //            node.right = build(index, data);
    //            return node;
    //        }
    //    }
}
