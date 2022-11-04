package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	
	private Contato[] contatos;

	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[10];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	public Contato[] getFavoritos() {
		return this.favoritos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		if (this.contatos[posicao - 1] == null || posicao > 100 || posicao < 0) {
			throw new IllegalArgumentException("\nPOSIÇÃO INVÁLIDA");
		} else {
			return this.contatos[posicao - 1];
		}
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		verificaCadastroContato(posicao, nome, sobrenome, telefone);
		this.contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
	}

	private void verificaCadastroContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao < 0 || posicao > 100) {
			throw new IllegalArgumentException("\nPOSIÇÃO INVÁLIDA");
		}

		if (nome.isEmpty() || telefone.isEmpty()) {
			throw new IllegalArgumentException("\nCONTATO INVÁLIDO");
		}

		Contato testeContato = new Contato(nome, sobrenome, telefone);
		for (Contato con : this.contatos) {
			if (con != null) {
				if (con.equals(testeContato)) {
					throw new IllegalArgumentException("\nCONTATO JÁ CADASTRADO");
				}
			}
		}
	}

	private void verificaCadastroFavorito(int idContato, int posicao) {
		Contato testeContato = this.contatos[idContato - 1];
		
		for (Contato fav : this.favoritos) {
			if (fav != null) {
				if (fav.equals(testeContato)){
					throw new IllegalArgumentException("\nO CONTATO JÁ SE ENCONTRA NOS FAVORITOS");
				}
			}
		}

		if (posicao < 0 || posicao > 100) {
			throw new IllegalArgumentException("\nPOSIÇÃO INVÁLIDA");
		}
	}

	public void adicionaFavorito(int contato, int posicao) {
		verificaCadastroFavorito(contato, posicao);
		this.favoritos[posicao - 1] = this.getContato(contato);
	}

	public void removeFavorito(int posicao) {
		this.favoritos[posicao - 1] = null;
	}
}
