package agenda;

public class Contato {
    private String nome;
    private String sobrenome;
    private String telefone;

    
    public Contato(String nome, String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }


    public String getNome() {
        return this.nome;
    }
    

    public String getSobrenome() {
        return this.sobrenome;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }

        Contato oContato = (Contato) o;
        if (this.nome.equals(oContato.nome) && this.sobrenome.equals(oContato.sobrenome)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.nome + " " + this.sobrenome + "\n" + this.telefone;
    }
}
