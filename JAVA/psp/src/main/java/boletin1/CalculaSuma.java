package boletin1;

public class CalculaSuma {

	public static void main(String[] args) {
		CalculaSuma c = new CalculaSuma();
		System.out.println(c.suma(args[0], 10));
	}

	public int suma(String tipo, int num) {
		int suma = 0;
		if (tipo.equals("par")) {
			for (int i = 0; i <= num; i++) {
				if (i % 2 == 0) {
					suma = suma + i;
				}
			}
		} else {
			if (tipo.equals("impar")) {
				for (int i = 0; i <= num; i++) {
					if (i % 3 == 0) {
						suma = suma + i;
					}
				}
			}
		}
		return suma;
	}
}