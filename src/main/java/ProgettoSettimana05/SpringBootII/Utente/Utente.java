package ProgettoSettimana05.SpringBootII.Utente;

import java.util.Collection;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "utenti")
public class Utente implements UserDetails {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String cognome;
	private String username;
	@Column(nullable = false, unique = true)
	private String email;
	private String password;

	public Utente(String nome, String cognome, String username, String email, String password) {

		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", email="
				+ email + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return null;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


}
