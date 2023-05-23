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

    public void imprimirChave() {
      System.out.println(this.chave);
    }

    public Node obterNoEsquerda() {
      return this.esquerda;
    }

    public Node obterNoDireita() {
      return this.direita;
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

  /**
   * Método responsável pela obtenção do nó de menor chave na
   * BST.
   */
  public Node minimo() {
    return this.minimo(this.raiz);
  }

  /**
   * Método responsável por percorrer recursivamente a BST em busca
   * do nó de menor chave.
   */
  private Node minimo(Node no) {
    if (no == null) { // Quando nó nulo,
      return no; // retorne nulo.
    }

    if (no.esquerda != null) { // Quando houver nó à esquerda,
      return this.minimo(no.esquerda); // busque à esquerda.
    }

    return no; // Nó encontrado.
  }
}
