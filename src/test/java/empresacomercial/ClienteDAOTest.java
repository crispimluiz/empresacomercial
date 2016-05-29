package empresacomercial;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.empresacomercial.dao.ClienteDAO;
import br.com.empresacomercial.domain.Cliente;

public class ClienteDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Cliente cliente = new Cliente();
		cliente.setNomeCliente("Marcos Eduardo");
		cliente.setCidade("Araguari");
		cliente.setEmail("antonio@live.com");
		cliente.setTelefone("83209000074");
		cliente.setEndereco("Rua Joao Almeida, 40");
		cliente.setDataCadastro(new Date());
		cliente.setLimiteCredito(1600.00);
		cliente.setEstado("MG");
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
		
		
		
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if (cliente == null) {
			System.out.println("Nenhum estado escontrado, favor colocar uma opção válida!");
		} else {
			System.out.println("Registro encontrado: ");
			System.out.println(cliente.getNome() + " - " + cliente.getEndereco());
		}

	}

	@Test
	@Ignore
	public void listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.Listar();

		for (Cliente cliente : resultado) {
			System.out.println(cliente.getCodigo()+ " - " + cliente.getNome() + " - " + cliente.getEndereco()
			+ " - " +cliente.getLimiteCredito());
		}
	}
}
