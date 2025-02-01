public abstract class Veiculo {
	protected String marca;
	protected int ano;
	protected double velocidadeAtual = 0;

	protected Veiculo(String marca, int ano) {
		this.marca = marca;
		this.ano = ano;
		this.velocidadeAtual = velocidadeAtual;
	}


	public abstract void exibirDetalhes();

	public void acelerar(double incremento) {
		velocidadeAtual += incremento;
	}

	public void frear(double decremento) {
		velocidadeAtual -= decremento;
		if (velocidadeAtual < 0) {
			velocidadeAtual = 0;
		}
	}

	public double getVelocidadeAtual() {
		return velocidadeAtual;
	}

	public int getAno() {
		return ano;
	}
}
