
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;





public class Loja {


  private  String endereço;
   private String nome;
    private static  List<Veiculo> estoqueVeiculos = new ArrayList<Veiculo>();   
    
    
    
    public String getEndereco(){
    	return this.endereço;
   
    }
    public String getNome(){
    	return this.nome;
   
    }
    public void adicionarVeiculo(Veiculo veiculo) {
        try{
        	estoqueVeiculos.add(veiculo);
            }        
        catch(InputMismatchException e1){
            System.out.println("Erro input mismatch");
        }        
        }
  
    
    public Veiculo pesquisaMoto(Object obj) {
        for(Veiculo m : estoqueVeiculos){
        	if(m.propriedades.values().equals(obj)){
        		System.out.println("Veiculo   "+m+"  encontrado no estoque");
        		return m;
        		
        	}
        }
       return null;
      
    }        
    

public void listarEstoqueDeVeiculos(){
    for(Veiculo c : estoqueVeiculos){
       if(c != null){
            System.out.println("Veiculo : " +c);
        }
    }
    
    }
public void ListaVeiculosPropriedades(Veiculo v){
	for(Object key: v.propriedades.keySet()){		
			System.out.print(v.propriedades.get(key));
			System.out.print(" - ");
			System.out.println(key);
			
	}
}




static Path newFile = Paths.get("C:\\Users\\Avell B155\\Desktop\\estoqueCarros.txt");
public static void salvarEstoque(List<Veiculo> veiculo){
      
	try {
	  Files.deleteIfExists(newFile);
	  newFile = Files.createFile(newFile);
	} catch (IOException ex) {
	  System.out.println("Error creating file");
	}
	System.out.println(Files.exists(newFile));
        
        
        
        try(BufferedWriter writer = Files.newBufferedWriter(
	        newFile, Charset.defaultCharset())){
            for(Veiculo c : estoqueVeiculos){
             if(c != null){    
           
            
            writer.append(c.toString());
            writer.newLine();
            }
        
            }
             }
             catch (IOException e) {  
        e.printStackTrace();   
        }
                      
        
}

    public static void recuperarEstoqueCarro(){
        try(BufferedReader reader = Files.newBufferedReader(
	            newFile, Charset.defaultCharset())){
            String lineFromFile = "";
            System.out.println("Carros no estoque  : ");
            while((lineFromFile = reader.readLine()) != null){
                System.out.println(lineFromFile);
            }
        }
        catch(IOException exception){
            System.out.println("Erro ao ler o arquivo");
            
        }
    }
}
