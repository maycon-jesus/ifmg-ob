public class PilhaManipulation {
	static int iguais(Pilha P1, Pilha P2) {
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

	static void print(Pilha pilha) {
		for(int it:pilha.itens){
			if(it == 0) continue;
			System.out.println(it);
		}
	}
}