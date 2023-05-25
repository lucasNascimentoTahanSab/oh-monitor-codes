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

    public Integer obterChave() {
      return this.chave;
    }

    public Node obterNoEsquerda() {
      return this.esquerda;
    }

    public Node obterNoDireita() {
      return this.direita;
    }

    public Node obterNoPai() {
      return this.pai;
    }
  }

  public Node raiz;

  public BST() {
    this.raiz = null;
  }

  /**
   * Método responsável pela inserção de uma nova chave em BST
   * a partir da raiz.
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

    if (pai == null) {
      this.inserirNaRaiz(chave);
    } else if (chave < pai.chave) {
      this.inserirAEsquerda(pai, chave);
    } else if (chave > pai.chave) {
      this.inserirADireita(pai, chave);
    }
  }

  /**
   * Método responsável por, ao inserir nó à esquerda do pai,
   * vincular este nó ao pai.
   */
  private void inserirAEsquerda(Node pai, Integer chave) {
    pai.esquerda = new Node(chave);
    pai.esquerda.pai = pai;
  }

  /**
   * Método responsável por, ao inserir nó à direita do pai,
   * vincular este nó ao pai.
   */
  private void inserirADireita(Node pai, Integer chave) {
    pai.direita = new Node(chave);
    pai.direita.pai = pai;
  }

  private void inserirNaRaiz(Integer chave) {
    this.raiz = new Node(chave);
  }
}
