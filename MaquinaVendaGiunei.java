package senai;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MaquinaVendaGiunei {
	
	static ArrayList<String>produtos = new ArrayList<String>();
	static ArrayList<Double>preco = new ArrayList<Double>();
	static ArrayList<Double>precoFinal = new ArrayList<Double>();	
	static ArrayList<Integer>indProduto = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		///Produtos
		produtos.add("Latinha de refrigerante");
		produtos.add("Pacote de biscoitos");
		produtos.add("Garrafa de água");
		produtos.add("Kit Kat");;
		produtos.add("Cenoura");
		
		//Preço Inicial
		preco.add(3.70);//refri
		preco.add(5.50);//biscoito
		preco.add(2.25);//agua
		preco.add(3.00);//kitKat
		preco.add(2.75);//cenoura
		
		//Preço Final
		precoFinal.add(4.00);//refri
		precoFinal.add(6.00);//biscoito
		precoFinal.add(2.50);//agua
		precoFinal.add(3.50);//kitKat
		precoFinal.add(3.00);//cenoura
				
		//Menu	
		StringBuffer menu = new StringBuffer();
		menu.append("Maquina de vendas");
		menu.append("\n");
		menu.append("Digite o que deseja fazer");
		menu.append("\n\n");
		menu.append("1 - Cadastrar produto");
		menu.append("\n");
		menu.append("2 - Listar produtos");
		menu.append("\n");
		menu.append("3 - Alterar produto");
		menu.append("\n");
		menu.append("4 - Remover produto");
		menu.append("\n");
		menu.append("5 - Efetuar uma venda");
		menu.append("\n");
		menu.append("6 - Total capital de vendas");
		menu.append("\n");
		menu.append("7 - Total lucro");
		menu.append("\n");
		menu.append("0 - Sair");
		
		//Variáveis
		int escolha = -1;
		String produto;
		double valorInicial;
		double valorFinal;
		int ind;
		
		while (escolha != 0) {
			escolha = jopInt(menu.toString());
			switch (escolha) {
			case 1:
				//1 Cadastrar produto
				produto = jopStr("Digite o nome do novo produto");
				valorInicial = jopDoub("Digite o valor feito na unidade de "+produto);
				valorFinal = jopDoub("Digite o valor que será o preço de "+produto);
				cadastrar(produto, valorInicial, valorFinal);
				jopShow("Produto: "+produto+" | Valor inicial: "+valorInicial+" | Valor comercial: "+valorFinal+" >>> Cadastrado!");
				break;
			case 2:
				//2 Listar
				jopShow(listar());
				break;
			case 3:
				//3 Alterar
				ind = jopInt("Digite o índice do produto que desejas alterar\n\n"+listarInd());
				produto = jopStr("Digite o novo nome do produto");
				valorInicial = jopDoub("Digite o valor inicial de "+produto);
				valorFinal = jopDoub("Digite o valor comercial de "+produto);
				alterar(ind, produto, valorInicial, valorFinal);
				jopShow("Produto alterado com sucesso!\nProduto: "+produto+" | Valor inicial: "+valorInicial+" | Valor final: "+ valorFinal);
				break;
			case 4:
				//4 Remover Produto
				ind = jopInt("Digite o índice do produto que desejas remover\n\n"+listarInd());
				remover(ind);
				jopShow("Produto removido!");
				break;
			case 5:
				//5 Efetuar venda produto
				ind = jopInt("Digite o índice do produto a ser vendido\n\n"+listarInd());
				vender(ind);
				jopShow(produtos.get(ind)+" vendido!");
				break;
			case 6:
				//6 Total reais vendas
				jopShow("Total vendido: R$"+vendas());
				break;
			case 7:
				//7 Total reais lucro
				jopShow("Total do lucro: R$"+lucro());
				break;
			case 0:
				//0 Sair
				jopShow("Saindo...");
				break;

			default:
				jopShow("Algo foi digitado errado!");
				break;
			}
		}//fim while
		
	}//fim main
	
	public static String jopStr(String msg) {
		String retorno = "";
		retorno = JOptionPane.showInputDialog(msg);
		return retorno;
	}
	
	public static Integer jopInt(String msg) {
		int num;
		num = Integer.parseInt(JOptionPane.showInputDialog(msg));
		return num;
	}
	
	public static Double jopDoub(String msg) {
		double num;
		num = Double.parseDouble(JOptionPane.showInputDialog(msg));
		return num;
	}
	
	public static void jopShow(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public static void cadastrar(String produto, Double valorInicial, Double valorFinal) {
		produtos.add(produto);
		preco.add(valorInicial);
		precoFinal.add(valorFinal);
	}
	
	public static String listar() {
		StringBuffer lista = new StringBuffer();
		lista.append("Lista dos produtos da máquina");
		lista.append("\n\n");
		for (int i = 0; i < produtos.size(); i++) {
			lista.append(i+" - "+produtos.get(i)+" | Valor inicial: "+preco.get(i)+" | Valor final: "+precoFinal.get(i));
			lista.append("\n");
			lista.append("==============================");
			lista.append("\n");
		}
		return lista.toString();
	}
	
	public static String listarInd() {
		StringBuffer lista = new StringBuffer();
		lista.append("Lista dos produtos da máquina");
		lista.append("\n\n");
		for (int i = 0; i < produtos.size(); i++) {
			lista.append(i+" - "+produtos.get(i));
			lista.append("\n");
			lista.append("==============================");
			lista.append("\n");
		}
		return lista.toString();
	}
	
	public static void alterar(int ind, String produto, Double valorInicial, Double valorFinal) {
		produtos.set(ind, produto);
		preco.set(ind, valorInicial);
		precoFinal.set(ind, valorFinal);
	}
	
	public static void remover(int ind) {
		produtos.remove(ind);
		preco.remove(ind);
		precoFinal.remove(ind);
	}
	
	public static void vender(int ind) {
		indProduto.add(ind);
	}
	
	public static Double vendas() {
		Double valorTotal = 0.00;
		for (int i = 0; i < indProduto.size(); i++) {
			valorTotal = valorTotal + precoFinal.get(indProduto.get(i));
		}
		return valorTotal;
	}
	
	public static Double lucro() {
		Double lucroTotal = 0.0;
		for (int i = 0; i < indProduto.size(); i++) {
			lucroTotal += (precoFinal.get(indProduto.get(i)) - preco.get(indProduto.get(i)));
		}
		return lucroTotal;
	}
}