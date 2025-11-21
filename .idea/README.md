# Artículos API (Spring Boot 3)

API de Gestión de Productos con Spring Boot 3, JPA, Validaciones y base H2 en memoria.

## Requisitos
- Java 17+
- Maven 3.8+

## Correr la app
```bash
mvn spring-boot:run
```

La API levanta por defecto en:
- http://localhost:8080

Consola H2:
- http://localhost:8080/h2-console
JDBC URL: `jdbc:h2:mem:articulosdb`

## Endpoints

- GET `/api/productos  || Listar productos`
- GET `/api/productos/{id}  || Obtener producto por ID`
- GET `/api/productos/buscar?nombre=xxx   ||  Buscar productos por nombre`
- POST `/api/productos || Crear producto`
- PUT `/api/productos/{id} || Actualizar producto completo`
- PATCH `/api/productos/{id} || Actualizar precio/stock`
- DELETE `/api/productos/{id} Eliminar producto`
