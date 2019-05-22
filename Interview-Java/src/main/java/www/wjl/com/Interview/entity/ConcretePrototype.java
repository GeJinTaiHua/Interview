package www.wjl.com.Interview.entity;

/**
 * 原型模式
 *
 * @author xiaolong
 * @date 2019/5/22 14:20
 */
public class ConcretePrototype extends Prototype {

    private String filed;

    public ConcretePrototype(String filed) {
        this.filed = filed;
    }

    @Override
    Prototype myClone() {
        return new ConcretePrototype(filed);
    }

    @Override
    public String toString() {
        return filed;
    }
}
