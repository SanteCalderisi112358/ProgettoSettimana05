package ProgettoSettimana05.SpringBootII.Dispositivo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ProgettoSettimana05.SpringBootII.Exception.DeleteDispositivoImpossibileRelazioneDispositivoException;

@RestController
@RequestMapping("/dispositivi")
public class DispositivoController {
	@Autowired
	DispositivoService dispositivoSrv;

	@GetMapping
	public Page<Dispositivo> getUtenti(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return dispositivoSrv.find(page, size, sortBy);
	}

	@GetMapping("/{id}")
	public Dispositivo findById(@PathVariable UUID id) {
		return dispositivoSrv.findById(id);

	}

	@PutMapping("/{id}")
	public Dispositivo updateDispositivo(@PathVariable UUID id, @RequestBody DispositivoRequestPayload body) {
		return dispositivoSrv.findByIdAndUpdate(id, body);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteDispositivo(@PathVariable UUID id) {
		try {
			dispositivoSrv.findByIdAndDelete(id);
		} catch (DeleteDispositivoImpossibileRelazioneDispositivoException ex) {
			System.err.println(ex.getMessage());
		}

	}
}
