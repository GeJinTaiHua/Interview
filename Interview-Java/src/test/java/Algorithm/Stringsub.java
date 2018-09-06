package Algorithm;

/*
 * @desc 获取一个字符串在另一个字符串中出现的次数
 * @author wjl
 * @date 2018/9/6 0006
 */
public class Stringsub {
    public static void main(String[] args) {
        String str = "hgdfjdssgjdhgfusdkkhdsgfkkshfkkbjsdhh";
        String substr = "kk";
        int count = sub(str, substr);
        System.out.println("Hello World!");
    }

    /*
     * @desc 获取一个字符串substr在另一个字符串str中出现的次数
     * @author wjl
     * @date 2018/9/6 0006
     */
    public static int sub(String str, String substr) {
        int index = 0;
        int count = 0;
        int fromindex = 0;
        while ((index = str.indexOf(substr, fromindex)) != -1) {
            //str=str.substring(index+substr.length());
            fromindex = index + substr.length();
            count++;
        }
        return count;
    }

    /*
     * @desc 计算字符串str2在字符串str1中出现的次数
     * @author wjl
     * @date 2018/9/6 0006
     */
    public static int sub2(String str1, String str2) {
        int count = 0;
        int j = 0;
        int temp = 0;

        if (str1.contains(str2)) {
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) == str2.charAt(j) && j < str2.length()) {
                    temp++;
                    j++;

                    // 存在一个
                    if (temp == str2.length()) {
                        count++;
                        temp = 0;
                        j = 0;
                    }
                } else {
                    temp = 0;
                    j = 0;
                }
            }
        } else {
            return 0;
        }

        return count;
    }
}
