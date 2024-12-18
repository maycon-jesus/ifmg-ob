class Main {
    public static void main(String[] args) {
        System.out.println("==========[LISTA SIMPLESMENTE ENCADEADA]==========");
        System.out.println("Criando Lista");
        LinkedList<Integer> minhaLista = new LinkedList<Integer>();
        System.out.println("Inserindo Elemento");

        minhaLista.addHead(2);// 2, 33, 99, 1000
        minhaLista.addTail(33);
        minhaLista.addTail(99);
        minhaLista.addTail(1000);
        minhaLista.printLinkedList();

        LinkedList<Integer> listaB = new LinkedList<Integer>();
        listaB.addHead(2);// 2 , 33, 99, 1000
        listaB.addTail(33);
        listaB.addTail(99);
        listaB.addTail(1000);
        System.out.println("############ LISTA B");
        listaB.printLinkedList();
        System.out.println("############ minha lista");
        minhaLista.printLinkedList();

        System.out.println("------------- Verificando se duas listas são iguais ----------------");
        boolean equal = false;
        equal = LinkedListManipulation.isEqual(listaB, listaB);
        System.out.println("A lista B é igual a lista B: " + equal);
        equal = LinkedListManipulation.isEqual(listaB, minhaLista);
        System.out.println("A lista B é igual a lista minhaLista: " + equal);

        System.out.println("\n\n\n\n==========[LISTA DUPLAMENTE ENCADEADA]==========");
        System.out.println("Criando Lista");
        DoublyLinkedList<Integer> minhaListaDupla = new DoublyLinkedList<Integer>();
        System.out.println("Inserindo Elemento");

        minhaListaDupla.addHead(11);// 2, 33, 99, 1000
        minhaListaDupla.addTail(42);
        minhaListaDupla.addTail(85);
        minhaListaDupla.addTail(17);
        minhaListaDupla.addTail(93);
        minhaListaDupla.addTail(26);
        minhaListaDupla.addTail(58);
        minhaListaDupla.addTail(73);
        minhaListaDupla.addTail(99);

        minhaListaDupla.printLinkedList();

        System.out.println("------------- Removendo Elemento 11 ----------------");
        minhaListaDupla.removeElement(11);
        minhaListaDupla.printLinkedList();
        System.out.println("------------- Removendo Elemento 58 ----------------");
        minhaListaDupla.removeElement(58);
        minhaListaDupla.printLinkedList();


        System.out.println("==========[PILHA]==========");
        System.out.println("Criando minhaPilha");
        Pilha minhaPilha = new Pilha();
        System.out.println("Inserindo Elementos na minhaPilha");
        minhaPilha.push(23);
        minhaPilha.push(78);
        minhaPilha.push(45);
        minhaPilha.push(89);
        minhaPilha.push(34);
        minhaPilha.push(56);
        minhaPilha.push(92);
        minhaPilha.push(11);

        System.out.println("Criando minhaPilha2");
        Pilha minhaPilha2 = new Pilha();
        System.out.println("Inserindo Elementos na minhaPilha22");
        minhaPilha2.push(23);
        minhaPilha2.push(78);
        minhaPilha2.push(45);
        minhaPilha2.push(89);
        minhaPilha2.push(34);
        minhaPilha2.push(56);
        minhaPilha2.push(92);
        minhaPilha2.push(11);
        PilhaManipulation.print(minhaPilha2);

        System.out.println("------------- Verificando se duas pilhas são iguais ----------------");
        System.out.println("minhaPilha é igual a minhaPilha2: " + PilhaManipulation.iguais(minhaPilha, minhaPilha2));






        // LinkedList<Integer> newList = new LinkedList<Integer>();
        // newList.addHead(1);
        // newList.addTail(3);
        // newList.addTail(50);
        // newList.addTail(60);

        // LinkedList<Integer> newList2 = new LinkedList<Integer>();
        // newList2.addHead(1);
        // newList2.addTail(3);
        // newList2.addTail(50);
        // newList2.addTail(6000);
        // // newList2.printLinkedList();

        // // ...
    }
}