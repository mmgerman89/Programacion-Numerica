/*
 * Prueba.java
 * 
 * Clase de prueba de la clase Raices
 */


public class Prueba {
	
	public static void main (String args[]) {
		/*
		String funcion = "e^x - x^2 +4";
		String derivada = "e^x - 2 * x";
		double raiz;
		
		Raices app = new Raices();
		
		raiz = app.biseccion(funcion, -3, -2, 500, 0.000000000000001);
		System.out.printf("\nResultado con Bisección: %5.16f\n\n\n", raiz);
		
		raiz = app.secante(funcion, -3, -2, 500, 0.000000000000001);
		System.out.printf("\nResultado con Secante: %5.16f\n\n\n", raiz);
		
		raiz = app.regulaFalsiMod(funcion, -3, -2, 500, 0.000000000000001);
		System.out.printf("\nResultado con REgula Falsi Modificada: %5.16f\n\n\n", raiz);
		
		raiz = app.newton(funcion, derivada, -3, 500, 0.000000000000001);
		System.out.printf("\nResultado con Newton: %5.16f\n\n\n", raiz);
		*/
		
		
		/*
		String funcion = "cos(x) - x * e^x";
		String derivada = "-sen(x) - e^x - x * e^x";
		double raiz;
		
		Raices app = new Raices();
		
		raiz = app.biseccion(funcion, 0, 1, 500, 0.000000000000001);
		System.out.printf("\nResultado con Bisección: %5.16f\n\n\n", raiz);
		
		raiz = app.secante(funcion, 0, 1, 500, 0.000000000000001);
		System.out.printf("\nResultado con Secante: %5.16f\n\n\n", raiz);
		
		raiz = app.regulaFalsiMod(funcion, 0, 1, 500, 0.000000000000001);
		System.out.printf("\nResultado con Regula Falsi Modificada: %5.16f\n\n\n", raiz);
		
		raiz = app.newton(funcion, derivada, 0, 500, 0.000000000000001);
		System.out.printf("\nResultado con Newton: %5.16f\n\n\n", raiz);
		*/
		
		
		/*
		String funcion = "tan(x) - cos(x) - 1/2";
		String derivada = "1 + (tan(x))^2 + sen(x)";
		double raiz;
		
		Raices app = new Raices();
		
		raiz = app.biseccion(funcion, 0, 1, 500, 0.000000000000001);
		System.out.printf("\nResultado con Bisección: %5.16f\n\n\n", raiz);
		
		raiz = app.secante(funcion, 0, 1, 500, 0.000000000000001);
		System.out.printf("\nResultado con Secante: %5.16f\n\n\n", raiz);
		
		raiz = app.regulaFalsiMod(funcion, 0, 1, 500, 0.000000000000001);
		System.out.printf("\nResultado con Regula Falsi Modificada: %5.16f\n\n\n", raiz);
		
		raiz = app.newton(funcion, derivada, 0, 500, 0.000000000000001);
		System.out.printf("\nResultado con Newton: %5.16f\n\n\n", raiz);
		*/
		
		
		// /*
		String funcion = "e^(-x) - sen(x)";
		String derivada = "-e^(-x) - cos(x)";
		double raiz;
		
		Raices app = new Raices();
		
		raiz = app.biseccion(funcion, 2, 4, 500, 0.000000000000001);
		System.out.printf("\nResultado con Bisección: %5.16f\n\n\n", raiz);
		
		raiz = app.secante(funcion, 2, 4, 500, 0.000000000000001);
		System.out.printf("\nResultado con Secante: %5.16f\n\n\n", raiz);
		
		raiz = app.regulaFalsiMod(funcion, 2, 4, 500, 0.000000000000001);
		System.out.printf("\nResultado con Regula Falsi Modificada: %5.16f\n\n\n", raiz);
		
		raiz = app.newton(funcion, derivada, 3, 500, 0.000000000000001);
		System.out.printf("\nResultado con Newton: %5.16f\n\n\n", raiz);
		// */
	}
}

