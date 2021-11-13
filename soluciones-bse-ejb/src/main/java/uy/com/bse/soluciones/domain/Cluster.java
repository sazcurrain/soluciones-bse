package uy.com.bse.soluciones.domain;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import jdk.jfr.BooleanFlag;

@Entity
public class Cluster extends SolInfra {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ips;
	private int cantNodos;
	private Boolean virtual;
	private int totalMemoriaRamGB;
	private int totalAlmacenamientoGB;
	private int TotalNumeroCPU;

	public Cluster() {
		// TODO Auto-generated constructor stub
		super();
	}

	@NotNull
	public String getIPs() {
		return ips;
	}

	public void setIPs(String ips) {
		this.ips = ips;
	}

	@PositiveOrZero
	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	@NotNull @BooleanFlag
	public Boolean getVirtual() {
		return virtual;
	}

	public void setVirtual(Boolean virtual) {
		this.virtual = virtual;
	}

	@PositiveOrZero
	public int getTotalMemoriaRamGB() {
		return totalMemoriaRamGB;
	}

	public void setTotalMemoriaRamGB(int totalMemoriaRamGB) {
		this.totalMemoriaRamGB = totalMemoriaRamGB;
	}

	@PositiveOrZero
	public int getTotalAlmacenamientoGB() {
		return totalAlmacenamientoGB;
	}

	public void setTotalAlmacenamientoGB(int totalAlmacenamientoGB) {
		this.totalAlmacenamientoGB = totalAlmacenamientoGB;
	}

	@PositiveOrZero
	public int getTotalNumeroCPU() {
		return TotalNumeroCPU;
	}

	public void setTotalNumeroCPU(int totalNumeroCPU) {
		TotalNumeroCPU = totalNumeroCPU;
	}
}