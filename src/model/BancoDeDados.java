package model;

import java.util.Map;
import java.util.TreeMap;

public class BancoDeDados {

	public static Map<String, Usuario> usuariosCadastrados = new TreeMap<String, Usuario>(
			String.CASE_INSENSITIVE_ORDER);
}