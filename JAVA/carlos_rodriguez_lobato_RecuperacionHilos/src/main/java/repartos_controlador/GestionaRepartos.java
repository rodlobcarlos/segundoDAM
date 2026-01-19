package repartos_controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import repartos_modelo.Pedidos;
import repartos_modelo.Repartidor;
import repartos_modelo.Zona;

public class GestionaRepartos {

	public static void main(String[] args) {

		Semaphore pedidoZona1 = new Semaphore(20);
		Semaphore pedidoZona2 = new Semaphore(10);

		List<Thread> list = new ArrayList<Thread>();
		Repartidor repartidorBici = new Repartidor("1", true, false, pedidoZona1);
		Repartidor repartidorMoto = new Repartidor("2", false, true, pedidoZona2);
		Pedidos pedidosBici = new Pedidos("1", Zona.ZONA1, null, pedidoZona1);
		Pedidos pedidosMoto = new Pedidos("2", Zona.ZONA2, null, pedidoZona2);

		for (int i = 0; i < 20; i++) {
			if (pedidosBici.getZona().equals(Zona.ZONA1)) {
				Thread hiloPedidosBici = new Thread(pedidosBici, " Pedido " + i);
				Thread hilo1 = new Thread(repartidorBici, " Repartidor " + i);
				list.add(hilo1);
				list.add(hiloPedidosBici);
				hiloPedidosBici.start();
				hilo1.start();
			}
		}

		for (int i = 0; i < 10; i++) {
			if (pedidosMoto.getZona().equals(Zona.ZONA2)) {
				Thread hiloPedidosMoto = new Thread(pedidosMoto, " Pedido " + i);
				Thread hilo2 = new Thread(repartidorMoto, " Repartidor " + i);
				list.add(hilo2);
				list.add(hiloPedidosMoto);
				hiloPedidosMoto.start();
				hilo2.start();
			}
		}

		for (Thread thread : list) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Numero de pedidos totales (Bici) = " + repartidorBici.getNumPedidos());
		System.out.println("Numero de pedidos totales (Moto) = " + repartidorMoto.getNumPedidos());
	}

}
