package com.changsheng.love.controller;
import com.changsheng.love.model.SsopTSynArea;
import com.changsheng.love.model.SysMenu;
import com.changsheng.love.service.SsopTSynAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    private SsopTSynAreaService ssopTSynAreaService;
    @RequestMapping("/test")
    public String test(Model m) {
        //List<SsopTSynArea> list=ssopTSynAreaService.selectAll();
        List<SysMenu> list2=ssopTSynAreaService.selectMenuAll();
        //m.addAttribute("list",list);
        m.addAttribute("list2",list2);
        return "test";
    }
}