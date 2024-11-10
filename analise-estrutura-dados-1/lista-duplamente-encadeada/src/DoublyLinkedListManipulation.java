class DoublyLinkedListManipulation {

    public static boolean checkIfEqual(DoublyLinkedList<Integer> listaA, DoublyLinkedList<Integer> listaB) {
        // Verificar se as duas listas são iguais
        if (listaA.getSize() != listaB.getSize())
            return false;
        if (listaA.getSize() == 0 || listaB.getSize() == 0)
            return true;

        DoublyLinkedList.Item<Integer> itemA = listaA.getLista();
        DoublyLinkedList.Item<Integer> itemB = listaB.getLista();

        while (itemA != null) {
            if (itemA.elemento != itemB.elemento)
                return false;
            itemA = itemA.proximo;
            itemB = itemB.proximo;
        }

        return true;

    }

    public static DoublyLinkedList<Integer> mergeLists(DoublyLinkedList<Integer> listaA, DoublyLinkedList<Integer> listaB) {
        // Sejam duas listas A e B. Implemente o método para fazer o merge entre as duas
        // listas, que B seja adicionado no final de A.
        DoublyLinkedList<Integer> listaC = new DoublyLinkedList<Integer>();
        if (listaA.getSize() != 0) {
            DoublyLinkedList.Item<Integer> lastElement = listaA.getLista();

            while (lastElement != null) {
                listaC.addTail(lastElement.elemento);
                lastElement = lastElement.proximo;
            }
        }

        if (listaB.getSize() != 0) {
            DoublyLinkedList.Item<Integer> lastElement = listaB.getLista();
            while (lastElement != null) {
                listaC.addTail(lastElement.elemento);
                lastElement = lastElement.proximo;
            }
        }

        return listaC;
    }

}