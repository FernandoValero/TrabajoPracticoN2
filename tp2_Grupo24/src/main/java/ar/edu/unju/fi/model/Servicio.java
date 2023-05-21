package ar.edu.unju.fi.model;

public class Servicio {
	private String dia;
	private String paseador;
	private String horario;


	public Servicio() {
		// TODO Auto-generated constructor stub
	}
	public Servicio(String dia, String paseador, String horario) {
		super();
		this.dia = dia;
		this.paseador = paseador;
		this.horario = horario;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public  String getPaseador() {
		return paseador;
	}
	public void setPaseador(String paseador) {
		this.paseador = paseador;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	

	
	
}
