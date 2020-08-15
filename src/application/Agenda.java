package application;

/**
 *
 * @author Bruno Prestes
 */
public class Agenda {
    
    private Contato[] contatos;
    
    //Criei uma agenda com capacidade de 5 contatos
    //Pois tenho um atributo array e instanciei 
    //as posicões desse array
    public Agenda(){
        contatos = new Contato[5];
    }
    
    /*Será feito um for dentro do metodo to String
    para imprimir cada contato do vetor 
    o for melhorado imprime o vetor inteiro de contatos
    */

    /*
    C é apenas um parâmetro da classe Contato
    como ele é um objeto que foi instanciado 
    ele será tudo o que for declarado 
    e como é um array e array de objetos
    contatos[i] receberá na posição do vetor
    o objeto que será instanciado na classe teste(main)
    ou main(teste)
    */
    public void adicionarContato(Contato c) throws AgendaCheiaException{
        
        boolean cheia = true;
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i] == null) {
                contatos[i] = c;
                cheia = false;
                break;
                //achou uma posicao que pode adicionar o contato, paramos o for
                
                /*
                se o contato indicado for igual nulo então 
                deverá ser preenchido
                */
            }
        }
        
        if (cheia) {
        /*lançar exception aqui, porque não lógica
         acessar uma posição que não existe na agenda
        */
        throw new AgendaCheiaException();
        /*
        Lancei um throw na assinatura do metodo
        pois ela não será capturada aqui 
        e sim em outra classe
        */
        }
        
    }
    
    public int consultaPorNome(String nome) throws ContatoNaoExisteException {
    
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i] != null) {
                /*o equalsIgnoreCase(nome) irá comparar se o nome que está no
                getNome do objeto indicado na posição do vetor
                é o mesmo da busca no método 
                se for isso então ele irá retornar positivamente sua busca com
                o objeto que será dado a String no object 
               */     
                if (contatos[i].getNome().equalsIgnoreCase(nome)){
                return i;
            }  
          }
        }
       
        //lançar exception contato não existe
        //foi criado um método com uma exception trazendo nome como parâmetro
        //uma vez dado o nome ele irá setar o nome e depois deverá ser chamado no main
       throw new ContatoNaoExisteException(nome);
       
}
    
    //Tem muitos
    @Override
    public String toString() {
        String s = "";
        for (Contato c : contatos) {

            s += c.toString() + "\n";
            //contato já tem seu método to String
            //portanto ele será impresso um por um    

            
            
        }
        return s;
    }
    
    
}
