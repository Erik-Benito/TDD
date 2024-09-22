public class Email {
    private int id;
    private String nome;

    public Email(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isValid() {
        // Valida se o e-mail contém "@" e pelo menos um ponto depois do "@"
        return nome.matches("^[\\w\\.-]+@[\\w\\.-]+\\.[a-z]{2,}$");
    }
}
