package br.com.project.util.all;

public enum EstatusPersistencia {
	
	ERRO("Erro"), SUCESSO("Sucesso"),
	OBJETO_REFERENCIADO("Esse objeto não pode ser apagado por possuir referências ao mesmo tempo.");
	
	private String name;
	
	private EstatusPersistencia(String s) {
		this.name = s;
	}
	
	public String toString() {
		return this.name;
	}

}
