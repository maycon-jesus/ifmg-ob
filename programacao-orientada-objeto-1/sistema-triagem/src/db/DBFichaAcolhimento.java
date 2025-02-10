package db;

import Atendimento.FichaAcolhimento;

public class DBFichaAcolhimento extends DBManager<FichaAcolhimento>{

    public DBFichaAcolhimento() {
        super("db/fichaacolhimento", "id, id, enfermeiroId, Sintomas,tempoDosSintomas, doencasPreExistentes,usoDeMedicamento, jaFezCirurgia, AlergiaMedicamentoSubstancia, gravida, traumaAcidenteRecente, historicoFamiliar, fumante,consomeAlcool, infoDor, temperaturaCorporal, pressaoSanguinea, frequeciaCardiaca,frequenciaRespiratoria,saturacaoDeOxigenio, taxaDeGlicose, consegueAndar, sinaisDeEmergencia, sinaisDeInfeccaoGrave, especialidadeNecessaria, prioridade", 10);
    }

    @Override
    FichaAcolhimento createInstaceOfData(String[] dataArr) {
        return null;
    }

    @Override
    String instanceToStringData(FichaAcolhimento data) {
        return "";
    }
}
