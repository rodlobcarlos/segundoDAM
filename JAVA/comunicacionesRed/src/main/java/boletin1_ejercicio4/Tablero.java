package boletin1_ejercicio4;

public class Tablero {
    private String[][] matriz;
    private int premiosRestantes;

    public Tablero() {
        // Matriz de 3 filas y 4 columnas
        this.matriz = new String[3][4];
        
        // Inicializamos los premios (usando índices 0-indexed para el código)
        // Posición [1,1] -> [0][0]
        matriz[0][0] = "Crucero";
        // Posición [2,3] -> [1][2]
        matriz[1][2] = "Masaje";
        // Posición [3,1] -> [2][0]
        matriz[2][0] = "Entradas";
        // Posición [3,4] -> [2][3]
        matriz[2][3] = "1000€";
        
        this.premiosRestantes = 4;
    }

    public synchronized int getPremiosRestantes() {
        return premiosRestantes;
    }

    /**
     * Intenta capturar un premio. 
     * @param f Fila (1-3)
     * @param c Columna (1-4)
     * @return El nombre del premio, "NADA" si está vacío, o "YA_CAPTURADO"
     */
    public synchronized String intentarCapturarPremio(int f, int c) {
        // Validar si la posición es correcta (1-based)
        if (f < 1 || f > 3 || c < 1 || c > 4) return "ERROR_RANGO";
        
        String premio = matriz[f-1][c-1];
        
        if (premio != null) {
            matriz[f-1][c-1] = null; // El premio desaparece
            premiosRestantes--;
            return premio;
        } else {
            return "NADA";
        }
    }
}