package Product;


import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

public class Product {
    private String productCode;
    private String productName;
    private String description;
    private int price;
    private ProductStatus productStatus;
    private static final String BLUE = "\u001B[034m";
    private static final String BLACK = "\u001B[030m";
    
    public Product (String productCode , String productName , String description , int price) {
        this.productCode = productCode;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.productStatus = ProductStatus.onSale;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }
    public void paint(Graphics g){
    g.setColor (Color.blue);
    g.drawString(productName, 120, 120);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.productCode, other.productCode)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  "Product Code : " + productCode + 
                "\nProduct Name : " +BLUE+productName  +BLACK+
                "\nDescription : " + description + 
                "\nPrice : " + price + 
                "\nProduct Status : " + productStatus;
    }
    
    
    
    
}
