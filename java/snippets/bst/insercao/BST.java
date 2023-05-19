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
   * árvore binária de busca.
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
      this.inserirNaRaiz(chave);
    } else if (chave < pai.chave) {
      this.inserirAEsquerda(chave, pai);
    } else {
      this.inserirADireita(chave, pai);
    }
  }

  /**
   * Método responsável pela inserção de uma nova chave à
   * direita do nó recebido.
   */
  private Node inserirADireita(Integer chave, Node no) {
    no.direita = new Node(chave);

    return no.direita;
  }

  /**
   * Método responsável pela inserção de uma nova chave à
   * esquerda do nó recebido.
   */
  private Node inserirAEsquerda(Integer chave, Node no) {
    no.esquerda = new Node(chave);

    return no.esquerda;
  }

  /**
   * Método responsável pela inserção de uma nova chave na
   * raiz da árvore.
   */
  private Node inserirNaRaiz(Integer chave) {
    raiz = new Node(chave);

    return raiz;
  }
}
