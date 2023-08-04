package ProgettoSettimana05.SpringBootII.Utente;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
	private final UtenteRepository utenteRepo;

	@Autowired
	public UtenteService(UtenteRepository utenteRepo) {

		this.utenteRepo = utenteRepo;
	}

	public Utente create(UtenteRequestPayload body) {
		// check if email already in use
//		utenteRepo.findByEmail(body.getEmail()).ifPresent(user -> {
//			throw new BadRequestException("L'email è già stata utilizzata");
//		});
		Utente newUser = new Utente(body.getNome(), body.getCognome(), body.getUsername(), body.getEmail(),
				body.getPassword());
		return utenteRepo.save(newUser);
	}



	public Page<Utente> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
		return utenteRepo.findAll(pageable);
	}

	public List<Utente> findNoPage() {

		return utenteRepo.findAll();
	}

	public Utente findById(UUID id) throws NotUtenteFoundException {
		return utenteRepo.findById(id).orElseThrow(() -> new NotUtenteFoundException(id));
	}

	public Utente findByIdAndUpdate(UUID id, UtenteRequestPayload body) throws NotUtenteFoundException {
		Utente found = this.findById(id);
		found.setEmail(body.getEmail());
		found.setNome(body.getNome());
		found.setCognome(body.getCognome());
		found.setUsername(body.getUsername());

		return utenteRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotUtenteFoundException {
		Utente found = this.findById(id);
		if (found != null) {
			utenteRepo.delete(found);
		} else {
			throw new NotUtenteFoundException(id);
		}

	}

	public Utente findByEmail(String email) {
		return utenteRepo.findByEmail(email)
				.orElseThrow(() -> new NotUtenteFoundException("Utente con email " + email + " non trovato"));
	}

}

