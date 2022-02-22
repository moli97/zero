package top.imoli.zero.model.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.imoli.zero.model.demo.entity.CCServer;

import java.util.List;

@Mapper
@DS("jdbc-zero")
public interface CCServerMapper extends BaseMapper<CCServer> {

    @Select("select * from t_central_control_server")
    List<CCServer> getCCServerList();

    @Delete("delete from t_central_control_server where url = #{url}")
    int deleteCCServer(String url);

    @Insert("insert ignore into t_central_control_server(`url`) values(#{url})")
    int addCCServer(String url);
}
