package www.wjl.com.Interview.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author xiaolong
 * @date 2019/5/21 13:56
 */
public class DemoService {
    @Transactional(rollbackFor = Exception.class)
    public void test() {
        int i = 0;
    }
}
