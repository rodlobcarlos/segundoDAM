package repartos_modelo;

import java.util.concurrent.Semaphore;

public class Repartidor implements Runnable {

	private String idRepartidor;
	private boolean esBici;
	private boolean esMoto;
	private int numPedidos;
	private Semaphore pedido;

	public Semaphore getPedido() {
		return pedido;
	}

	public void setPedido(Semaphore pedido) {
		this.pedido = pedido;
	}

	public boolean isEsBici() {
		return esBici;
	}

	public void setEsBici(boolean esBici) {
		this.esBici = esBici;
	}

	public boolean isEsMoto() {
		return esMoto;
	}

	public void setEsMoto(boolean esMoto) {
		this.esMoto = esMoto;
	}

	public String getIdRepartidor() {
		return idRepartidor;
	}

	public void setIdRepartidor(String idRepartidor) {
		this.idRepartidor = idRepartidor;
	}

	public int getNumPedidos() {
		return numPedidos;
	}

	public void setNumPedidos(int numPedidos) {
		this.numPedidos = numPedidos;
	}

	@Override
	public String toString() {
		return "Repartidor [idRepartidor=" + idRepartidor + ", esBici=" + esBici + ", esMoto=" + esMoto
				+ ", numPedidos=" + numPedidos + ", pedido=" + pedido + "]";
	}

	public Repartidor(String idRepartidor, boolean esBici, boolean esMoto, Semaphore pedido) {
		super();
		this.idRepartidor = idRepartidor;
		this.esBici = esBici;
		this.esMoto = esMoto;
		this.pedido = pedido;
	}

	@Override
	public void run() {
		repartidorBici();
		repartidorMoto();
	}

	public void repartidorBici() {
		numPedidos += 1;
		if (esBici) {
			try {
				System.out.println("Tengo un pedido (Bici). " + Thread.currentThread().getName());
				pedido.acquire(2);
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				pedido.release(2);
				System.out.println("Pedido entregado. " + Thread.currentThread().getName());
			}
		}
	}

	public void repartidorMoto() {
		if (esMoto) {
			try {
				pedido.acquire(4);
				System.out.println("Tengo un pedido (Moto). " + Thread.currentThread().getName());
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				pedido.release(4);
				System.out.println("Pedido entregado." + Thread.currentThread().getName());
			}
		}
	}
}
