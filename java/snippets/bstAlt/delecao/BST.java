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

    this.initialize();
  }

  public void deletar(Integer chave) {
    Node no = this.raiz;

    if (no != null) {
      this.walk(null, no);
    }

    while (no != null && no.chave != chave) {
      if (chave < no.chave) {
        this.walk(no, no.esquerda);

        no = no.esquerda;
      } else if (chave > no.chave) {
        this.walk(no, no.direita);

        no = no.direita;
      }
    }

    if (no == null) {
      return;
    }

    this.markDelete(no);

    if (no.esquerda == null) {
      if (no.direita != null) {
        this.walk(no, no.direita);
        this.found(no.direita);
      }

      this.subtituirFilho(no.pai, no, no.direita);

      this.delete(no);

      if (no.direita != null) {
        this.exitFound();
      }
    } else if (no.direita == null) {
      if (no.esquerda != null) {
        this.walk(no, no.esquerda);
        this.found(no.esquerda);
      }

      this.subtituirFilho(no.pai, no, no.esquerda);

      this.delete(no);

      if (no.esquerda != null) {
        this.exitFound();
      }
    } else {
      this.substituirQuandoDoisFilhos(no);
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

  public void inserir(Integer chave) {
    Node pai = null;
    Node filho = this.raiz;

    while (filho != null && filho.chave != chave) {
      this.walk(pai, filho);

      pai = filho;

      if (chave < filho.chave) {
        if (filho.esquerda == null || filho.esquerda.chave == chave) {
          this.walk(filho, null);
        }

        filho = filho.esquerda;
      } else if (chave > filho.chave) {
        if (filho.direita == null || filho.direita.chave == chave) {
          this.walk(filho, null);
        }

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

  private void inserirAEsquerda(Node pai, Integer chave) {
    pai.esquerda = new Node(chave);
    pai.esquerda.pai = pai;

    this.insert(pai.esquerda);
    this.walk(pai.esquerda, null);
  }

  private void inserirADireita(Node pai, Integer chave) {
    pai.direita = new Node(chave);
    pai.direita.pai = pai;

    this.insert(pai.direita);
    this.walk(pai.direita, null);
  }

  private void inserirNaRaiz(Integer chave) {
    this.raiz = new Node(chave);

    this.insert(this.raiz);
    this.walk(this.raiz, null);
  }

  private void update(Node no, int novoValor) {
    System.out.print("subject");
    System.out.print("/");
    System.out.print(
        "{ " +
            "\"structure\": \"" + System.identityHashCode(this) + "\", " +
            "\"address\": \"" + System.identityHashCode(no) + "\", " +
            "\"old\": " + no.chave + ", " +
            "\"new\": " + novoValor + ", " +
            "\"operation\": \"update\" " +
            "}");
    System.out.print("\n");
  }

  private void delete(Node no) {
    System.out.print("subject");
    System.out.print("/");
    System.out.print(
        "{ " +
            "\"structure\": \"" + System.identityHashCode(this) + "\", " +
            "\"address\": \"" + (no != null ? System.identityHashCode(no) : null) + "\", " +
            "\"value\": " + (no != null ? no.chave : null) + ", " +
            "\"operation\": \"delete\" " +
            "}");
    System.out.print("\n");
  }

  private void markDelete(Node no) {
    System.out.print("subject");
    System.out.print("/");
    System.out.print(
        "{ " +
            "\"structure\": \"" + System.identityHashCode(this) + "\", " +
            "\"address\": \"" + (no != null ? System.identityHashCode(no) : null) + "\", " +
            "\"value\": " + (no != null ? no.chave : null) + ", " +
            "\"operation\": \"markDelete\" " +
            "}");
    System.out.print("\n");
  }

  private void insert(Node no) {
    System.out.print("subject");
    System.out.print("/");
    System.out.print(
        "{ " +
            "\"structure\": \"" + System.identityHashCode(this) + "\", " +
            "\"address\": \"" + (no != null ? System.identityHashCode(no) : null) + "\", " +
            "\"value\": " + (no != null ? no.chave : null) + ", " +
            "\"operation\": \"insert\" " +
            "}");
    System.out.print("\n");
  }

  private void found(Node node) {
    System.out.print("subject");
    System.out.print("/");
    System.out.print(
        "{ " +
            "\"structure\": \"" + System.identityHashCode(this) + "\", " +
            "\"address\": \"" + (node != null ? System.identityHashCode(node) : null) + "\", " +
            "\"value\": " + (node != null ? node.chave : null) + ", " +
            "\"operation\": \"found\" " +
            "}");
    System.out.print("\n");
  }

  private void exitFound() {
    System.out.print("subject");
    System.out.print("/");
    System.out.print(
        "{ " +
            "\"structure\": \"" + System.identityHashCode(this) + "\", " +
            "\"operation\": \"exitFound\" " +
            "}");
    System.out.print("\n");
  }

  private void walk(Node origin, Node destiny) {
    System.out.print("subject");
    System.out.print("/");
    System.out.print(
        "{ " +
            "\"structure\": \"" + System.identityHashCode(this) + "\", " +
            "\"origin\": " + (origin != null ? origin.chave : null) + ", " +
            "\"destiny\": " + (destiny != null ? destiny.chave : null) + ", " +
            "\"operation\": \"walk\" " +
            "}");
    System.out.print("\n");
  }

  private void initialize() {
    System.out.print("subject");
    System.out.print("/");
    System.out.print(
        "{ " +
            "\"address\": \"" + System.identityHashCode(this) + "\", " +
            "\"operation\": \"initialize\" " +
            "}");
    System.out.print("\n");
  }
}
