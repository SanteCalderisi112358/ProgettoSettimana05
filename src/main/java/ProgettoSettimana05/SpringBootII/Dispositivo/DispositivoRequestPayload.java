package ProgettoSettimana05.SpringBootII.Dispositivo;

import ProgettoSettimana05.SpringBootII.Utente.Utente;

public class DispositivoRequestPayload {

	private String nome;
	private String marca;
	private TipoDispositivo tipoDispositivo;
	private StatoDispositivo statoDispositivo;
	private Utente utente;

	public DispositivoRequestPayload(String nome, String marca, TipoDispositivo tipoDispositivo,
			StatoDispositivo statoDispositivo, Utente utente) {

		this.nome = nome;
		this.marca = marca;
		this.tipoDispositivo = tipoDispositivo;
		this.statoDispositivo = statoDispositivo;
		this.utente = utente;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public String getNome() {
		return nome;
	}

	public String getMarca() {
		return marca;
	}

	public TipoDispositivo getTipoDispositivo() {
		return tipoDispositivo;
	}

	public StatoDispositivo getStatoDispositivo() {
		return statoDispositivo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

	public void setStatoDispositivo(StatoDispositivo statoDispositivo) {
		this.statoDispositivo = statoDispositivo;
	}

	@Override
	public String toString() {
		return "DispositivoRequestPayload [nome=" + nome + ", marca=" + marca + ", tipoDispositivo=" + tipoDispositivo
				+ ", statoDispositivo=" + statoDispositivo + "]";
	}

}
