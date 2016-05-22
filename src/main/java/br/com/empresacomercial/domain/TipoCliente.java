package br.com.empresacomercial.domain;

public enum TipoCliente {
		CPF("PessoaFisica", "1"), CNPJ("PessoaJuridica", "2");

		public final String DocumentoFederal;
		public final String numero;

		TipoCliente(String DocumentoFederal, String numero){
			this.DocumentoFederal = DocumentoFederal;
			this.numero = numero;
			
			
		}

}
