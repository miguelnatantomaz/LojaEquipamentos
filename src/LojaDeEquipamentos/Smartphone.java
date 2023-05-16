package LojaDeEquipamentos;

public class Smartphone extends Equipamento {
	private static final long serialVersionUID = 1L;
	private int qtdChip;
	
	public Smartphone(String nome, String marca, String modelo, String tamanhoDeTela, int qtdChip) {
		super(nome, marca, modelo, tamanhoDeTela);
		this.plataforma = "Mobile";
		this.qtdChip = qtdChip;
	}
	
	@Override
	public String plataforma() {
		System.out.printf("Plataforma utilizada: " + this.plataforma);
		
		return this.plataforma;
	}
	
	public int getterChip() {
		System.out.printf("Quantidade de ship: " + this.qtdChip);
		
		return this.qtdChip;
	}
	
}
