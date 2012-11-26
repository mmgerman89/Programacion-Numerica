/*
 * Raices.java
 * 
 * Clase que implementa los métodos de búsqueda de raíces
 * 
 */


public class Raices {
	private Parseador parseador;
	
	public double biseccion( String fcion, double a, double b, int n, double tol ){
		parseador = new Parseador();
		
		String funcion = parseador.parsear(fcion);
		
		double[] sucA = new double[n+1];
		double[] sucB = new double[n+1];
		double[] sucP = new double[n+1];
		double[] sucFP = new double[n+1];
		
		double resultado = 0.0;
		
		int i = 0;
		
		sucA[i] = a;
		sucB[i] = b;

		while (i < n){
			sucP[i] = (sucA[i] + sucB[i])/2;
			sucFP[i] = parseador.f(funcion, sucP[i]);
			
			if (Math.abs(sucFP[i]) < tol)
				break;
			
			if (sucFP[i] * parseador.f(funcion, a) < 0){
				sucB[i+1] = sucP[i];
				sucA[i+1] = sucA[i];
			}else{
				sucA[i+1] = sucP[i];
				sucB[i+1] = sucB[i];
			}
				
			i++;
		}
		
		if (i >= n){
			System.out.printf("\t\tError en el metodo de biseccion...\n");
		}else{
			System.out.printf("\n\n\t\t\t\tMetodo de Biseccion\n\n");
			System.out.printf("%2s\t%18s\t%18s\t%18s\t%18s\n", "i", "a", "b", "p", "f(p)");
			
			for( int j = 0; j <= i; j++ ){
				System.out.printf("%2d\t%5.15f\t%5.15f\t%5.15f\t%5.15f\n", 
					j+1, sucA[j], sucB[j], sucP[j], sucFP[j]);
			}
			System.out.println();
			
			resultado = sucP[i];
		}
		return resultado;
	}
	
	public double secante ( String fcion, double a, double b, int n, double tol ){
		parseador = new Parseador();
		
		String funcion = parseador.parsear(fcion);
		
		double[] sucA = new double[n+1];
		double[] sucFA = new double[n+1];
		double[] sucB = new double[n+1];
		double[] sucFB = new double[n+1];
		double[] sucP = new double[n+1];
		double[] sucFP = new double[n+1];
		
		double resultado = 0.0;
		
		int i = 0;
		
		sucA[i] = a;
		sucB[i] = b;

		while (i < n){
			sucFA[i] = parseador.f(funcion, sucA[i]);
			sucFB[i] = parseador.f(funcion, sucB[i]);
			
			sucP[i] = sucB[i] - (sucFB[i] * ( sucB[i] - sucA[i] )/( sucFB[i] - sucFA[i] ) );
			sucFP[i] = parseador.f(funcion, sucP[i]);
			
			if (Math.abs(sucFP[i]) < tol)
				break;
			
			if (sucFP[i] * sucFA[i] < 0){
				sucB[i+1] = sucP[i];
				sucA[i+1] = sucA[i];
			}else{
				sucA[i+1] = sucP[i];
				sucB[i+1] = sucB[i];
			}
				
			i++;
		}
		
		if (i >= n){
			System.out.printf("\t\tError en el metodo de la secante...\n");
		}else{
			System.out.printf("\n\n\t\t\t\tMetodo de la Secante\n\n");
			System.out.printf("%2s\t%18s\t%18s\t%18s\t%18s\t%18s\t%18s\n",
				"i", "a", "b", "p", "f(a)", "f(b)", "f(p)");
			
			for( int j = 0; j <= i; j++ ){
				System.out.printf("%2d\t%5.15f\t%5.15f\t%5.15f\t%5.15f\t%5.15f\t%5.15f\n", 
					j+1, sucA[j], sucB[j], sucP[j], sucFA[j], sucFB[j], sucFP[j]);
			}
			System.out.println();
			resultado = sucP[i];
		}
		return resultado;
	}
	
	public double regulaFalsiMod ( String fcion, double a, double b, int n, double tol ){
		parseador = new Parseador();
		
		String funcion = parseador.parsear(fcion);
		
		double[] sucA = new double[n+1];
		double[] sucFA = new double[n+1];
		double[] sucB = new double[n+1];
		double[] sucFB = new double[n+1];
		double[] sucP = new double[n+1];
		double[] sucFP = new double[n+1];
		double w;
		
		double resultado = 0.0;
		
		int i = 0;
		
		sucA[i] = a;
		sucB[i] = b;
		sucFA[i] = parseador.f(funcion, sucA[i]);
		sucFB[i] = parseador.f(funcion, sucB[i]);
		w = sucFB[i];
		sucP[i] = (sucA[i]*sucFB[i] - sucB[i]*sucFA[i])/(sucFB[i] - sucFA[i]);

		while (i < n){		
			sucFP[i] = parseador.f(funcion, sucP[i]);
			
			if (Math.abs(sucFP[i]) < tol)
				break;
			
			if (sucFP[i] * sucFA[i] < 0){
				sucB[i+1] = sucP[i];
				sucFB[i+1] = sucFP[i];
				sucA[i+1] = sucA[i];
				
				if (sucFP[i] * w > 0)
					sucFA[i+1] = sucFA[i] / 2;
				else
					sucFA[i+1] = sucFA[i];
			}else{
				sucA[i+1] = sucP[i];
				sucFA[i+1] = sucFP[i];
				sucB[i+1] = sucB[i];
				
				if (sucFP[i] * w > 0)
					sucFB[i+1] = sucFB[i] / 2;
				else
					sucFB[i+1] = sucFB[i];
			}
			
			w = sucFP[i];
			i++;
			sucP[i] = (sucA[i]*sucFB[i] - sucB[i]*sucFA[i])/(sucFB[i] - sucFA[i]);
		}
		
		if (i >= n){
			System.out.printf("\t\tError en el metodo Regula Falsi Modificada...\n");
		}else{
			System.out.printf("\n\n\t\t\t\tMetodo Regula Falsi Modificada\n\n");
			System.out.printf("%2s\t%18s\t%18s\t%18s\t%18s\t%18s\t%18s\n",
				"i", "a", "b", "p", "f(a)", "f(b)", "f(p)");
			
			for( int j = 0; j <= i; j++ ){
				System.out.printf("%2d\t%5.15f\t%5.15f\t%5.15f\t%5.15f\t%5.15f\t%5.15f\n", 
					j+1, sucA[j], sucB[j], sucP[j], sucFA[j], sucFB[j], sucFP[j]);
			}
			System.out.println();
			
			resultado = sucP[i];
		}
		return resultado;
	}
	
	public double newton ( String fcion, String fcionDer, double p0, int n, double tol ){
		parseador = new Parseador();
		
		String funcion = parseador.parsear(fcion);
		String derivada = parseador.parsear(fcionDer);
		
		double[] sucP0 = new double[n+1];
		double[] sucFP0 = new double[n+1];
		double[] sucP = new double[n+1];
		double[] sucFP = new double[n+1];
		
		double resultado = 0.0;
		
		int i = 0;
		
		sucP0[i] = p0;

		while (i < n){
			sucFP0[i] = parseador.f(funcion, sucP0[i]);
			sucP[i] = sucP0[i] - (sucFP0[i])/(parseador.f(derivada, sucP0[i]));
			sucFP[i] = parseador.f(funcion, sucP[i]);
			
			if (Math.abs(sucFP[i]) < tol)
				break;
			
			sucP0[i+1] = sucP[i];				
			i++;
		}
		
		if (i >= n){
			System.out.printf("\t\tError en el metodo de Newton...\n");
		}else{
			System.out.printf("\n\n\t\t\t\tMetodo de Newton\n\n");
			System.out.printf("%2s\t%18s\t%18s\t%18s\t%18s\n",
				"i", "p0", "p", "f(p0)", "f(p)");
			
			for( int j = 0; j <= i; j++ ){
				System.out.printf("%2d\t%5.15f\t%5.15f\t%5.15f\t%5.15f\n", 
					j+1, sucP0[j], sucP[j], sucFP0[j], sucFP[j]);
			}
			System.out.println();
			resultado = sucP[i];
		}
		return resultado;
	}
}

