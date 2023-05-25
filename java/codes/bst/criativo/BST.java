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

  /**
   * Método responsável pela deleção de um nó a partir da chave
   * recebida.
   */
  public void deletar(Integer chave) {
    this.raiz = this.deletar(this.raiz, chave);
  }

  /**
   * Método responsável por caminhar recursivamente pela BST
   * para a remoção da chave recebida.
   */
  private Node deletar(Node no, Integer chave) {
    if (no == null) { // Quando chave não encontrada,
      return no; // retorne nulo.
    }

    if (chave < no.chave) { // Quando chave menor que a chave do nó atual,
      no.esquerda = this.deletar(no.esquerda, chave); // caminhe para a esquerda.
    } else if (chave > no.chave) { // Quando chave maior que a chave do nó atual,
      no.direita = this.deletar(no.direita, chave); // caminhe para a direita.
    } else { // Quando encontrada a chave,
      if (no.esquerda == null) { // se não houver filho à esquerda,
        return no.direita; // assuma o filho à direita,
      }

      if (no.direita == null) { // se não houver filho à direita,
        return no.esquerda; // assuma o filho à esquerda.
      }

      // Quando houverem ambos os filhos,

      Node substituto = this.minimo(no.direita); // assuma o menor à direita.

      no.chave = substituto.chave;
      no.direita = this.deletar(no.direita, no.chave); // Remova o menor à direita.
    }

    return no;
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

  /**
   * Método responsável pela obtenção do nó de maior chave na
   * BST.
   */
  public Node maximo() {
    return this.maximo(this.raiz);
  }

  /**
   * Método responsável por percorrer recursivamente a BST em busca
   * do nó de maior chave.
   */
  private Node maximo(Node no) {
    if (no == null) { // Quando nó nulo,
      return no; // retorne nulo.
    }

    if (no.direita != null) { // Quando houver nó à direita,
      return this.maximo(no.direita); // busque à direita.
    }

    return no; // Nó encontrado.
  }

  /**
   * Método responsável pela impressão do nós da BST em ordem
   * crescente.
   */
  public void imprimirInOrdem() {
    this.imprimirInOrdem(this.raiz);
  }

  /**
   * Método responsável por percorrer BST recursivamente para apresentação
   * dos nós em ordem crescente. Para ordem descrescente, bastaria inverter
   * as chamadas ao método, percorrendo primeiro à direita e depois à esquerda.
   */
  private void imprimirInOrdem(Node no) {
    if (no == null) { // Quando nó nulo,
      return; // retorne.
    }

    this.imprimirInOrdem(no.esquerda); // Percorra a BST à esquerda,

    System.out.print(no.chave + " "); // imprima a chave do último nó à esquerda ainda não impresso,

    this.imprimirInOrdem(no.direita); // percorra a BST à direita.
  }

  /**
   * Método responsável pela impressão do nós da BST em pré-ordem.
   */
  public void imprimirPreOrdem() {
    this.imprimirPreOrdem(this.raiz);
  }

  /**
   * Método responsável por percorrer BST recursivamente para apresentação
   * dos nós em pré-ordem crescente.
   */
  private void imprimirPreOrdem(Node no) {
    if (no == null) { // Quando nó nulo,
      return; // retorne.
    }

    System.out.print(no.chave + " "); // Imprima a chave do nó atual,

    this.imprimirPreOrdem(no.esquerda); // percorra a BST à esquerda,
    this.imprimirPreOrdem(no.direita); // percorra a BST à direita.
  }

  /**
   * Método responsável pela impressão do nós da BST em pré-ordem.
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
}
