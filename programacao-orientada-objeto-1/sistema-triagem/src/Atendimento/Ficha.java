package Atendimento;

import db.DBItem;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class Ficha extends DBItem {
    int id;
    int pacienteId;
    int fichaAcolhidmentoId;
    FichaStatus status;
    LocalDateTime horaDaChegada;

    public Ficha(int pacienteId, int fichaAcolhidmentoId, FichaStatus status, LocalDateTime horaDaChegada) {
        this.pacienteId = pacienteId;
        this.fichaAcolhidmentoId = fichaAcolhidmentoId;
        this.status = status;
        this.horaDaChegada = horaDaChegada;
    }
}
