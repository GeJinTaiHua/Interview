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
}
