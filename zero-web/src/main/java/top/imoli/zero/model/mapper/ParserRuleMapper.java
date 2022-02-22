package top.imoli.zero.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.imoli.zero.model.entity.ParserRuleDemo;

import java.util.List;

@Mapper
public interface ParserRuleMapper extends BaseMapper<ParserRuleDemo> {

    @Select("select * from t_parser_rule")
    List<ParserRuleDemo> getAllParserRule();


}
