package ejeArrayList.eje01;

public class Coche {
	private String modelo;
	private boolean motor;
	private int velocidad;
	private int velocidadMax;
	public int distanciaParcial;
	public int distanciaTotal;

	Coche(String modelo, int velocidadMax) {
		this.modelo = modelo;
		this.distanciaParcial = 0;
		this.distanciaTotal = 0;
		this.velocidad = 0;
		this.velocidadMax = velocidadMax;
		this.motor = false;
	}

	public boolean arrancar() {
		if (motor) {
			infoError("Motor ya arrancado");
			return false;
		} else {
			motor = true;
			return true;
		}
	}

	public boolean parar() {
		if (!motor) {
			infoError("Motor ya esta parado");
			return false;
		}
		if (velocidad != 0) {
			infoError("No se puede parar con el vehiculo en marcha");
			return false;
		}

		motor = false;
		distanciaParcial = 0;

		return true;
	}

	public boolean acelera(int cantidad) {
		if (motor) {
			velocidad = velocidad + cantidad;
			if (velocidad > velocidadMax) {
				velocidad = velocidadMax;
			}
			return true;
		} else {
			infoError(" Motor parado. No se puede acelerar");
			return false;
		}
	}

	public boolean frena(int cantidad) {
		if (motor) {
			velocidad = velocidad - cantidad;
			if (velocidad < 0) {
				velocidad = 0;
			}
			return true;
		} else {
			infoError(" Motor parado. No se puede frenar");
			return false;
		}
	}

	public boolean recorre() {
		if (motor) {
			distanciaParcial += velocidad;
			distanciaTotal += velocidad;
			return true;
		} else {
			infoError(" Motor parado. No se puede avanzar ");
			return false;
		}
	}

	public String info() {
		return this.modelo + " Motor encendido: " + motor + " km :" + distanciaParcial + " Velocidad:" + velocidad;
	}

	public int getKilometros() {
		return distanciaParcial;
	}

	private void infoError(String mensaje) {
		System.err.println(mensaje);
	}

	public String getModelo() {
		return this.modelo;
	}
}