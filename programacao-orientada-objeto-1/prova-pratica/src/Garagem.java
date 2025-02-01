import java.util.ArrayList;
import java.util.List;

public class Garagem<T extends Veiculo> {
	private List<T> veiculos = new ArrayList<>();

	public void adicionarVeiculo(T veiculo) {
		veiculos.add(veiculo);
	}

	public void listarVeiculos() {
		for (T veiculo : veiculos) {
			veiculo.exibirDetalhes();
		}
	}

	public T obterVeiculoMaisVelho() {
		T veiculoMaisVelho = null;
		for (T veiculo : veiculos) {
			if (veiculoMaisVelho == null) {
				veiculoMaisVelho = veiculo;
			} else if (veiculo.getAno() < veiculoMaisVelho.getAno()) {
				veiculoMaisVelho = veiculo;
			}
		}
		return veiculoMaisVelho;
	}
}
