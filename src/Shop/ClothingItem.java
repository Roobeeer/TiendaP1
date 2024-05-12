package Shop;

public class ClothingItem {
    private String name;
    private double price;
    private char size;

    public ClothingItem(String name, double price, char size){
        this.name = name;
        this.price = price;
        if(size == 'S' || size == 'M' || size == 'L' ){
            this.size = size;
        }else{
            System.out.println("Tamaño no válido. Se asignará S por defecto");
            this.size = 'S';
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void setSize(char size){
        if(size == 'S'|| size == 'M' || size == 'L') {
            this.size = size;
        }else{
            System.out.println("Tamaño inválido, no se ha modificado");
        }
    }

    public char getSize(){
        return size;
    }

    @Override
    public String toString(){
        return name+"\t\t"+price+"\t\t\t"+size;
    }
}



