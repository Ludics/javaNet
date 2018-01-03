import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONArray;
import java.util.*;

public class testJSON{
    public static void main(String []args) throws JSONException{
        try{
            JSONObject jo = new JSONObject();
            jo.put("name", "ludi");
            jo.put("age", 21);
            String ludi = jo.toString();
            //System.out.println(ludi);
            ludi = "[{'name':'ludi', 'age':21}, {'name': 'stt', 'age': 20}]";
            // ludi = "{\"userID\":\"15\", \"userName\":\"ludi129\"}";
            // JSONObject obj = new JSONObject(ludi);
            // System.out.println(ludi);
            // System.out.println(obj.get("userID"));
            JSONArray jsonArray = new JSONArray(ludi);
            int iSize = jsonArray.length();
            System.out.println("Size:" + iSize);
            for (int i = 0; i < iSize; i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                System.out.println("[" + i + "]name=" + jsonObj.get("name"));
                System.out.println("[" + i + "]age=" + jsonObj.get("age"));
                System.out.println();
            }
        } catch (JSONException ex){
            ex.printStackTrace();
        }
        
    }
}