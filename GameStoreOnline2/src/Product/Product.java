package Product;


import java.util.Objects;

public class Product {
    private final String productCode;
    private final String productName;
    private final String description;
    private final int price;
    private final ProductStatus productStatus;
    
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
                "\n Product Name : " + productName + 
                "\n Description : " + description + 
                "\n Price : " + price + 
                "\n Product Status : " + productStatus;
    }
    
    
    
    
}
