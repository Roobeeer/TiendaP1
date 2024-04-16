package Sales;
import Shop.*;

public class SalesRegister {
    private long totalSalesCount;
    private double totalSalesAmount;


    public String processSale(Inventory inventory, String name, char size){
        int hayStock = inventory.checkStock(name,size);
        if(hayStock !=0){
            inventory.extractItem(name,size);
            totalSalesCount++;
            totalSalesAmount++;
            return name;

        }else{
            System.out.println("El producto no está en stock");
            System.exit(0);
            return null;
        }
    }

    public long getTotalSalesCount(){
        return totalSalesCount;
    }

    public double getTotalSalesAmount(){
        return totalSalesAmount;
    }

    public long getBalance(){
        return (long)totalSalesCount+(long)totalSalesAmount;

    }


    @Override
    public String toString(){
        return "Ventas totales = "+totalSalesCount + "Cantidad de ventas = "+totalSalesAmount+" Balance : "+getBalance();
    }
}
