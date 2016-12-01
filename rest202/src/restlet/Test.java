package restlet;

import org.restlet.representation.Representation;
import org.restlet.resource.*;

public class Test {
    static final String BASE_URI = "http://aws.nguyenresearch.com:8080/cart";

    public static void main(String[] args) throws Exception {
        ClientResource client=new ClientResource(BASE_URI);
        Representation result_string = client.get();
        System.out.println("finished");
            /*
            final JSONObject json = new JsonRepresentation(response.getEntity()).getJsonObject();

            // Navigate within the JSON document to display the titles
            final JSONObject resultSet = json.getJSONObject("ResultSet");
            final JSONArray results = resultSet.getJSONArray("Result");
            for (int i = 0; i < results.length(); i++) {
                System.out.println(results.getJSONObject(i).getString("Title"));
            }
            */
    }
}
