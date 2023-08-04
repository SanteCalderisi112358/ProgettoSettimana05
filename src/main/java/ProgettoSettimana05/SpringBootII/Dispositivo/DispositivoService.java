package ProgettoSettimana05.SpringBootII.Dispositivo;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DispositivoService {
	@Autowired
	DispositivoRepository dispositivoRepo;

	public Dispositivo checkAndCreate(DispositivoRequestPayload body) {
		if (body.getStatoDispositivo().equals(StatoDispositivo.ASSEGNATO)
				|| body.getStatoDispositivo().equals(StatoDispositivo.DISMESSO)
				|| body.getStatoDispositivo().equals(StatoDispositivo.IN_MANUTENZIONE)) {
			throw new NotFoundDispositivoException(
					"Il dispositivo è " + body.getStatoDispositivo() + " e non è assegnabile al dipendente");
		} else {
			Dispositivo nuovoDispositivo = new Dispositivo(body.getNome(), body.getMarca(), body.getTipoDispositivo(),
					StatoDispositivo.ASSEGNATO, body.getUtente());
			System.err.println(
					"Il disposito " + body.getNome() + " è stato assegnato al dipendente " + body.getUtente().getId()
							+ ".\nLo stato del dispositivo è passato da 'DISPONIBILE' a 'ASSEGNATO'");
			return dispositivoRepo.save(nuovoDispositivo);
		}

	}

	public Page<Dispositivo> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
		return dispositivoRepo.findAll(pageable);
	}

	public List<Dispositivo> findNoPage() {

		return dispositivoRepo.findAll();
	}

	public Dispositivo findById(UUID id) throws NotFoundDispositivoException {
		return dispositivoRepo.findById(id).orElseThrow(() -> new NotFoundDispositivoException(id));
	}

	public Dispositivo findByIdAndUpdate(UUID id, DispositivoRequestPayload body) throws NotFoundDispositivoException {
		Dispositivo found = this.findById(id);
		found.setNome(body.getNome());
		found.setMarca(body.getMarca());
		found.setStatoDispositivo(body.getStatoDispositivo());
		found.setTipoDispositivo(body.getTipoDispositivo());
		found.setUtente(body.getUtente());

		return dispositivoRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundDispositivoException {
		Dispositivo found = this.findById(id);
		dispositivoRepo.delete(found);
	}



}
