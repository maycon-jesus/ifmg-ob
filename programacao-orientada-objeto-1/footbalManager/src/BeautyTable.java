import java.util.ArrayList;

public class BeautyTable {
    public void printArrayList(ArrayList<ArrayList<String>> arr) {
        if (arr.isEmpty()) return;
        int[] columnsWidth = new int[arr.getFirst().size()];

        for (int i = 0; i < arr.size(); i++) {
            ArrayList<String> line = arr.get(i);
            for (int j = 0; j < arr.get(i).size(); j++) {
                String cell = line.get(j);
                if (cell.length() > columnsWidth[j]) {
                    columnsWidth[j] = cell.length();
                }
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            ArrayList<String> line = arr.get(i);

            for (int j = 0; i == 0 && j < arr.get(i).size(); j++) {
                int currentColumnWidth = columnsWidth[j];

                if (j == 0) {
                    System.out.print("┌");
                }

                System.out.print("─".repeat(currentColumnWidth + 2));

                if (j == line.size() - 1) {
                    System.out.print("┐");
                } else {
                    System.out.print("┬");
                }
            }
            if (i == 0) {
                System.out.println();
            }

            for (int j = 0; j < arr.get(i).size(); j++) {
                String cell = line.get(j);
                int currentColumnWidth = columnsWidth[j];
                int whiteSpaces = currentColumnWidth - cell.length();
                if (j == 0) {
                    System.out.print("│ ");
                }
                System.out.print(cell + " ".repeat(whiteSpaces) + " │ ");
            }
            System.out.println();
            for (int j = 0; j < arr.get(i).size(); j++) {
                int currentColumnWidth = columnsWidth[j];

                if (i == arr.size() - 1 && j == 0) {
                    System.out.print("└");
                } else if (j == 0) {
                    System.out.print("├");
                }

                System.out.print("─".repeat(currentColumnWidth + 2));

                // Faz ultima linha da tabela
                if (i == arr.size() - 1 && j == line.size() - 1) {
                    System.out.print("┘");
                    continue;
                } else if (i == arr.size() - 1) {
                    System.out.print("┴");
                    continue;
                }

                // Faz linhas intermediarias
                if (j == line.size() - 1) {
                    System.out.print("┤");
                } else {
                    System.out.print("┼");
                }
            }

            System.out.println();
        }
    }
}
