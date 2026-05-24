# CrearDto

Se creó un DTO para la clase `Producto` similar a `ClienteDto`.

- Archivo: `src/main/java/ort/da/mvp/facturas/dto/ProductoDto.java`
- Package: `ort.da.mvp.facturas.dto`
- Implementación: constructor desde `Producto`, campos privados y acceso solo mediante getters.
- Incluye método estático `listaDtos(List<Producto> lista)` para convertir listas de `Producto` a listas de `ProductoDto`.

## Notas

El DTO expone los atributos públicos de la clase `Producto` a través de getters:
- `getNombre()`
- `getPrecio()`
- `getUnidades()`
- `getProveedor()`

No se agregaron setters al DTO para mantenerlo como objeto de solo lectura.
