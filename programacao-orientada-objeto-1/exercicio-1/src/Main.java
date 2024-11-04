import java.util.Scanner;

public class Main {
    public static Double convertFeetToMeters(Double feets){
        return feets*3.281;
    };

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe a altura do avião em pés: ");
        Double feets = scan.nextDouble();
        System.out.println("A conversao deu: "+ String.valueOf(convertFeetToMeters(feets)));
    }
}
