package br.com.empresacomercial.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.empresacomercial.dao.ClienteDAO;
import br.com.empresacomercial.domain.Cliente;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class clienteBean implements Serializable {
	private Cliente cliente;
	private List<Cliente> clientes;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.Listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Listar os Clientes");
			erro.printStackTrace();
		}
	}

	public void novo() {
		cliente = new Cliente();
	}

	public void salvar() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.merge(cliente);

			novo();

			clientes = clienteDAO.Listar();

			Messages.addGlobalInfo("Cliente Salvo com Sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar os Clientes");
			erro.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {
		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("pessoaSelecionada");
			ClienteDAO clienteDAO = new ClienteDAO();

			clienteDAO.excluir(cliente);

			clientes = clienteDAO.Listar();

			Messages.addGlobalInfo("Cliente Excluido com Sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o Cliente");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("pessoaSelecionada");

			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.Listar();

			Messages.addGlobalInfo("Cliente Editado com Sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar Editar um Cliente");
			erro.printStackTrace();
		}
	}
}
