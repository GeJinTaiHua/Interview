package IO;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

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

        if (oldFile.isFile() && oldFile.exists()) {
            InputStream inputStream = new FileInputStream(oldFile);
            OutputStream outputStream = new FileOutputStream(newFile);

            byte[] temp = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(temp)) > 0) {
                outputStream.write(temp);
            }

            inputStream.close();
            outputStream.close();
        }
    }

    @Test
    public void test12() throws Exception {

    }
}
