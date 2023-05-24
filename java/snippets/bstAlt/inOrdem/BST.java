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
      System.out.println("subject-output/" + this.chave);
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

    this.initialize();
  }

  public void inserir(Integer chave) {
    this.raiz = inserir(null, this.raiz, chave);

    this.walk(this.raiz, null);
  }

  private Node inserir(Node pai, Node filho, Integer chave) {
    if (filho == null) {
      if (pai != null) { this.walk(pai, null); }

      filho = new Node(chave);

      this.insert(filho);

      return filho;
    }

    this.walk(pai, filho);

    if (chave < filho.chave) {
      filho.esquerda = inserir(filho, filho.esquerda, chave);

      this.walk(filho.esquerda, filho);
    } else if (chave > filho.chave) {
      filho.direita = inserir(filho, filho.direita, chave);

      this.walk(filho.direita, filho);
    }

    return filho;
  }

  public void imprimirInOrdem() {
    this.imprimirInOrdem(null, this.raiz);
  }

  private void imprimirInOrdem(Node pai, Node no) {
    if (no == null) {
      return;
    }

    walk(pai, no);

    this.imprimirInOrdem(no, no.esquerda);

    no.imprimirChave();

    walk(null, no.direita);

    this.imprimirInOrdem(no, no.direita);
  }

  void insert(Node node) {
    System.out.print("subject");
    System.out.print("/");
    System.out.print(
      "{ " +
        "\"structure\": \"" + System.identityHashCode(this) + "\", " +
        "\"address\": \"" + (node != null ? System.identityHashCode(node) : null) + "\", " +
        "\"value\": " + (node != null ? node.chave : null) + ", " +
        "\"operation\": \"insert\" " +
      "}"
    );
    System.out.print("\n");
  }

  void walk(Node origin, Node destiny) {
    System.out.print("subject");
    System.out.print("/");
    System.out.print(
      "{ " +
        "\"structure\": \"" + System.identityHashCode(this) + "\", " +
        "\"origin\": " + (origin != null ? origin.chave : null) + ", " +
        "\"destiny\": " + (destiny != null ? destiny.chave : null) + ", " +
        "\"operation\": \"walk\" " +
      "}"
    );
    System.out.print("\n");
  }

  private void initialize() {
    System.out.print("subject");
    System.out.print("/");
    System.out.print(
      "{ " +
        "\"address\": \"" + System.identityHashCode(this) + "\", " +
        "\"operation\": \"initialize\" " +
      "}"
    );
    System.out.print("\n");
  }
}