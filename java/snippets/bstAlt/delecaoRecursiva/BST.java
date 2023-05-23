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

  public void deletar(Integer chave) {
    this.raiz = this.deletar(this.raiz, this.raiz, chave);

    walk(this.raiz, null);
  }

  public Node deletar(Node pai, Node no, Integer chave) {
    if (no == null) {
      return no;
    }

    walk(pai, no);

    if (chave < no.chave) {
      no.esquerda = this.deletar(no, no.esquerda, chave);

      walk(no.esquerda, no);
    } else if (chave > no.chave) {
      no.direita = this.deletar(no, no.direita, chave);

      walk(no.direita, no);
    } else {
      if (no.esquerda == null) {
        walk(no, no.direita);
        delete(no);

        return no.direita; 
      }

      if (no.direita == null) { 
        walk(no, no.esquerda);
        delete(no);

        return no.esquerda;
      }

      walk(no, no.direita);

      Node substituto = this.minimo(no.direita);

      update(no, substituto.chave);

      no.chave = substituto.chave;
      no.direita = this.deletar(no, no.direita, no.chave);

      walk(no.direita, no);
    }

    return no;
  }

  public Node minimo(Node no) {
    while (no.esquerda != null) {
      walk(no, no.esquerda);

      no = no.esquerda;
    }

    return no;
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
      "}"
    );
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
      "}"
    );
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
      "}"
    );
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
