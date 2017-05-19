package tests;

import org.junit.Assert;
import org.junit.Test;

import mathematica.MiMath;
import polinomio.BinomioDeNewton;
import polinomio.Polinomio;

public class TestBinomioDeNewton {

	@Test
	public void testFactorial() {
		Assert.assertEquals(MiMath.factorial(0), 1);
		Assert.assertEquals(MiMath.factorial(1), 1);
		Assert.assertEquals(MiMath.factorial(2), 2);
		Assert.assertEquals(MiMath.factorial(3), 6);
		Assert.assertEquals(MiMath.factorial(4), 24);
		Assert.assertEquals(MiMath.factorial(5), 120);
		Assert.assertEquals(MiMath.factorial(6), 720);
		Assert.assertEquals(MiMath.factorial(7), 5040);
	}

	@Test
	public void testCombinatoria() {
		Assert.assertEquals(MiMath.combinatoria(6, 0), 1);
		Assert.assertEquals(MiMath.combinatoria(6, 1), 6);
		Assert.assertEquals(MiMath.combinatoria(6, 2), 15);
		Assert.assertEquals(MiMath.combinatoria(6, 3), 20);
		Assert.assertEquals(MiMath.combinatoria(6, 4), 15);
		Assert.assertEquals(MiMath.combinatoria(6, 5), 6);
		Assert.assertEquals(MiMath.combinatoria(6, 6), 1);
	}

	@Test
	public void testCombinatoriaRecursiva() {
		Assert.assertEquals(MiMath.combinatoriaRecursiva(6, 0), 1);
		Assert.assertEquals(MiMath.combinatoriaRecursiva(6, 1), 6);
		Assert.assertEquals(MiMath.combinatoriaRecursiva(6, 2), 15);
		Assert.assertEquals(MiMath.combinatoriaRecursiva(6, 3), 20);
		Assert.assertEquals(MiMath.combinatoriaRecursiva(6, 4), 15);
		Assert.assertEquals(MiMath.combinatoriaRecursiva(6, 5), 6);
		Assert.assertEquals(MiMath.combinatoriaRecursiva(6, 6), 1);
	}

	@Test
	public void testTartaglia() {
		int[][] tartaglia = { { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 2, 1, 0, 0 }, { 1, 3, 3, 1, 0 },
				{ 1, 4, 6, 4, 1 } };
		int[][] miTartaglia = MiMath.trianguloDeTartaglia(5);

		for (int i = 0; i < tartaglia.length; i++) {
			for (int j = 0; j < tartaglia.length; j++) {
				Assert.assertEquals(tartaglia[i][j], miTartaglia[i][j]);
			}
		}
	}

	@Test
	public void testQueSecreaBinomio() {
		BinomioDeNewton binomio = new BinomioDeNewton(2, 1, 2);
		Assert.assertEquals(binomio.getA(), 2);
		Assert.assertEquals(binomio.getB(), 1);
		Assert.assertEquals(binomio.getN(), 2);
	}

	@Test
	public void testCoeficienteK() {
		BinomioDeNewton binomio = new BinomioDeNewton(2, 1, 2);
		Assert.assertEquals(binomio.coeficienteK(binomio.getN()), 4);
		Assert.assertEquals(binomio.coeficienteK(1), 4);
		Assert.assertEquals(binomio.coeficienteK(0), 1);
	}

	@Test
	public void testFormaPolinomica() {
		BinomioDeNewton binomio = new BinomioDeNewton(2, 1, 2);
		Polinomio p = binomio.formaPolinomica();
		double[] coeficientes = { 4, 4, 1 };
		Polinomio q = new Polinomio(coeficientes);
		Assert.assertEquals(p, q);
	}

	@Test
	public void testFormaPolinomicaConTartaglia() {
		BinomioDeNewton binomio = new BinomioDeNewton(1, 1, 2);
		Polinomio p = binomio.formaPolinomicaConTartaglia();
		double[] coeficientes = { 1, 2, 1 };
		Polinomio q = new Polinomio(coeficientes);
		Assert.assertEquals(p, q);
	}
}
