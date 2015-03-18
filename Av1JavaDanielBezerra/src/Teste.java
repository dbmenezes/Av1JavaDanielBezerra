

public class Teste {

	public static void main(String[] args) {
		
	Veiculo v1 = new Veiculo();
	v1.propriedades.put("montadora", "gm");
	v1.propriedades.put("capacidadeDoTanque", 100);
	Loja l1 = new Loja();
	l1.adicionarVeiculo(v1);
	l1.ListaVeiculosPropriedades(v1);
}
}