package application;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno Prestes
 */
public class Teste {
        
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();
        
        int opcao = 1;
        
        while (opcao != 3) {            
            opcao = obterOpcaoMenu(sc);
            if (opcao == 1) { //Consultar contato
            consultarContato(sc, agenda);
        } else if (opcao == 2) { // Adicionar contato
            adicionarContato(sc, agenda);
        }
            
        }
   
    }
    
    public static void adicionarContato(Scanner sc, Agenda agenda) {
    
        try {
            System.out.println("Criando um contato, entre com as informações");
            String nome = leInformacaoString(sc, "Entre com o nome do contato");
            String telefone = leInformacaoString(sc, "Entre com o telefone do contato");
            String email = leInformacaoString(sc, "Entre com o email do contato");
            
            Contato contato = new Contato();
            contato.setNome(nome);
            contato.setEmail(email);
            contato.setTelefone(telefone);
            
            System.out.println("Contato a ser criado: ");
            System.out.println(contato);
            
            agenda.adicionarContato(contato);
        } catch (AgendaCheiaException e) {
            System.out.println(e.getMessage());
            System.out.println("Contatos da agenda");
            System.out.println(agenda);
        }
    }
    
    public static void consultarContato(Scanner sc, Agenda agenda) {
    String nomeContato = leInformacaoString(sc, "Entre com o "
                    + "nome do contato a ser pesquisado");
              
            try {
                if (agenda.consultaPorNome(nomeContato) >= 0) {
                    //se não existir contato é porque não foi instanciado nada
                    //no for
                    /*pois a cada contato adicionado 
o consultaPorNome() que é um int vai sendo incrementado e caso eu consultar                   
um Zé Roberto da vida que não foi chamado no int ex 0 1 2 nenhum entre os três
como ele é menor que três então não existe 
                    */
                    System.out.println("Contato existe");
                }
            } catch (ContatoNaoExisteException e) {
                System.out.println(e.getMessage());
            }    
    
    }
    
    public static String leInformacaoString(Scanner sc, String msg) {
        //Método irá retornar o que foi parametrizado no main
        // também irá receber a String do nome do contato no sc.nextLine();
        System.out.println(msg);
        String entrada = sc.nextLine();
        return entrada;
    }
    
    public static int obterOpcaoMenu(Scanner sc) {
        
        boolean entradaValida = false;
        int opcao = 3;
        
        while (!entradaValida) {            
        
            System.out.println("Digite a opção desejada:");
            System.out.println("1: Consultar contato");
            System.out.println("2: Adicionar contato");
            System.out.println("3: Sair");
            
            try{
                String entrada = sc.nextLine();
                opcao = Integer.parseInt(entrada);
                
                if (opcao == 1 || opcao == 2 ||opcao == 3) {
                    entradaValida = true;
                } else {
                    throw new Exception("Entrada inválida");
                }
            }
            catch (Exception e) {
        System.out.println("Entrada inválida, digite novamente\n");
        
            }
        }
       
        return opcao;
    }
}
