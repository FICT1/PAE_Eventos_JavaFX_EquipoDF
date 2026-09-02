# PAE Eventos JavaFX - Equipo DF

Aplicación de escritorio en JavaFX para la gestión de tres módulos de eventos de una feria comunitaria: inventario de una pulpería, recepción de lotes de café y venta de artesanías.

## Integrantes

- Daniella Rocha
- Franklin Callejas

## Descripción del proyecto

La aplicación se organiza en una ventana principal con navegación por pestañas (`EventosNavegacion.fxml`), cada una con su propio módulo independiente:

- **Inventario de Pulpería (Reto 1):** registro de productos con validación de campos, búsqueda por código (con tecla Enter) y visualización en tabla.
- **Recepción de Café (Reto 2):** registro de lotes entregados por productores, detalle del lote con doble clic, y edición/eliminación mediante menú contextual (clic derecho) con confirmación antes de eliminar.
- **Tienda de Artesanías (Reto 3):** catálogo de artesanías con menú y barra de herramientas, búsqueda por código, y vista previa de imagen en la tabla.

## Requisitos

- JDK 21
- Maven (o el wrapper incluido `mvnw` / `mvnw.cmd`)

## Cómo ejecutar la aplicación

Desde la raíz del proyecto:

```bash
# Windows
mvnw.cmd clean javafx:run

# Linux / macOS
./mvnw clean javafx:run
```

También se puede ejecutar directamente desde un IDE (IntelliJ IDEA) corriendo la clase `Launcher.java`, que evita el error *"JavaFX runtime components are missing"* al no usar `MainApplication` como punto de entrada directo.

## Estructura del proyecto

```
src/main/java/ni/edu/uam/pae_eventos_javafx_equipodf/
├── Launcher.java              # Punto de entrada de la aplicación
├── MainApplication.java       # Carga la ventana principal (EventosNavegacion.fxml)
├── controller/
│   ├── MainController.java
│   ├── InventarioController.java   # Reto 1
│   ├── CafeController.java         # Reto 2
│   └── ArtesaniasController.java   # Reto 3
└── model/
    ├── Producto.java          # Reto 1
    ├── LoteCafe.java          # Reto 2
    └── Artesania.java         # Reto 3

src/main/resources/ni/edu/uam/pae_eventos_javafx_equipodf/
├── EventosNavegacion.fxml     # Ventana principal con las 3 pestañas
├── InventarioView.fxml
├── CafeView.fxml
└── ArtesaniasView.fxml
```
