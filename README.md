# Calculadora Simple

## 📌 Descripcion general  

Esta es una calculadora básica implementada en Java que realiza las cuatro operaciones fundamentales (suma, resta, multiplicación y división). El proyecto demuestra la aplicación de cuatro patrones de diseño fundamentales en una sola clase Java.


## 🖼️ Patrones Utilizados

### 1. Singleton (Creacional)
Justificación: Garantiza que solo exista una instancia de la calculadora en toda la aplicación.
Implementación:

- Constructor privado

- Método estático getInstance() para obtener la instancia única

- Variable estática instance que almacena la única instancia

### 2. Factory Method (Comportamiento)
Justificación: Centraliza la creación de objetos de operaciones matemáticas.
Implementación:

- Mapa operaciones que asocia símbolos ("+", "-", etc.) con instancias de operaciones

- Método calcular() que usa este mapa para obtener la operación adecuada


### 3. Prototype (Creacional)
Justificación: Permite clonar operaciones existentes en lugar de crearlas desde cero.
Implementación:

- Cada operación implementa la interfaz Cloneable

- Método clone() en cada clase de operación

- Las operaciones pueden ser duplicadas cuando sea necesario

### 4. Bridge (Estructural)
Justificación: Separa la abstracción (concepto de operación) de su implementación (operaciones concretas).
Implementación:

- Interfaz Operacion que define el contrato para todas las operaciones

- Clases concretas (Suma, Resta, etc.) que implementan la interfaz

- La calculadora trabaja con la interfaz, no con las implementaciones concretas

## Instrucciones de compilación y ejecución

### Compilación:

bash
javac CalculadoraBasica.java

###Ejecución:

bash
java CalculadoraBasica

### Uso
- Ingrese operaciones en el formato: numero operador numero (ej. 5 + 3)

- Operadores soportados: + (suma), - (resta), * (multiplicación), / (división)

- Para salir, escriba salir

## Notas Adicionales


- La división por cero mostrará un mensaje de error

- Los operadores no reconocidos mostrarán un mensaje de error

- El formato de entrada debe ser exacto (un espacio entre cada elemento)

----
