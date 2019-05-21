package www.wjl.com.Interview.service;

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
     * 七种事务传播行为
     * <p>
     * REQUIRED：如果当前无事务则开启一个事务，否则加入当前事务。
     * REQUIRES_NEW：如果当前无事务则开启一个事务，否则挂起当前事务并开启新事务。
     * SUPPORTS：如果当前有事务则加入当前事务。
     * NOT_SUPPORTED：如果当前有事务，则挂起当前事务以无事务状态执行方法。
     * MANDATORY：如果当前无事务则抛出异常，否则加入当前事务。
     * NEVER：如果当前有事务，则抛出异常。
     * NESTED：创建一个嵌套事务，如果当前无事务则创建一个事务。
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void sevenTrans() {
        int i = 0;
    }
}
