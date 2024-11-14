class Pilha {
    int tamPilha = 100;
    int topo=-1;
    int[] itens;

    Pilha() {
        itens = new int[tamPilha];
    }

    void push(int valor){
        if(topo == tamPilha){
            return;
        }
        topo++;
        itens[topo] = valor;
    }

    int pop(){
        if(topo == -1){
            return -1;
        }
        return itens[topo--];
    }

    Boolean empty(){
        return topo == -1;
    }
}
