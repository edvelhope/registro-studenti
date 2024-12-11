package registro;

// Classe che rappresenta uno studente

public class Studente {
	private String nome;
	private String cognome;
	private String matricola;

	// Costruttore

	public Studente(String nome, String cognome, String matricola) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
	}
	
	// Metodo che restituisce matricola usato in controlloMatricola

	public String getMatricola() {
		return matricola;
	}

	// Metodo per stampare le informazioni degli studenti

	public String toString() {
		return "Matricola: " + matricola + ", Nome: " + nome + ", Cognome: " + cognome;
	}

}
