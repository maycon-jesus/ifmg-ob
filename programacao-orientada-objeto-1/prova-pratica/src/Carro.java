public class Carro extends Veiculo implements Transportavel {
	private int quantidadePortas;
	private boolean arCondicionadoLigado;

	public Carro(String marca, int ano, int quantidadePortas) {
		super(marca, ano);
		this.quantidadePortas = quantidadePortas;
	}

	@Override
	public void exibirDetalhes() {
		System.out.println("***");
		System.out.println("Marca: " + this.marca);
		System.out.println("Ano: " + this.ano);
		System.out.println("Quantidade de portas: " + this.quantidadePortas);
		System.out.println("***");
	}

	public void ligarArCondicionado() {
		arCondicionadoLigado = true;
	}

	public void desligarArCondicionado() {
		arCondicionadoLigado = false;
	}

	public boolean isArCondicionadoLigado() {
		return arCondicionadoLigado;
	}

	@Override
	public void transportar(String destino) {
		double distancia = 0;
		switch (destino) {
			case "são paulo": {
				distancia = 500;
				break;
			}
			case "bh": {
				distancia = 100;
				break;
			}
		}
		double valor = calcularCustoTransporte(distancia);

		System.out.println("Transportando para " + destino + "(" + distancia + "km)" + " pelo valor de: " + valor);
	}

	@Override
	public double calcularCustoTransporte(double distancia) {
		return distancia * 2.5;
	}

}
