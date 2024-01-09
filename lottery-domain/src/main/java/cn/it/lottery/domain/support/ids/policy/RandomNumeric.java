package cn.it.lottery.domain.support.ids.policy;

import cn.it.lottery.domain.support.ids.IIdGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @author vickyaa
 * @date 1/4/24
 * @file RandomNumeric
 */

@Component
public class RandomNumeric implements IIdGenerator {
    @Override
    public long nextId() {
        return Long.parseLong(RandomStringUtils.randomNumeric(11));
    }
}
