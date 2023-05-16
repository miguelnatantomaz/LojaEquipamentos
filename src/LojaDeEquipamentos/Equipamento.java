package LojaDeEquipamentos;

import java.io.Serializable;

public abstract class Equipamento implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String marca;
	private String modelo;
	private String tamanhoDeTela;
	protected Boolean isLigado;
	protected String plataforma;
	
	public Equipamento(String nome, String marca, String modelo, String tamanhoDeTela) {
		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.tamanhoDeTela = tamanhoDeTela;
		this.isLigado = false;
	}
	
	public String toString() {
		String txt = "";
		txt += "Nome: "     + this.nome     + "\n";
		txt += "Marca: "    + this.marca    + "\n";
		txt += "Modelo: "     + this.modelo     + "\n";
		txt += "Tamanho da tela: "  + this.tamanhoDeTela  + "\n";
		txt += "Plataforma: " + this.plataforma();
		return txt;
	}
	public void ligar() {
		if(this.isLigado == false) {
			this.isLigado = true;
			System.out.printf(this.nome + "foi ligado");
		}
		
		System.out.printf(this.nome + "já está ligado");
	}
	
	public void desligar() {
		if(this.isLigado == true) {
			this.isLigado = false;
			System.out.printf(this.nome + "foi ligado");
		}
		
		System.out.printf(this.nome  + "já está ligado");
	}
	
	public abstract String plataforma();
}
