package uy.com.bse.soluciones.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import jdk.jfr.BooleanFlag;

@Entity
public class Servidor extends SolInfra {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ip;
	private Boolean virtual;
	private int memoriaRamGB;
	private int almacenamientoGB;
	private String modeloCPU;
	private int numeroCPU;
	

	public Servidor() {
		// TODO Auto-generated constructor stub
		super();
	}

	@NotNull @Column(unique=true)
	public String getIP() {
		return ip;
	}

	public void setIP(String ip) {
		this.ip = ip;
	}

	@NotNull @BooleanFlag
	public Boolean getVirtual() {
		return virtual;
	}

	public void setVirtual(Boolean virtual) {
		this.virtual = virtual;
	}

	@PositiveOrZero
	public int getMemoriaRamGB() {
		return memoriaRamGB;
	}

	public void setMemoriaRamGB(int memoriaRamGB) {
		this.memoriaRamGB = memoriaRamGB;
	}

	@PositiveOrZero
	public int getAlmacenamientoGB() {
		return almacenamientoGB;
	}

	public void setAlmacenamientoGB(int almacenamientoGB) {
		this.almacenamientoGB = almacenamientoGB;
	}

	public String getModeloCPU() {
		return modeloCPU;
	}

	public void setModeloCPU(String modeloCPU) {
		this.modeloCPU = modeloCPU;
	}

	@PositiveOrZero
	public int getNumeroCPU() {
		return numeroCPU;
	}

	public void setNumeroCPU(int numeroCPU) {
		this.numeroCPU = numeroCPU;
	}
}
