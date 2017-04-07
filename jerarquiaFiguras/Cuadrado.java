package exMarzo2017_NievesBorrero.jerarquiaFiguras;

import exMarzo2017_NievesBorrero.excepciones.DimensionNoValidaException;

/**
 * Clase que permite la creaci�n de un cuadrado, que hereda de rect�ngulo.
 * @author Nieves Borrero
 *
 */

public class Cuadrado extends Rectangulo {

	public Cuadrado(double lado) throws DimensionNoValidaException {
		super(lado, lado);
	}

	@Override
	public String toString() {
		return "\n" + getClass().getSimpleName() + " codigo=" + getCodigo()
				+ ", perimetro()=" + redondearDimension(perimetro())
				+ ", area()=" + redondearDimension(area()) + ", lado: "
				+ redondearDimension(getBase());
	}
}
