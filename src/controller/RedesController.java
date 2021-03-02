package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class RedesController {

	public RedesController() {
		super();
	}
	
	//Retornar nome do SO
	public String os() {
	    String so = System.getProperty("os.name");
	    return so;
	  }
	
	//Menu de opções Windows
	public void menuWindows(int param) {
	  if(param == 1) {
	   //Leitura de Processo:
	   String process = "TASKLIST /FO TABLE"; 
	   lerProcesso(process);
	  }
	  else if(param == 2) {
	    //Matar um processo por PID ou Nome:
		String processo = JOptionPane.showInputDialog("PID ou Nome do processo: ");
	    killprocessoWin(processo); 
	  }
	  else {
		JOptionPane.showInputDialog("Opção Invalida!");  
	  }
		
	}
	
	//Menu de opções Linux
		public void menuLinux(int param) {
		  if(param == 1) {
		   //Leitura de Processo:
		   String process = "ps -ef"; 
		   lerProcesso(process);
		  }
		  else if(param == 2) {
		    //Matar um processo por PID ou Nome:
			String processo = JOptionPane.showInputDialog("PID ou Nome do processo: ");
		    killprocessoLinux(processo); 
		  }
		  else {
			JOptionPane.showInputDialog("Opção Invalida!");  
		  }
			
		}
	
	
	
	
	//Leitura de Processo
	public void lerProcesso(String processo) {
		try {
			Process p = Runtime.getRuntime().exec(processo);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
			  System.out.println(linha);
			  linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Matar processo Windows:
	public void killprocessoWin(String param) {
		String cmdPid = "TASKKILL /PID";
		String cmdNome = "TASKKILL /IM";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		try {
		  //TASKKILL /PID numpid
		  pid = Integer.parseInt(param);
		  buffer.append(cmdPid);
		  buffer.append(" ");
		  buffer.append(pid);
		  
		}catch (NumberFormatException e) {
			//TASKKILL pelo nome
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(param);
		}
		
	    lerProcesso(buffer.toString());
		
	}
	
	
	//Matar processo Linux:
		public void killprocessoLinux(String param) {
			String cmdPid = "KILL -9";
			String cmdNome = "KILL -f";
			int pid = 0;
			StringBuffer buffer = new StringBuffer();
			
			try {
			  //TASKKILL /PID numpid
			  pid = Integer.parseInt(param);
			  buffer.append(cmdPid);
			  buffer.append(" ");
			  buffer.append(pid);
			  
			}catch (NumberFormatException e) {
				//TASKKILL pelo nome
				buffer.append(cmdNome);
				buffer.append(" ");
				buffer.append(param);
			}
			
		    lerProcesso(buffer.toString());
			
		}
	
     

}