package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LerPropriedades {

	public static String retornarValor (String chave) {
		String retorno = null;
		
		Properties properties = new Properties();
		try {
			properties.load(new FileReader("configuracao/config.properties"));
			retorno = properties.getProperty(chave);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retorno;
	}
}
