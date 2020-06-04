package senai;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Desafio11 {
	
	static ArrayList<String> nomes = new ArrayList<String>();
	
	static ArrayList<String> emails = new ArrayList<String>();
	
	static ArrayList<String> celulares = new ArrayList<String>();
	
	static ArrayList<Character> generos = new ArrayList<Character>();
	
	static ArrayList<Integer> idades = new ArrayList<Integer>();
	
	public static void main(String[] args) {
				
		nomes.add("Marco");
		nomes.add("Jertrudes");
		nomes.add("Anabel");
		emails.add("asdasd");
		emails.add("asdasd");
		emails.add("asdasd");
		celulares.add("123123");
		celulares.add("123123");
		celulares.add("123123");
		generos.add('M');
		generos.add('F');
		generos.add('N');
		idades.add(19);
		idades.add(61);
		idades.add(21);
		
		String nome = "";
		String email= "";
		String celular = "";
		Character genero = ' ';
		Integer idade = 0;
		int tipogenero = 0;
		int indice = -1;
		
		StringBuffer menu = new StringBuffer();
		menu.append("1 - Adicionar contato");
		menu.append("\n");
		menu.append("2 - Remover um contato");
		menu.append("\n");
		menu.append("3 - Listar contatos");
		menu.append("\n");
		menu.append("4 - Apenas por genero");
		menu.append("\n");
		menu.append("5 - Pesquisar");
		menu.append("\n");
		menu.append("0 - Sair");
		
		int controle = -1;
		
		while(controle !=0) {
			controle = jopInt(menu.toString());
			switch (controle) {
			case 1:
				nome = jopStr("Digite o nome do contato");
				email = jopStr("Digite o Email de "+nome);
				celular = jopStr("Digite o celular de "+nome);
				tipogenero = jopInt("Digite o genero:\n0 - Masculino\n1 - Feminino\n2 - Não-Binário");
				if(tipogenero==0) {
					genero = 'M';
				}else if(tipogenero==1) {
					genero = 'F';
				}else {
					genero = 'N';
				}
				idade = jopInt("Digite a idade de "+nome);
				
				addContato(nome, email, celular, genero, idade);
				
				break;
			case 2:
				indice = jopInt(
						listarContatosIndice()
						+ "Escolha o indice do contato a ser removido"
						);
				remContato(indice);
				break;
			case 3:
				jop(listarContatos());
				break;
			case 4:
				indice = jopInt("Listar pessoas de qual gênero?\n1 - Masculino\n2 - Feminino\n3 - Não-Binário");
				jop(listarPorGenero(indice));
				break;
			case 5:
				nome = jopStr("Quem você deseja encontrar?");
				jop(pesquisar(nome));
				
				break;
			case 0:
				jop("Saindo...");
				break;

			default:
				jop("Opção inválida!");
				break;
			}
		}
				
	}
	
	public static Integer jopInt(String mensagem) {
		Integer numero = 0;
		numero = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
		return numero;
	}
	
	public static String jopStr(String mensagem) {
		String retorno = "";
		retorno = JOptionPane.showInputDialog(mensagem);
		return retorno;
	}
	
	public static void jop(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	public static void addContato(String nome, String email, String celular, Character genero, Integer idade) {
		nomes.add(nome);
		emails.add(email);
		celulares.add(celular);
		generos.add(genero);
		idades.add(idade);
		jop("Contato adicionado com sucesso!");
	}
	
	public static String listarContatos() {
		StringBuffer lista = new StringBuffer();
		lista.append("Lista de contatos");
		lista.append("\n");
		lista.append("========================");
		lista.append("\n");
		for (int i = 0; i < nomes.size(); i++) {
			lista.append("Nome: "+nomes.get(i));
			lista.append("\n");
			lista.append("Email: "+emails.get(i));
			lista.append("\n");
			lista.append("Celular: "+celulares.get(i));
			lista.append("\n");
			lista.append("Gênero: "+generos.get(i));
			lista.append("\n");
			lista.append("Idade: "+idades.get(i));
			lista.append("\n");
			lista.append("========================");
			lista.append("\n");
		}
		return lista.toString();
	}
	
	public static void remContato(Integer indice) {
		
		nomes.remove(nomes.get(indice));
		celulares.remove(celulares.get(indice));
		emails.remove(emails.get(indice));
		generos.remove(generos.get(indice));
		idades.remove(idades.get(indice));
		
		jop("Contato excluído com sucesso!");
	}
	
	public static String listarContatosIndice() {
		StringBuffer lista = new StringBuffer();
		lista.append("Lista de contatos");
		lista.append("\n");
		lista.append("========================");
		lista.append("\n");
		for (int i = 0; i < nomes.size(); i++) {
			lista.append("Índice: "+i);
			lista.append("\n");
			lista.append("Nome: "+nomes.get(i));
			lista.append("\n");
			lista.append("Email: "+emails.get(i));
			lista.append("\n");
			lista.append("Celular: "+celulares.get(i));
			lista.append("\n");
			lista.append("Gênero: "+generos.get(i));
			lista.append("\n");
			lista.append("Idade: "+idades.get(i));
			lista.append("\n");
			lista.append("========================");
			lista.append("\n");
		}
		return lista.toString();
	}
	
	public static String listarPorGenero(Integer tipogenero) {
        Character gen;
        if (tipogenero == 0) {
            gen = 'M';
        } else if (tipogenero == 1) {
            gen = 'F';
        } else {
            gen = 'N';
        }
        StringBuffer lista = new StringBuffer();
        lista.append("Lista");
        lista.append("\n");
        lista.append("========================");
        lista.append("\n");


        for (int i = 0; i < generos.size(); i++) {
            if (generos.get(i).equals(gen)) {
                lista.append("Nome: " + nomes.get(i));
                lista.append("\n");
                lista.append("Email: " + emails.get(i));
                lista.append("\n");
                lista.append("Celular: " + celulares.get(i));
                lista.append("\n");
                lista.append("Gênero: " + generos.get(i));
                lista.append("\n");
                lista.append("Idade: " + idades.get(i));
                lista.append("\n");
                lista.append("========================");
                lista.append("\n");
            }

		}
			
		
		return lista.toString();
	}
	
	public static String pesquisar(String parametro) {
		StringBuffer lista = new StringBuffer();
		for (int i = 0; i < nomes.size(); i++) {
			if(nomes.get(i).toUpperCase().startsWith(parametro.toUpperCase())) {
				lista.append("Contato encontrado!");
				lista.append("\nNome: "+nomes.get(i));
				lista.append("\nEmail: "+emails.get(i));
				lista.append("\nCelular: "+celulares.get(i));
				lista.append("\nGênero: "+generos.get(i));
				lista.append("\nIdade: "+idades.get(i));
			}
		}
		return lista.toString();
	}
}
