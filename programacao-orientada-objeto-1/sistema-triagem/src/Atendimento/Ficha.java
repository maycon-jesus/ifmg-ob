package Atendimento;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class Ficha {
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
