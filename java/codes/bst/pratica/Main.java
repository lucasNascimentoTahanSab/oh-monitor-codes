import java.util.Scanner;

public class Main {
  private static Scanner scanner = new Scanner(System.in);

  /**
   * Método responsável pela montagem das prioridades recebidas como entrada
   * em BST.
   */
  private static BST obterPrioridadesOrdenadas() {
    BST prioridades = new BST();

    while (scanner.hasNextLine()) {
      prioridades.inserir(Integer.valueOf(scanner.nextLine()));
    }

    return prioridades;
  }

  public static void main(String[] args) {
    BST prioridades = obterPrioridadesOrdenadas();

    prioridades.imprimirInOrdem();

    // Sua solução vem aqui!
  }
}
