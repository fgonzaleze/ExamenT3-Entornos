package examen;
/**
 * Programa que realiza fracciones
 * @author jgonzalez
 * @version 0.1 26/01/2023
 *
 */
// Clase que define una fracción


public class Fraccion {
	// Numerador
	private int num;

	// Denominador
	private int den;

	private String mensaje = num + "/" + den;

	// Constructor por defecto

	public Fraccion() { // debe generar el valor neutro que es 0/1
		num = 0;
		den = 1;

	}
/**
 * Constructor de parámetros
 * @param num Numero de la fraccion 
 * @param den Devuelve la fraccion simplificada
 */
	// Constructor con parámetros
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0) {
			this.den = 1;
		}
			
		else {
			this.den = den;
		}
		// devuelvo la fracci�n simplificada
		simplificar();
	}
/**
 * Construtor que copia la fraccion
 * @param f Entero final que determina la fraccion
 */
	// Constructor copia
	public Fraccion(final Fraccion f) {
		num = f.num;
		den = f.den;
	}

	// getters y setters
/**
 * Valor entero que da el numero
 * @param num Selecciona el numero
 */
	public void setNum(int num) {
		this.num = num;

	}
/**
 * Valor entero que devuelve el numero
 * @return num Devuelve el numero
 */
	public int getNum() {
		return num;

	}
/**
 * Valor entero que da el denominador
 * @param den Denominador dado
 */
	public void setDen(int den) {
		this.den = den;
	}
/**
 * Valor entero que da den
 * @return den Denominador devuelto
 */
	public int getDen() {
		return den;
	}
/**
 * Algoritmo de Euclides para calcular el maximo comun divisor
 * @return u Devuelve el valor absoluto del numerador
 */
	// Cálculo del máximo común divisor por el algoritmo de Euclides
	private int maximoComunDivisor() {
		int u = Math.abs(num); // valor absoluto del numerador
		int v = Math.abs(den); // valor absoluto del denominador
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return v;
	}

	// método para simplificar fracciones
	
	public void simplificar() {
		int n = maximoComunDivisor();
		num = num / n;
		den = den / n;
	}

	// Método toString

	public String toString() {
		return mensaje;

	}
/**
 * Funcion para sumar las fracciones
 * @param f Determina la fraccion
 * @return aux Numero auxiliar que simplifica
 */
	// suma de fracciones
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		int cruce1 = num * f.den;
		int cruce2 = den * f.num;
		aux.num = cruce1 + cruce2;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	// Restar fracciones
/**
 * Funcion para restar las fracciones
 * @param f Determina la fraccion
 * @return aux Numero auxiliar que simplifica
 */
	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den - den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

//Multiplicar fracciones
/**
 * Funcion para multiplicar fracciones
 * @param fraccion Determina la fraccion
 * @return aux Numero auxiliar que simplifica
 */
	public Fraccion multiplicar(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		aux.num = num * fraccion.num;
		aux.den = den * fraccion.den;
		aux.simplificar();
		return aux;

	}

//Dividir fracciones
/**
 * Funcion para dividir fracciones
 * @param f Determina la fraccion
 * @return aux Numero auxiliar que simplifica
 */
	public Fraccion dividir(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den;
		aux.den = den * f.num;
		aux.simplificar();
		return aux;

	}

}
