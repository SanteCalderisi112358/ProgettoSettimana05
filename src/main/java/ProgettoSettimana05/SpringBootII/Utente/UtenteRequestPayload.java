package ProgettoSettimana05.SpringBootII.Utente;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class UtenteRequestPayload {

	private String nome;
	private String cognome;
	private String username;
	private String email;
	private String password;

	public UtenteRequestPayload(String nome, String cognome, String username, String email, String password) {

		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "UtenteRequestPayload [nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", email="
				+ email + "]";
	}


}
