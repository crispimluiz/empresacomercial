package br.com.empresacomercial.domain;

public enum Cargo {
	COMPRADOR("1"), VENDEDOR("2"), AUXILIAR_ADMINISTRATIVO("3"), GERENTE("4"), DIRETOR("5");

	private final String setor;

	Cargo(String setor) {
		this.setor = setor;
	}

	public String getSetor() {
		return setor;
	}
}