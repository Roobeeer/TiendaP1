package Sales;
import Shop.*;

public class SalesRegister {
    public static long totalSalesCount;
    public static double totalSalesAmount;


    public static ClothingItem processSale(Inventory inventory, String name, char size){
        int hayStock = inventory.checkStock(name,size);
        if(hayStock !=0){
            ClothingItem item = inventory.extractItem(name,size);
            totalSalesCount++;
            totalSalesAmount += item.getPrice();
            return item;

        }else{
            System.out.println("El producto no está en stock");
            return null;
        }
    }
    public static void resetTotalSalesCount(){
        totalSalesCount = 0;
    }
    public static void resetTotalSalesAmount(){
        totalSalesAmount = 0;
    }

    public static long getTotalSalesCount(){
        return totalSalesCount;
    }

    public static double getTotalSalesAmount(){
        return totalSalesAmount;
    }

    public static String getBalance(){
        return "Total sales " + getTotalSalesAmount() + ", total count " + getTotalSalesCount();

    }

    @Override
    public String toString(){
        return "Ventas totales = "+totalSalesCount + "Cantidad de ventas = "+totalSalesAmount+" Balance : "+getBalance();
    }
}
