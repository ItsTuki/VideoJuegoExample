# VideoJuegoExample

Ejercicio completo de una API REST con **Spring Boot** para administrar un catálogo de videojuegos: CRUD, filtros y consultas simples sobre precio y stock.

Los datos se guardan en memoria (en una lista), así que se borran al reiniciar la aplicación.

## Tecnologías

- Java 21
- Spring Boot 4 (Web MVC y Validation)
- Lombok
- Maven (incluye el wrapper `mvnw`)

## Endpoints

Base: `http://localhost:8080/api/v1/games`

| Método | Ruta | Qué hace |
|---|---|---|
| `GET` | `/api/v1/games` | Lista todos los juegos. |
| `GET` | `/api/v1/games/{id}` | Busca un juego por ID. |
| `POST` | `/api/v1/games` | Agrega un juego. |
| `PUT` | `/api/v1/games` | Actualiza un juego (según el `id` del cuerpo). |
| `DELETE` | `/api/v1/games/{id}` | Elimina un juego. |
| `GET` | `/api/v1/games/genero/{genero}` | Filtra por género. |
| `GET` | `/api/v1/games/filtro/{plataforma}` | Filtra por plataforma. |
| `GET` | `/api/v1/games/mas-barato` | Devuelve el juego más barato. |
| `GET` | `/api/v1/games/conteo-stock` | Cuenta cuántos juegos tienen stock disponible. |

### Ejemplo de juego

```json
{
  "id": 1,
  "titulo": "Hollow Knight",
  "genero": "Metroidvania",
  "plataforma": "PC",
  "precio": 14990,
  "stock": 5,
  "desarrollador": "Team Cherry"
}
```

Todos los campos son obligatorios; `precio` debe ser positivo y `stock` no puede ser negativo.

## Cómo ejecutarlo

```bash
./mvnw spring-boot:run      # Linux / macOS
mvnw.cmd spring-boot:run    # Windows
```

La API queda en <http://localhost:8080>.

## Estructura

```
src/main/java/com/juego/video/
├── controller/controllerJuego.java    # endpoints REST
├── service/Juegoservice.java          # lógica de negocio
├── repository/JuegoQlRepository.java  # almacenamiento en memoria y filtros
└── model/JuegoDeMierda.java           # entidad con validaciones
```
