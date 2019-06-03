package www.wjl.com.Interview.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring 事务
 *
 * @author xiaolong
 * @date 2019/5/21 13:56
 */
public class TransactionalService {
    /**
     * 七种事务传播行为：
     * REQUIRED：如果当前无事务则开启一个事务，否则加入当前事务。（默认）
     * REQUIRES_NEW：如果当前无事务则开启一个事务，否则挂起当前事务并开启新事务。（一直new）
     * SUPPORTS：如果当前有事务则加入当前事务。（随遇而安）
     * NOT_SUPPORTED：如果当前有事务，则挂起当前事务以无事务状态执行方法。（一直无事务）
     * MANDATORY：如果当前无事务则抛出异常，否则加入当前事务。（无事务=异常）
     * NEVER：如果当前有事务，则抛出异常。（有事务=异常）
     * NESTED：创建一个嵌套事务，如果当前无事务则创建一个事务。
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void sevenPropagation() {
    }

    /**
     * 四种事务隔离级别：
     * DEFAULT：默认
     * READ_UNCOMMITTED：读未提交，发生脏读、不可重复读和幻像读。
     * READ_COMMITTED：读已提交，发生不可重复读和幻像读。
     * REPEATABLE_READ：可重复读，发生幻像读。
     * SERIALIZABLE：串行化
     */
    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public void fourIsolationLevel() {
    }
}
