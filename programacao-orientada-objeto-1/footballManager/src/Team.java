public class Team {
    private String nome = "";
    private int pontos = 0;
    private int golsFeitos = 0;
    private int golsTomados = 0;
    private int cartoesVermelhos = 0;
    private int cartoesAmarelos = 0;
    private int pos = 0;
    private int games = 0;

    Team(String nome) {
        this.nome = nome;
    }

    public Integer getPontos() {
        return pontos;
    }

    public Integer getGolsFeitos() {
        return golsFeitos;
    }

    public Integer getGolsTomados() {
        return golsTomados;
    }

    public Integer getCartoesVermelhos() {
        return cartoesVermelhos;
    }

    public Integer getCartoesAmarelos() {
        return cartoesAmarelos;
    }

    public Integer getPosition() {
        return pos;
    }

    public void setPosition(int pos) {
        this.pos = pos;
    }

    public Integer getGames() {
        return this.games;
    }

    public String getNome() {
        return nome;
    }

    public Integer getSaldoGols() {
        return golsFeitos - golsTomados;
    }

    public void increaseGoals(int goals) {
        this.golsFeitos += goals;
    }

    public void increaseGames(int qtd) {
        this.games += qtd;
    }

    public void increasePoints(int points) {
        this.pontos += points;
    }

    public void increaseCartaoVermelho(int qtd) {
        this.cartoesVermelhos += qtd;
    }

    public void increaseCartaoAmarelo(int qtd) {
        this.cartoesAmarelos += qtd;
    }

    public void decreaseGoals(int goals) {
        this.golsTomados += goals;
    }
}
