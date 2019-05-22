package www.wjl.com.Interview.entity;

import lombok.Data;

/**
 * 关联
 *
 * @author xiaolong
 * @date 2019/5/22 14:25
 */
@Data
public class You {
    // 让pen成为you的类属性
    private Pen pen;

    public You(Pen p) {
        this.pen = p;
    }

    public void write() {
        pen.write();
    }
}
