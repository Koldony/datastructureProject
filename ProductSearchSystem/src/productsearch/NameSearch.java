package productsearch;

import java.util.ArrayList;

public class NameSearch {
    private ArrayList<Product> products;
    
    public NameSearch(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> search(String keyword) {
        ArrayList<Product> result = new ArrayList<>();
        String key = keyword.trim().toLowerCase();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().toLowerCase().contains(key)) {
                result.add(products.get(i));
            }
        }
        return result;
    }
}
