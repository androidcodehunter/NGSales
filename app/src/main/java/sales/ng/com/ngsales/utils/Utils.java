package sales.ng.com.ngsales.utils;

import android.content.Context;
import android.util.Log;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import sales.ng.com.ngsales.model.Product;

/**
 * Created by User on 12/27/2017.
 */

public class Utils {

    private static final String TAG = "Utils";

    public static List<Product> getDummyProducts(Context context){
        List<Product>products = new ArrayList<>();
        Product product;
        try {

            InputStreamReader is = new InputStreamReader(context.getAssets()
                    .open("products.csv"));
            CSVReader reader = new CSVReader(is);
            for (String[] value : reader.readAll()) {
                product = new Product();
                product.setProductName(value[2]);
                product.setProductPrice(value[3]);
                products.add(product);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

}
