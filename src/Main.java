import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opt;
        Scanner sc = new Scanner(System.in);
        ABB arbol = new ABB();
        do {
            System.out.println("Menu:");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Buscar");
            System.out.println("4. Mostrar orden");
            System.out.println("5. Mostrar preorden");
            System.out.println("6. Mostrar posorden");
            System.out.println("7. Salir");
            System.out.print("Ingrese una opcion: ");
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("Escribe el numero a insertar:");
                    arbol.insertar(sc.nextDouble());
                    System.out.println("Se ha insertado el numero correctamente");
                    break;
                case 2:
                    System.out.println("Escribe el numero a eliminar");
                    arbol.eliminar(sc.nextDouble());
                    System.out.println("Se ha eliminado el número correctamente");
                    break;
                case 3:
                    System.out.println("Introduce el número a buscar");
                    System.out.println(arbol.buscar(sc.nextDouble()));
                    break;
                case 4:
                    System.out.println(arbol.mostrarOrden(arbol.getRaiz()));
                    break;
                case 5:
                    System.out.println(arbol.mostrarPreOrden(arbol.getRaiz()));
                    break;
                case 6:
                    System.out.println(arbol.mostrarPosOrden(arbol.getRaiz()));
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo...");
                    break;
            }
        } while (opt != 7);
    }
}