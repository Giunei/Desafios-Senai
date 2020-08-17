package senai;

import java.util.ArrayList;
import javax.swing.JOptionPane;
 
public class Desafio12 {
   
	//dados funcionários
    static ArrayList<String>funcionarios = new ArrayList<String>();
    static ArrayList<Integer>idadesFunc = new ArrayList<Integer>();
    //dados clientes
    static ArrayList<String>clientes = new ArrayList<String>();
    static ArrayList<Integer>idadesClientes = new ArrayList<Integer>();
    //dados dos produtos
    static ArrayList<String>produtos = new ArrayList<String>();
    static ArrayList<Double>precoProdutos = new ArrayList<Double>();
    static ArrayList<String>validade = new ArrayList<String>();
    //informações de venda
    static ArrayList<Integer>vendasProduto = new ArrayList<Integer>();
    static ArrayList<Integer>vendasFuncionario = new ArrayList<Integer>();
    static ArrayList<Integer>vendasCliente = new ArrayList<Integer>();
    static ArrayList<Double>vendasPreco = new ArrayList<Double>();
   
    public static void main(String[] args) {
       
        int escolhaPrincipal = -1;
        String nome = "";
        Double preco = 0.00;
        String produto = "";
        int idade = 0;
       
        //produtos padrão
        produtos.add("Pipoca gourmet de caramelo, chocolate e amendoim");
        produtos.add("Pipoca de Negresco");
        produtos.add("Pipoca de leite ninho");
        produtos.add("Pipoca de Nutella");
        produtos.add("Pipoca de Ovomaltine");
        produtos.add("Pipoca salgada");
        produtos.add("Refrigerante");
        produtos.add("Água");
        produtos.add("Quentão");
        produtos.add("Paçoca");
        produtos.add("Hot-Dog");
       
        //preços padrão
        precoProdutos.add(12.00);//da casa
        precoProdutos.add(10.00);//negresco
        precoProdutos.add(10.00);//leite ninho
        precoProdutos.add(10.00);//Nutella
        precoProdutos.add(10.00);//Ovomaltine
        precoProdutos.add(10.00);//salgada
        precoProdutos.add(5.00);//refri
        precoProdutos.add(2.50);//agua
        precoProdutos.add(5.90);//quentao
        precoProdutos.add(1.50);//paçoca
        precoProdutos.add(7.50);//hotdog
       
        //validades padrão
        validade.add("10/06");
        validade.add("10/06");
        validade.add("10/06");
        validade.add("10/06");
        validade.add("10/06");
        validade.add("10/06");
        validade.add("10/06");
        validade.add("10/12");
        validade.add("10/06");
        validade.add("11/06");
        validade.add("10/06");
        
        //clientes padrão
        clientes.add("Marcos Andrade");
        idadesClientes.add(47);
        clientes.add("Jordana Andrade");
        idadesClientes.add(65);
        clientes.add("Laura Souza");
        idadesClientes.add(32);
        
        //funcionários padrão
        funcionarios.add("Geraldo Corneo");
        idadesFunc.add(25);
        funcionarios.add("Melissa Maccari");
        idadesFunc.add(31);
        funcionarios.add("Rebeca Lestrange");
        idadesFunc.add(23);
       
        StringBuffer menu = new StringBuffer();
        menu.append("Bem vindos ao arriá da festa junina!");
        menu.append("\n");
        menu.append("Digite o que deseja fazer:");
        menu.append("\n\n");
        menu.append("1 - Funcionário");
        menu.append("\n");
        menu.append("2 - Clientes");
        menu.append("\n");
        menu.append("3 - Serviços");
        menu.append("\n");
        menu.append("4 - Vendas");
        menu.append("\n");
        menu.append("0 - Sair");
       
        StringBuffer menuSecundario = new StringBuffer();
        menuSecundario.append("\n");
        menuSecundario.append("Digite o que deseja fazer:");
        menuSecundario.append("\n\n");
        menuSecundario.append("1 - Adicionar");
        menuSecundario.append("\n");
        menuSecundario.append("2 - Alterar");
        menuSecundario.append("\n");
        menuSecundario.append("3 - Listar");
        menuSecundario.append("\n");
        menuSecundario.append("0 - Retornar");
       
   
        while(escolhaPrincipal!=0) {
            escolhaPrincipal = jopInt(menu.toString());
            int indice;
            String vencimento = "";
            int escolhaSecundaria = -1;
            switch (escolhaPrincipal) {
            case 1:
                //adicionar funcionario
                while(escolhaSecundaria!=0) {
                    escolhaSecundaria = jopInt("FUNCIONÁRIO"+menuSecundario.toString());
                    switch(escolhaSecundaria) {
                    case 1:
                        nome = jopStr("Digite o nome do funcionário");
                        idade = jopInt("Digite a idade de "+nome);
                        addFunc(nome, idade);                    
                        break;
                    case 2:
                        indice = jopInt("Digite qual o índice de quem você deseja alterar\n"+listarFunc());
                        nome = jopStr("Digite o nome desse funcionário");
                        idade = jopInt("Digite a idade de "+nome);
                        alterarFunc(indice, nome, idade);
                        break;
                    case 3:
                        jop(listarFunc());          
                        break;
                    case 0:
                        jop("Retornando ao menu principal...");
                        break;
                    default:
                        jop("Opção inválida");
                        break;                     
                    }
                }
                break;
            case 2:
                while(escolhaSecundaria!=0) {
                    escolhaSecundaria = jopInt("Clientes"+menuSecundario.toString());
                    switch(escolhaSecundaria) {
                    case 1:
                        nome = jopStr("Digite o nome do cliente");
                        idade = jopInt("Digite a idade de "+nome);
                        addCliente(nome, idade);
                        break;
                    case 2:
                        //alterar cliente
                        indice = jopInt("Digite qual o índice de quem você deseja alterar\n"+listarClienteInd());
                        nome = jopStr("Digite o nome desse cliente");
                        idade = jopInt("Digite a idade de "+nome);
                        alterarFunc(indice, nome, idade);
                        break;
                    case 3:
                        jop(listarClientes());          
                        break;
                    case 0:
                        escolhaSecundaria = 0;
                        escolhaPrincipal = -1;
                        jop("Retornando ao menu principal...");
                        break;
                    default:
                        jop("Opção inválida");
                        break;                     
                    }
                }
                break;
            case 3:
                while(escolhaSecundaria!=0) {
                    escolhaSecundaria = jopInt("SERVIÇOS"+menuSecundario.toString());
                    switch(escolhaSecundaria) {
                    case 1:
               
                        nome = jopStr("Digite o nome do novo produto");
                        vencimento = jopStr("Digite a data de validade de "+ nome);
                        preco = jopDoub("Digite o preço de "+nome);
                        addProduto(nome, vencimento, preco);
                        break;
                    case 2:
                         //alterar produto
                        indice = jopInt("Digite o índice do produto a ser alterado\n\n"+listarProdutos());
                        nome = jopStr("Digite o novo nome do produto");
                        vencimento = jopStr("Digite a nova data de validade de "+ nome);
                        preco = jopDoub("Digite o novo preço de "+nome);
                        alterarProduto(indice, produto, preco, vencimento);
                        break;
                    case 3:
                        //listar produtos
                        jop(listarProdutos());
                        break;
                    case 0:
                        jop("Retornando ao menu principal...");
                        break;
                    default:
                        jop("Opção inválida");
                        break;                     
                    }
                }
                break;
            case 4:
                while(escolhaSecundaria!=0) {
                    menuSecundario = new StringBuffer();
                    menuSecundario.append("VENDAS");
                    menuSecundario.append("\n");
                    menuSecundario.append("Digite o que deseja fazer");
                    menuSecundario.append("\n");
                    menuSecundario.append("1 - Atribuir uma venda");
                    menuSecundario.append("\n");
                    menuSecundario.append("2 - Alterar uma venda");
                    menuSecundario.append("\n");
                    menuSecundario.append("3 - Listar");
                    menuSecundario.append("\n");
                    menuSecundario.append("0 - Retornar");
                    escolhaSecundaria = jopInt(menuSecundario.toString());
                    switch(escolhaSecundaria) {
                    case 1:
                        //atribuir uma venda
                        int nomeInt;
                        int produtoInt;
                        int clienteInt;
                       
                        nomeInt = jopInt("Qual funcionário está realizando a venda?\n\n"+listarFunc());
                        produtoInt = jopInt("Qual produto está sendo vendido?\n\n"+listarProdutos());
                        clienteInt = jopInt("Para quem está sendo realizada a venda?\n\n"+listarClientes());
                        venderProduto(nomeInt, produtoInt, clienteInt);
                        break;
                    case 2:
                         //alterar venda
                        indice = jopInt("Qual o índice da venda?\n\n"+listarVendaInd());
                        nomeInt = jopInt("Qual o nome do vendedor?\n\n"+listarFunc());
                        produtoInt = jopInt("Qual produto está sendo vendido?\n\n"+listarProdutos());
                        clienteInt = jopInt("Para quem está sendo realizada a venda?\n\n"+listarClientes());
                        alterarVenda(indice, nomeInt, produtoInt, clienteInt);
                        break;
                    case 3:
                        jop(listarVenda());
                        break;
                    case 0:
                        jop("Retornando ao menu principal...");
                        break;
                    default:
                        jop("Opção inválida");
                        break;                     
                    }
                }
                break;
            case 0:
                //sair
                jop("Saindo do programa");
                break;
 
            default:
                jop("Opção inválida");
                break;
            }
       
        }
    }
       
        public static Integer jopInt(String mensagem) {
            Integer numero = 0;
            numero = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
            return numero;
        }
       
        public static Double jopDoub(String mensagem) {
            Double numero = 0.00;
            numero = Double.parseDouble(JOptionPane.showInputDialog(mensagem));
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
       
        public static void addFunc(String func, Integer idade) {
            funcionarios.add(func);
            idadesFunc.add(idade);
            jop("Funcionário cadastrado com sucesso!");
        }
       
        public static void alterarFunc(int x, String alteracao, Integer y) {
            funcionarios.set(x, alteracao);
            idadesFunc.set(x, y);
        }
              
        public static String listarVenda() {
            StringBuffer lista = new StringBuffer();
            lista = new StringBuffer();
            for (int i = 0; i < vendasProduto.size(); i++) {
            	lista.append("\n");
                lista.append("Produto vendido: "+produtos.get(vendasProduto.get(i)));
                lista.append("\n");
                lista.append("Vendedor: "+funcionarios.get(vendasFuncionario.get(i)));
                lista.append("\n");
                lista.append("Comprador: "+clientes.get(vendasCliente.get(i)));
                lista.append("\n");
                lista.append("Preço pago: "+precoProdutos.get(vendasProduto.get(i)));
                lista.append("\n");
                lista.append("===================");
                }
            return lista.toString();
        }
        
        public static String listarVendaInd() {
            StringBuffer lista = new StringBuffer();
            lista = new StringBuffer();
            for (int i = 0; i < vendasProduto.size(); i++) {
            	lista.append("\n");
            	lista.append("Índice: "+i);
            	lista.append("\n");
                lista.append("Produto vendido: "+produtos.get(vendasProduto.get(i)));
                lista.append("\n");
                lista.append("Vendedor: "+funcionarios.get(vendasFuncionario.get(i)));
                lista.append("\n");
                lista.append("Comprador: "+clientes.get(vendasCliente.get(i)));
                lista.append("\n");
                lista.append("Preço pago: "+precoProdutos.get(vendasProduto.get(i)));
                lista.append("\n");
                lista.append("===================");
                }
            return lista.toString();
        }
       
        public static String listarFunc() {
            StringBuffer lista = new StringBuffer();
            lista = new StringBuffer();
            for (int i = 0; i < funcionarios.size(); i++) {
                lista.append(i+" - "+funcionarios.get(i)+": "+idadesFunc.get(i)+" anos");
                lista.append("\n");
                }
            return lista.toString();}
        

        public static void addCliente(String nome, Integer idade) {
            clientes.add(nome);
            idadesClientes.add(idade);
            jop("Cliente cadastrado com sucesso!");
        }
       
        public static void alterarCliente(int x, String alteracao, Integer y) {
            clientes.set(x, alteracao);
            idadesClientes.set(x, y);
        }
       
        public static String listarClienteInd() {
            StringBuffer lista = new StringBuffer();
            lista = new StringBuffer();
            for (int i = 0; i < clientes.size(); i++) {
                lista.append(i+" - "+clientes.get(i));
                lista.append("\n");
                }
            return lista.toString();
        }
       
        public static String listarClientes() {
            StringBuffer lista = new StringBuffer();
            lista = new StringBuffer();
            for (int i = 0; i < clientes.size(); i++) {
                lista.append(i+" - "+clientes.get(i)+": "+idadesClientes.get(i)+" anos");
                lista.append("\n");
                }
            return lista.toString();
        }
       
        public static void addProduto(String nome, String vencimento, Double preco) {
            produtos.add(nome);
            validade.add(vencimento);
            precoProdutos.add(preco);
            jop("Produto cadastrado com sucesso!");
        }
       
        public static void alterarProduto(int x, String alteracao, Double y, String z) {
            produtos.set(x, alteracao);
            validade.set(x, z);
            precoProdutos.set(x, y);
        }
       
        public static String listarProdutos() {
            StringBuffer lista = new StringBuffer();
            lista = new StringBuffer();
            for (int i = 0; i < produtos.size(); i++) {
                lista.append(i+" - "+produtos.get(i)+": R$"+precoProdutos.get(i)+" - Vencimento: "+validade.get(i));
                lista.append("\n");
            }
            return lista.toString();
        }
       
        public static void venderProduto(int a, int b, int c) {
            //a = funcionario; b = produto; c = cliente
            vendasFuncionario.add(a);
            vendasProduto.add(b);
            vendasCliente.add(c);
        }
       
        public static void alterarVenda(int indice, int funcionario, int produto, int cliente) {
            vendasFuncionario.set(indice, funcionario);
            vendasProduto.set(indice, produto);
            vendasCliente.set(indice, cliente);
        }
       
}