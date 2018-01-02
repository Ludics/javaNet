import java.net.*;

import jdk.internal.org.objectweb.asm.Handle;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.*;

public class myNet{

    private static final String httpUrl = "http://www.imooc.com/api/teacher?type=4&num=40";
    public static void main(String[] args) throws IOException
    {
        
        // URL url = new URL("http://www.ludics.cn");
        URL url = new URL(httpUrl);
        HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();

        httpUrlConnection.setRequestMethod("GET");
        httpUrlConnection.setConnectTimeout(8000);
        httpUrlConnection.setReadTimeout(8000);
        httpUrlConnection.setDoInput(true);
        httpUrlConnection.setDoOutput(true);
        httpUrlConnection.setUseCaches(false);
        httpUrlConnection.connect();
        InputStream inputStream = httpUrlConnection.getInputStream();
        InputStreamReader in = new InputStreamReader(inputStream);
        BufferedReader bf = new BufferedReader(in);
        StringBuffer sb = new StringBuffer();
        String inputLine = null;
        
        while ((inputLine = bf.readLine()) != null){
            System.out.println(inputLine);
        }
        // int ch;
        // while ((ch=inputStream.read()) != -1){ 
        //     System.out.println((char)ch);
        // }
        
    }

}

