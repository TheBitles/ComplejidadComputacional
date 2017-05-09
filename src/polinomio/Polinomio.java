package polinomio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * La clase Polinomio permite evaluar un polinomio con diferentes m�todos. <br>
 * Los m�todos usar�n diferentes algoritmos con complejidades computacionales
 * diferentes. <br>
 * La posici�n cero del arreglo de coeficientes contiene el coeficiente de grado
 * n. <br>
 * La posici�n n del arreglo de coeficientes contiene al t�rmino independiente.
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
	 * - Primera l�nea: grado del polinomio. Segunda l�nea: (grado + 1)
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
	 * Eval�a el polinomio utilizando c�lculo de potencia por multiplicaciones
	 * sucesivas.
	 * 
	 * @param x
	 *            es el n�mero a evaluar con el polinomio
	 * @return Se retorna la evaluaci�n del polinomio
	 */
	public double evaluarMSucesivas(double x) {
		double y = 0;
		for (int i = 0; i < coeficientes.length; i++) {
			y += coeficientes[i] * potencia(x, grado - i);
		}
		return y;
	}

	/**
	 * Eval�a el polinomio utilizando c�lculo de potencia por recursividad.
	 * 
	 * @param x
	 *            es el n�mero a evaluar con el polinomio
	 * @return Se retorna la evaluaci�n del polinomio
	 */
	public double evaluarRecursiva(double x) {
		double y = 0;
		for (int i = 0; i < coeficientes.length; i++) {
			y += coeficientes[i] * potenciaRecursiva(x, grado - i);
		}
		return y;
	}

	/**
	 * Eval�a el polinomio utilizando c�lculo de potencia por recursividad
	 * distinguiendo si el exponente es par o impar.
	 * 
	 * @param x
	 *            es el n�mero a evaluar con el polinomio
	 * @return Se retorna la evaluaci�n del polinomio
	 */
	public double evaluarRecursivaPar(double x) {
		double y = 0;
		for (int i = 0; i < coeficientes.length; i++) {
			y += coeficientes[i] * potenciaRecursivaPar(x, grado - i);
		}
		return y;
	}

	/**
	 * Eval�a el polinomio almacenando las potencias de x ya calculadas.
	 * 
	 * @param x
	 *            es el n�mero a evaluar con el polinomio
	 * @return Se retorna la evaluaci�n del polinomio
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
	 * Eval�a el polinomio almacenando las potencias de x ya calculadas. <br>
	 * Tiene la misma complejidad computacional que el m�todo
	 * evaluarProgDinamica pero ejecuta en menos tiempo.
	 * 
	 * @param x
	 *            es el n�mero a evaluar con el polinomio
	 * @return Se retorna la evaluaci�n del polinomio
	 */
	public double evaluarMejorada(double x) {
		return x; // implementar !!
	}

	/**
	 * Eval�a el polinomio utilizando c�lculo de potencia con el m�todo
	 * Math.pow(x, n).
	 * 
	 * @param x
	 *            es el n�mero a evaluar con el polinomio
	 * @return Se retorna la evaluaci�n del polinomio
	 */
	public double evaluarPow(double x) {
		double y = 0;
		for (int i = 0; i < coeficientes.length; i++) {
			y += coeficientes[i] * Math.pow(x, grado - i);
		}
		return y;
	}

	/**
	 * Eval�a el polinomio utilizando el algoritmo de Horner, uno de los m�todos
	 * del c�lculo num�rico.
	 * 
	 * @param x
	 *            es el n�mero a evaluar con el polinomio
	 * @return Se retorna la evaluaci�n del polinomio
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
		} else if(n == 0) {
				return 1;
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
		} else if(n == 0) {
			return 1;
		} else if (n % 2 == 0) {
			return potenciaRecursivaPar(x * x, n / 2);
		} else {
			return x * potenciaRecursivaPar(x, n - 1);
		}
	}
}
