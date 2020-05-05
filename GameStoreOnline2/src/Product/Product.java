package Product;


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
//       try {
//        Objects.requireNonNull(productCode, "Don't give a null");
//        Objects.requireNonNull(productName, "Don't give a null");
//        Objects.requireNonNull(description, "Don't give a null");
//        Objects.requireNonNull(price, "Don't give a null");
        if(productCode!=null && productName!=null && description!=null){
        this.productCode = productCode;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.productStatus = ProductStatus.onSale; }
//        else if(productCode==null || productName==null || description==null){
//            System.out.println("Not Null");
//        }
//        } catch(Exception p) {
//            System.out.println("Don't give a null");
//        }
    }

    public Product(String productCode , String productName , String description , int price,String productStatus) {
         if(productCode!=null && productName!=null && description!=null){
         this.productCode = productCode;
        this.productName = productName;
        this.description = description;
        this.price = price;
        if(productStatus.equalsIgnoreCase("Beta Test")){this.productStatus = ProductStatus.betaTest;}
        if(productStatus.equalsIgnoreCase("Coming Soon")){this.productStatus = ProductStatus.comingSoon;}
        if(productStatus.equalsIgnoreCase("onSale")){this.productStatus = ProductStatus.onSale;}
        if(productStatus.equalsIgnoreCase("Suspended")){this.productStatus = ProductStatus.suspendedForSale;}
         }
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
    
    public String getProductStatusToString() {
        if(this.productStatus==ProductStatus.betaTest){return "Beta Test";}
        else if(this.productStatus==ProductStatus.comingSoon){return "Coming Soon";}
        else if(this.productStatus==ProductStatus.onSale){return "On Sale";}
        else if(this.productStatus==ProductStatus.suspendedForSale){return "Suspended";}
        else{return null;}
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
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
