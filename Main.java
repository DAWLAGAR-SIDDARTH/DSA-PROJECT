public class Main {
    // Node class
    static class Node {
        int key;
        Node left, right;

        Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // BST class
    static class BST {
        Node root;

        BST() {
            root = null;
        }

        void insert(int key) {
            root = insertRec(root, key);
        }

        Node insertRec(Node root, int key) {
            if (root == null) return new Node(key);
            if (key < root.key)
                root.left = insertRec(root.left, key);
            else
                root.right = insertRec(root.right, key);
            return root;
        }

        boolean search(int key) {
            return searchRec(root, key);
        }

        boolean searchRec(Node root, int key) {
            if (root == null) return false;
            if (key == root.key) return true;
            return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
        }

        void delete(int key) {
            root = deleteRec(root, key);
        }

        Node deleteRec(Node root, int key) {
            if (root == null) return root;
            if (key < root.key)
                root.left = deleteRec(root.left, key);
            else if (key > root.key)
                root.right = deleteRec(root.right, key);
            else {
                if (root.left == null) return root.right;
                else if (root.right == null) return root.left;
                root.key = minValue(root.right);
                root.right = deleteRec(root.right, root.key);
            }
            return root;
        }

        int minValue(Node root) {
            while (root.left != null) root = root.left;
            return root.key;
        }

        void inorder() {
            inorderRec(root);
            System.out.println();
        }

        void inorderRec(Node root) {
            if (root != null) {
                inorderRec(root.left);
                System.out.print(root.key + " -> ");
                inorderRec(root.right);
            }
        }

        void preorder() {
            preorderRec(root);
            System.out.println();
        }

        void preorderRec(Node root) {
            if (root != null) {
                System.out.print(root.key + " -> ");
                preorderRec(root.left);
                preorderRec(root.right);
            }
        }

        void postorder() {
            postorderRec(root);
            System.out.println();
        }

        void postorderRec(Node root) {
            if (root != null) {
                postorderRec(root.left);
                postorderRec(root.right);
                System.out.print(root.key + " -> ");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        BST tree = new BST();

        // Python-style method calls
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder:");
        tree.inorder();

        System.out.println("Preorder:");
        tree.preorder();

        System.out.println("Postorder:");
        tree.postorder();

        System.out.println("Search 40:");
        System.out.println(tree.search(40) ? "Found" : "Not Found");

        System.out.println("Delete 30:");
        tree.delete(30);
        tree.inorder();
    }
}
// compleated