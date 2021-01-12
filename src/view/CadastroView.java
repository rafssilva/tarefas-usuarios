package view;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import controller.UsuarioController;
import model.Usuario;

@ManagedBean
@ViewScoped
public class CadastroView {

	private Usuario usuario;
	private UsuarioController usuarioController;
	private List<Usuario> usuariosCadastrados;
	private UIComponent component;

	@PostConstruct
	public void init() {
		usuarioController = new UsuarioController();
		atualizarListaUsuarios();
		novoUsuario();
	}

	public void cadastrar() {
		if (usuarioController.cadastrar(usuario)) {
			atualizarListaUsuarios();
			novoUsuario();
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(component.getClientId(), new FacesMessage("E-mail já cadastrado nesta base de dados"));
		}
	}

	public String voltar() {
		return "index";
	}

	private void atualizarListaUsuarios() {
		usuariosCadastrados = usuarioController.listarUsuarios();
	}

	private void novoUsuario() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public List<Usuario> getUsuariosCadastrados() {
		return usuariosCadastrados;
	}

	public UIComponent getComponent() {
		return component;
	}

	public void setComponent(UIComponent component) {
		this.component = component;
	}
}