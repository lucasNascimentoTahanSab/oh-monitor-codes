public class Main {
  public static void main(String[] args) {
    BST bst = new BST();

    bst.inserir(25);
    bst.inserir(15);
    bst.inserir(16);
    bst.inserir(28);
    bst.inserir(27);
    bst.inserir(32);

    BST.Node no = bst.buscar(28); // Obtenção do nó de chave 28.

    System.out.println(no.obterChave()); // Impressão da chave do nó recuperado.
    System.out.println(no.obterNoEsquerda().obterChave()); // Impressão da chave do nó à esquerda do nó recuperado.
    System.out.println(no.obterNoDireita().obterChave()); // Impressão da chave do nó à direita do nó recuperado.
  }
}
