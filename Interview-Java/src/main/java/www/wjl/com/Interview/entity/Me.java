package www.wjl.com.Interview.entity;

/**
 * 依赖
 *
 * @author xiaolong
 * @date 2019/5/22 14:24
 */
public class Me {
    // pen作为Me类方法的参数
    public void write(Pen pen) {
        pen.write();
    }
}
