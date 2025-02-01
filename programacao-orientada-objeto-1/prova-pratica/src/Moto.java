public class Moto extends Veiculo implements Transportavel {
	private int cilindrada;
	private boolean capaceteObrigatorio = true;

	public Moto(String marca, int ano, int cilindrada) {
		super(marca, ano);
		this.cilindrada = cilindrada;
	}

	@Override
	public void exibirDetalhes() {
		System.out.println("***");
		System.out.println("Marca: " + this.marca);
		System.out.println("Ano: " + this.ano);
		System.out.println("Cilindrada: " + cilindrada);
		System.out.println("Capacete Obrigatorio: " + capaceteObrigatorio);
		System.out.println("***");
	}

	public void empinar() {
		System.out.println("Empinando moto " + this.marca);
	}

	@Override
	public void transportar(String destino) {
		double distancia = 0;
		switch (destino) {
			case "são paulo": {
				distancia = 500;
			}
			case "bh": {
				distancia = 100;
			}
		}
		double valor = calcularCustoTransporte(distancia);

		System.out.println("Transportando para " + destino + "(" + distancia + "km)" + " pelo valor de: " + valor);
	}

	@Override
	public double calcularCustoTransporte(double distancia) {
		return distancia * 1.5;
	}
}
