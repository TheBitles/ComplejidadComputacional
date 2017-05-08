package poliniomios;

public class Polinomio {

	private int grado;
	
	private double[] coeficientes;
	
	public Polinomio(double[] coeficientes){
		this.grado = coeficientes.length - 1;
		this.coeficientes = coeficientes;
	}
	
	public double evaluarMSucesivas(double x){
		double total = 0;
		for(int i = 0; i <= this.grado; i++){
			int k = grado - i;
			double val = this.coeficientes[i];
			for(int j = 0; j < k; j++){
				val *= x;
			}
			total += val;
		}
		return total;
	}
	
	public double evaluarRecursiva(double x){}
	//public double evaluarRecursivaPar(double x){}
	//public double evaluarProgDinamica(double x){}
	//public double evaluarMejorada(double x){}
	//public double evaluarPow(double x){}
	//public double evaluarHorner(double x){}
	
	
}

