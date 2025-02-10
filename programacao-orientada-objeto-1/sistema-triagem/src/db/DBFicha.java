package db;

import Atendimento.Ficha;

public class DBFicha  extends DBManager<Ficha>{

    public DBFicha() {
        super("db/ficha", "id, pacienteId, fichaAcolhidmentoId, status, " +
                "horaDaChegada", 10);
    }

    @Override
    Ficha createInstaceOfData(String[] dataArr) {
        return null;
    }

    @Override
    String instanceToStringData(Ficha data) {
        return "";
    }
}
