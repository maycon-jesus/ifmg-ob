class LinkedList<E> {
    private Item<E> lista;
    private int size;

    public LinkedList() {
        lista = null;
    }

    public Item<E> getLista() {
        return lista;
    }

    public int getSize() {
        return size;
    }

    public void addHead(E item) {
        if (lista == null) {
            lista = new Item<E>(item, null);
        } else {
            Item<E> novoItem = new Item<E>(item, lista);
            lista = novoItem;
        }
        size++;
    }

    public void addTail(E item) {
        if (lista == null) {
            lista = new Item<E>(item, null);
        } else {
            Item<E> ponteiro = lista;
            for (; ponteiro.proximo != null; ponteiro = ponteiro.proximo) {
            }
            ponteiro.proximo = new Item<E>(item, null);
        }
        size++;
    }

    public boolean removeElement(E item) {
        if (lista == null) {
            return false;
        }

        // Implementar a remocao de um elemento na lista
        if (this.size == 1 && lista.elemento.equals(item)) {
            lista = null;
            size--;
            return true;
        } else if (this.size > 1) {
            Item<E> itemAnterior = null;
            Item<E> itemAtual = lista;
            for (; itemAtual != null; itemAtual = itemAtual.proximo) {
                if (itemAtual.elemento != item) {
                    itemAnterior = itemAtual;
                    continue;
                }
                if (itemAnterior == null) {
                    lista = lista.proximo;
                } else {
                    itemAnterior.proximo = itemAtual.proximo;
                }
            }
            size--;
            return true;
        } else {
            return false;
        }

    }

    public boolean elementExist(E item) {
        if (lista == null)
            return false;
        Item<E> ponteiro = lista;
        // Checar se um elemento existe na lista
        for (; ponteiro != null; ponteiro = ponteiro.proximo) {
            if (ponteiro.elemento == item) {
                return true;
            }
        }
        return false;
    }

    public void printLinkedList() {
        Item<E> ponteiro = lista;
        System.out.println("Imprimindo a Lista encadeada");
        for (; ponteiro != null; ponteiro = ponteiro.proximo) {
            System.out.println(ponteiro.elemento);
        }
    }

    public static class Item<T> {
        T elemento;
        Item<T> proximo;

        Item(T item, Item<T> prox) {
            elemento = item;
            proximo = prox;
        }
    }

}