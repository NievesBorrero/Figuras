package exMarzo2017_NievesBorrero.jerarquiaFiguras;

import exMarzo2017_NievesBorrero.excepciones.DimensionNoValidaException;

/**
 * Clase que permite la creación de un triángulo, que hereda de FiguraCerrada.
 * @author Nieves Borrero
 *
 */

public class Triangulo extends FiguraCerrada {
	private double base;
	private double altura;

	public Triangulo(double base, double altura) throws DimensionNoValidaException {
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
		comprobarDimension(base);
		this.altura = altura;
	}

	@Override
	protected double perimetro() {
		return getBase() + getAltura() + (Math.sqrt(getBase() + getAltura()));
	}

	@Override
	protected double area() {
		return (getBase() * getAltura()) / 2;
	}

	@Override
	public String toString() {
		return super.toString() + "base=" + redondearDimension(getBase())
				+ ", altura=" + redondearDimension(getAltura());
	}

}
