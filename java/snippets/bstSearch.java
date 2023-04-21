public Node search(Integer data)
{
  Node current = root;
  System.out.println("Elementos visitados: ");

  while (current.data != data)
  {
    if (current != null)
    {
      System.out.println("%d ", current.data);

      // vá para a subárvore da esquerda
      if (current.data > data)
      {
        current = current.leftChild;
      } // senão, vá para a subárvore da direita
      else
      {
        current = current.rightChild;
      } // não encontrado

      if (current == null)
      {
        return null;
      }
    }
  }

  return current;
}