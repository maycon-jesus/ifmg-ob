public class Main {
	public static void printTestScenario(String title) {
		System.out.println("======[ " + title + " ]======");
	}

	public static void main(String[] args) {
		Garagem<Carro> garagemCarro = new Garagem<>();

		Carro hyundai = new Carro("Hyunday", 2020, 4);
		Carro fiat = new Carro("Fiat", 2025, 4);
		Carro gm = new Carro("GM", 2015, 2);

		garagemCarro.adicionarVeiculo(hyundai);
		garagemCarro.adicionarVeiculo(fiat);
		garagemCarro.adicionarVeiculo(gm);

		printTestScenario("Teste listar veiculos");
		garagemCarro.listarVeiculos();

		printTestScenario("Teste ligar ar condicionado");
		System.out.println("Fiat ar ligado? " + fiat.isArCondicionadoLigado());
		fiat.ligarArCondicionado();
		System.out.println("Fiat ar ligado? " + fiat.isArCondicionadoLigado());

		printTestScenario("Teste acelerar e frear GM");
		System.out.println("GM Velocidade: " + gm.getVelocidadeAtual());
		gm.acelerar(100);
		System.out.println("GM Velocidade: " + gm.getVelocidadeAtual());
		gm.frear(20);
		System.out.println("GM Velocidade: " + gm.getVelocidadeAtual());
		gm.frear(500);
		System.out.println("GM Velocidade: " + gm.getVelocidadeAtual());

//		Motos
		Garagem<Moto> garagemMoto = new Garagem<>();

		Moto yamaha = new Moto("Yamaha", 2010, 125);
		Moto honda = new Moto("Honda", 2000, 300);

		garagemMoto.adicionarVeiculo(yamaha);
		garagemMoto.adicionarVeiculo(honda);

		printTestScenario("Listar motos");
		garagemMoto.listarVeiculos();


		printTestScenario("Teste empinar moto");
		yamaha.empinar();
		honda.empinar();

		printTestScenario("Teste empinar moto");
		yamaha.empinar();
		honda.empinar();

//		Garagem mista
		Garagem<Veiculo> garagemMista = new Garagem<>();
		garagemMista.adicionarVeiculo(honda);
		garagemMista.adicionarVeiculo(yamaha);
		garagemMista.adicionarVeiculo(hyundai);
		garagemMista.adicionarVeiculo(gm);
		garagemMista.adicionarVeiculo(fiat);

		printTestScenario("Listar veiculos garagem mista");
		garagemMista.listarVeiculos();

//		Obter veiculo mais velho
		printTestScenario("Veiculo mais velho");
		garagemMista.obterVeiculoMaisVelho().exibirDetalhes();

//		Transportar com moto
		printTestScenario("Transporte com moto para bh");
		honda.transportar("bh");

		//		Transportar com carro
		printTestScenario("Transporte com moto 100km");
		fiat.transportar("são paulo");

	}
}
