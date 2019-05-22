package www.wjl.com.Interview.entity;

/**
 * 组合
 *
 * @author xiaolong
 * @date 2019/5/22 14:28
 */
public class Nose {
    // 一个人有鼻子有眼睛
    private Nose nose = new Nose();
    private Me me = new Me();
}
