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
  }

  private Node raiz;

  public BST() {
    this.raiz = null;

    this.initialize();
  }

  public void inserir(Integer chave) {
    Node pai = null;
    Node filho = this.raiz;

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
    } else if (chave > pai.chave) {
      this.inserirADireita(chave, pai);
    }
  }

  private void inserirADireita(Integer chave, Node no) {
    this.walk(no, null);

    no.direita = new Node(chave);
    no.direita.pai = no;

    this.insert(no.direita);
    this.walk(no.direita, null);
  }

  private void inserirAEsquerda(Integer chave, Node no) {
    this.walk(no, null);

    no.esquerda = new Node(chave);
    no.esquerda.pai = no;

    this.insert(no.esquerda);
    this.walk(no.esquerda, null);
  }

  private void inserirNaRaiz(Integer chave) {
    this.raiz = new Node(chave);

    this.insert(this.raiz);
    this.walk(this.raiz, null);
  }

  public void deletar(Integer chave) {
    Node no = this.raiz;

    while (no != null && no.chave != chave) {
      walk(no.pai, no);

      if (chave < no.chave) {
        walk(no, no.esquerda);

        no = no.esquerda;
      } else if (chave > no.chave) {
        walk(no, no.direita);

        no = no.direita;
      }
    }

    if (no == null) {
      return;
    }

    if (no.esquerda == null) {
      if (no.direita != null) { walk(no, no.direita); }

      this.transplantar(no, no.direita);

      if (no.direita != null) { walk(no.direita, null); }

      delete(no);
    } else if (no.direita == null) {
      if (no.esquerda != null) { walk(no, no.esquerda); }
      
      this.transplantar(no, no.esquerda);

      if (no.esquerda != null) { walk(no.esquerda, no); }

      delete(no);
    } else {
      walk(no, no.direita);

      Node substituto = this.minimo(no.direita);

      if (substituto.pai != no) {
        if (substituto.direita != null) { walk(substituto, substituto.direita); }

        this.transplantar(substituto, substituto.direita);

        if (substituto.direita != null) { 
          walk(substituto.direita, substituto); 
          update(substituto, substituto.direita.chave);
          delete(substituto.direita);
        }

        substituto.direita = no.direita;
        substituto.direita.pai = substituto;
      }

      this.transplantar(no, substituto);
      
      walk(substituto, no);
      update(no, substituto.chave);
      delete(substituto);

      substituto.esquerda = no.esquerda;
      substituto.esquerda.pai = substituto;
    }
  }

  public Node minimo(Node no) {
    while (no.esquerda != null) {
      walk(no, no.esquerda);

      no = no.esquerda;
    }

    return no;
  }

  public void transplantar(Node primeiroNo, Node segundoNo) {
    if (primeiroNo.pai == null) {
      this.raiz = segundoNo;
    } else if (primeiroNo.pai.esquerda == primeiroNo) {
      primeiroNo.pai.esquerda = segundoNo;
    } else {
      primeiroNo.pai.direita = segundoNo;
    }

    if (segundoNo != null) {
      segundoNo.pai = primeiroNo.pai;
    }
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
