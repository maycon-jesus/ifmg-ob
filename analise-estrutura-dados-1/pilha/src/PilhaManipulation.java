public class PilhaManipulation {
    int testaMaisElementos(Pilha P1, Pilha P2) {
        return P1.topo>P2.topo? 1:0;
    }

    int transferirElementos(Pilha P1, Pilha P2) {
        if(P1.empty()) return 1;
        for(int i = 0; i<=P1.topo; i++){
            P2.push(P1.itens[i]);
        }
        return 0;
    }

    void inverterPilha(Pilha P) {
        for(int i = 0; i<=P.topo/2; i++){
            int aux = P.itens[i];
            P.itens[i] = P.itens[P.topo-i];
            P.itens[P.topo-i]=aux;
        }
    }

    int iguais(Pilha P1, Pilha P2) {
        if(P1.topo != P2.topo) {return 0;}
        if(P1.empty() && P2.empty()) return 1;

        int currentIndex = 0;
        while(P1.topo >=currentIndex){
            if(P1.itens[currentIndex] != P2.itens[currentIndex]){
                return 0;
            }
            currentIndex++;
        }

        return 1;
    }

    void print(Pilha pilha) {
        for(int it:pilha.itens){
            if(it == 0) continue;
            System.out.println(it);
        }
    }
}
