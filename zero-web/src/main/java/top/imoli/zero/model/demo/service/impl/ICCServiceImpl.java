package top.imoli.zero.model.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.imoli.zero.model.demo.entity.CCServer;
import top.imoli.zero.model.demo.mapper.CCServerMapper;
import top.imoli.zero.model.demo.service.ICCService;

import java.util.List;

@Service
@DS("jdbc-zero")
public class ICCServiceImpl extends ServiceImpl<CCServerMapper, CCServer> implements ICCService {

    @Override
    public List<CCServer> findAll() {
        return baseMapper.getCCServerList();
    }
}
