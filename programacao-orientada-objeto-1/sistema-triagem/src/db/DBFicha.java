package db;

import Atendimento.Ficha;
import Atendimento.FichaStatus;

import java.time.LocalDateTime;

public class DBFicha extends DBManager<Ficha> {

    public DBFicha() {
        super("db/ficha", "id, pacienteId, fichaAcolhidmentoId, status, " +
                "horaDaChegada", 10);
    }

    @Override
    Ficha createInstaceOfData(String[] dataArr) {

        int id = Integer.parseInt(dataArr[0]);
        int pacienteId = Integer.parseInt(dataArr[1]);
        int fichaAcolhidmentoId = Integer.parseInt(dataArr[2]);
        FichaStatus status = FichaStatus.valueOf(dataArr[3]);
        LocalDateTime horaDaChegada = LocalDateTime.parse(dataArr[4]);

        Ficha ficha = new Ficha(id, pacienteId, fichaAcholhimentoId, status, horaDaChegada);


        return ficha;
    }


    @Override
    String instanceToStringData(Ficha data) {
        return "";
    }
}
