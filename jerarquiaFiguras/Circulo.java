package figuras.jerarquiaFiguras;

import figuras.excepciones.DimensionNoValidaException;

/**
 * Clase que permite la creación de círculos.
 * @author Nieves Borrero
 *
 */

public class Circulo extends FiguraCerrada {
	private double radio;
	
	public Circulo(double radio) throws DimensionNoValidaException {
		setRadio(radio);
	}
	public Circulo (int codigo){
		super(codigo);
	}
	
	@Override
	protected double perimetro() {
		return (2*Math.PI*getRadio());
	}

	protected double getRadio() {
		return radio;
	}

	private void setRadio(double radio) throws DimensionNoValidaException {
		comprobarDimension(radio);
		this.radio = radio;
	}

	@Override
	protected double area() {
		return Math.PI*Math.pow(getRadio(), 2);
	}

	@Override
	public String toString() {
		return super.toString()+" radio="+redondearDimension(getRadio());
	}

}
