public class BST {
  public class Node {
    private Integer chave;
    private Node esquerda;
    private Node direita;

    private Node(Integer chave) {
      this.chave = chave;
      this.esquerda = null;
      this.direita = null;
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
  }

  public Node raiz;

  public BST() {
    this.raiz = null;
  }

  /**
   * Método responsável pela impressão dos nós da BST em pré-ordem.
   */
  public void imprimirPosOrdem() {
    this.imprimirPosOrdem(this.raiz);
  }

  /**
   * Método responsável por percorrer BST recursivamente para apresentação
   * dos nós em pré-ordem.
   */
  private void imprimirPosOrdem(Node no) {
    if (no == null) { // Quando nó nulo,
      return; // retorne.
    }

    this.imprimirPosOrdem(no.esquerda); // Percorra a BST à esquerda,
    this.imprimirPosOrdem(no.direita); // percorra a BST à direita,

    System.out.print(no.chave + " "); // imprima a chave do nó atual.
  }

  /**
   * Método responsável pela inserção de uma nova chave em BST
   * a partir da raiz.
   */
  public void inserir(Integer chave) {
    this.raiz = inserir(this.raiz, chave);
  }

  /**
   * Método responsável por caminhar recursivamente pela BST
   * para a inserção de uma nova chave.
   */
  private Node inserir(Node no, Integer chave) {
    if (no == null) { // Quando nó nulo,
      return new Node(chave); // insira.
    }

    if (chave < no.chave) { // Quando menor que o nó atual,
      no.esquerda = inserir(no.esquerda, chave); // insira à esquerda.
    } else if (chave > no.chave) { // Quando maior que o nó atual,
      no.direita = inserir(no.direita, chave); // insira à direita.
    }

    return no;
  }
}
