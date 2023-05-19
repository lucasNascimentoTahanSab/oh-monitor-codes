public class BST {
  public class Node {
    private Integer chave;
    private Node esquerda;
    private Node direita;

    private Node(Integer chave) {
      this.chave = chave;
    }
  }

  private Node raiz;

  public BST() {
    this.raiz = null;

    this.initialize();
  }

  public void inserir(Integer chave) {
    Node pai = null;
    Node filho = raiz;

    while (filho != null) {
      walk(pai, filho);

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
      this.inserirAEsquerda(chave, pai);
    } else {
      this.inserirADireita(chave, pai);
    }
  }

  private void inserirADireita(Integer chave, Node no) {
    this.walk(no, null);

    no.direita = new Node(chave);
    
    this.insert(no.direita);
    this.walk(no.direita, null);
  }

  private void inserirAEsquerda(Integer chave, Node no) {
    this.walk(no, null);

    no.esquerda = new Node(chave);
    
    this.insert(no.esquerda);
    this.walk(no.esquerda, null);
  }

  private void inserirNaRaiz(Integer chave) {
    raiz = new Node(chave);
    
    this.insert(this.raiz);
    this.walk(this.raiz, null);
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
