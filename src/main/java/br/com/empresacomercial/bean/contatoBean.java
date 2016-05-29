package br.com.empresacomercial.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.empresacomercial.dao.ClienteDAO;
import br.com.empresacomercial.dao.ContatoDAO;
import br.com.empresacomercial.domain.Cliente;
import br.com.empresacomercial.domain.Contato;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class contatoBean implements Serializable {
	private Contato contato;
	private List<Contato> contatos;
	private List<Cliente> clientes;

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@PostConstruct
	public void listar() {
		try {
			contato = new Contato();
			
			ContatoDAO contatoDAO = new ContatoDAO();
			contatos = contatoDAO.Listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Listar os Contatos");
			erro.printStackTrace();
		}

	}

	public void novo() {
		try {
			contato = new Contato();

			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.Listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Listar os Clientes");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			ContatoDAO contatoDAO = new ContatoDAO();
			contatoDAO.merge(contato);

			novo();

			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.Listar();

			contatos = contatoDAO.Listar();

			Messages.addGlobalInfo("Contato Salvo com Sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar os Contatos");
			erro.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {
		try {
			contato = (Contato) evento.getComponent().getAttributes().get("contatoSelecionado");

			ContatoDAO contatoDAO = new ContatoDAO();
			contatoDAO.excluir(contato);

			contatos = contatoDAO.Listar();

			Messages.addGlobalInfo("Contato Excluido com Sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o Contato");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			contato = (Contato) evento.getComponent().getAttributes().get("contatoSelecionado");
			
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.Listar();
			
			Messages.addGlobalInfo("Cliente Editado com Sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar Editar Contato");
			erro.printStackTrace();
		}
	}
}