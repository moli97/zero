package top.imoli.zero.model.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.imoli.zero.model.demo.entity.CCServer;

import java.util.List;


public interface ICCService extends IService<CCServer> {

	List<CCServer> findAll();

}
