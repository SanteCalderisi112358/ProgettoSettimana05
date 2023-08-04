package ProgettoSettimana05.SpringBootII.Utente;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UtenteLoginSuccessful {
	private String token;
	private String nome;
	private String cognome;
	private String username;

	public UtenteLoginSuccessful(String token, String nome, String cognome, String username) {

		this.token = token;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
	}
	@Override
	public String toString() {
		return "UtenteLoginSuccessful [token=" + token + ", nome=" + nome + ", cognome=" + cognome + ", username="
				+ username + "]";
	}



}
