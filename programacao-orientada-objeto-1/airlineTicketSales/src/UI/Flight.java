package UI;

import Methods.Seat;

import java.util.ArrayList;
import java.util.Arrays;

class Flight {
    static void printFlightSeats(Methods.Flight flight){
        BeautyTable table = new BeautyTable();
        ArrayList<ArrayList<String>> arrTable = new ArrayList<>();
        ArrayList<String> firstLine = new ArrayList<>();
        firstLine.add("");
        firstLine.add("A");
        firstLine.add("B");
        firstLine.add("C");
        firstLine.add("D");
        arrTable.add(firstLine);
        Seat[][] seats = flight.getSeats();
        for(int i = 0; i< seats.length; i++){
            Seat[] line = seats[i];
            ArrayList<String> nTableLine = new ArrayList<>();
            nTableLine.add(String.valueOf(i+1));
            for(Seat seat: line){
                if(seat.isBlocked()) {
                    nTableLine.add("");
                }else if(seat.isEmpty()){
                    nTableLine.add("-");
                }else{
                    nTableLine.add("X");
                }
            }
            arrTable.add(nTableLine);
        }
        table.printArrayList(arrTable);
    }
}
