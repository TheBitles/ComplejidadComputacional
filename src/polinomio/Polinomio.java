package polinomio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * La clase Polinomio permite evaluar un polinomio con diferentes métodos. <br>
 * Los métodos usarán diferentes algoritmos con complejidades computacionales
 * diferentes. <br>
 * La posición cero del arreglo de coeficientes contiene el coeficiente de grado
 * n. <br>
 * La posición n del arreglo de coeficientes contiene al término independiente.
 * 
 * @author TheBitles
 */
public class Polinomio {

	private int grado;
	private double[] coeficientes;

	public int getGrado() {
		return grado;
	}

	/**
	 * Constructor de la clase Polinomio, que lo levanta de un archivo. <br>
	 * - Primera línea: grado del polinomio. Segunda línea: (grado + 1)
	 * coeficientes del polinomio.
	 * 
	 * @param path
	 *            es el path de un archivo del que se levanta el polinomio.
	 */
	public Polinomio(String path) {
		try {
			FileReader file = new FileReader(path);
			Scanner scan = new Scanner(file);

			grado = scan.nextInt();
			coeficientes = new double[grado + 1];
			for (int i = 0; i < coeficientes.length; i++) {
				coeficientes[i] = scan.nextDouble();
			}

			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo levantar el archivo");
		}
	}

	/**
	 * Constructor de la clase Polinomio, que recibe un array con los coeficientes del polinomio
	 * @param coeficientes es el array de coeficientes del polinomio
	 */
	public Polinomio(double[] coeficientes) {
		this.grado = coeficientes.length - 1;
		this.coeficientes = coeficientes;
	}

	/**
	 * Evalúa el polinomio utilizando cálculo de potencia por multiplicaciones
	 * sucesivas.
	 * 
	 * @param x
	 *            es el número a evaluar con el polinomio
	 * @return Se retorna la evaluación del polinomio
	 */
	public double evaluarMSucesivas(double x) {
		double y = 0;
		for (int i = 0; i < coeficientes.length; i++) {
			y += coeficientes[i] * potencia(x, grado - i);
		}
		return y;
	}

	/**
	 * Evalúa el polinomio utilizando cálculo de potencia por recursividad.
	 * 
	 * @param x
	 *            es el número a evaluar con el polinomio
	 * @return Se retorna la evaluación del polinomio
	 */
	public double evaluarRecursiva(double x) {
		double y = 0;
		for (int i = 0; i < coeficientes.length; i++) {
			y += coeficientes[i] * potenciaRecursiva(x, grado - i);
		}
		return y;
	}

	/**
	 * Evalúa el polinomio utilizando cálculo de potencia por recursividad
	 * distinguiendo si el exponente es par o impar.
	 * 
	 * @param x
	 *            es el número a evaluar con el polinomio
	 * @return Se retorna la evaluación del polinomio
	 */
	public double evaluarRecursivaPar(double x) {
		double y = 0;
		for (int i = 0; i < coeficientes.length; i++) {
			y += coeficientes[i] * potenciaRecursivaPar(x, grado - i);
		}
		return y;
	}

	/**
	 * Evalúa el polinomio almacenando las potencias de x ya calculadas.
	 * 
	 * @param x
	 *            es el número a evaluar con el polinomio
	 * @return Se retorna la evaluación del polinomio
	 */
	public double evaluarProgDinamica(double x) {
		double y = coeficientes[grado];
		double p = x;
		for (int i = grado - 1; i >= 0; i--) {
			y += coeficientes[i] * p;
			p *= x;
		}
		return y;
	}

	/**
	 * Evalúa el polinomio almacenando las potencias de x ya calculadas. <br>
	 * Tiene la misma complejidad computacional que el método
	 * evaluarProgDinamica pero ejecuta en menos tiempo.
	 * 
	 * @param x
	 *            es el número a evaluar con el polinomio
	 * @return Se retorna la evaluación del polinomio
	 */
	public double evaluarMejorada(double x) {
		return x; // implementar !!
	}

	/**
	 * Evalúa el polinomio utilizando cálculo de potencia con el método
	 * Math.pow(x, n).
	 * 
	 * @param x
	 *            es el número a evaluar con el polinomio
	 * @return Se retorna la evaluación del polinomio
	 */
	public double evaluarPow(double x) {
		double y = 0;
		for (int i = 0; i < coeficientes.length; i++) {
			y += coeficientes[i] * Math.pow(x, grado - i);
		}
		return y;
	}

	/**
	 * Evalúa el polinomio utilizando el algoritmo de Horner, uno de los métodos
	 * del cálculo numérico.
	 * 
	 * @param x
	 *            es el número a evaluar con el polinomio
	 * @return Se retorna la evaluación del polinomio
	 */
	public double evaluarHorner(double x) {
		double y = 0;
		for (int i = coeficientes.length - 1; i >= 0; i--) {
			y = coeficientes[i] + x * y;
		}
		return y;
	}

	/**
	 * Calcula una potencia mediante multiplicaciones sucesivas.
	 * 
	 * @param x
	 *            es la base
	 * @param n
	 *            es el exponente
	 * @return Se retorna la potencia
	 */
	private double potencia(double x, int n) {
		double p = 1;
		for (int i = 0; i < n; i++) {
			p *= x;
		}
		return p;
	}

	/**
	 * Calcula una potencia mediante recursividad.
	 * 
	 * @param x
	 *            es la base
	 * @param n
	 *            es el exponente
	 * @return Se retorna la potencia
	 */
	private double potenciaRecursiva(double x, int n) {
		if (n == 1) {
			return x;
		} else {
			return x * potenciaRecursiva(x, n - 1);
		}
	}

	/**
	 * Calcula una potencia mediante recursividad distinguiendo si el exponente
	 * es par o impar.
	 * 
	 * @param x
	 *            es la base
	 * @param n
	 *            es el exponente
	 * @return Se retorna la potencia
	 */
	private double potenciaRecursivaPar(double x, int n) {
		if (n == 1) {
			return x;
		} else if (n % 2 == 0) {
			return potenciaRecursivaPar(x * x, n / 2);
		} else {
			return potenciaRecursivaPar(x, n - 1);
		}
	}
}
