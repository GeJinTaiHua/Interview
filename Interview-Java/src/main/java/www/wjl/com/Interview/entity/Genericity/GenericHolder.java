package www.wjl.com.Interview.entity.Genericity;

public class GenericHolder<T> {
    private T obj;

    public GenericHolder() {
    }

    public GenericHolder(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
