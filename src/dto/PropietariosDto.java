package dto;

import java.time.LocalDate;

public class PropietariosDto {
		
		
		long idPropietario;
		String dni;
		String matricula;
		LocalDate fechaCompra;
		boolean esHistorico;
		public long getIdPropietario() {
			return idPropietario;
		}
		public void setIdPropietario(long idPropietario) {
			this.idPropietario = idPropietario;
		}
		public String getDni() {
			return dni;
		}
		public void setDni(String dni) {
			this.dni = dni;
		}
		public String getMatricula() {
			return matricula;
		}
		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}
		public LocalDate getFechaCompra() {
			return fechaCompra;
		}
		public void setFechaCompra(LocalDate fechaCompra) {
			this.fechaCompra = fechaCompra;
		}
		public boolean isEsHistorico() {
			return esHistorico;
		}
		public void setEsHistorico(boolean esHistorico) {
			this.esHistorico = esHistorico;
		}
		public PropietariosDto(long idPropietario, String dni, String matricula, LocalDate fechaCompra,
				boolean esHistorico) {
			super();
			this.idPropietario = idPropietario;
			this.dni = dni;
			this.matricula = matricula;
			this.fechaCompra = fechaCompra;
			this.esHistorico = esHistorico;
		}
		@Override
		public String toString() {
			return "PropietariosDto [idPropietario=" + idPropietario + ", dni=" + dni + ", matricula=" + matricula
					+ ", fechaCompra=" + fechaCompra + ", esHistorico=" + esHistorico + "]";
		}
		
		
		
		
		
		
		
		
}
