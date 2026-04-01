# Implementation Steps

This document outlines the steps taken to refactor the VideoJuegoExample project to correct structural and best-practice errors. The objective of this refactoring is to comply strictly with the evaluation guidelines and the Controller-Service-Repository (CSR) pattern.

## 1. Model Refactoring
- Removed the previous model class and created `Game.java`.
- Standardized all attributes in English (`id`, `title`, `genre`, `platform`, `price`, `stock`, `developer`).
- Applied `@NotNull`, `@NotBlank`, and `@Positive` annotations for data integrity. Replaced inappropriate strings with explicit, professional English validation messages.

## 2. Repository Implementation
- Created `GameRepository.java` targeting an in-memory repository structure using `java.util.List`.
- Adjusted logic to use copy returns for read-only actions and explicit replacements for updates.
- Replaced improper RuntimeExceptions with standard Java exceptions (`NoSuchElementException`, `IllegalArgumentException`) corresponding to exact failures, such as updating non-existent IDs.

## 3. Service Layer Refactoring
- Created `GameService.java`.
- Delegated database manipulations explicitly to the Repository instance to encapsulate logic within the Service tier, strictly following the CSR bounded pattern.

## 4. Controller Logic and Endpoints
- Created `GameController.java` mapped to the standard endpoint notation `/api/v1/games`.
- Wrapped endpoints in `try/catch` statements to verify that exact service failures are caught and handled. Responses correlate to valid HTTP states (`200 OK`, `201 CREATED`, `404 NOT_FOUND`, `400 BAD_REQUEST`, `204 NO_CONTENT`).

## 5. Exception Management
- Added a `GlobalExceptionHandler.java` incorporating `@ControllerAdvice`.
- Handled `MethodArgumentNotValidException` structurally to render clean JSON output upon endpoint validation failures (i.e. empty titles or zero limits), strictly mapping validation failures directly into JSON attributes.
