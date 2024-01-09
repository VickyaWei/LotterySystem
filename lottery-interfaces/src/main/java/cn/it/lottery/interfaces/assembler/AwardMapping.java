package cn.it.lottery.interfaces.assembler;

import cn.it.lottery.domain.strategy.model.vo.DrawAwardVO;
import cn.it.lottery.rpc.dto.AwardDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


/**
 * @author vickyaa
 * @date 1/9/24
 * @file AwardMapping
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AwardMapping extends IMapping<DrawAwardVO, AwardDTO> {

    @Mapping(target = "userId", source = "awardId")
    @Override
    AwardDTO sourceToTarget(DrawAwardVO var1);

    @Override
    DrawAwardVO targetToSource(AwardDTO var1);

}