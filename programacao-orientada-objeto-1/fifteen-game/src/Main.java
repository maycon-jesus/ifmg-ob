import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {
    static String[][] gameTable = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", " "}};
    static Integer[] blankPosition = {2,2}; // Posição em que espaço vazio está {y,x}

    public static class PossibleMove {
        int[] coords;
        String value;

        public PossibleMove(String value, int[] coords){
            this.value=value;
            this.coords=coords;
        }
    }

    public static ArrayList<PossibleMove> getPossibleMoves(){
        ArrayList<PossibleMove> possibles = new ArrayList<PossibleMove>();
        int y = blankPosition[0];
        int x = blankPosition[1];
        int yCima = y-1;
        int yBaixo = y+1;
        int xRight = x+1;
        int xLeft = x-1;


        if(yCima >= 0){
            possibles.add(new PossibleMove(gameTable[yCima][x], new int[]{yCima, x}));
        }
        if(xRight <= 2){
            possibles.add(new PossibleMove(gameTable[y][xRight], new int[]{y, xRight}));
        }
        if(yBaixo <= 2){
            possibles.add(new PossibleMove(gameTable[yBaixo][x], new int[]{yBaixo, x}));
        }
        if(xLeft >=0){
            possibles.add(new PossibleMove(gameTable[y][xLeft], new int[]{y, xLeft}));
        }

        return possibles;
    };

    public static void printTable(){
        for(String[] line: gameTable) {
            for (String cell : line) {
                System.out.print(" " + cell + " ");
            }
            System.out.println();
        }
    }

    public static void move(PossibleMove target){
        int yFrom = target.coords[0];
        int xFrom = target.coords[1];
        int yTo = blankPosition[0];
        int xTo = blankPosition[1];

        String aux = gameTable[yTo][xTo];
        gameTable[yTo][xTo] = gameTable[yFrom][xFrom];
        gameTable[yFrom][xFrom] = aux;
        blankPosition[0] = target.coords[0];
        blankPosition[1] = target.coords[1];
    }

    public static void main(String[] args) {
        Random rand = new Random();

        printTable();

        int dificuldade = 3;
        int embaralhamento = dificuldade*20;

        for(int i =0;i<embaralhamento;i++){
            ArrayList<PossibleMove> possibleMoves = getPossibleMoves();
            int num = rand.nextInt(possibleMoves.size());
            PossibleMove move = possibleMoves.get(num);
            move(move);
        }

        printTable();

    }
}