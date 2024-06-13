package Common;

import org.json.simple.JSONObject;

public class PayloadBuilder {
    public static JSONObject createEmployeeObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Nkosi");
        jsonObject.put("job", "Test");

        return jsonObject;

    }
    public static JSONObject updateEmployeeObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","morpheus");
        jsonObject.put("job","zion resident");
        jsonObject.put("surname","TestSurname");

        return jsonObject;
    }

    public static JSONObject patchEmployeeObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","morpheuspatch");
        jsonObject.put("job","zion residentpatch");

        return jsonObject;
    }

}
