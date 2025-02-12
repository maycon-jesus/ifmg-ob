package Atendimento;

import db.DBItem;

import java.time.LocalDateTime;

public class Ficha extends DBItem {

    int pacienteId;
    int fichaAcolhidmentoId;
    FichaStatus status;
    LocalDateTime horaDaChegada;

    public Ficha(int id, int pacienteId, int fichaAcolhidmentoId, FichaStatus status, LocalDateTime horaDaChegada) {
        super(id);
        this.pacienteId = pacienteId;
        this.fichaAcolhidmentoId = fichaAcolhidmentoId;
        this.status = status;
        this.horaDaChegada = horaDaChegada;
    }
}
