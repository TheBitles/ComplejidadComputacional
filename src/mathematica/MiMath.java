package mathematica;

public class MiMath {

	public static int combinatoria(int m, int n) {
		return factorial(m) / (factorial(m - n) * factorial(n));
	}

	public static int combinatoriaRecursiva(int m, int n) {
		if (m == 0 || m == n) {
			return 1;
		} else if (n == 0) {
			return 0;
		} else {
			return combinatoriaRecursiva(m - 1, n - 1) + combinatoriaRecursiva(m - 1, n);
		}
	}

	public static int factorial(int n) {
		int f = 1;
		for (int i = 2; i <= n; i++) {
			f *= i;
		}
		return f;
	}

	public static int[][] trianguloDeTartaglia(int n) {
		int[][] tartaglia = new int[n][n];
		for (int i = 0; i < tartaglia.length; i++) {
			tartaglia[i][i] = 1;
			tartaglia[i][0] = 1;
		}
		for (int i = 2; i < n; i++) {
			for (int j = 1; j < i; j++) {
				tartaglia[i][j] = tartaglia[i - 1][j - 1] + tartaglia[i - 1][j];
			}
		}
		return tartaglia;
	}
}
