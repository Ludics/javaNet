
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.json.JSONException;
import java.util.*;
// import org.json.JSONObject;
// import java.util.logging.Logger;

public class TestLogSign {
    // Logger log = new Logger(this.getClass());//初始化日志类
    /**
     * @作用 使用urlconnection
     * @param username
     * @param password
     * @return 
     * @throws IOException
     */
    private String myUrl = "http://www.ludics.cn/app/";
    public String register(String username,String password) throws IOException{
        OutputStreamWriter out = null;
        BufferedReader reader = null;
        String response="";
        try {
            URL httpUrl = null; //HTTP URL类 用这个类来创建连接
            //创建URL
            httpUrl = new URL(myUrl+"signup.php");
            //建立连接
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("connection", "keep-alive");
            conn.setRequestProperty("Charset", "utf-8");
            conn.setUseCaches(false);//设置不要缓存
            conn.setInstanceFollowRedirects(true);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(3000);
            String data = "&userName=" + username + "&userPassword=" + password;
            conn.setRequestProperty("Content-Length",String.valueOf(data.getBytes().length));
            conn.connect();
            //POST请求
            OutputStream os = conn.getOutputStream();
            os.write(data.getBytes());
            os.flush();
            //读取响应
            reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String lines;
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                response+=lines;
            }
            reader.close();
            // 断开连接
            conn.disconnect();
            // System.out.println(response.toString());
            // log.info(response.toString());
        } catch (Exception e) {
            // System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(reader!=null){
                    reader.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }

        return response;
    }
    /**
     * @作用 登录
     * @param username
     * @param password
     * @return "Username existed, register failed." 
     * @return "Register success."
     * @throws IOException
     */

    public String login(String username, String password) throws IOException{
        OutputStreamWriter out = null;
        BufferedReader reader = null;
        String response="";
        try {
            
            URL httpUrl = null; //HTTP URL类 用这个类来创建连接
            //创建URL
            httpUrl = new URL(myUrl+"user_login.php");
            //建立连接
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("connection", "keep-alive");
            conn.setRequestProperty("Charset", "utf-8");
            conn.setUseCaches(false);//设置不要缓存
            conn.setInstanceFollowRedirects(true);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(3000);
            String data = "&userName=" + username + "&userPassword=" + password;
            conn.setRequestProperty("Content-Length",String.valueOf(data.getBytes().length));
            conn.connect();
            //POST请求
            OutputStream os = conn.getOutputStream();
            os.write(data.getBytes());
            os.flush();
            //读取响应
            reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String lines;
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                response+=lines;
            }
            reader.close();
            // 断开连接
            conn.disconnect();
            // System.out.println(response.toString());
            // log.info(response.toString());
        } catch (Exception e) {
            // System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(reader!=null){
                    reader.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }

        return response;
    }

    public static void main(String[] args){
        // JSONObject jsonObj = new JSONObject();
        // jsonObj.append("username", "stt");
        // jsonObj.append("password", "ludics");
        // String url = "http://www.ludics.cn/app/signup.php";

        String username, password;
        Scanner sc = new Scanner(System.in);
        System.out.print("Username： ");
        username = sc.nextLine();
        System.out.print("Password: ");
        password = sc.nextLine();
        sc.close();
        TestLogSign test = new TestLogSign();
        try{
            String re = test.login(username, password);
            System.out.println(re);
        } catch(IOException ex){
            ex.printStackTrace();
        } 
        
    }
}