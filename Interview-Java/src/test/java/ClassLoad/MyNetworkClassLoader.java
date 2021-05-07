package ClassLoad;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
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
    public Class<?> findClass(String name) {
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String name) {
        String classUrl = url + "/" + name.replace(".", "/") + ".class";
        byte[] bytes = null;

        InputStream is = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            URL url = new URL(classUrl);
            is = url.openStream();

            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }

            bytes = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                assert is != null;
                is.close();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }

        return bytes;
    }

    public static void main(String[] args) throws Exception {
        // 删除本地class再调试，否则会调用本地的class
        MyNetworkClassLoader myNetworkClassLoader = new MyNetworkClassLoader("https://github.com/GeJinTaiHua/MyNote/tree/master/Interview-Java/src/main/resources/classlib");
        Class<?> loadClass = myNetworkClassLoader.loadClass("www.wjl.com.Interview.SnowFlake");
        Method method = loadClass.getMethod("main", String[].class);
        method.invoke(null, (Object) new String[]{});
    }
}
