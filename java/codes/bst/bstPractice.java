public class BstPractice {
    public static void main(String[] args) {
        BST bst = new BST();

        bst.insert(47);
        bst.insert(23);
        bst.insert(12);
        bst.insert(11);
        bst.insert(13);
        bst.insert(2);
        bst.insert(88);
        bst.insert(70);
        bst.insert(72);
        bst.insert(30);
        bst.insert(25);
        bst.insert(100);

        bst.deleteKey(88);
        bst.deleteKey(13);
        bst.deleteKey(47);
    }
}
