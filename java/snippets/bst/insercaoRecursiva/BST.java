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
    this.raiz = inserir(this.raiz, chave);
  }

  /**
   * Método responsável por caminhar recursivamente pela BST
   * para a inserção de uma nova chave.
   */
  private Node inserir(Node no, Integer chave) {
    if (no == null) {
      return new Node(chave);
    }

    if (chave < no.chave) {
      no.esquerda = inserir(no.esquerda, chave);
    } else if (chave > no.chave) {
      no.direita = inserir(no.direita, chave);
    }

    return no;
  }
}
