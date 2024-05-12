package Shop;

public class Inventory {
    private static int MAX_SIZE = 10;

    private ClothingItem[] items;

    private int itemLength;
    public Inventory(int size) {
        MAX_SIZE = size;
        this.items = new ClothingItem[MAX_SIZE];
        this.itemLength = 0;
    }
    public int getItemCount() {
        return itemLength;
    }

    public void addItem(ClothingItem newItem) {
        if (itemLength < MAX_SIZE) {
            items[itemLength] = newItem;
            itemLength++;
        } else {
            System.out.println("Prenda no añadida, supera el valor del inventario");
        }
    }

    public int checkStock(String name, char size){
        int count = 0;
        for(int i = 0; i< itemLength; i++) {
            if(items[i].getName().equals(name) && items[i].getSize() == size){
                count++;
            }
        }
        return count;
    }

    public void removeItem(String name, char size){
        for(int i = 0; i< itemLength; i++){
            if(items[i].getName().equals(name) && items[i].getSize() == size){
                for(int j = i; j< itemLength -1; j++){
                    items[j] = items[j+1];
                }
                items[itemLength -1] = null;
                itemLength--;
                System.out.println("Prenda borrada");
                return;
            }
        }
        System.out.println("La prenda no esta en el inventario");
    }


    public ClothingItem extractItem(String name, char size){
        for(int i = 0; i< itemLength; i++){
            if(items[i].getName().equals(name) && items[i].getSize() == size){
                ClothingItem extractedItem = items[i];
                removeItem(name,size);
                return extractedItem;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder inventoryString = new StringBuilder();
        inventoryString.append("Inventario: => ").append("itemLength=").append(itemLength).append(", MAX_SIZE=").append(MAX_SIZE).append("\n");
        inventoryString.append("Nombre").append("\t\t").append("Precio").append("\t\t   ").append("Talla").append("\n");
        inventoryString.append("-------------------------------------\n");
        //$-20s%-20.2f%-20c%n
        for(int i = 0; i< itemLength; i++){
            inventoryString.append(items[i].toString()).append("\n");
        }
        return inventoryString.toString();
    }

    public void setItems(ClothingItem[] items) {
        this.items = items;
    }

    public int getItemLength() {
        return itemLength;
    }

    public void setItemLength(int itemLength) {
        this.itemLength = itemLength;
    }

    public ClothingItem[] getItems() {
        return items;
    }
    public int getMAX_SIZE(){
        return MAX_SIZE;
    }
    public void setMAX_SIZE(int MAX_SIZE){
        this.MAX_SIZE = MAX_SIZE;
    }

}




