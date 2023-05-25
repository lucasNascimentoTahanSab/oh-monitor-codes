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
   * Método responsável pela obtenção do nó com a chave procurada.
   */
  public Node buscar(Integer chave) {
    return this.buscar(this.raiz, chave);
  }

  /**
   * Método responsável por caminhar pela BST recursivamente em
   * busca da chave recebida.
   */
  private Node buscar(Node no, Integer chave) {
    if (no == null) { // Quando nó nulo,
      return no; // retorne nulo.
    }

    if (chave < no.chave) { // Quando menor que o nó atual,
      return this.buscar(no.esquerda, chave); // busque à esquerda.
    } else if (chave > no.chave) { // Quando maior que o nó atual,
      return this.buscar(no.direita, chave); // busque à direita.
    }

    return no; // Nó encontrado.
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
