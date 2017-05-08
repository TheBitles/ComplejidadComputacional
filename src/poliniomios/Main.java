package poliniomios;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] coeficientes = new double[3];
		coeficientes[0] = 2;
		coeficientes[1] = 2;
		coeficientes[2] = 2;

		Polinomio p = new Polinomio(coeficientes);
		double k = p.evaluarMSucesivas(2);
		System.out.println(k);
		
	}

}
