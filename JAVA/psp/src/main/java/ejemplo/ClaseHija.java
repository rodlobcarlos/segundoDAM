package ejemplo;

import java.io.FileNotFoundException;

public class ClaseHija {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Esto leyendo desde el hijo " + 7);
		throw new FileNotFoundException();
	}
}
