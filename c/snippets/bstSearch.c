struct node *search(int data)
{
  struct node *current = root;
  printf("Elementos visitados: ");

  while (current->data != data)
  {
    if (current != NULL)
    {
      printf("%d ", current->data);

      // vá para a subárvore da esquerda
      if (current->data > data)
      {
        current = current->leftChild;
      } // senão, vá para a subárvore da direita
      else
      {
        current = current->rightChild;
      } // não encontrado

      if (current == NULL)
      {
        return NULL;
      }
    }
  }

  return current;
}