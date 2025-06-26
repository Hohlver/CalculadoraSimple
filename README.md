# Calculadora Simple

## Descripcion general  

Esta es una calculadora básica implementada en Java que realiza las cuatro operaciones fundamentales (suma, resta, multiplicación y división). El proyecto demuestra la aplicación de cuatro patrones de diseño fundamentales utilizados en una sola clase Java.


## Patrones Utilizados

### 1. Singleton (Creacional)
Justificación: Garantiza que solo exista una instancia de la calculadora en toda la aplicación.
Implementación:
```java
private static CalculadoraBasica instance;  // <-- Se declara variable estática y única instancia

private CalculadoraBasica() {  // <-- Constructor privado
    operaciones.put("+", new Suma());
    operaciones.put("-", new Resta());
    operaciones.put("*", new Multiplicacion());
    operaciones.put("/", new Division());
}

public static CalculadoraBasica getInstance() {  // <-- Método estático de acceso
    if(instance == null) {
        instance = new CalculadoraBasica();  // <-- Instanciación controlada
    }
    return instance;
}
```
- Posee constructor privado

- Posee método estático getInstance() para obtener la instancia única

- Posee variable estática instance que almacena la única instancia

### 2. Factory Method (Comportamiento)
Justificación: Centraliza la creación de objetos de operaciones matemáticas.
Implementación:
```java
    private Map<String, Operacion> operaciones = new HashMap<>();
    
    private CalculadoraBasica() {
        operaciones.put("+", new Suma());
        operaciones.put("-", new Resta());
        operaciones.put("*", new Multiplicacion());
        operaciones.put("/", new Division());
    }
    
    public static CalculadoraBasica getInstance() {
        if(instance == null) {
            instance = new CalculadoraBasica();
        }
        return instance;
    }
    
    public double calcular(double a, double b, String operador) {
        Operacion op = operaciones.get(operador);
        if(op == null) throw new IllegalArgumentException("Operador no válido");
        return op.ejecutar(a, b);
    }
```

- Utiliza un mapa Factory que asocia símbolos ("+", "-", "*", "/") con instancias de operaciones

- El método calcular() utiliza este mapa para obtener la operación adecuada


### 3. Prototype (Creacional)
Justificación: Permite clonar operaciones existentes en lugar de crearlas desde cero.
Implementación:
```java
    private static class Suma implements Operacion, Cloneable {
        public double ejecutar(double a, double b) { return a + b; }
        public Suma clone() { return new Suma(); }
    }
    
// ... otras implementaciones (Resta, Multiplicacion, division.)
```

- Cada operación implementa la interfaz Cloneable

- El método clone() se encuentra en cada clase de operación

- Las operaciones pueden ser duplicadas cuando sea necesario

### 4. Bridge (Estructural)
Justificación: Separa la abstracción (concepto de operación) de su implementación (operaciones concretas).
Implementación:
```java
private interface Operacion {  // Abstracción
    double ejecutar(double a, double b);
}

private static class Suma implements Operacion {  // Implementación concreta
    public double ejecutar(double a, double b) {
        return a + b;
    }
}
// ... otras implementaciones (Resta, Multiplicacion, division.)


Operacion op = operaciones.get(operador);
return op.ejecutar(a, b); 
```
- Posee la interfaz 'Operacion' que define el contrato para todas las operaciones

- Tiene clases concretas (Suma, Resta, Multiplicacion, Division.) que implementan dicha interfaz

- La calculadora trabaja con la interfaz, no con las implementaciones concretas

## Instrucciones de compilación y ejecución

### Compilación:
```java
bash
javac CalculadoraBasica.java
```
### Ejecución:
```java
bash
java CalculadoraBasica
```
### Uso:
- Las operaciones deben ser ingresadas en el formato: Numero [ESPACIO] Operador [ESPACIO] Numero (ej. 1 + 2)

- Operadores soportados: + (suma), - (resta), * (multiplicación) y / (división)

- Para salir solo hay que escribir 'Salir'

## Notas Adicionales


- La división por cero mostrará un mensaje de error

- Los operadores no reconocidos mostrarán un mensaje de error

- El formato de entrada DEBE ser exacto (un espacio entre cada elemento)

----
