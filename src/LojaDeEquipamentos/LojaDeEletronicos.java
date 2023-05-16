package LojaDeEquipamentos;

import java.awt.Color;
import java.awt.Font;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class LojaDeEletronicos {
	private ArrayList<Equipamento> equipamentos;

	public LojaDeEletronicos() {
		this.equipamentos = new ArrayList<Equipamento>();
	}
	
	public String[] leValores (String [] dadosIn){
		String [] dadosOut = new String [dadosIn.length];

		for (int i = 0; i < dadosIn.length; i++)
			dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

		return dadosOut;
	}

	public Smartphone leSmartphone (){

		String [] valores = new String [5];
		String [] nomeVal = {"Nome", "Marca", "Modelo", "Tamanho de tela", "Quantidade Chip"};
		valores = leValores (nomeVal);
		
		int chip = this.retornaInteiro(valores[4]);

		Smartphone SamsungPocket = new Smartphone (valores[0],valores[1],valores[2], valores[3], chip);
		return SamsungPocket;
	}

	public Smartwatch leSmartwatch (){

		String [] valores = new String [5];
		String [] nomeVal = {"Nome", "Marca", "Modelo", "Tamanho de Tela", "Tipo de pulseira"};
		valores = leValores (nomeVal);

		Smartwatch xiaomiWatch = new Smartwatch (valores[0],valores[1],valores[2], valores[3], valores[4]);
		return xiaomiWatch;
	}
	
	public Notebook leNotebook (){

		String [] valores = new String [6];
		String [] nomeVal = {"Nome", "Marca", "Modelo", "Tamanho de Tela", "Processador", "Memoria Ram"};
		valores = leValores (nomeVal);
		
		int memoriaRam = this.retornaInteiro(valores[5]);

		Notebook notebookPositivoGamerCeleron = new Notebook (valores[0],valores[1],valores[2], valores[3], valores[4], memoriaRam);
		return notebookPositivoGamerCeleron;
	}

	private boolean intValido(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	public int retornaInteiro(String entrada) {
	    Object[] options = {"Voltar"};
	    while (!this.intValido(entrada)) {
    	  int result = JOptionPane.showOptionDialog(null, "Valor incorreto!\n\nDigite um numero inteiro.", "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
          if (result == 0) { // O usuário clicou em "Cancelar"
              return -1;
          }
//          entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um numero inteiro.");
	    }
	    return Integer.parseInt(entrada);
	}

	public void salvaEletronicos (ArrayList<Equipamento> equipamentos){
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream 
					(new FileOutputStream("c:\\Users\\Miguel\\Downloads\\LojaDeEletronicos.dados")); // Alterar path aonde deseja salvar o arquivo do eletronico
			for (int i=0; i < equipamentos.size(); i++)
				outputStream.writeObject(equipamentos.get(i));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Impossivel criar arquivo!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<Equipamento> recuperaEletronicos (){
		ArrayList<Equipamento> equipamentosTemp = new ArrayList<Equipamento>();

		ObjectInputStream inputStream = null;

		try {	
			inputStream = new ObjectInputStream
					(new FileInputStream("c:\\Users\\Miguel\\Downloads\\LojaDeEletronicos.dados")); // Alterar path aonde deseja recuperar o arquivo salvo
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof Equipamento) {
					equipamentosTemp.add((Equipamento) obj);
				}   
			}          
		} catch (EOFException ex) {
			System.out.println("Fim de arquivo.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Arquivo com eletronicos NAO existe!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return equipamentosTemp;
		}
	}

	public void menuLoja (){

		String menu = "";
		String entrada;
		int    opc1, opc2;

		do {
			menu = "Controle Da Loja de Eletronicos\n" +
					"Opcoes:\n" + 
					"1. Entrar nos eletronicos\n" +
					"2. Exibir Eletronicos\n" +
					"3. Limpar Eletronicos\n" +
					"4. Gravar Eletronicos\n" +
					"5. Recuperar Eletronicos\n" +
					"9. Sair";
			entrada = JOptionPane.showInputDialog (menu + "\n\n");
			opc1 = this.retornaInteiro(entrada);

			switch (opc1) {
			case 1:
				menu = "Entrada de Eletronicos\n" +
						"Opçoes:\n" + 
						"1. Smartphone\n" +
						"2. Smartwatch\n" + 
						"3. Notebook\n";

				entrada = JOptionPane.showInputDialog (menu + "\n\n");
				opc2 = this.retornaInteiro(entrada);

				switch (opc2){
				case 1: equipamentos.add((Equipamento)leSmartphone());
				break;
				case 2: equipamentos.add((Equipamento)leSmartwatch());
				break;
				case 3: equipamentos.add((Equipamento)leNotebook());
				break;
				default: 
					JOptionPane.showMessageDialog(null,"Eletronico para entrada NAO escolhido!");
				}

				break;
			case 2:
				if (equipamentos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com eletronicos primeiramente");
					break;
				}
				String dados = "";
				for (int i=0; i < equipamentos.size(); i++)	{
					dados += equipamentos.get(i).toString() + "---------------\n";
				}
				JOptionPane.showMessageDialog(null,dados);
				break;
			case 3:
				if (equipamentos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com eletronicos primeiramente");
					break;
				}
				equipamentos.clear();
				JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
				break;
			case 4:
				if (equipamentos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com eletronicos primeiramente");
					break;
				}
				salvaEletronicos(equipamentos);
				JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
				break;
			case 5:
				equipamentos = recuperaEletronicos();
				if (equipamentos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
					break;
				}
				JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
				break;
			case 9:
				JOptionPane.showMessageDialog(null,"Fim do aplicativo Loja de eletronicos");
				break;
			}
		} while (opc1 != 9);
	}


	public static void main (String [] args){
		
		UIManager.put("OptionPane.background", new ColorUIResource(255, 255, 255)); // define a cor de fundo
		UIManager.put("Panel.background", new ColorUIResource(255, 255, 255)); // define a cor de fundo do painel interno
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 16)); // define a fonte da mensagem
		UIManager.put("OptionPane.messageForeground", Color.BLACK); // define a cor do texto da mensagem
		UIManager.put("OptionPane.okButtonText", "Ok"); // altera o texto do botão "OK"
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		
		LojaDeEletronicos eletronicos = new LojaDeEletronicos ();
		eletronicos.menuLoja();

	}

}
