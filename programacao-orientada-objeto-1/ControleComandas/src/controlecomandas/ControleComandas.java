
package controlecomandas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ControleComandas {
    //int - Integer
    //double - Double
    //boolean - Boolean
    //long - Long
    //String

    //processando arquivos ... LEITURA
    
    public static void testeEscrita(){
        Scanner entrada = new Scanner(System.in);
        
        String textoLinha = null;
        
        File arquivo = new File("C:\\Users\\saulo.cabral\\Downloads\\textosUsuario.txt");
        
        try{
            FileWriter marcaEscrita = new FileWriter(arquivo);
            
            BufferedWriter bufEscrita = new BufferedWriter(marcaEscrita);
            
            //realizar a escrita dos dados
            do{
                textoLinha = entrada.nextLine();
                
                if(!textoLinha.equalsIgnoreCase("sair")){
                    bufEscrita.write(textoLinha+"\n");
                }
            
            }while(!textoLinha.equalsIgnoreCase("sair"));
            
            bufEscrita.flush();
            bufEscrita.close();
            
        }catch(IOException ex){
            System.err.println("Arquivo corrompido");
        }
        
        
        
        
        
    }
    
    
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        Restaurante restAvenida = new Restaurante("marisa sunset");
        
        while(true){
            System.out.println("1 - Cadastrar Comanda\n"
                    + "2 - realizar pedido\n"
                    + "3 - fechar comanda\n"
                    + "4 - encerrar o dia\n\n");
            
            int opcao = entrada.nextInt();
            
            switch(opcao){
                case 1: restAvenida.realCadastraComanda();break;
                case 2: restAvenida.realizarPedido(); break;
                case 3: restAvenida.fecharComanda(); break;
                case 4: restAvenida.fecharTodasComandas(); break;
            }
        }
        
        
        //restAvenida.realCadastraComanda();
        
        
        
        
        
        //simulando o gar. atendendo 10 pedidos
        /*for(int i = 0; i < 10;i++){
            restAvenida.realizarPedido();
        }*/
        
        
                
    }
    
}
