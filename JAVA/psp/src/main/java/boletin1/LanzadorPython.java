package boletin1;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LanzadorPython {
	private static final String diractorioGenerarClasses = "C:\\Users\\alumno\\Desktop\\segundoDAM\\JAVA\\psp\\src\\main\\java";
	private static final String rutaResource = "C:\\Users\\alumno\\Desktop\\segundoDAM\\JAVA\\psp\\src\\main\\resources";

	private static final Logger logger = LogManager.getLogger(Lanzador.class);

	public static void main(String[] args) {

		LanzadorPython lp = new LanzadorPython();
		try {
			lp.lanzadorPython("hola mundo", "hola.py");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void lanzadorPython(String comando, String file) throws IOException {
		FileWriter escritura = new FileWriter(comando);
		escritura.write(file);
		logger.debug(escritura);
		escritura.close();
	}
}
