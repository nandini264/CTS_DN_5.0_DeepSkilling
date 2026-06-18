public class Product{
    int productId;
    String productName;
    String category;
    public Product(int productId,String productName,String category) {
        this.productId=productId;
        this.productName=productName;
        this.category=category;
    }
    public String toString(){
        return ("Product ID: "+productId+", Name: "+productName+", Category: "+category);
    }

    public static Product linearSearch(Product[] products,int targetId){
        for(Product product : products){
            if (product.productId==targetId){
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products,int targetId){
        int l=0,r=products.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(products[mid].productId==targetId)
                return products[mid];
            else if(products[mid].productId<targetId)
                l=mid+1;
            else
                r=mid-1;
        }
        return null;
    }
}