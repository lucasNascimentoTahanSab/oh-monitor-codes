public class BST {
  public class Node {
    private Integer chave;
    private Node esquerda;
    private Node direita;

    private Node(Integer chave) {
      this.chave = chave;
    }
  }

  private Node raiz;

  public BST() {
    this.raiz = null;
  }

  /**
   * Método responsável pela inserção de uma nova chave em
   * árvore binária de busca a partir da raiz.
   */
  public void inserir(Integer chave) {
    Node pai = null;
    Node filho = raiz;

    while (filho != null) {
      pai = filho;

      if (chave < filho.chave) {
        filho = filho.esquerda;
      } else if (chave > filho.chave) {
        filho = filho.direita;
      }
    }

    if (pai == null) {
      this.raiz = new Node(chave);
    } else if (chave < pai.chave) {
      pai.direita = new Node(chave);
    } else {
      pai.esquerda = new Node(chave);
    }
  }
}
