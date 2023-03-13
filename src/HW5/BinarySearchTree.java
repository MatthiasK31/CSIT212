/*
Matthias Kim
HW5
3/12/22
Did Extra Credit!
 */

package HW5;

public class BinarySearchTree {
    public TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void inorder_tree_walk(TreeNode x) {
        if (x != null) {
            inorder_tree_walk(x.left);
            System.out.print(x.key + " ");
            inorder_tree_walk(x.right);
        }
    }

    public void preorder_tree_walk(TreeNode x) {
        if (x != null) {
            System.out.print(x.key + " ");
            preorder_tree_walk(x.left);
            preorder_tree_walk(x.right);
        }
    }

    public void postorder_tree_walk(TreeNode x) {
        if (x != null) {
            postorder_tree_walk(x.left);
            postorder_tree_walk(x.right);
            System.out.print(x.key + " ");
        }
    }


    public TreeNode search(TreeNode x, int k) {
        if (x == null || k == x.key) return x;
        if (k < x.key) return search(x.left, k);
        else return search(x.right, k);
    }

    public TreeNode iterative_search(int k) {
        TreeNode c = root;
        while (c != null && k != c.key) {
            if (k < c.key) c = c.left;
            else c = c.right;
        }
        return c;
    }

    public TreeNode minimum() {
        if (root == null) {
            return null;
        }
        TreeNode node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public TreeNode maximum() {
        TreeNode t = root;
        while (t.right != null) t = t.right;
        return t;
    }

    public TreeNode successor(TreeNode x) {
        if (x.right != null) {
            TreeNode node = x.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            TreeNode y = x.p;

            while (y != null && x == y.right) {
                x = y;
                y = y.p;
            }
            return y;
        }
    }

    public void insert(int k) {
        TreeNode newNode = new TreeNode(k);
        if (root == null) {
            root = newNode;
        } else {
            TreeNode currentNode = root;
            TreeNode p;
            while (true) {
                p = currentNode;
                if (k < currentNode.key) {
                    currentNode = currentNode.left;
                    if (currentNode == null) {
                        p.left = newNode;
                        newNode.p = p;
                        return;
                    }
                } else {
                    currentNode = currentNode.right;
                    if (currentNode == null) {
                        p.right = newNode;
                        newNode.p = p;
                        return;
                    }
                }
            }
        }
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree bst;
        TreeNode n;
        bst = new BinarySearchTree();
        for (int i = 0; i < array.length; i++)
            bst.insert(array[i]);
        System.out.println("Inorder_tree_walk starts ------------------");
        bst.inorder_tree_walk(bst.root);
        System.out.println("\nInorder_tree_walk ends ------------------");
        System.out.print("\n\n");

        //EXTRA CREDIT
        System.out.println("Preorder_tree_walk starts ------------------");
        bst.preorder_tree_walk(bst.root);
        System.out.println("\nPreorder_tree_walk ends ------------------");
        System.out.print("\n\n");

        System.out.println("Postorder_tree_walk starts ------------------");
        bst.postorder_tree_walk(bst.root);
        System.out.println("\nPostorder_tree_walk ends ------------------");
        System.out.print("\n\n");
        //////////////

        System.out.println("Search starts ------------------");
        n = bst.search(bst.root, 13);
        System.out.println("found: " + n.key);
        System.out.println("Search ends ------------------");
        System.out.print("\n\n");
        System.out.println("Iterative search starts ------------------");
        n = bst.iterative_search(4);
        System.out.println("found: " + n.key);
        System.out.println("Iterative search ends ------------------");
        System.out.print("\n\n");
        System.out.println("Minimum starts ------------------");
        n = bst.minimum();
        System.out.println("Minimum key is " + n.key);
        System.out.println("Minimum ends ------------------");
        System.out.print("\n\n");
        System.out.println("Maximum starts ------------------");
        n = bst.maximum();
        System.out.println("Maximum key is " + n.key);
        System.out.println("Maximum ends ------------------");
        System.out.print("\n\n");
        System.out.println("Successor starts ------------------");
        n = bst.successor(bst.root.left.right.right);
        System.out.println("Successor key is " + n.key);
        System.out.println("Successor ends ------------------");
    }
}