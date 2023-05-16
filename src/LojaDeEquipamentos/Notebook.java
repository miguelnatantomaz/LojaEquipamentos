package LojaDeEquipamentos;

public class Notebook extends Equipamento {
	private static final long serialVersionUID = 1L;
	private String processador;
	private int memoriaRam;
	
	public Notebook(String nome, String marca, String modelo, String tamanhoDeTela, String processador, int memoriaRam) {
		super(nome, marca, modelo, tamanhoDeTela);
		this.plataforma = "Desktop";
		this.processador = processador;
		this.memoriaRam = memoriaRam;
	}
	
	@Override
	public String plataforma() {
		System.out.printf("Plataforma utilizada: " + this.plataforma);
		return this.plataforma;
	}
	
	public String getterProcessador() {
		System.out.printf("Processador autal: " + this.processador);
		return this.processador;
	}
	
	public void setterMemoriaRam(int adicionarMemoria) {
		System.out.printf("memoria ram atual: " + adicionarMemoria);
		this.memoriaRam = adicionarMemoria;
	}
	
	public int getterMemoriaRam() {
		System.out.printf("Quantidade de memoria ram atual: " + this.memoriaRam);
		return this.memoriaRam;
	}
}
