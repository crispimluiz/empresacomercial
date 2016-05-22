package conexaoTest;

import org.hibernate.Session;
import org.junit.Test;

import br.com.empresacomercial.util.HibernateUtil;

public class hibernateUtilTest {
	@Test
	public void conectar(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();;
	}

}
