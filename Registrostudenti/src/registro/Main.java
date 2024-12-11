/*Gestione di un Registro di Studenti
Creare un programma Java che consenta di gestire un registro degli studenti. Il programma deve:

Registrare nuovi studenti con:
Nome,
Cognome,
Matricola (univoca).
Visualizzare l'elenco degli studenti.
Cercare uno studente tramite la matricola.
Requisiti Tecnici:
Creare una classe Studente con i campi necessari.
Utilizzare un ArrayList per memorizzare gli studenti.
Creare un menu testuale che permetta all'utente di:

Aggiungere uno studente.
Visualizzare tutti gli studenti.
Cercare uno studente per matricola.
Uscire dal programma*/

package registro;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	// Creazione dell'ArrayList degli studenti e apertura scanner

	public static ArrayList<Studente> studenti = new ArrayList<Studente>();
	static Scanner s = new Scanner(System.in);

	// Metodo per aggiungere un nuovo studente

	public static void aggiungiStudente() {

		System.out.print("Nome: ");
		String nome = s.nextLine();

		System.out.print("Cognome: ");
		String cognome = s.nextLine();

		System.out.print("N. Matricola: ");
		String matricola = s.nextLine();

		// Verifica se la matricola è già esistente

		if (controlloMatricola(matricola)) {
			System.out.println("Questo studente è già presente in registro.");
			return;
		}

		Studente nuovoStudente = new Studente(nome, cognome, matricola);
		studenti.add(nuovoStudente);

	}

	// Metodo per visualizzre tutti gli studenti

	public static void elencoStudenti() {
		System.out.println("Elenco Studenti: ");
		for (int i = 0; i < studenti.size(); i++) {
			System.out.println(studenti.get(i));
		}

	}

	// Metodo per cercare uno studente per matricola

	public static void cercaMatricola() {
		System.out.print("Inserisci matricola: ");
		String matricola = s.nextLine();

		for (Studente studente : studenti) {
			if (studente.getMatricola().equals(matricola)) {
				System.out.println("Studente presente");
				return;
			}
		}
		System.out.println("Nessuno studente trovato con questa matricola: " + matricola);
	}

	// Metodo per verificare se esiste già la matricola inserita

	public static boolean controlloMatricola(String matricola) {
		for (Studente studente : studenti) {
			if (studente.getMatricola().equals(matricola)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		// Creazione menù testuale

		boolean esci = false;

		while (!esci) {
			System.out.print("REGISTRO STUDENTI\n");
			System.out.println(
					"1.Aggiungi Studente\n2.Visualizza tutti gli studenti\n3.Cerca studente per matricola\n4.Esci");
			System.out.print("Inserisci un' azione valida: ");

			int scelta = s.nextInt();
			s.nextLine();

			switch (scelta) {
			case 1:
				aggiungiStudente();
				break;
			case 2:
				elencoStudenti();
				break;
			case 3:
				cercaMatricola();
				break;
			case 4:
				esci = true;
				System.out.println("Sei uscito dal programma");
				break;
			default:
				System.out.println("Opzione non valida");
			}
		}

		s.close();

	}

}
