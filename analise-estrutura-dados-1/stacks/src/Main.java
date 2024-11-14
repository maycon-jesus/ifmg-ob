public class Main {
    public static void main(String[] args) {
        PilhaManipulation pilhaManipulation = new PilhaManipulation();
        Pilha pilha = new Pilha();
        pilha.push(3);
        pilha.push(4);
        pilha.push(5);

        Pilha pilha2 = new Pilha();
        pilha2.push(3);
        pilha2.push(4);
        pilha2.push(5);

        System.out.println(pilhaManipulation.iguais(pilha,pilha2));
    }
}
