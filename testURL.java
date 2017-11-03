import java.net.*;
import java.io.*;

public class testURL{
    public static void main(String[] args) throws IOException
    {
        URL url = new URL("https://i.cnblogs.com/EditPosts.aspx?opt=1");
        String file = url.getFile();
        System.out.println(file);
        String host = url.getHost();
        System.out.println(host);
        int port = url.getPort();
        System.out.println(port);
        String query = url.getQuery();
        System.out.println(query);
        String protocol = url.getProtocol();
        System.out.println(protocol);
        
        URL url2 = new URL("http://www.baidu.com");
        URLConnection connection = url2.openConnection();
        InputStream is = connection.getInputStream();
        OutputStream os = new FileOutputStream("./data.txt");
        byte[] buffer = new byte[1024];
        int flag = 0;
        while (-1 != (flag = is.read(buffer, 0, buffer.length)))
        {
            os.write(buffer, 0, flag);
        }
        os.close();
        is.close();
        
    }

}

