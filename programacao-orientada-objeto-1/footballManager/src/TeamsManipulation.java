import java.util.ArrayList;

public class TeamsManipulation {
    public void sortTeams(ArrayList<Team> teams){
        for(int i = 0; i < teams.size(); i++){
            Team teamA = teams.get(i);
            Team bigger = teams.get(i);
            int biggerIndex = i;

            for(int j = i+1; j<teams.size(); j++){
                Team currentTeamComparative = teams.get(j);

                if(currentTeamComparative.getPontos() < bigger.getPontos()) continue;
                if(currentTeamComparative.getPontos() > bigger.getPontos()) {
                    bigger=currentTeamComparative;
                    biggerIndex = j;
                    continue;
                };

                if(currentTeamComparative.getSaldoGols() < bigger.getSaldoGols()) continue;
                if(currentTeamComparative.getSaldoGols() > bigger.getSaldoGols()) {
                    bigger=currentTeamComparative;
                    biggerIndex = j;
                    continue;
                };

                if(currentTeamComparative.getGolsFeitos() < bigger.getGolsFeitos()) continue;
                if(currentTeamComparative.getGolsFeitos() > bigger.getGolsFeitos()) {
                    bigger=currentTeamComparative;
                    biggerIndex = j;
                    continue;
                };

                if(currentTeamComparative.getCartoesVermelhos() > bigger.getCartoesVermelhos()) continue;
                if(currentTeamComparative.getCartoesVermelhos() < bigger.getCartoesVermelhos()) {
                    bigger=currentTeamComparative;
                    biggerIndex = j;
                    continue;
                };

                if(currentTeamComparative.getCartoesAmarelos() > bigger.getCartoesAmarelos()) continue;
                if(currentTeamComparative.getCartoesAmarelos() < bigger.getCartoesAmarelos()) {
                    bigger=currentTeamComparative;
                    biggerIndex = j;
                    continue;
                };
            }

//            Invertendo o teamA com o bigger que é o time melhor pontuado
//            Colocando bigger no começo
            bigger.setPosition(i+1);
            teams.set(i,bigger);

//            Colocando teamA no lugar anterior do bigger
            teamA.setPosition(biggerIndex+1);
            teams.set(biggerIndex,teamA);
        }
    }

    public void printTeamsTable(ArrayList<Team> teams){
        ArrayList<ArrayList<String>> table = new ArrayList<>();

        ArrayList<String> headerRow = new ArrayList<>();
        headerRow.add("Posição");
        headerRow.add("Time");
        headerRow.add("Qtd. Jogos");
        headerRow.add("Saldo de Gols");
        headerRow.add("Gols Pró");
        headerRow.add("Cartões Vermelhos");
        headerRow.add("Cartões Amarelos");
        table.add(headerRow);

        for (Team team : teams) {
            ArrayList<String> row = new ArrayList<>();
            row.add(team.getPosition().toString());
            row.add(team.getNome());
            row.add(team.getGames().toString());
            row.add(team.getSaldoGols().toString());
            row.add(team.getGolsFeitos().toString());
            row.add(team.getCartoesVermelhos().toString());
            row.add(team.getCartoesAmarelos().toString());
            table.add(row);
        }

        new BeautyTable().printArrayList(table);
    }

    public void printTeamDetails(Team team){
        System.out.println("=====/ DETALHES DA EQUIPE "+team.getNome()+" /=====");
        System.out.println("Posição na tabela: " + team.getPosition());
        System.out.println("Total de jogos: " + team.getGames());
        System.out.println("Pontos: " + team.getPontos());
        System.out.println("Gols feitos: " + team.getGolsFeitos());
        System.out.println("Gols tomados: " + team.getGolsTomados());
        System.out.println("Saldo de gols: " + team.getSaldoGols());
        System.out.println("Cartões amarelos: " + team.getCartoesAmarelos());
        System.out.println("Cartões vermelhos: " + team.getCartoesVermelhos());
    }
}
