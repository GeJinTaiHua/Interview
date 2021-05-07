package ClassLoad;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 网络版的自定义加载器
 */
public class MyNetworkClassLoader extends ClassLoader {
    private final String url;

    public MyNetworkClassLoader(String url) {
        super();
        this.url = url;
    }

    @Override
    public Class findClass(String name) {
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String name) {
        String classUrl = url + "/" + name.replace(".", "/") + ".class";
        byte[] bytes = null;

        try {
            URL url = new URL(classUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(60 * 1000);
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            InputStream inputStream = conn.getInputStream();

            byte[] buffer = new byte[1024];
            int len = 0;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((len = inputStream.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            bos.close();
            bytes = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bytes;
    }

    public static void main(String[] args) throws Exception {
        MyNetworkClassLoader myNetworkClassLoader = new MyNetworkClassLoader("https://github.com/GeJinTaiHua/MyNote/tree/master/Interview-Java/src/main/resources/classlib");
        Class<?> loadClass = myNetworkClassLoader.loadClass("www.wjl.com.Interview.SnowFlake");
        Method method = loadClass.getMethod("main", String[].class);
        method.invoke(null, (Object) new String[]{});
    }
}
