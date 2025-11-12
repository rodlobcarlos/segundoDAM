package hilos;

// Clase que representa un hilo hijo
class HiloHijo extends Thread {
    private int id;

    public HiloHijo(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("Hilo hijo " + id + ": iniciado.");
            Thread.sleep(5000); // Simula trabajo de 5 segundos
            System.out.println("Hilo hijo " + id + ": terminado.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Clase que actúa como "padre" y contiene el método que lanza y espera a los hijos
class PadreConVariosHilos {

    // Método que lanza varios hilos hijos y los espera
    public void ejecutarHilos() {
    

        int numHijos = 3;
        HiloHijo[] hijos = new HiloHijo[numHijos];

        System.out.println("Hilo padre: creando " + numHijos + " hilos hijos...");

        // Crear y lanzar los hilos hijos
        for (int i = 0; i < numHijos; i++) {
            hijos[i] = new HiloHijo(i + 1);
            hijos[i].start();
        }

        // Esperar a que todos los hijos terminen
        for (int i = 0; i < numHijos; i++) {
            try {
                hijos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        
        System.out.println("Hilo padre: todos los hijos terminaron.");
    
    }
}

// Clase principal con el método main
public class EjemplosHilos {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        PadreConVariosHilos padre = new PadreConVariosHilos();
        padre.ejecutarHilos(); // Ejecuta la lógica del padre con varios hilos hijos
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo total del hilo padre: " + (fin - inicio) + " ms");
    }
}
