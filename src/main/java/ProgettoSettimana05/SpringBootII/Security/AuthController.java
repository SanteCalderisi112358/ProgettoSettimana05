package ProgettoSettimana05.SpringBootII.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import ProgettoSettimana05.SpringBootII.Exception.UnauthorizedException;
import ProgettoSettimana05.SpringBootII.Utente.Utente;
import ProgettoSettimana05.SpringBootII.Utente.UtenteLoginPayload;
import ProgettoSettimana05.SpringBootII.Utente.UtenteLoginSuccessful;
import ProgettoSettimana05.SpringBootII.Utente.UtenteRequestPayload;
import ProgettoSettimana05.SpringBootII.Utente.UtenteService;

@Controller
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	UtenteService usersService;

	@Autowired
	JWTTools jwtTools;

	@PostMapping("/registrazione")
	@ResponseStatus(HttpStatus.CREATED)
	public Utente saveUser(@RequestBody UtenteRequestPayload body) {
		Utente created = usersService.create(body);

		return created;
	}

	@PostMapping("/login")
	public ResponseEntity<UtenteLoginSuccessful> login(@RequestBody UtenteLoginPayload body) {


		Utente user = usersService.findByEmail(body.getEmail());

		if (body.getPassword().equals(user.getPassword())) {


			String token = jwtTools.createToken(user);
			String nome = user.getNome();
			String cognome = user.getCognome();
			String username = user.getUsername();
			UtenteLoginSuccessful loginAvvenuto = new UtenteLoginSuccessful(token, nome, cognome, username);
			return new ResponseEntity<>(loginAvvenuto, HttpStatus.OK);

		} else {

			throw new UnauthorizedException("Credenziali non valide!");
		}
	}

}
