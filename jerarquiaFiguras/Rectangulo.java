package figuras.jerarquiaFiguras;

import figuras.excepciones.DimensionNoValidaException;

/**
 * Clase que permite la creación de un rectángulo, que hereda de FiguraCerrada.
 * 
 * @author Nieves Borrero.
 */

public class Rectangulo extends FiguraCerrada {
	private double base;
	private double altura;

	public Rectangulo(double base, double altura) throws DimensionNoValidaException {
		setBase(base);
		setAltura(altura);
	}

	protected double getBase() {
		return base;
	}

	private void setBase(double base) throws DimensionNoValidaException {
		comprobarDimension(base);
		this.base = base;
	}

	protected double getAltura() {
		return altura;
	}

	private void setAltura(double altura) throws DimensionNoValidaException {
		comprobarDimension(altura);
		this.altura = altura;
	}

	@Override
	protected double perimetro() {
		return (2 * getBase()) + (2 * getAltura());
	}

	@Override
	protected double area() {
		return getBase() * getAltura();
	}

	@Override
	public String toString() {
		return super.toString() + "[base=" + redondearDimension(getBase())
				+ ", altura=" + redondearDimension(getAltura()) + "]";
	}

}
