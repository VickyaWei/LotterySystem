package cn.it.lottery.interfaces.assembler;

import org.mapstruct.*;
import org.mapstruct.MapperConfig;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author vickyaa
 * @date 1/9/24
 * @file IMapping
 */

@MapperConfig
public interface IMapping<SOURCE, TARGET> {

    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    TARGET sourceToTarget(SOURCE var1);

    @InheritInverseConfiguration(name = "sourceToTarget")
    SOURCE targetToSource(TARGET var1);

    @InheritConfiguration(name = "sourceToTarget")
    List<TARGET> sourceToTarget(List<SOURCE> var1);

    @InheritConfiguration(name = "targetToSource")
    List<SOURCE> targetToSource(List<TARGET> var1);

    List<TARGET> sourceToTarget(Stream<SOURCE> stream);

    List<SOURCE> targetToSource(Stream<TARGET> stream);
}
