package figuras.jerarquiaFiguras;

import exMarzo2017_NievesBorrero.excepciones.DimensionNoValidaException;

/**
 * Clase que permite la creación de un cuadrado, que hereda de rectángulo.
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
