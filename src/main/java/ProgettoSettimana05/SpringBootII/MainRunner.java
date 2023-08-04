package ProgettoSettimana05.SpringBootII;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import ProgettoSettimana05.SpringBootII.Dispositivo.DispositivoRequestPayload;
import ProgettoSettimana05.SpringBootII.Dispositivo.DispositivoService;
import ProgettoSettimana05.SpringBootII.Dispositivo.NotFoundDispositivoException;
import ProgettoSettimana05.SpringBootII.Dispositivo.StatoDispositivo;
import ProgettoSettimana05.SpringBootII.Dispositivo.TipoDispositivo;
import ProgettoSettimana05.SpringBootII.Utente.Utente;
import ProgettoSettimana05.SpringBootII.Utente.UtenteService;

@Component
public class MainRunner implements CommandLineRunner {
	@Autowired
	UtenteService utenteSrv;
	@Autowired
	DispositivoService dispositivoSrv;

	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker(Locale.ITALIAN);
		/* ISTANZIO 30 DIPENDENTI RANDOM CON FAKER E LI SALVO NEL DB */
//		for (int i = 0; i < 5; i++) {
//			String name = faker.name().firstName();
//			String surname = faker.name().lastName();
//			String email = faker.internet().emailAddress();
//			String username = faker.lordOfTheRings().character();
//			String password = String.valueOf(faker.number().numberBetween(1000, 9999));
//			UtenteRequestPayload user = new UtenteRequestPayload(name, surname, username, email, password);
//			utenteSrv.create(user);
//		}
		/*
		 * INIZIALIZZAZIONE 10 SMARTPHONE, 10 LAPTOT E 10 TABLET E LI SALVO NEL DB il
		 * loro numero è inferiore rispetto a quello voluto a causa dei controlli in
		 * create() di dispositivoSrv
		 */

		List<Utente> listaUtenti = utenteSrv.findNoPage();
		System.err.println("DIPENDENTI");
		listaUtenti.forEach(u -> System.err.println(u));
		/* 10 SMARTPHONE */
		for (int i = 0; i < 10; i++) {
			String nome = faker.backToTheFuture().character();
			String marca = faker.beer().name();
			TipoDispositivo tipoDispositivo = TipoDispositivo.SMARTPHONE;
			StatoDispositivo statoDispositivo = StatoDispositivo.values()[new Random()
					.nextInt(StatoDispositivo.values().length)];
			Utente utente = listaUtenti.get(faker.number().numberBetween(0, listaUtenti.size() - 1));
			DispositivoRequestPayload nuovoDispositivo = new DispositivoRequestPayload(nome, marca, tipoDispositivo,
					statoDispositivo, utente);
			try {
				dispositivoSrv.create(nuovoDispositivo);
			} catch (NotFoundDispositivoException e) {
				System.err.println(e.getMessage());
			}

			System.err.println(nuovoDispositivo.toString());
		}
		/* 10 LAPTOT */
		for (int i = 0; i < 10; i++) {
			String nome = faker.backToTheFuture().character();
			String marca = faker.beer().name();
			TipoDispositivo tipoDispositivo = TipoDispositivo.LAPTOT;
			StatoDispositivo statoDispositivo = StatoDispositivo.values()[new Random()
					.nextInt(StatoDispositivo.values().length)];
			Utente utente = listaUtenti.get(faker.number().numberBetween(0, listaUtenti.size() - 1));
			DispositivoRequestPayload nuovoDispositivo = new DispositivoRequestPayload(nome, marca, tipoDispositivo,
					statoDispositivo, utente);
			try {
				dispositivoSrv.create(nuovoDispositivo);
			} catch (NotFoundDispositivoException e) {
				System.err.println(e.getMessage());
			}
		}
		/* 10 TABLET */
		for (int i = 0; i < 10; i++) {
			String nome = faker.backToTheFuture().character();
			String marca = faker.beer().name();
			TipoDispositivo tipoDispositivo = TipoDispositivo.TABLET;
			StatoDispositivo statoDispositivo = StatoDispositivo.values()[new Random()
					.nextInt(StatoDispositivo.values().length)];
			Utente utente = listaUtenti.get(faker.number().numberBetween(0, listaUtenti.size() - 1));
			DispositivoRequestPayload nuovoDispositivo = new DispositivoRequestPayload(nome, marca, tipoDispositivo,
					statoDispositivo, utente);
			try {
				dispositivoSrv.create(nuovoDispositivo);
			} catch (NotFoundDispositivoException e) {
				System.err.println(e.getMessage());
			}
		}


	}



}