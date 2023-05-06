class BST {
    // node class that defines BST node
    class Node {
        int key;
        Node left, right;

        public Node(int data) {
            key = data;
            left = right = null;
        }
    }

    // BST root node
    Node root;

    // Constructor for BST =>initial empty tree
    BST() {
        root = null;

        System.out.print("35a7bfa2-e0aa-11ed-b5ea-0242ac120002");
        System.out.print("/");
        System.out.print(
            "{ " +
                "\"address\": \"" + System.identityHashCode(this) + "\", " +
                "\"operation\": \"initialize\" " +
            "}"
        );
        System.out.print("\n");
    }

    // delete a node from BST
    void deleteKey(int key) {
        root = delete_Recursive(root, root, key);
    }

    // recursive delete function
    Node delete_Recursive(Node parent, Node root, int key) {
        // tree is empty
        if (root == null)
            return root;

        // traverse the tree
        if (key < root.key) // traverse left subtree
            root.left = delete_Recursive(root, root.left, key);
        else if (key > root.key) // traverse right subtree
            root.right = delete_Recursive(root, root.right, key);
        else {
            // node contains only one child
            if (root.left == null) {
                System.out.print("35a7bfa2-e0aa-11ed-b5ea-0242ac120002");
                System.out.print("/");
                System.out.print(
                    "{ " +
                        "\"structure\": \"" + System.identityHashCode(this) + "\", " +
                        "\"parent\": \"" + System.identityHashCode(parent) + "\", " +
                        "\"address\": \"" + System.identityHashCode(root) + "\", " +
                        "\"switch\": \"" + System.identityHashCode(root.right) + "\", " +
                        "\"operation\": \"delete\" " + 
                    "}"
                );
                System.out.print("\n");

                return root.right;
            } else if (root.right == null) {
                System.out.print("35a7bfa2-e0aa-11ed-b5ea-0242ac120002");
                System.out.print("/");
                System.out.print(
                    "{ " +
                        "\"structure\": \"" + System.identityHashCode(this) + "\", " +
                        "\"parent\": \"" + System.identityHashCode(parent) + "\", " +
                        "\"address\": \"" + System.identityHashCode(root) + "\", " +
                        "\"switch\": \"" + System.identityHashCode(root.left) + "\" " +
                        "\"operation\": \"delete\" " + 
                    "}"
                );
                System.out.print("\n");

                return root.left;
            }

            // node has two children;
            // get inorder successor (min value in the right subtree)
            root.key = minValue(root.right);

            System.out.print("35a7bfa2-e0aa-11ed-b5ea-0242ac120002");
            System.out.print("/");
            System.out.print(
                "{ " +
                    "\"structure\": \"" + System.identityHashCode(this) + "\", " +
                    "\"parent\": \"" + System.identityHashCode(parent) + "\", " +
                    "\"address\": \"" + System.identityHashCode(root) + "\", " +
                    "\"value\": " + root.key + ", " +
                    "\"operation\": \"update\" " + 
                "}"
            );
            System.out.print("\n");

            // Delete the inorder successor
            root.right = delete_Recursive(root, root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        // initially minval = root
        int minval = root.key;
        // find minval
        while (root.left != null) {
            minval = root.left.key;
            root = root.left;
        }
        return minval;
    }

    // insert a node in BST
    void insert(int key) {
        root = insert_Recursive(root, root, key, null);
    }

    // recursive insert function
    Node insert_Recursive(Node parent, Node root, int key, String direction) {
        System.out.print("35a7bfa2-e0aa-11ed-b5ea-0242ac120002");
        System.out.print("/");
        System.out.print(
            "{ " +
                "\"structure\": \"" + System.identityHashCode(this) + "\", " +
                "\"origin\": \"" + System.identityHashCode(parent) + "\", " +
                "\"destiny\": \"" + System.identityHashCode(root) + "\", " +
                "\"operation\": \"walk\" " +
            "}"
        );
        System.out.print("\n");

        // tree is empty
        if (root == null) {
            root = new Node(key);

            System.out.print("35a7bfa2-e0aa-11ed-b5ea-0242ac120002");
            System.out.print("/");
            System.out.print(
                "{ " +
                    "\"structure\": \"" + System.identityHashCode(this) + "\", " +
                    "\"parent\": \"" + System.identityHashCode(parent) + "\", " +
                    "\"address\": \"" + System.identityHashCode(root) + "\", " +
                    "\"value\": " + root.key + ", " +
                    "\"operation\": \"insert\" " +
                "}"
            );
            System.out.print("\n");

            return root;
        }

        // traverse the tree
        if (key < root.key) { // insert in the left subtree
            root.left = insert_Recursive(root, root.left, key, "left");

            System.out.print("35a7bfa2-e0aa-11ed-b5ea-0242ac120002");
            System.out.print("/");
            System.out.print(
                "{ " +
                    "\"structure\": \"" + System.identityHashCode(this) + "\", " +
                    "\"origin\": \"" + System.identityHashCode(root.left) + "\", " +
                    "\"destiny\": \"" + System.identityHashCode(root) + "\", " +
                    "\"operation\": \"walk\" " +
                "}"
            );
            System.out.print("\n");
        }
        else if (key > root.key) { // insert in the right subtree
            root.right = insert_Recursive(root, root.right, key, "right");

            System.out.print("35a7bfa2-e0aa-11ed-b5ea-0242ac120002");
            System.out.print("/");
            System.out.print(
                "{ " +
                    "\"structure\": \"" + System.identityHashCode(this) + "\", " +
                    "\"origin\": \"" + System.identityHashCode(root.right) + "\", " +
                    "\"destiny\": \"" + System.identityHashCode(root) + "\", " +
                    "\"operation\": \"walk\" " +
                "}"
            );
            System.out.print("\n");
        }

        // return pointer
        return root;
    }

    // method for inorder traversal of BST
    void inorder() {
        inorder_Recursive(root);

        System.out.println();
    }

    // recursively traverse the BST
    void inorder_Recursive(Node root) {
        if (root != null) {
            inorder_Recursive(root.left);
            System.out.print(root.key + " ");
            inorder_Recursive(root.right);
        }
    }

    boolean search(int key) {
        root = search_Recursive(root, key);
        if (root != null)
            return true;
        else
            return false;
    }

    // recursive insert function
    Node search_Recursive(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key)
            return root;
        // val is greater than root's key
        if (root.key > key)
            return search_Recursive(root.left, key);
        // val is less than root's key
        return search_Recursive(root.right, key);
    }
}