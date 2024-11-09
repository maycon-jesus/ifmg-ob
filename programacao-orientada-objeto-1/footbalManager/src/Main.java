import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //    Use delimiter para deixar escrever Strings com espaço
    private static final Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private static final ArrayList<Team> teams = new ArrayList<Team>();
    private static final TeamsManipulation teamsManipulation = new TeamsManipulation();
    private static Boolean blockNewTeams = false;

    private static void registerTeam() {
        if (blockNewTeams) {
            System.out.println("O cadastro de novas equipes não está dispoível após o campeonato começar!");
            return;
        }
        if (teams.size() == 20) {
            System.out.println("O limite de 20 equipes ja foi atingido!!!");
            return;
        }
        System.out.print("Qual será o nome do time: ");
        String name = sc.next();
        Team nTeam = new Team(name);
        teams.add(nTeam);
    }

    private static Team promptTeamToUser(String prompt, Team ignoreTeam) {
        System.out.println(prompt);
        for (int i = 0; i < teams.size(); i++) {
            Team currentTeam = teams.get(i);
            if (currentTeam == ignoreTeam) {
                continue;
            }
            System.out.println(i + 1 + " - " + currentTeam.getNome());
        }
        System.out.print("Opção: ");
        int choice = sc.nextInt();
        if (choice <= 0 || choice > teams.size()) {
            System.out.println("Opção inválida!");
            return promptTeamToUser(prompt, ignoreTeam);
        }
        return teams.get(choice - 1);
    }

    private static int promptTeamInfoToUser(String teamName, String prompt) {
        System.out.print("[" + teamName + "] " + prompt);
        return sc.nextInt();
    }

    private static void registerNewGame() {
        if (teams.size() < 2) {
            System.out.println("A quantidade mínima de times (2) não foi atingido!");
            return;
        }
        Team teamA = promptTeamToUser("Informe o primeiro time: ", null);
        int teamAGoals = promptTeamInfoToUser(teamA.getNome(), "Gols feitos: ");
        int teamAYellow = promptTeamInfoToUser(teamA.getNome(), "Qtd. Cartões amarelos: ");
        int teamARed = promptTeamInfoToUser(teamA.getNome(), "Qtd. Cartões vermelhos: ");

        Team teamB = promptTeamToUser("Informe o segundo time: ", teamA);
        int teamBGoals = promptTeamInfoToUser(teamB.getNome(), "Gols feitos: ");
        int teamBYellow = promptTeamInfoToUser(teamB.getNome(), "Qtd. Cartões amarelos: ");
        int teamBRed = promptTeamInfoToUser(teamB.getNome(), "Qtd. Cartões vermelhos: ");

        teamA.increaseGames(1);
        teamA.increaseGoals(teamAGoals);
        teamA.decreaseGoals(teamBGoals);
        teamA.increaseCartaoAmarelo(teamAYellow);
        teamA.increaseCartaoVermelho(teamARed);

        teamB.increaseGames(1);
        teamB.increaseGoals(teamBGoals);
        teamB.decreaseGoals(teamAGoals);
        teamB.increaseCartaoAmarelo(teamBYellow);
        teamB.increaseCartaoVermelho(teamBRed);

        if (teamAGoals > teamBGoals) {
            teamA.increasePoints(3);
        } else if (teamBGoals > teamAGoals) {
            teamB.increasePoints(3);
        } else {
            teamA.increasePoints(1);
            teamB.increasePoints(1);
        }

        teamsManipulation.sortTeams(teams);
        blockNewTeams = true;
    }

    private static void getTeamDetails() {
        Team team = promptTeamToUser("De qual time você deseja visualizar os dados? ", null);
        teamsManipulation.printTeamDetails(team);
    }

    public static void menu() {
        System.out.println("=====/ MENU /=====");
        System.out.println("1 - Cadastrar nova equipe");
        System.out.println("2 - Cadastrar nova partida");
        System.out.println("3 - Mostrar tabela");
        System.out.println("4 - Mostrar equipes aptas a participar da libertadores");
        System.out.println("5 - Equipes em condições de rebaixamento");
        System.out.println("6 - Acessar dados da equipe líder");
        System.out.println("7 - Acessar dados de uma equipe");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 0: {
                System.exit(0);
                break;
            }
            case 1: {
                registerTeam();
                break;
            }
            case 2: {
                registerNewGame();
                break;
            }
            case 3: {
                teamsManipulation.printTeamsTable(teams);
                break;
            }
            case 4: {
                ArrayList<Team> nArr = new ArrayList<Team>();
                for (int i = 0; i < teams.size() && i < 4; i++) {
                    nArr.add(teams.get(i));
                }

                teamsManipulation.printTeamsTable(nArr);
                break;
            }
            case 5: {
                ArrayList<Team> nArr = new ArrayList<Team>();
                for (int i = teams.size() - 4; i < teams.size() && i >= 0; i++) {
                    nArr.add(teams.get(i));
                }

                teamsManipulation.printTeamsTable(nArr);
                break;
            }
            case 6: {
                if (teams.isEmpty()) {
                    System.out.println("Não possui nenhum time cadastrado no sistema!");
                    break;
                }
                teamsManipulation.printTeamDetails(teams.getFirst());
                break;

            }
            case 7: {
                if (teams.isEmpty()) {
                    System.out.println("Não possui nenhum time cadastrado no sistema!");
                    break;
                }
                getTeamDetails();
                break;
            }
            default: {
                System.out.println("Opção inválida!!!");
                System.out.println();
                break;
            }
        }
        menu();
    }

    public static void main(String[] args) {
        menu();
    }
}
