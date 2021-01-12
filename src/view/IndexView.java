package view;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class IndexView {

	public String cadastroUsuarios() {
		return "cadastro";
	}

	public String gerenciamentoTarefas() {
		return "tarefa";
	}
}