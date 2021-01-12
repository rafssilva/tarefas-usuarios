package view;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import controller.UsuarioController;
import model.Tarefa;
import model.Usuario;

@ManagedBean
@ViewScoped
public class TarefaView {

	private UsuarioController usuarioController;
	private List<Usuario> usuariosCadastrados;
	private String emailUsuarioSelecionado;
	private List<Tarefa> tarefas;
	private Tarefa tarefa;
	private Boolean desabilitado = true;

	@PostConstruct
	public void init() {
		usuarioController = new UsuarioController();
		usuariosCadastrados = usuarioController.listarUsuarios();
		criarNovaTarefa();
	}

	public void selecionarUsuario(ValueChangeEvent event) {
		emailUsuarioSelecionado = (String) event.getNewValue();
		atualizarListaTarefasUsuario();
		desabilitado = false;
	}

	public void atribuirTarefa() {
		usuarioController.atribuirTarefa(emailUsuarioSelecionado, tarefa);
		criarNovaTarefa();
	}

	public String voltar() {
		return "index";
	}

	private void criarNovaTarefa() {
		tarefa = new Tarefa();
	}

	private void atualizarListaTarefasUsuario() {
		tarefas = usuarioController.buscarTarefas(emailUsuarioSelecionado);
	}

	public List<Usuario> getUsuariosCadastrados() {
		return usuariosCadastrados;
	}

	public String getEmailUsuarioSelecionado() {
		return emailUsuarioSelecionado;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public Boolean getDesabilitado() {
		return desabilitado;
	}
}