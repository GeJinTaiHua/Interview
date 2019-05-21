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
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void test() {
        int i = 0;
    }
}
