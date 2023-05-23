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

  public void inserir(Integer chave) {
    this.raiz = inserir(this.raiz, chave);
  }

  private Node inserir(Node no, Integer chave) {
    if (no == null) {
      return new Node(chave);
    }

    if (chave < no.chave) {
      no.esquerda = inserir(no.esquerda, chave);
    } else if (chave > no.chave) {
      no.direita = inserir(no.direita, chave);
    }

    return no;
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

      walk(no.esquerda, no);
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
