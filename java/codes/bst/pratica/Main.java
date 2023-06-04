public class Main {
  /**
   * Método responsável pela montagem das prioridades recebidas como entrada
   * em BST.
   */
  private static BST obterPrioridadesOrdenadas(String[] args) {
    BST prioridades = new BST();

    for (String arg : args) {
      prioridades.inserir(Integer.valueOf(arg));
    }

    return prioridades;
  }

  public static void main(String[] args) {
    BST prioridades = obterPrioridadesOrdenadas(args);

    prioridades.imprimirInOrdem();

    // Sua solução vem aqui!
  }
}
