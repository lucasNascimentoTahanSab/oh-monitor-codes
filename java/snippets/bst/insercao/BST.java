public class BST {
  public class Node {
    private Integer chave;
    private Node esquerda;
    private Node direita;
    private Node pai;

    private Node(Integer chave) {
      this.chave = chave;
      this.esquerda = null;
      this.direita = null;
      this.pai = null;
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
    Node filho = this.raiz;

    while (filho != null) {
      pai = filho;

      if (chave < filho.chave) {
        filho = filho.esquerda;
      } else if (chave > filho.chave) {
        filho = filho.direita;
      }
    }

    if (pai == null) { // Quando o pai for nulo,
      this.raiz = new Node(chave); // insira na raiz.
    } else if (chave < pai.chave) { // Quando for menor que o pai,
      pai.direita = new Node(chave); // insira à esquerda.
      pai.direita.pai = pai;
    } else if (chave > pai.chave) { // Quando for maior que o pai,
      pai.esquerda = new Node(chave); // insira à esquerda.
      pai.esquerda.pai = pai;
    }
  }
}
