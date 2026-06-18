public class Main{
    public static Product linearSearch(Product[] products,int targetId){
        for(Product product : products){
            if (product.productId==targetId)
                return product;
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
    public static void main(String[]args){
        Product[] products={
            new Product(101,"Laptop","Electronics"),
            new Product(102,"Sarees","Fashion"),
            new Product(103,"Shoes","Accesories"),
            new Product(104,"Books","Stationary"),
            new Product(105,"Earrings","Jewellery"),
        };
        int targetId=103;
        Product res1=linearSearch(products,targetId);
        if(res1!=null)
            System.out.println("Linear Search. Found: "+res1);
        else
            System.out.println("Product not found");

        Product res2=linearSearch(products,targetId);
        if(res2!=null)
            System.out.println("Binary Search. Found: "+res2);
        else
            System.out.println("Product not found");

    }
}