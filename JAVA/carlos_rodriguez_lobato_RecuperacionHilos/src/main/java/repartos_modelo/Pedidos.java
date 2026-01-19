package repartos_modelo;

import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;

public class Pedidos implements Runnable {

	private String idCliente;
	private Zona zona;
	private LocalDateTime fechaReparto;
	private Semaphore pedido;

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public LocalDateTime getFechaReparto() {
		return fechaReparto;
	}

	public void setFechaReparto(LocalDateTime fechaReparto) {
		this.fechaReparto = fechaReparto;
	}

	public Semaphore getPedido() {
		return pedido;
	}

	public void setPedido(Semaphore pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "Pedidos [idCliente=" + idCliente + ", zona=" + zona + ", fechaReparto=" + fechaReparto + ", pedido="
				+ pedido + "]";
	}

	public Pedidos(String idCliente, Zona zona, LocalDateTime fechaReparto, Semaphore pedido) {
		super();
		this.idCliente = idCliente;
		this.zona = zona;
		this.fechaReparto = null;
		this.pedido = pedido;
	}

	@Override
	public void run() {
		try {
			pedido.acquire();
			System.out.println("Pedidos... " + getIdCliente());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println("Suelto pedidos. " + getIdCliente());
			setFechaReparto(LocalDateTime.now());
			System.out.println("Fecha actualizada del pedido asignado. " + this.fechaReparto);

		}
	}

}
