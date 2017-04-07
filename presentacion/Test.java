package exMarzo2017_NievesBorrero.presentacion;

/**
 * @author Nieves Borrero
 */
import exMarzo2017_NievesBorrero.estructuras.Figuritas;
import exMarzo2017_NievesBorrero.excepciones.DimensionNoValidaException;
import exMarzo2017_NievesBorrero.excepciones.FiguraNoExisteException;
import exMarzo2017_NievesBorrero.excepciones.ListaVaciaException;
import utiles.Menu;
import utiles.Teclado;

public class Test {
	static Figuritas figuras = Figuritas.getInstance();
	private static Menu menuGeneral = new Menu("**General", new String[] {
			"Altas", "Bajas", "Listar" });
	private static Menu menuAltas = new Menu("**Altas", new String[] {
			"Masivas(dimensiones aleatorias,3 figuras de cada tipo)",
			"Selectivas(dimension por teclado)" });
	private static Menu menuAltasSelectivas = new Menu(
			"**Elige la figura a crear", new String[] { "Rectangulo",
					"Cuadrado", "Circulo", "Triangulo" });
	private static Menu menuListar = new Menu("**Listar", new String[] {
			"Todos", "Triangulos", "Del reves" });
	private static Menu menuBajas = new Menu("**Bajas", new String[] {
			"Por indicador", "Por indice en la lista" });

	public static void main(String[] args) {
		int opcion;

		do {
			switch (opcion = menuGeneral.gestionar()) {
			case 1:
				altas();
				break;
			case 2:
				bajas();
				break;
			case 3:
				listar();
				break;
			case 4:
				salir();
				break;
			}
		} while (opcion != menuGeneral.SALIR);

	}

	private static void salir() {
		System.out.println("Hasta otra!");

	}

	private static void listar() {
		int opcion;
		do {
			switch (opcion = menuListar.gestionar()) {
			case 1:
				listarTodos();
				break;
			case 2:
				listarTriangulos();
				break;
			case 3:
				listarDelReves();
				break;
			case 4:
				break;
			}
		} while (opcion != menuListar.SALIR);

	}

	private static void listarTodos() {
		try {
			System.out.println(figuras.listar());
		} catch (ListaVaciaException e) {
			System.err.println("Error al listar figuras" + e.getMessage());
		}

	}

	private static void listarDelReves() {
		try {
			System.out.println(figuras.listarDelReves());
		} catch (ListaVaciaException e) {
			System.err.println("Error al listar figuras en orden inverso"
					+ e.getMessage());
		}
	}

	private static void listarTriangulos() {
		try {
			System.out.println(figuras.listarTriangulos());
		} catch (ListaVaciaException e) {
			System.err.println("Error al listar triangulos" + e.getMessage());
		}

	}

	private static void bajas() {
		int opcion;
		do {
			switch (opcion = menuBajas.gestionar()) {
			case 1:
				bajaId();
				break;
			case 2:
				bajaIndex();
				break;
			case 3:
				break;
			}
		} while (opcion != menuBajas.SALIR);

	}

	private static void bajaIndex() {
		try {
			System.out.println(figuras.listar());
		} catch (ListaVaciaException e) {
			System.out.println("No puedes dar de baja a ninguna figura, "
					+ e.getMessage());
		}

		try {
			figuras.remove(Teclado
					.leerEntero("selecciona indice de la figura a eliminar"));
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Error al borrar, indice no valido");
		}
	}

	private static void bajaId() {
		try {
			System.out.println(figuras.listar());
		} catch (ListaVaciaException e) {
			System.out.println("No puedes dar de baja a ninguna figura, "
					+ e.getMessage());
		}

		try {
			figuras.removeId(Teclado
					.leerEntero("selecciona codigo de la figura a eliminar"));
		} catch (FiguraNoExisteException | DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}

	private static void altas() {
		int opcion;

		do {
			switch (opcion = menuAltas.gestionar()) {
			case 1:
				altasMasivas();
				break;
			case 2:
				altasSelectivas();
				break;
			case 3:
				break;
			}
		} while (opcion != menuAltas.SALIR);

	}

	private static void altasMasivas() {
		try {
			figuras.addFigurasAleatorias();
			System.out.println(figuras.listar());
		} catch (ListaVaciaException e) {
			System.err.println(e.getMessage());
		}

	}

	private static void altasSelectivas() {
		int opcion;

		do {
			switch (opcion = menuAltasSelectivas.gestionar()) {
			case 1:
				addRectangulo();
				break;
			case 2:
				addCuadrado();
				break;
			case 3:
				addCirculo();
				break;
			case 4:
				addTriangulo();
				break;
			case 5:
				break;
			}
		} while (opcion != menuAltasSelectivas.SALIR);

	}

	private static void addTriangulo() {
		try {
			figuras.addTriangulo(Teclado.leerDecimal("Introduce la base"),
					Teclado.leerDecimal("Introduce la altura"));
		} catch (DimensionNoValidaException e) {
			System.err.println("Error al aniadir triangulo, " + e.getMessage());
		}

	}

	private static void addCirculo() {
		try {
			figuras.addCirculo(Teclado.leerDecimal("Introduce el radio"));
		} catch (DimensionNoValidaException e) {
			System.err.println("Error al aniadir circulo, " + e.getMessage());
		}

	}

	private static void addCuadrado() {
		try {
			figuras.addCuadrado(Teclado.leerDecimal("Introduce el lado"));
		} catch (DimensionNoValidaException e) {
			System.err.println("Error al aniadir cuadrado, " + e.getMessage());
		}

	}

	private static void addRectangulo() {
		try {
			figuras.addRectangulo(Teclado.leerDecimal("Introduce la base"),
					Teclado.leerDecimal("Introduce la altura"));
		} catch (DimensionNoValidaException e) {
			System.err
					.println("Error al aniadir rectangulo, " + e.getMessage());
		}

	}

}
