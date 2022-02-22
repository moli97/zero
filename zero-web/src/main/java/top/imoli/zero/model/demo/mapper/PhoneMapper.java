package top.imoli.zero.model.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.imoli.zero.model.demo.entity.Phone;

import java.util.List;

@Mapper
public interface PhoneMapper {

    @Select("select * from t_phone")
    List<Phone> getCCServerList();

}
