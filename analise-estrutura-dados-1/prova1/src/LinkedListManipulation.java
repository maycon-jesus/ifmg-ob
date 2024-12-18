import java.util.Objects;

class LinkedListManipulation {

    public static boolean isEqual(LinkedList<Integer> listaA, LinkedList<Integer> listaB) {
        // Verificar se as duas listas são iguais
        if (listaA.getSize() != listaB.getSize())
            return false;
        if (listaA.getSize() == 0 || listaB.getSize() == 0)
            return true;

        LinkedList.Item<Integer> itemA = listaA.getLista();
        LinkedList.Item<Integer> itemB = listaB.getLista();

        while (itemA != null) {
            if (!Objects.equals(itemA.elemento, itemB.elemento))
                return false;
            itemA = itemA.proximo;
            itemB = itemB.proximo;
        }

        return true;

    }

}