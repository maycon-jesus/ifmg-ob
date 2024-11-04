class LinkedListManipulation {

    public static boolean checkIfEqual(LinkedList<Integer> listaA, LinkedList<Integer> listaB) {
        // Verificar se as duas listas são iguais
        if (listaA.getSize() != listaB.getSize())
            return false;
        if (listaA.getSize() == 0 || listaB.getSize() == 0)
            return true;

        LinkedList.Item<Integer> itemA = listaA.getLista();
        LinkedList.Item<Integer> itemB = listaB.getLista();

        while (itemA != null) {
            if (itemA.elemento != itemB.elemento)
                return false;
            itemA = itemA.proximo;
            itemB = itemB.proximo;
        }

        return true;

    }

    public static LinkedList<Integer> mergeLists(LinkedList<Integer> listaA, LinkedList<Integer> listaB) {
        // Sejam duas listas A e B. Implemente o método para fazer o merge entre as duas
        // listas, que B seja adicionado no final de A.
        LinkedList<Integer> listaC = new LinkedList<Integer>();
        if (listaA.getSize() != 0) {
            LinkedList.Item<Integer> lastElement = listaA.getLista();

            while (lastElement != null) {
                listaC.addTail(lastElement.elemento);
                lastElement = lastElement.proximo;
            }
        }

        if (listaB.getSize() != 0) {
            LinkedList.Item<Integer> lastElement = listaB.getLista();
            while (lastElement != null) {
                listaC.addTail(lastElement.elemento);
                lastElement = lastElement.proximo;
            }
        }

        return listaC;
    }

}