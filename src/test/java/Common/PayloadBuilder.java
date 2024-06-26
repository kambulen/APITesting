package Common;

import org.json.simple.JSONObject;

public class PayloadBuilder {
    public static JSONObject createEmployeeObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Nkosi");
        jsonObject.put("job", "Test");

        return jsonObject;

    }

    public static JSONObject updateEmployeeObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "morpheus");
        jsonObject.put("job", "zion resident");
        jsonObject.put("surname", "TestSurname");

        return jsonObject;
    }

    public static JSONObject patchEmployeeObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "morpheuspatch");
        jsonObject.put("job", "zion residentpatch");

        return jsonObject;
    }

    public static JSONObject registerStationObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", "SF_TEST003");
        jsonObject.put("name", "D-Town, Zone 20");
        jsonObject.put("latitude", 37.76);
        jsonObject.put("longitude", -122.43);
        jsonObject.put("altitude", 150);

        return jsonObject;


    }

}
