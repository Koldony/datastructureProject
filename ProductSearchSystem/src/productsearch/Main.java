package productsearch;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductStore store = new ProductStore();
        try {
            store.load("data/products.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find data/products.txt");
            return;
        }

        NameSearch nameSearch = new NameSearch(store.getProducts());
        Scanner sc = new Scanner(System.in);
        String choice = "";

        while (!choice.equals("0")) {
            System.out.println("======================================");
            System.out.println("    Product Search System (Demo)");
            System.out.println("======================================");
            System.out.println("[1] Search product by name");
            System.out.println("[2] Show all products");
            System.out.println("[0] Exit");
            System.out.print("Choose an option: ");

            if (!sc.hasNextLine()) {
                break;
            }
            choice = sc.nextLine().trim();

            switch (choice) {
            case "1":
                System.out.print("Product Name : ");
                String keyword = sc.nextLine();
                printProducts(nameSearch.search(keyword));
                break;
            case "2":
                printProducts(store.getProducts());
                break;
            case "0":
            	System.out.println("\n====================================");
                System.out.println("\t\"TERMINATED PROCESS\"");
                System.out.println("====================================");
                break;
            default:
                System.out.println("Invalid option");
            }
            System.out.println();
        }
        sc.close();
    }

    private static void printProducts(ArrayList<Product> list) {
        if (list.isEmpty()) {
            System.out.println("Product not found");
            return;
        }
        System.out.println();
        
        System.out.println(pad("ID", 6) + pad("Name", 34) + pad("Category", 16) + "Price");
        System.out.println("------------------------------------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            Product p = list.get(i);
            System.out.println(pad(p.getId(), 6) + pad(p.getName(), 34) + pad(p.getCategory(), 16) + (int) p.getPrice());
        }
        System.out.println("------------------------------------------------------------------");
        System.out.println("Total: " + list.size() + " item(s)");
    }

    private static String pad(String text, int width) {
        String result = text;
        while (result.length() < width) {
            result = result + " ";
        }
        return result;
    }
}
