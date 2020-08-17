package senai;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressoesRegulares {
	
	public static void main(String[] args) {
		
		/***
		 * \d - todos os numeros
		 * \D - tudo que não for numero
		 * \s - espaços (\n \r \f \t)
		 * \S - caractar q n é branco
		 * \w - letras, numeros e o _
		 * \W - tudo que n seja letras e numeros
		 ***/
		
		String regex = "[0-9]{8}";
		String texto = "99999999 888 46579 9999f777";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		System.out.println("texto: "+texto);
		System.out.println("indice : 0123456789");
		System.out.println("expressao: "+matcher.pattern());
		System.out.println("posições encontradas");
		
		while(matcher.find()) {
			System.out.println(matcher.start() + " "+ matcher.group());
		}
	}

}