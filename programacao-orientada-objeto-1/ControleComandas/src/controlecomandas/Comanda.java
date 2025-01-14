package controlecomandas;


import controlecomandas.Cliente;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Comanda {
    private LocalDateTime data;
    private int numMesa;
    private double valorTotal;
    private Cliente respComanda;

    //Preciso de uma lista de produtos
    //Produto produtosCons[] = new Produto[1000];
    private ArrayList<Produto> produtos = new ArrayList<>();

    public Comanda(int numMesa, Cliente respComanda) {
        this.numMesa = numMesa;
        this.respComanda = respComanda;
        this.valorTotal = 0.0;
        this.data = LocalDateTime.now();
    }

    public void anotaPedido(Produto novoPedido) {
        this.produtos.add(novoPedido);
        this.valorTotal += novoPedido.getValorUnit();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    
    
    public void imprimePedidos() {
        //for(int i = 0; i < this.produtos.size(); i++){
        for(Produto iterador : this.produtos){
            System.out.println(iterador.getNome());
        }
    }

    public void writeFile(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_uuuu_HH_mm");
        File file = new File("comandas/mesa"+this.numMesa+"_"+this.data.format(formatter)+".txt");

        try{
            FileWriter marcaEscrita = new FileWriter(file);

            BufferedWriter bufEscrita = new BufferedWriter(marcaEscrita);

            bufEscrita.write(this.respComanda.getNome());
            bufEscrita.newLine();
            for(Produto iterador : this.produtos){
                bufEscrita.write(iterador.getNome()+" - R$ "+iterador.getValorUnit());
                bufEscrita.newLine();
            }
            bufEscrita.write("Total: R$ "+this.getValorTotal());
            bufEscrita.newLine();



            bufEscrita.flush();
            bufEscrita.close();

        }catch(IOException ex){
            System.err.println("Arquivo corrompido");
        }
    }
    
    
    
    
}
