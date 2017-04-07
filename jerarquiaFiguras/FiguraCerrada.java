package figuras.jerarquiaFiguras;

import exMarzo2017_NievesBorrero.excepciones.DimensionNoValidaException;

/**
 * Clase padre de la que heredan los distintos tipos de figuras cerradas.
 * @author Nieves Borrero.
 */

public abstract class FiguraCerrada {

	protected static final double MIN = 0.5;
	protected int codigo;
	private static int id = 1;
	
	
	public FiguraCerrada(){
		setCodigo(codigo);
	}
	
	FiguraCerrada(int codigo) {
		this.codigo=codigo;
	}

	/**
	 * Calcula el perímetro de la figura.
	 * 
	 * @return decimal
	 */
	protected abstract double perimetro();

	/**
	 * Calcula el área de la figura.
	 * 
	 * @return decimal
	 */
	protected abstract double area();

	protected int getCodigo() {
		return codigo;
	}

	/**
	 * Identifica cada figura con un código único autoincrementable.
	 * 
	 * @param codigo
	 */
	protected void setCodigo(int codigo) {
		this.codigo = id++;
	}

	/**
	 * Comprueba si la dimensión es válida
	 * 
	 * @throws DimensionNoValidaException
	 */
	protected void comprobarDimension(double dimension)
			throws DimensionNoValidaException {
		if (dimension < MIN)
			throw new DimensionNoValidaException("Error, al crear el "
					+ getClass().getSimpleName()+": "+dimension
					+ ": la dimension ha de tener un minimo de 0.5");
	}
	
	/**
	 * Redondea las dimensiones
	 * @param dimension
	 * @return decimal
	 */
	protected double redondearDimension(double dimension){
		return Math.round(dimension*100d)/100d;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		FiguraCerrada other = (FiguraCerrada) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "\n" + getClass().getSimpleName() + " codigo=" + getCodigo()
				+ ", perimetro()=" + redondearDimension(perimetro()) + ", area()=" + redondearDimension(area());
	}

}
