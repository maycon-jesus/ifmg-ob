import java.util.ArrayList; // Importa a classe ArrayList
import java.util.Scanner; // Importa a classe Scanner
import java.util.Random; // Importa a Biblioteca para gerar números Aleatórios

public class Main { // Classe Principal do Programa

    static String[][] gameTable = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", " "}};
    static Integer[] blankPosition = {2, 2};
    static Integer moveCouter = 0;

    public static class PossibleMove {
        int[] coords;
        String value;

        public PossibleMove(String value, int[] coords) {
            this.value = value;
            this.coords = coords;
        }
    }

    public static ArrayList<PossibleMove> getPossibleMoves() {
        ArrayList<PossibleMove> possibles = new ArrayList<>();
        int y = blankPosition[0];
        int x = blankPosition[1];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] direct : directions) {
            int newY = y + direct[0];
            int newX = x + direct[1];
            if (newY >= 0 && newY <= 2 && newX >= 0 && newX <= 2) {
                possibles.add(new PossibleMove(gameTable[newY][newX], new int[]{newY, newX}));
            }
        }

        return possibles;
    }

    public static void printTable(){
        enum LinePrintMode {
            TOP,
            BOTTOM,
            CELL_NUMBER,
            MIDDLE_LINES
        }
        LinePrintMode linePrintMode = LinePrintMode.TOP;

        int gameTableLineIndex = 0;
        for (int lineIndex =0;lineIndex<gameTable.length*2+1;lineIndex++) {
            switch (linePrintMode) {
                case LinePrintMode.TOP -> {
                    System.out.print("┌───┬───┬───┐");
                    linePrintMode = LinePrintMode.CELL_NUMBER;
                    break;
                }
                case LinePrintMode.BOTTOM -> {
                    System.out.print("└───┴───┴───┘");
                    linePrintMode = LinePrintMode.CELL_NUMBER;
                    break;
                }
                case LinePrintMode.CELL_NUMBER -> {

                    System.out.print("│ "+gameTable[gameTableLineIndex][0]+" │ "+gameTable[gameTableLineIndex][1]+" │ "+gameTable[gameTableLineIndex][2]+" │");
                    gameTableLineIndex++;
                    if(lineIndex==gameTable.length*2-1){
                        linePrintMode = LinePrintMode.BOTTOM;
                    }else{
                        linePrintMode = LinePrintMode.MIDDLE_LINES;
                    }
                    break;
                }
                case LinePrintMode.MIDDLE_LINES -> {
                    System.out.print("├───┼───┼───┤");
                    linePrintMode = LinePrintMode.CELL_NUMBER;
                    break;
                }
            }

            System.out.println();
        }
    }

    public static void move(PossibleMove target) {
        int yFrom = target.coords[0];
        int xFrom = target.coords[1];
        int yTo = blankPosition[0];
        int xTo = blankPosition[1];

        gameTable[yTo][xTo] = gameTable[yFrom][xFrom];
        gameTable[yFrom][xFrom] = " ";
        blankPosition[0] = yFrom;
        blankPosition[1] = xFrom;
    }

    public static void shuffleTable(int difficulty) {
        Random rand = new Random();
        int shuffles = difficulty * 20;
        for (int i = 0; i < shuffles; i++) {
            ArrayList<PossibleMove> possibleMoves = getPossibleMoves();
            int num = rand.nextInt(possibleMoves.size());
            PossibleMove move = possibleMoves.get(num);
            move(move);
        }
    }

    public static boolean isGameSolved() {
        String[][] winningTable = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", " "}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!gameTable[i][j].equals(winningTable[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Quantidade de jogadas até agora: " + moveCouter);
            System.out.println("Escolha uma das pecas e mova para o espaco vazio:\n");
            ArrayList<PossibleMove> possibleMoves = getPossibleMoves();

            String choice = scanner.nextLine();
            PossibleMove possibleMove = possibleMoves.stream().filter(move-> {
                return move.value.equals(choice);
            }).findAny().orElse(null);

            if(possibleMove ==null){
                System.out.println("Escolha invalida. Tente novamente.");
                continue;
            }

            move(possibleMove);
            moveCouter++;
            break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\tBem-vindo ao jogo de quebra-cabecas Racha-Cuca!");

        printTable();

        System.out.println("\tTabuleiro ordenado!");
        System.out.println("\nEscolha o seu nivel de dificuldades:\n1 - Facil\n2 - Medio\n3 - Dificil\n");
        System.out.print("\tNivel: ");

        int difficulty = Integer.parseInt(scanner.nextLine());

        shuffleTable(difficulty); //Funções
        System.out.println("\tTabuleiro embaralhado. Vamos começar o jogo!");
        printTable(); //Funções

        while (!isGameSolved()) {
            playerMove();
            printTable();
        }

        System.out.println("Parabens jogador! Voce resolveu o Racha-Cuca em " +moveCouter+ " movimentos!!!");
    }
}
//End Program
