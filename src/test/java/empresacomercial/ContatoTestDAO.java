package empresacomercial;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.empresacomercial.dao.ClienteDAO;
import br.com.empresacomercial.dao.ContatoDAO;
import br.com.empresacomercial.domain.Cargo;
import br.com.empresacomercial.domain.Cliente;
import br.com.empresacomercial.domain.Contato;
import br.com.empresacomercial.domain.Departamento;

public class ContatoTestDAO {
	@Test
	@Ignore
	public void salvar() {
		Long codigoCliente = 2L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCliente);

		Contato contato = new Contato();
		contato.setCliente(cliente);
		contato.setNomeContato("Joaquim de Oliveira");
		contato.setEmailContato("fjldkfj@kdlkdf.com");
		contato.setTelefoneContato("4328429892");
		contato.setCargo(Cargo.VENDEDOR);
		contato.setDepartamento(Departamento.SERVIÇOS);

		ContatoDAO contatoDAO = new ContatoDAO();
		contatoDAO.salvar(contato);

		System.out.println("Usuário Salvo com sucesso");

	}

	@Test
	@Ignore
	public void listar() {

		ContatoDAO contatoDAO = new ContatoDAO();
		List<Contato> resultado = contatoDAO.Listar();

		for (Contato contato : resultado) {

			System.out.println(contato.getCodigo() + " - " + contato.getNomeContato() + " - "
					+ contato.getEmailContato() + " - " + contato.getTelefoneContato());

		}

	}

}