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
   * Método responsável pela deleção da chave recebida em
   * árvore binária de busca a partir da raiz.
   */
  public void deletar(Integer chave) {
    this.raiz = this.deletar(this.raiz, chave);
  }

  /**
   * Método responsável por caminhar recursivamente pela BST
   * para remoção da chave recebida.
   */
  public Node deletar(Node no, Integer chave) {
    if (no == null) { // Quando chave não encontrada,
      return no; // retorne.
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
   * Método responsável pela obtenção do nó de menor chave a partir do nó
   * recebido.
   */
  public Node minimo(Node no) {
    while (no.esquerda != null) {
      no = no.esquerda;
    }

    return no;
  }
}
