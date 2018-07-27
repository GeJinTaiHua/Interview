package Pattern.Singleton;

import www.wjl.com.Interview.entity.SingleE;

/*
 * @desc 枚举单例
 *  SingletonEnum.instance.getInstance()
 * @author wjl
 * @date 2018/7/27 0027
 */
public enum SingletonEnum {
    instance;
    private SingleE ins;

    private SingletonEnum() {
        ins = new SingleE();
    }

    public SingleE getInstance() {
        return ins;
    }
}
