import java.util.Arrays;

public class EcommerceSearchFunction {

    static class Product {
        String productId;
        String productName;
        String category;

        public Product(String productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public void printDetails() {
            System.out.println("Product ID   : " + productId);
            System.out.println("Product Name : " + productName);
            System.out.println("Category     : " + category);
        }
    }

    static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    static Product binarySearch(Product[] products, String name) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0) return products[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product("P100", "Laptop", "Electronics"),
                new Product("P101", "Shirt", "Fashion"),
                new Product("P102", "Phone", "Electronics"),
                new Product("P103", "Book", "Stationery"),
                new Product("P104", "Watch", "Accessories")
        };

        System.out.println("--- E-COMMERCE SEARCH SYSTEM ---\n");

        System.out.println("[Linear Search]");
        System.out.println("Searching for: Phone");
        Product result1 = linearSearch(products, "Phone");
        System.out.println("Result:");
        if (result1 != null) result1.printDetails();
        else System.out.println("Product not found.");

        Arrays.sort(products, (a, b) -> a.productName.compareToIgnoreCase(b.productName));

        System.out.println("\n[Binary Search]");
        System.out.println("Searching for: Phone");
        Product result2 = binarySearch(products, "Phone");
        System.out.println("Result:");
        if (result2 != null) result2.printDetails();
        else System.out.println("Product not found.");
    }
}
