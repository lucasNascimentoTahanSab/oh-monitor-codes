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
   * Método responsável pela deleção de um nó a partir da chave
   * recebida.
   */
  public void deletar(Integer chave) {
    Node no = this.raiz;

    while (no != null && no.chave != chave) {
      if (chave < no.chave) {
        no = no.esquerda;
      } else if (chave > no.chave) {
        no = no.direita;
      }
    }

    if (no == null) {
      return;
    }

    if (no.esquerda == null) { // Quando não houver filho à esquerda,
      this.subtituirFilho(no.pai, no, no.direita); // assuma o filho à direita.
    } else if (no.direita == null) { // Quando não houver filho à direita,
      this.subtituirFilho(no.pai, no, no.esquerda); // assuma o filho à esquerda.
    } else { // Quando houverem ambos os filhos,
      this.substituirQuandoDoisFilhos(no); // assuma o menor à direita.
    }
  }

  /**
   * Método responsável por substituir o nó recebido pelo nó de
   * menor chave à direita.
   */
  private void substituirQuandoDoisFilhos(Node no) {
    Node substituto = this.minimo(no.direita);

    this.substituir(no, substituto);
  }

  /**
   * Método responsável por substituir o nó recebido pelo substituto,
   * realizando as trocas dos pais e filhos.
   */
  private void substituir(Node no, Node substituto) {
    if (substituto.pai != no) { // Quando pai do substituto não for o nó,
      this.subtituirFilho(substituto.pai, substituto, substituto.direita); // pai do substituto recebe filho à direita
      this.substituirPaiADireita(no, substituto); // e substituto recebe filho à direita do nó.
    }

    this.subtituirFilho(no.pai, no, substituto); // pai do nó recebe substituto
    this.substituirPaiAEsquerda(no, substituto); // e substituto recebe filho à esquerda do nó.
  }

  /**
   * Método responsável por atribuir filho à esquerda do nó ao
   * substituto.
   */
  private void substituirPaiAEsquerda(Node no, Node substituto) {
    no.esquerda.pai = substituto;
    substituto.esquerda = no.esquerda;
  }

  /**
   * Método responsável por atribuir filho à direita do nó ao
   * substituto.
   */
  private void substituirPaiADireita(Node no, Node substituto) {
    no.direita.pai = substituto;
    substituto.direita = no.direita;
  }

  /**
   * Método responsável pela obtenção do nó de menor chave a partir
   * do nó recebido.
   */
  public Node minimo(Node no) {
    while (no.esquerda != null) {
      no = no.esquerda;
    }

    return no;
  }

  /**
   * Método responsável por trocar o filho do pai pelo substituto
   * recebido em processo de remoção do filho.
   */
  private void subtituirFilho(Node pai, Node filho, Node substituto) {
    if (pai == null) { // Quando não houver pai,
      this.substituirFilhoNaRaiz(substituto);
    } else if (pai.esquerda == filho) { // quando o filho estiver à esquerda,
      this.substituirFilhoAEsquerda(pai, substituto);
    } else if (pai.direita == filho) { // quando o filho estiver à direita.
      this.substituirFilhoADireita(pai, substituto);
    }
  }

  /**
   * Método responsável por transplante à direita do pai quando
   * nó filho original estiver à direita.
   */
  private void substituirFilhoADireita(Node pai, Node no) {
    pai.direita = no;

    if (no != null) {
      no.pai = pai;
    }
  }

  /**
   * Método responsável por transplante à esquerda do pai quando
   * nó filho original estiver à esquerda.
   */
  private void substituirFilhoAEsquerda(Node pai, Node no) {
    pai.esquerda = no;

    if (no != null) {
      no.pai = pai;
    }
  }

  /**
   * Método responsável por transplante em raiz quando não houver
   * nó pai.
   */
  private void substituirFilhoNaRaiz(Node no) {
    this.raiz = no;
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
