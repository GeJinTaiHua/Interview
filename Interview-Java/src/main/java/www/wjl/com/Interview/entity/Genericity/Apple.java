package www.wjl.com.Interview.entity.Genericity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 苹果
 *
 * @date 2018/8/31 0031
 */
@Data
public class Apple extends Fruit {
    private BigDecimal weight;

    private String name;

    public Apple(String name) {
        super(name);
    }
}
