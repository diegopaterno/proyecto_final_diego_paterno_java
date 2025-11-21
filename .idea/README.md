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

- GET `/api/productos`
- GET `/api/productos/{id}`
- GET `/api/productos/buscar?nombre=xxx`
- POST `/api/productos`
- PUT `/api/productos/{id}`
- PATCH `/api/productos/{id}`   (precio/stock opcional)
- DELETE `/api/productos/{id}`
