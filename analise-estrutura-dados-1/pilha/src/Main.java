public class Main {
    public static void main(String[] args) {
        PilhaManipulation pilhaManipulation = new PilhaManipulation();
        Pilha pilha1 = new Pilha();
        pilha1.push(6);
        pilha1.push(7);
        pilha1.push(8);

        Pilha pilha2 = new Pilha();
        pilha2.push(2);
        pilha2.push(3);
        pilha2.push(4);
        pilha2.push(5);

        Pilha pilha3 = new Pilha();
        pilha3.push(6);
        pilha3.push(7);
        pilha3.push(8);

        System.out.println("Valida se pilhas possuem mais elementos:");
        System.out.println("Pilha1 > Pilha2? "+pilhaManipulation.testaMaisElementos(pilha1, pilha2));
        System.out.println("Pilha2 > Pilha3? "+pilhaManipulation.testaMaisElementos(pilha2, pilha3));

        System.out.println("Transferir elementos:");
        System.out.println("=== Pilha 1");
        pilhaManipulation.print(pilha1);
        System.out.println("=== Pilha 2");
        pilhaManipulation.print(pilha2);
        System.out.println("Pilha1 para Pilha2: "+pilhaManipulation.transferirElementos(pilha1, pilha2));
        System.out.println("=== Pilha 1");
        pilhaManipulation.print(pilha1);
        System.out.println("=== Pilha 2");
        pilhaManipulation.print(pilha2);

        pilhaManipulation.inverterPilha(pilha2);
        System.out.println("=== Pilha 2");
        pilhaManipulation.print(pilha2);

        System.out.println("Pilha 1 == Pilha 3? "+ pilhaManipulation.iguais(pilha1,pilha3));
        System.out.println("Pilha 2 == Pilha 3? "+ pilhaManipulation.iguais(pilha2,pilha3));

    }
}
