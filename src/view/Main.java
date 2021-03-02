package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
	RedesController redesController = new RedesController(); 
	
	//Chamada Identificador de Sistema Operacional
	String identificarso = redesController.os();
	
	if(identificarso.contains("Windows")) {
	  //Opções Windows 
	  System.out.println("-- Entrei em Ambiente Windows --");
	  int opc = 0;
	  while(opc != 3) {
		opc = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Listar Processos Ativos \n 2 - Finalizar processo pelo nome ou PID \n 3 - Sair"));
		if(opc == 3) {
	     break;
		}
		redesController.menuWindows(opc);
	  }  
	 }
	//Opções Linux
	else if (identificarso.contains("Linux")) {
      System.out.println("-- Entrei em Ambiente Linux --");
      //Opções Linux
      int opc = 0;
	  while(opc != 3) {
		opc = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Listar Processos Ativos \n 2 - Finalizar processo pelo nome ou PID \n 3 - Sair"));
		if(opc == 3) {
		 break;
		}
		redesController.menuLinux(opc);
	  }  
	}
		
		
 }
}
