package senai;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Planilha {
	
	//1 TRIMESTRE
	static ArrayList<String>produtos = new ArrayList<String>();
	static ArrayList<Double>jan = new ArrayList<Double>();
	static ArrayList<Double>fev = new ArrayList<Double>();
	static ArrayList<Double>mar = new ArrayList<Double>();
	
	//2 TRIMESTRE
	//static ArrayList<String>produtos2 = new ArrayList<String>();
	static ArrayList<Double>abr = new ArrayList<Double>();
	static ArrayList<Double>mai = new ArrayList<Double>();
	static ArrayList<Double>jun = new ArrayList<Double>();
	
	public static void main(String[] args) {
		
		produtos.add("Computador");
		produtos.add("Notebook");
		produtos.add("Monitor");
		produtos.add("Teclado");
		produtos.add("Mouse");
		produtos.add("Headphone");
		
		//TRIMESTRE 1
		
		jan.add(4500.0);
		jan.add(6250.0);
		jan.add(3300.0);
		jan.add(8000.0);
		jan.add(4557.0);
		jan.add(3260.0);
		
		fev.add(5040.0);
		fev.add(7000.0);
		fev.add(3696.0);
		fev.add(8690.0);
		fev.add(5104.0);
		fev.add(3640.0);
		
		mar.add(5696.0);
		mar.add(7910.0);
		mar.add(4176.0);
		mar.add(10125.0);
		mar.add(5676.0);
		mar.add(4113.0);
		
		//TRIMESTRE 2
		
		abr.add(6265.0);
		abr.add(8701.0);
		abr.add(4569.0);
		abr.add(12341.0);
		abr.add(6344.0);
		abr.add(4525.0);
		
		mai.add(6954.0);
		mai.add(9658.0);
		mai.add(5099.0);
		mai.add(12365.0);
		mai.add(7042.0);
		mai.add(5022.0);
		
		jun.add(7858.0);
		jun.add(10197.0);
		jun.add(5769.0);
		jun.add(13969.0);
		jun.add(7957.0);
		jun.add(5671.0);
		
		int escolha = -1;
		
		StringBuffer menu = new StringBuffer();
		menu.append("Escolha o que desejas");
		menu.append("\n\n");
		menu.append("1 - Total 1º Trimestre");
		menu.append("\n");
		menu.append("2 - Máximo 1º Trimestre");
		menu.append("\n");
		menu.append("3 - Mínimo 1º Trimestre");
		menu.append("\n");
		menu.append("4 - Média 1º Trimestre");
		menu.append("\n");
		menu.append("5 - Total 2º Trimestre");
		menu.append("\n");
		menu.append("6 - Máximo 2º Trimestre");
		menu.append("\n");
		menu.append("7 - Mínimo 2º Trimestre");
		menu.append("\n");
		menu.append("8 - Média 2º Trimestre");
		menu.append("\n");
		menu.append("9 - Totais de cada mês");
		menu.append("\n");
		menu.append("10 - Total do Semestre");
		menu.append("\n");
		menu.append("0 - Sair");
		
		while (escolha!=0) {
			escolha = jopInt(menu.toString());
			switch (escolha) {
			case 1:
				jopShow("1º Trimestre\n"+Soma(jan, fev, mar));
				break;
			case 2:
				jopShow("1º Trimestre\n"+Max(jan,fev,mar));
				break;
			case 3:
				jopShow("1º Trimestre\n"+Min(jan,fev,mar));
				break;
			case 4:
				jopShow("1º Trimestre\n"+Media(jan,fev,mar));
				break;
			case 5:
				jopShow("2º Trimestre\n"+Soma(abr, mai, jun));
				break;
			case 6:
				jopShow("2º Trimestre\n"+Max(abr,mai,jun));
				break;
			case 7:
				jopShow("2º Trimestre\n"+Min(abr,mai,jun));
				break;
			case 8:
				jopShow("2º Trimestre\n"+Media(abr,mai,jun));
				break;
			case 9:
				jopShow("Total de cada mês: "+Mes(jan, fev, mar, abr, mai, jun));
				break;
			case 10:
				jopShow(Total(jan, fev, mar, abr, mai, jun));
				break;
			case 0:
				jopShow("Saindo...");
				break;
			default:
				break;
			
			}
		}
	}
	
	public static Integer jopInt(String msg) {
		int num = 0;
		num = Integer.parseInt(JOptionPane.showInputDialog(msg));
		return num;
	}
	
	public static Double jopDouble(String msg) {
		double num = 0.0;
		num = Double.parseDouble(JOptionPane.showInputDialog(msg));
		return num;
	}
	
	public static String jopStr(String msg) {
		String x = "";
		x = JOptionPane.showInputDialog(msg);
		return x;
	}
	
	public static void jopShow(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public static String Soma(ArrayList<Double> x, ArrayList<Double> y, ArrayList<Double> z) {
		double num = 0;
		StringBuffer resultado = new StringBuffer();
		resultado.append("<<Soma>>\n");
		for (int i = 0; i < produtos.size(); i++) {
			num=num+x.get(i);
			num=num+y.get(i);
			num=num+z.get(i);
		}
		resultado.append("Resultado da soma: "+num);
		return resultado.toString();
	}
	
	public static String Max(ArrayList<Double> x, ArrayList<Double> y, ArrayList<Double> z) {
		double num = -1;
		StringBuffer resultado = new StringBuffer();
		resultado.append("<<Máximo>>\n");
		for (int i = 0; i < produtos.size(); i++) {
			if(num < x.get(i)) {
				num = x.get(i);
			}
			if(num < y.get(i)) {
				num = y.get(i);
			}
			if(num < z.get(i)) {
				num = z.get(i);
			}
		}
		resultado.append("Valor maior encontrado: "+num);
		return resultado.toString();
	}
	
	public static String Min(ArrayList<Double> x, ArrayList<Double> y, ArrayList<Double> z) {
		double num = 99999999;
		StringBuffer resultado = new StringBuffer();
		resultado.append("<<Mínimo>>\n");
		for (int i = 0; i < produtos.size(); i++) {
			if(num > x.get(i)) {
				num = x.get(i);
			}
			if(num > y.get(i)) {
				num = y.get(i);
			}
			if(num > z.get(i)) {
				num = z.get(i);
			}
		}
		resultado.append("Valor menor encontrado: "+num);
		return resultado.toString();
	}
	
	public static String Media(ArrayList<Double> x, ArrayList<Double> y, ArrayList<Double> z) {
		double num = 0;
		int a = produtos.size() * 3;
		StringBuffer resultado = new StringBuffer();
		resultado.append("<<Média>>\n");
		for (int i = 0; i < produtos.size(); i++) {
			num=num+x.get(i);
			num=num+y.get(i);
			num=num+z.get(i);			
		}
		System.out.println("a: "+a);
		num = num/a;
		resultado.append("Resultado da Média: "+num);
		return resultado.toString();
	}
	
	public static String Mes(ArrayList<Double> m, ArrayList<Double> n, ArrayList<Double> o, 
			ArrayList<Double> p, ArrayList<Double> q, ArrayList<Double> r) {
		double a = 0;
		double b = 0;
		double c = 0;
		double d = 0;
		double e = 0;
		double f = 0;
		StringBuffer resultado = new StringBuffer();
		resultado.append("<<Total dos meses>>\n\n");
		for (int i = 0; i < produtos.size(); i++) {
			a += m.get(i);	
			b += n.get(i);
			c += o.get(i);
			d += p.get(i);	
			e += q.get(i);
			f += r.get(i);
		}
		resultado.append("Janeiro: "+a);
		resultado.append("\n");
		resultado.append("Fevereiro: "+b);
		resultado.append("\n");
		resultado.append("Março: "+c);
		resultado.append("\n");
		resultado.append("Abril: "+d);
		resultado.append("\n");
		resultado.append("Maio: "+e);
		resultado.append("\n");
		resultado.append("Junho: "+f);
		return resultado.toString();
	}
	
	public static String Total(ArrayList<Double> m, ArrayList<Double> n, ArrayList<Double> o, 
			ArrayList<Double> p, ArrayList<Double> q, ArrayList<Double> r) {
		double num = 0;
		int a = produtos.size() * 3;
		StringBuffer resultado = new StringBuffer();
		resultado.append("<<Total>>\n");
		for (int i = 0; i < produtos.size(); i++) {
			num=num+m.get(i);
			num=num+n.get(i);
			num=num+o.get(i);	
			num=num+p.get(i);
			num=num+q.get(i);
			num=num+r.get(i);
		}
		resultado.append("Resultado: "+num);
		return resultado.toString();
	}
}
