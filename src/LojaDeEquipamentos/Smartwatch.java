package LojaDeEquipamentos;

public class Smartwatch extends Equipamento {
	private static final long serialVersionUID = 1L;
	private String tipoPulseira;
	
	public Smartwatch(String nome, String marca, String modelo, String tamanhoDeTela, String tipoPulseira) {
		super(nome, marca, modelo, tamanhoDeTela);
		this.plataforma = "Mobile";
		this.tipoPulseira = tipoPulseira;
	}
	
	@Override
	public String plataforma() {
		System.out.printf("Plataforma utilizada: " + this.plataforma);
		return this.plataforma;
	}
	
	public String getterPulseira() {
		System.out.printf("Pulseira autal: " + this.tipoPulseira);
		return this.tipoPulseira;
	}
	
	public void setterPulseira(String pulseiraNova) {
		System.out.printf("Pulseira nova: " + pulseiraNova);
		this.tipoPulseira = pulseiraNova;
	}
}
