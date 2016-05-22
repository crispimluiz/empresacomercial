package br.com.empresacomercial.domain;

public enum Porte {
	MICRO("1"), PEQUENO("2"), MEDIO("3"), GRANDE("4");

	private final String tamanho;

	Porte(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getTamanho() {
		return tamanho;
	}

}
