import java.util.Arrays;

public class ArrayMain {
    public static final float DISCOUNT = 0.10f;
    public static void main(String[] args) {
        Product[] prodArray = new Product[10];
        Product prod1 = new Product("Laptop", 450f);
        Product prod2 = new Product("Flash card", 12.5f);
        Product prod3 = new Product("Keyboard", 39.99f);
        prodArray[0] = prod1;
        prodArray[1] = prod2;
        prodArray[2] = prod3;
        for (int i = 0; i < prodArray.length; ++i){
            if (prodArray[i] != null){
                float priceCheck = prodArray[i].getPrice();
                if (priceCheck > 200){
                    prodArray[i].setPrice(priceCheck * (1 - DISCOUNT));
                }
                System.out.println(prodArray[i]);
            };
        }
        Arrays.fill(prodArray, prod1);
        for (Product product : prodArray){
            System.out.println(product);}
        prod1.setName("Portabe computer");
        System.out.println(Arrays.toString(prodArray));
    }

}
