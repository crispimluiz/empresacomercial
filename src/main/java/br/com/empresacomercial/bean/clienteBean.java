package br.com.empresacomercial.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.empresacomercial.dao.ClienteDAO;
import br.com.empresacomercial.domain.Cliente;
import br.com.empresacomercial.domain.TipoCliente;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class clienteBean implements Serializable {
	private Cliente cliente;
	private TipoCliente tipoCliente;
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

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	@PostConstruct
	public void listar(){
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
			clienteDAO.salvar(cliente);
			Messages.addGlobalInfo("Cliente Salvo com Sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar os Clientes");
			erro.printStackTrace();
		}

	}

	public void excluir() {
		System.out.println("Teste de excluir");
	}

	public void editar() {
		System.out.println("Teste Editar");
	}
}
