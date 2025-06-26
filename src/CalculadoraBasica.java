import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class CalculadoraBasica {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraBasica calc = CalculadoraBasica.getInstance();
        
        System.out.println("Calculadora Básica (+, -, *, /)");
        System.out.println("Ingrese 'salir' para terminar");
        
        while(true) {
            System.out.print("Ingrese operación (ej. 5 + 3): ");
            String input = scanner.nextLine().trim();
            
            if(input.equalsIgnoreCase("salir")) break;
            
            try {
                String[] partes = input.split(" ");
                if(partes.length != 3) {
                    System.out.println("Formato incorrecto. Use: numero operador numero");
                    continue;
                }
                
                double a = Double.parseDouble(partes[0]);
                String op = partes[1];
                double b = Double.parseDouble(partes[2]);
                
                double resultado = calc.calcular(a, b, op);
                System.out.println("Resultado: " + resultado);
            } catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        scanner.close();
        System.out.println("Calculadora cerrada");
    }    
    
    
    
    // Singleton
    private static CalculadoraBasica instance;
    
    // Bridge
    private interface Operacion {
        double ejecutar(double a, double b);
    }
    
    // Prototype
    private static class Suma implements Operacion, Cloneable {
        public double ejecutar(double a, double b) { return a + b; }
        public Suma clone() { return new Suma(); }
    }
    
    private static class Resta implements Operacion, Cloneable {
        public double ejecutar(double a, double b) { return a - b; }
        public Resta clone() { return new Resta(); }
    }
    
    private static class Multiplicacion implements Operacion, Cloneable {
        public double ejecutar(double a, double b) { return a * b; }
        public Multiplicacion clone() { return new Multiplicacion(); }
    }
    
    private static class Division implements Operacion, Cloneable {
        public double ejecutar(double a, double b) { 
            if(b == 0) throw new ArithmeticException("División por cero");
            return a / b; 
        }
        public Division clone() { return new Division(); }
    }
    
    // Factory Method implementation
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
    


}