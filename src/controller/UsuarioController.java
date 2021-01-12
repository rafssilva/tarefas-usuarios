package controller;

import java.util.ArrayList;
import java.util.List;
import model.BancoDeDados;
import model.Tarefa;
import model.Usuario;

public class UsuarioController {

	public boolean cadastrar(Usuario usuario) {
		if (emailNaoUnico(usuario)) {
			return false;
		} else {
			BancoDeDados.usuariosCadastrados.put(usuario.getEmail(), usuario);
			return true;
		}
	}

	public void atribuirTarefa(String emailUsuario, Tarefa tarefa) {
		Usuario usuario = buscarUsuario(emailUsuario);
		usuario.getTarefas().add(tarefa);
		alterar(usuario);
	}

	public Usuario buscarUsuario(String emailUsuario) {
		return BancoDeDados.usuariosCadastrados.get(emailUsuario);
	}

	public void alterar(Usuario usuario) {
		BancoDeDados.usuariosCadastrados.put(usuario.getEmail(), usuario);
	}

	public List<Tarefa> buscarTarefas(String emailUsuario) {
		return BancoDeDados.usuariosCadastrados.get(emailUsuario).getTarefas();
	}

	public List<Usuario> listarUsuarios() {
		return new ArrayList<>(BancoDeDados.usuariosCadastrados.values());
	}

	private boolean emailNaoUnico(Usuario usuario) {
		return BancoDeDados.usuariosCadastrados.containsKey(usuario.getEmail());
	}
}