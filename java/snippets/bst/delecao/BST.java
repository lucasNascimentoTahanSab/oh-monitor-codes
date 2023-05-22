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
  }

  /**
   * Método responsável pela inserção de uma nova chave em
   * árvore binária de busca a partir da raiz.
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

    if (pai == null) { // Quando o pai for nulo,
      this.raiz = new Node(chave); // insira na raiz.
    } else if (chave < pai.chave) { // Quando for menor que o pai,
      pai.direita = new Node(chave); // insira à esquerda.
      pai.direita.pai = pai;
    } else if (chave > pai.chave) { // Quando for maior que o pai,
      pai.esquerda = new Node(chave); // insira à esquerda.
      pai.esquerda.pai = pai;
    }
  }

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
      this.transplantar(no, no.direita); // assuma o filho à direita.
    } else if (no.direita == null) { // Quando não houver filho à direita,
      this.transplantar(no, no.esquerda); // assuma o filho à esquerda.
    } else { // Quando houverem ambos os filhos,
      Node substituto = this.minimo(no.direita); // assuma o menor à direita.

      if (substituto.pai != no) { // Atribua a direita do nó ao nó substituto, caso não seja filho direto do nó.
        this.transplantar(substituto, substituto.direita);

        substituto.direita = no.direita;
        substituto.direita.pai = substituto;
      }

      this.transplantar(no, substituto); // Atribua a esquerda do nó ao nó substituto.

      substituto.esquerda = no.esquerda;
      substituto.esquerda.pai = substituto;
    }
  }

  /**
   * Método responsável pela obtenção do nó de menor chave a partir do nó
   * recebido.
   */
  public Node minimo(Node no) {
    while (no.esquerda != null) {
      no = no.esquerda;
    }

    return no;
  }

  /**
   * Método responsável por atribuir ao segundo nó recebido a posição do
   * primeiro nó, vinculando o pai do primeiro nó ao segundo, desvinculando-o
   * do primeiro.
   */
  public void transplantar(Node primeiroNo, Node segundoNo) {
    if (primeiroNo.pai == null) { // Quando não houver pai,
      this.raiz = segundoNo; // insira na raiz.
    } else if (primeiroNo.pai.esquerda == primeiroNo) { // Quando o primeiro nó for o filho à esquerda,
      primeiroNo.pai.esquerda = segundoNo; // insira o segundo nó à esquerda.
    } else { // Quando o primeiro nó for o filho à direita,
      primeiroNo.pai.direita = segundoNo; // insira o segundo nó à direita.
    }

    if (segundoNo != null) { // Se o segundo nó não for nulo,
      segundoNo.pai = primeiroNo.pai; // vincule-o ao pai do primeiro nó.
    }
  }
}
