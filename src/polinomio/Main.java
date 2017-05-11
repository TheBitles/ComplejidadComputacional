package polinomio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {
		generarPolinomio(1000);
		Polinomio polinomio = new Polinomio("polinomio.in");
		rendimiento(polinomio);
	}
	
	public static void rendimiento(Polinomio polinomio) {
		System.out.println("Evaluando rendimiento...");
		
		Calendar tiempoInicial = new GregorianCalendar();
		//double y = polinomio.evaluarMSucesivas(2);
		//double y = polinomio.evaluarPow(2);
		//double y = polinomio.evaluarHorner(2);
		//double y = polinomio.evaluarMejorada(2);
		//double y = polinomio.evaluarRecursiva(2);
		//double y = polinomio.evaluarRecursivaPar(2);
		double y = polinomio.evaluarProgDinamica(2);
		Calendar tiempoFinal = new GregorianCalendar();
		
		System.out.println("\nResultado: " + y);
		long variacionTiempo = tiempoFinal.getTimeInMillis() - tiempoInicial.getTimeInMillis();
		System.out.println("Rendimiento del algoritmo: " + variacionTiempo + "from:\nfinal:   " + tiempoFinal.getTimeInMillis() + "\ninicial: " + tiempoInicial.getTimeInMillis());
		
	}
	
	public static void generarPolinomio(int grado) {
		try {
			FileWriter arch = new FileWriter("polinomio.in");
			BufferedWriter buffer = new BufferedWriter(arch);
			
			System.out.println("Generando polinomio...");
			buffer.write(String.valueOf(grado));
			buffer.newLine();
			for (int i = 0; i <= grado ; i++) {
				buffer.write(String.valueOf(1) + " ");
			}
			buffer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
