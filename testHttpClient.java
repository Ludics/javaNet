import java.util.ArrayList;

import org.omg.CORBA.NameValuePair;

import sun.net.www.http.HttpClient;
// import org.apache.http.*;

public class testHttpClient {
    HttpClient httpClient = new DefaultHttpClient();
    HttpGet httpGet = new HttpGet("http://www.ludics.cn");

    HttpResponse httpResponse = httpClient.execute(httpGet);

    // HttpPost httpPost = new HttpPost("http://www.baidu.com");
    // List<NameValuePair> params = new ArrayList<NameValuePair>();
    // params.add(new BasicNameValuePair("username", "admin"));
    // params.add(new BasicNameValuePair("password", "123456"));
    // HttpEntity httpEntity = new UrlEncodedFormEntity(params, "utf-8");
    // httpPost.setEntity(httpEntity);
    String resultData;
    if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
        resultData = EntityUtils.toString(httpResponse.getEntity(), "utf-8"); 
    }
    System.out.println(resultData);


}