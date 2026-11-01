package productsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductStore {
    private ArrayList<Product> products = new ArrayList<>();

    public void load(String path) throws FileNotFoundException {
        Scanner file = new Scanner(new File(path), "UTF-8");
        while (file.hasNextLine()) {
            String line = file.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] part = line.split(",");
            products.add(new Product(part[0], part[1], part[2], Double.parseDouble(part[3])));
        }
        file.close();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
