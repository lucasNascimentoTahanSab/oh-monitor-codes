public class Main {
  public static void main(String[] args) {
    BST bst = new BST();

    bst.inserir(25);
    bst.inserir(15);
    bst.inserir(16);
    bst.inserir(28);
    bst.inserir(27);
    bst.inserir(32);

    bst.imprimirPreOrdem();
  }
}
