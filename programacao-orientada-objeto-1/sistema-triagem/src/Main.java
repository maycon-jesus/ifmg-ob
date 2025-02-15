import Atendimento.Ficha;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static ArrayList<Ficha> fila = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("Hello world");

		Ficha f1 = new Ficha(1, 1);
		Ficha f2 = new Ficha(2, 2);
		Ficha f3 = new Ficha(3, 3);
		Ficha f4 = new Ficha(4, 4);
		Ficha f5 = new Ficha(5, 5);
		fila.add(f1);
		fila.add(f2);
		fila.add(f3);
		fila.add(f4);
		fila.add(f5);

		f1.setFichaAcolhimentoId(1);
		f2.setFichaAcolhimentoId(2);
		f3.setFichaAcolhimentoId(3);
		f4.setFichaAcolhimentoId(4);
		f5.setFichaAcolhimentoId(5);

		Collections.sort(Main.fila);

		for (Ficha f : fila) {
			System.out.println(f.getId());
		}


	}
}
