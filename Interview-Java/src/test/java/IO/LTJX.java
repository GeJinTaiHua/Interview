package IO;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.Arrays;

/**
 * @author xiaolong
 * @date 2019/6/14 13:59
 */
@SpringBootTest
public class LTJX {
    /**
     * 读文件，输出另外文件
     */
    @Test
    public void test1() throws Exception {
        File oldFile = new File("Pic" + File.separator + "test1old.txt");
        File newFile = new File("Pic" + File.separator + "test1new.txt");

        if (oldFile.exists() && oldFile.isFile()) {
            InputStream inputStream = new FileInputStream(oldFile);
            OutputStream outputStream = new FileOutputStream(newFile);

            byte[] temp = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(temp)) > 0) {
                outputStream.write(temp, 0, len);
                //outputStream.flush();
            }

            inputStream.close();
            outputStream.close();
        }
    }

    /**
     * 读文件，对文件内容排序，输出另外文件1
     */
    @Test
    public void test2() throws Exception {
        File oldFile = new File("Pic" + File.separator + "test2old.txt");
        File newFile = new File("Pic" + File.separator + "test2new.txt");

        if (oldFile.exists() && oldFile.isFile()) {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(oldFile), "UTF-8");
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(newFile), "UTF-8");

            char[] temp = new char[8];
            StringBuilder sb = new StringBuilder();
            while (reader.read(temp) > 0) {
                sb.append(temp);
            }

            String oldStr = sb.toString();
            char[] newStr = oldStr.toCharArray();

            Arrays.sort(newStr);
            writer.write(newStr);

            reader.close();
            writer.close();
        }
    }

    /**
     * 读文件，对文件内容排序，输出另外文件2
     */
    @Test
    public void test3() throws Exception {
        File oldFile = new File("Pic" + File.separator + "test3old.txt");
        File newFile = new File("Pic" + File.separator + "test3new.txt");

        if (oldFile.exists() && oldFile.isFile()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(oldFile)));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile)));

            StringBuilder sb = new StringBuilder();
            String temp;
            while ((temp = reader.readLine()) != null) {
                sb.append(temp);
            }

            String oldStr = sb.toString();
            char[] newChar = oldStr.toCharArray();
            Arrays.sort(newChar);

            writer.write(newChar);
            writer.flush();

            reader.close();
            writer.close();
        }
    }
}
