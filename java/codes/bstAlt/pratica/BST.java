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

    this.initialize();
  }

  public void inserir(Integer chave) {
    this.raiz = this.inserir(null, this.raiz, chave);

    this.walk(this.raiz, null);
  }

  private Node inserir(Node pai, Node filho, Integer chave) {
    if (filho == null) {
      if (pai != null) {
        this.walk(pai, null);
      }

      filho = new Node(chave);

      this.insert(filho);

      return filho;
    }

    this.walk(pai, filho);

    if (chave < filho.chave) {
      filho.esquerda = this.inserir(filho, filho.esquerda, chave);

      this.walk(filho.esquerda, filho);
    } else if (chave > filho.chave) {
      filho.direita = this.inserir(filho, filho.direita, chave);

      this.walk(filho.direita, filho);
    }

    return filho;
  }

  public void deletar(Integer chave) {
    this.raiz = this.deletar(null, this.raiz, chave);

    if (this.raiz != null) {
      this.walk(this.raiz, null);
    }
  }

  private Node deletar(Node pai, Node filho, Integer chave) {
    if (filho == null) {
      return filho;
    }

    this.walk(pai, filho);

    if (chave < filho.chave) {
      filho.esquerda = this.deletar(filho, filho.esquerda, chave);

      this.walk(filho.esquerda, filho);
    } else if (chave > filho.chave) {
      filho.direita = this.deletar(filho, filho.direita, chave);

      this.walk(filho.direita, filho);
    } else {
      this.markDelete(filho);

      if (filho.esquerda == null) {
        this.walk(filho, filho.direita);

        if (filho.direita != null) {
          this.found(filho.direita);
          this.delete(filho);
          this.exitFound();
        } else {
          this.delete(filho);
        }

        return filho.direita;
      }

      if (filho.direita == null) {
        this.walk(filho, filho.esquerda);

        if (filho.esquerda != null) {
          this.found(filho.esquerda);
          this.delete(filho);
          this.exitFound();
        } else {
          this.delete(filho);
        }

        return filho.esquerda;
      }

      this.walk(filho, filho.direita);

      Node substituto = this.minimo(filho, filho.direita);

      this.found(substituto);
      this.exitFound();
      this.walk(substituto, null);
      this.update(filho, substituto.chave);

      filho.chave = substituto.chave;
      filho.direita = this.deletar(filho, filho.direita, filho.chave);

      if (filho.direita != null) {
        this.walk(filho.direita, filho);
      }
    }

    return filho;
  }

  public Node buscar(Integer chave) {
    return this.buscar(null, this.raiz, chave);
  }

  private Node buscar(Node pai, Node no, Integer chave) {
    if (no == null) {
      this.walk(no, pai);

      return no;
    }

    this.walk(pai, no);

    if (chave < no.chave) {
      Node filho = this.buscar(no, no.esquerda, chave);

      this.walk(no, pai);

      return filho;
    } else if (chave > no.chave) {
      Node filho = this.buscar(no, no.direita, chave);

      this.walk(no, pai);

      return filho;
    }

    this.found(no);
    this.exitFound();

    this.walk(no, pai);

    return no;
  }

  public Node minimo() {
    Node noMinimo = this.minimo(null, this.raiz);

    this.exitFound();

    return noMinimo;
  }

  private Node minimo(Node pai, Node no) {
    if (no == null) {
      return no;
    }

    this.walk(pai, no);

    if (no.esquerda != null) {
      Node noMinimo = this.minimo(no, no.esquerda);

      this.walk(no, pai);

      return noMinimo;
    }

    this.found(no);
    this.walk(no, pai);

    return no;
  }

  public Node maximo() {
    Node noMaximo = this.maximo(null, this.raiz);

    this.exitFound();

    return noMaximo;
  }

  private Node maximo(Node pai, Node no) {
    if (no == null) {
      return no;
    }

    this.walk(pai, no);

    if (no.direita != null) {
      Node noMaximo = this.maximo(no, no.direita);

      this.walk(no, pai);

      return noMaximo;
    }

    this.found(no);
    this.walk(no, pai);

    return no;
  }

  public void imprimirInOrdem() {
    if (this.raiz == null) {
      return;
    }

    this.walk(null, this.raiz);

    this.imprimirInOrdem(null, this.raiz);

    this.exitFound();
  }

  private void imprimirInOrdem(Node pai, Node no) {
    if (no == null) {
      return;
    }

    this.walk(no, no.esquerda);

    this.imprimirInOrdem(no, no.esquerda);

    System.out.print(no.chave + " ");

    this.found(no);
    this.walk(no, no.direita);

    this.imprimirInOrdem(no, no.direita);

    this.walk(no, pai);
  }

  public void imprimirPreOrdem() {
    if (this.raiz == null) {
      return;
    }

    this.walk(null, this.raiz);

    this.imprimirPreOrdem(null, this.raiz);

    this.exitFound();
  }

  private void imprimirPreOrdem(Node pai, Node no) {
    if (no == null) {
      return;
    }

    System.out.print(no.chave + " ");

    this.found(no);
    this.walk(no, no.esquerda);

    this.imprimirPreOrdem(no, no.esquerda);

    this.walk(no, no.direita);

    this.imprimirPreOrdem(no, no.direita);

    this.walk(no, pai);
  }

  public void imprimirPosOrdem() {
    if (this.raiz == null) {
      return;
    }

    this.walk(null, this.raiz);

    this.imprimirPosOrdem(null, this.raiz);

    this.exitFound();
  }

  private void imprimirPosOrdem(Node pai, Node no) {
    if (no == null) {
      return;
    }

    this.walk(no, no.esquerda);

    this.imprimirPosOrdem(no, no.esquerda);

    this.walk(no, no.direita);

    this.imprimirPosOrdem(no, no.direita);

    System.out.print(no.chave + " ");

    this.found(no);
    this.walk(no, pai);
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

  private void insert(Node node) {
    System.out.print("subject");
    System.out.print("/");
    System.out.print(
        "{ " +
            "\"structure\": \"" + System.identityHashCode(this) + "\", " +
            "\"address\": \"" + (node != null ? System.identityHashCode(node) : null) + "\", " +
            "\"value\": " + (node != null ? node.chave : null) + ", " +
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
            "\"originAddress\": " + (origin != null ? "\"" + System.identityHashCode(origin) + "\"" : null) + ", " +
            "\"origin\": " + (origin != null ? origin.chave : null) + ", " +
            "\"destinyAddress\": " + (destiny != null ? "\"" + System.identityHashCode(destiny) + "\"" : null) + ", " +
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
