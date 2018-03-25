package converter;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Fetch currency exchange rates from apilayer.net and get the live rates in US Dollar,
 * Thai Baht, Japanese Yen, Chinese Yuan, Canadian Dollar, Singapore Dollar.
 *
 * @author Pakanon Pantisawat
 */
public class CurrencyGetter {
    private static final String URL = "http://apilayer.net/api/live?access_key=faaf102c532085e19c3a7306d9099035&currencies=USD,THB,JPY,CNY,CAD,SGD&format=1";

    private static JSONObject jsonObject;

    /**
     * Fetch the latest rate and save in json file.
     */
    public static void fetchRates() {
        java.net.URL url;
        BufferedReader reader;
        StringBuilder builder;

        try {
            url = new URL(URL);
            HttpURLConnection connection = ((HttpURLConnection) url.openConnection());
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setReadTimeout(15 * 1000);
            connection.connect();

            // read the output from the server

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            builder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            jsonObject = new JSONObject(builder.toString()).getJSONObject("quotes");
        } catch (Exception ignored) {
            System.err.println("Cannot fetch data from URL");
        }
    }

    /**
     * Get conversion rate of specified currency to USD.
     * @param to currency to convert to.
     * @return double value of conversion rate.
     */
    public static double convertUSDTo(String to) {
        return jsonObject.getDouble("USD" + to.toUpperCase());
    }

}
