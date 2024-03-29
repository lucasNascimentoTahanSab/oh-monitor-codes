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

      if (filho.esquerda != null) {
        this.walk(filho.esquerda, filho);
      }
    } else if (chave > filho.chave) {
      filho.direita = this.deletar(filho, filho.direita, chave);

      if (filho.direita != null) {
        this.walk(filho.direita, filho);
      }
    } else {
      this.markDelete(filho);

      if (filho.esquerda == null) {
        if (filho.direita != null) {
          this.walk(filho, filho.direita);
          this.found(filho.direita);
        }

        this.delete(filho);

        if (filho.direita != null) {
          this.exitFound();
        }

        return filho.direita;
      }

      if (filho.direita == null) {
        if (filho.esquerda != null) {
          this.walk(filho, filho.esquerda);
          this.found(filho.esquerda);
        }

        this.delete(filho);

        if (filho.esquerda != null) {
          this.exitFound();
        }

        return filho.esquerda;
      }

      this.walk(filho, filho.direita);

      Node substituto = this.minimo(filho, filho.direita);

      this.walk(substituto, filho);
      this.update(filho, substituto.chave);
      this.exitFound();

      filho.chave = substituto.chave;
      filho.direita = this.deletar(filho, filho.direita, filho.chave);

      if (filho.direita != null) {
        this.walk(filho.direita, filho);
      }
    }

    return filho;
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
