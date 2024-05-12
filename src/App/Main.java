package App;
import Sales.SalesRegister;
import Shop.ClothingItem;
import Shop.Inventory;
import java.util.Scanner;

public class Main {
    private static final int MINIMO = 1;
    private static final int MAXIMO = 5;


    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        Inventory inventory = new Inventory(15);
        do {
            showMenu();
            int numero = 0;
            int opcion = obtenerEntero(numero);
            switch (opcion) {
                case 1:
                    addItemToInventory(inventory);
                    break;
                case 2:
                    showInventory(inventory);
                    break;
                case 3:
                    processSale(inventory);
                    break;
                case 4:
                    salesStats(inventory);
                    break;
                default:
                    System.exit(0);
            }

        } while (true);
    }

    private static void showMenu(){
        System.out.println("*** Bienvendios a Strafalarius ***");
        System.out.println("Seleccione opción : \n1. Agregar una nueva prenda al inventario\n2. Mostrar inventario\n" +
                "3. Procesar venta\n4. Mostrar estadísticas de ventas\n5. Salir\nSeleccion una opción(1-5):");
    }


    private static int obtenerEntero(int numero){
        Scanner tec = new Scanner(System.in);
            if(tec.hasNextInt()){
                numero = tec.nextInt();
                if(numero >= MINIMO && numero <= MAXIMO){
                    return numero;
                }else{
                    System.out.println("Introduce un número entre el 1 y el 5");
                }
            }else{
                System.out.println("Introduzca un número entero");
                tec.next();
            }
            return numero;
    }

    private static ClothingItem addItemToInventory(Inventory inventory){
        Scanner tec = new Scanner(System.in);
        tec.nextLine();
        System.out.println("Introduzca el nombre de la prenda");
        String name = tec.nextLine();
        System.out.println("Introduce el precio de la prenda");
        int precio = tec.nextInt();
        tec.nextLine();
        System.out.println("Introduzca la talla de la prenda('S' || 'M' || 'L'): ");
        char size = tec.nextLine().toUpperCase().charAt(0);

        if(size != 'S' && size != 'M' && size != 'L'){
            System.out.println("Error, introduzca una de las tallas válidas(S, M o L)");
            tec.next();
        }else{
            size = size;
        }

        ClothingItem item1 = new ClothingItem(name,precio,size);
        inventory.addItem(item1);
        System.out.println("¡ITEM AÑADIDO AL INVENTARIO!");
        return item1;
    }
    private static void showInventory(Inventory inventory){
        System.out.println(inventory);
    }
    private static Inventory processSale(Inventory inventory){
        Scanner tec = new Scanner(System.in);
            System.out.println("Ingrese los detalles de la prenda que quiere comprar");
            System.out.println("Nombre: ");
            String name = tec.nextLine();
            System.out.println("Talla (S/M/L):");
            char talla = tec.nextLine().toUpperCase().charAt(0);
            System.out.println("Precio: ");
        int precio = tec.nextInt();
            ClothingItem item1= new ClothingItem(name,precio,talla);
            if(inventory.checkStock(name,talla) == 0){
                System.out.println("Error, la prenda introducida no se encuentra en el inventario");
                return inventory;

            }else {
                inventory.extractItem(name, talla);
                System.out.println(name + " (Size " + talla + ") vendida correctamente");
                SalesRegister.totalSalesAmount += item1.getPrice();
                SalesRegister.totalSalesCount++;

            }
            return inventory;
        }

    private static void salesStats(Inventory inventory){
        System.out.println("Ventas : "+SalesRegister.getTotalSalesCount());
        System.out.println("Dinero : "+SalesRegister.getTotalSalesAmount()+"€");
    }


}
