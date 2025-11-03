package calculaSuma;

public class CalculaSuma {
	
	public static void main(String[] args) {
		CalculaSuma c = new CalculaSuma();
		System.out.println(c.sumaNumeros(args[0], 10));
	}

	public int sumaNumeros(String tipo, int numero) {
		int contador = 0;
		if(tipo.equals("par")) {
			for(int i = 0; i <= numero; i++) {
				if(i %2 == 0) {
					contador += i;
				}
			}
		}else if(tipo.equals("impar")) {
			for(int i = 0; i <= numero; i++) {
				if(i % 3 == 0) {
					contador += i;
				}
			}
		}
		return contador;
		
	}
}
