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

        initialize();
    }

    // delete a node from BST
    void deleteKey(int key) {
        root = delete_Recursive(root, root, key);

        walk(root, null);
    }

    // recursive delete function
    Node delete_Recursive(Node parent, Node root, int key) {
        // tree is empty
        if (root == null)
            return root;

        walk(parent, root);

        // traverse the tree
        if (key < root.key) { // traverse left subtree
            root.left = delete_Recursive(root, root.left, key);
        
            walk(root.left, root);
        }
        else if (key > root.key) { // traverse right subtree
            root.right = delete_Recursive(root, root.right, key);
        
            walk(root.right, root);
        }
        else {
            // node contains only one child
            if (root.left == null) {
                walk(root, root.right);
                delete(root);

                return root.right;
            } else if (root.right == null) {
                walk(root, root.left);
                delete(root);

                return root.left;
            }

            walk(root, root.right);

            int newValue = minValue(root.right);

            update(root, newValue);

            // node has two children;
            // get inorder successor (min value in the right subtree)
            root.key = newValue;

            // Delete the inorder successor
            root.right = delete_Recursive(root, root.right, root.key);
            
            walk(root.right, root);
        }
        return root;
    }

    int minValue(Node root) {
        // initially minval = root
        int minval = root.key;
        // find minval
        while (root.left != null) {
            walk(root, root.left);

            minval = root.left.key;
            root = root.left;
        }

        walk(root, null);

        return minval;
    }

    // insert a node in BST
    void insert(int key) {
        root = insert_Recursive(null, root, key);

        walk(root, null);
    }

    // recursive insert function
    Node insert_Recursive(Node parent, Node root, int key) {
        // tree is empty
        if (root == null) {
            walk(parent, null);

            root = new Node(key);

            insert(root);

            return root;
        }

        walk(parent, root);

        // traverse the tree
        if (key < root.key) { // insert in the left subtree
            root.left = insert_Recursive(root, root.left, key);

            walk(root.left, root);
        }
        else if (key > root.key) { // insert in the right subtree
            root.right = insert_Recursive(root, root.right, key);

            walk(root.right, root);
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

    void update(Node node, int newValue) {
        System.out.print("35a7bfa2-e0aa-11ed-b5ea-0242ac120002");
        System.out.print("/");
        System.out.print(
            "{ " +
                "\"structure\": \"" + System.identityHashCode(this) + "\", " +
                "\"address\": \"" + System.identityHashCode(node) + "\", " +
                "\"old\": " + node.key + ", " +
                "\"new\": " + newValue + ", " +
                "\"operation\": \"update\" " + 
            "}"
        );
        System.out.print("\n");
    }

    void delete(Node node) {
        System.out.print("35a7bfa2-e0aa-11ed-b5ea-0242ac120002");
        System.out.print("/");
        System.out.print(
            "{ " +
                "\"structure\": \"" + System.identityHashCode(this) + "\", " +
                "\"address\": \"" + (node != null ? System.identityHashCode(node) : null) + "\", " +
                "\"value\": " + (node != null ? node.key : null) + ", " +
                "\"operation\": \"delete\" " +
            "}"
        );
        System.out.print("\n");
    }

    void insert(Node node) {
        System.out.print("35a7bfa2-e0aa-11ed-b5ea-0242ac120002");
        System.out.print("/");
        System.out.print(
            "{ " +
                "\"structure\": \"" + System.identityHashCode(this) + "\", " +
                "\"address\": \"" + (node != null ? System.identityHashCode(node) : null) + "\", " +
                "\"value\": " + (node != null ? node.key : null) + ", " +
                "\"operation\": \"insert\" " +
            "}"
        );
        System.out.print("\n");
    }

    void walk(Node origin, Node destiny) {
        System.out.print("35a7bfa2-e0aa-11ed-b5ea-0242ac120002");
        System.out.print("/");
        System.out.print(
            "{ " +
                "\"structure\": \"" + System.identityHashCode(this) + "\", " +
                "\"origin\": " + (origin != null ? origin.key : null) + ", " +
                "\"destiny\": " + (destiny != null ? destiny.key : null) + ", " +
                "\"operation\": \"walk\" " +
            "}"
        );
        System.out.print("\n");
    }

    void initialize() {
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
}