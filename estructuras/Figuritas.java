package exMarzo2017_NievesBorrero.estructuras;
/**
 * Clase para manejar una lista de figuras.
 * @author Nieves Borrero.
 */
import java.util.ArrayList;
import java.util.ListIterator;

import exMarzo2017_NievesBorrero.excepciones.DimensionNoValidaException;
import exMarzo2017_NievesBorrero.excepciones.FiguraNoExisteException;
import exMarzo2017_NievesBorrero.excepciones.ListaVaciaException;
import exMarzo2017_NievesBorrero.jerarquiaFiguras.Circulo;
import exMarzo2017_NievesBorrero.jerarquiaFiguras.Cuadrado;
import exMarzo2017_NievesBorrero.jerarquiaFiguras.FiguraCerrada;
import exMarzo2017_NievesBorrero.jerarquiaFiguras.Rectangulo;
import exMarzo2017_NievesBorrero.jerarquiaFiguras.Triangulo;

public class Figuritas {

	private static ArrayList<FiguraCerrada> figuritas;

	private Figuritas() {
		figuritas = new ArrayList<FiguraCerrada>();
	}

	public static Figuritas getInstance() {
		if (figuritas == null)
			return new Figuritas();
		return null;
	}

	/**
	 * Añade un rectángulo
	 * 
	 * @param base
	 * @param altura
	 * @throws DimensionNoValidaException
	 */
	public void addRectangulo(double base, double altura)
			throws DimensionNoValidaException {
		figuritas.add(new Rectangulo(base, altura));
	}

	/**
	 * Añade un cuadrado
	 * 
	 * @param lado
	 * @throws DimensionNoValidaException
	 */
	public void addCuadrado(double lado) throws DimensionNoValidaException {
		figuritas.add(new Cuadrado(lado));
	}

	/**
	 * Añade un círculo.
	 * 
	 * @param radio
	 * @throws DimensionNoValidaException
	 */
	public void addCirculo(double radio) throws DimensionNoValidaException {
		figuritas.add(new Circulo(radio));
	}

	/**
	 * Añade un triángulo.
	 * 
	 * @param base
	 * @param altura
	 * @throws DimensionNoValidaException
	 */
	public void addTriangulo(double base, double altura)
			throws DimensionNoValidaException {
		figuritas.add(new Triangulo(base, altura));
	}

	/**
	 * Añade tres figuras de cada tipo con dimensiones aleatorias.
	 * 
	 * @throws ListaVaciaException
	 * @throws DimensionNoValidaException
	 */
	public void addFigurasAleatorias() throws ListaVaciaException {

		for (int i = 0; i < 3; i++) {
			try {
				addRectangulo(generarAleatorio(), generarAleatorio());
				
			} catch (DimensionNoValidaException e) {
				System.err.println(e.getMessage());
			}
			try {
				addCuadrado(generarAleatorio());
				
			} catch (DimensionNoValidaException e) {
				System.err.println(e.getMessage());
			}
			try {
				addCirculo(generarAleatorio());
				
			} catch (DimensionNoValidaException e) {
				System.err.println(e.getMessage());
			}
			try {
				addTriangulo(generarAleatorio(), generarAleatorio());
				
			} catch (DimensionNoValidaException e) {
				System.err.println(e.getMessage());
			}

		}
	}

	/**
	 * @return decimal
	 */
	private double generarAleatorio() {
		return Math.random();
	}

	/**
	 * Elimina una figura por índice.
	 * 
	 * @param index
	 */
	public void remove(int index) {
			figuritas.remove(index);
	}

	/**
	 * Borra las figuras por identificador
	 * 
	 * @param identificador
	 * @throws FiguraNoExisteException
	 * @throws DimensionNoValidaException
	 */
	public void removeId(int codigo) throws FiguraNoExisteException,
			DimensionNoValidaException {
		if (!figuritas.remove(new Circulo(codigo)))
			throw new FiguraNoExisteException(
					"Error al borrar, la figura no existe");
	}

	/**
	 * Lista las figuras en orden inverso.
	 * 
	 * @return cadena.
	 * @throws ListaVaciaException
	 */
	public String listarDelReves() throws ListaVaciaException {
		comprobarListaVacia();

		ListIterator<FiguraCerrada> it = figuritas.listIterator(figuritas
				.size());
		StringBuilder st = new StringBuilder();
		FiguraCerrada figura;
		st.append(figuritas.size() + " figuritas:\n");
		
		while (it.hasPrevious()) {
			figura = it.previous();
			st.append(figura.toString());
		}
		return st.toString();
	}

	/**
	 * Comprueba si la lista está vacía.
	 * 
	 * @throws ListaVaciaException
	 */
	private void comprobarListaVacia() throws ListaVaciaException {
		if (figuritas.isEmpty()) {
			throw new ListaVaciaException("La lista esta vacia");
		}

	}

	/**
	 * Lista los triángulos.
	 * 
	 * @return cadena
	 * @throws ListaVaciaException
	 */
	public String listarTriangulos() throws ListaVaciaException {
		comprobarListaVacia();

		FiguraCerrada figura;
		int i = 0;
		StringBuilder st = new StringBuilder();
		ListIterator<FiguraCerrada> it = figuritas.listIterator();

		while (it.hasNext()) {
			figura = (FiguraCerrada) it.next();
			if (figura instanceof Triangulo) {
				st.append(figura.toString());
				i++;
			}
		}
		return st.toString() + "\nTotal de triangulos: " + i;
	}

	/**
	 * Lista las figuras.
	 * 
	 * @return cadena.
	 * @throws ListaVaciaException
	 */
	public String listar() throws ListaVaciaException {
		comprobarListaVacia();

		FiguraCerrada figura;
		StringBuilder st = new StringBuilder();
		ListIterator<FiguraCerrada> it = figuritas.listIterator();
		st.append(figuritas.size() + " figuritas:\n");

		while (it.hasNext()) {
			figura = (FiguraCerrada) it.next();
			st.append(figura.toString());
		}

		return st.toString();
	}

}
