package top.imoli.zero.model.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.imoli.zero.model.demo.entity.CCServer;
import top.imoli.zero.model.demo.entity.Phone;
import top.imoli.zero.model.demo.mapper.PhoneMapper;
import top.imoli.zero.model.demo.service.ICCService;

import java.util.List;


/**
 * @author paida 派哒 zeyu.pzy@alibaba-inc.com
 */
@Controller
public class GreetingController {

    @Autowired
    private ICCService iccService;
    @Autowired
    private PhoneMapper phoneMapper;

    @ResponseBody
    @GetMapping("/hello")
    public Object greeting(@RequestParam(name = "name", required = false, defaultValue = "1") String name) {
        List<CCServer> all = iccService.findAll();
        System.out.println(all);
        List<Phone> ccServerList = phoneMapper.getCCServerList();
        System.out.println(ccServerList);
        return all;
    }
}
