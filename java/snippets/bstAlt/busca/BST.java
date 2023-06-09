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

    this.enterFound();
    this.found(no);
    this.exitFound();

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

  private void enterFound() {
    System.out.print("subject");
    System.out.print("/");
    System.out.print(
        "{ " +
            "\"structure\": \"" + System.identityHashCode(this) + "\", " +
            "\"operation\": \"enterFound\" " +
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
