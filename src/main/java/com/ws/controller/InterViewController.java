package com.ws.controller;

import com.ws.bean.Interview;
import com.ws.service.InterViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class InterViewController {

    @Autowired
    private InterViewService interViewService;

    // 分页查询问题
    @RequestMapping("queryInterView")
    @ResponseBody
    public HashMap<String,Object> queryInterView(int page, int rows, Interview interview){
        return interViewService.queryInterView(page,rows,interview);
    }
    // 查询置顶问题根据点击量倒叙
    @RequestMapping("queryInterView2")
    @ResponseBody
    public List<Interview> queryInterView2(Interview interview){
        return interViewService.queryInterView2(interview);
    }

    // 查询置顶问题根据时间倒叙
    @RequestMapping("queryInterView3")
    @ResponseBody
    public List<Interview> queryInterView3(Interview interview){
        List<Interview> list = interViewService.queryInterView3(interview);
        return list;
    }

    //进入openfile.html 存入session
    @RequestMapping("addSessionOpenfile")
    @ResponseBody
    public void addSessionOpenfile(HttpSession session,Integer wid){
        Integer id = (Integer)session.getAttribute("wid");
        if(id!=null){
            session.removeAttribute("wid");
            session.setAttribute("wid",wid);
        }else{
            session.setAttribute("wid",wid);
            interViewService.updatepvpv(wid);
        }
    }

    //进入openmulu.html 存入session
    @RequestMapping("addSessionOpenmulu")
    @ResponseBody
    public void addSessionOpenmulu(HttpSession session,Integer mid){
        Integer id = (Integer)session.getAttribute("mid");
        if(id!=null){
            session.removeAttribute("mid");
            session.setAttribute("mid",mid);
        }else{
            session.setAttribute("mid",mid);
        }
    }
    //查询打开详细数据
    @RequestMapping("addSessionOpenfile2")
    @ResponseBody
    public Interview addSessionOpenfile2(HttpSession session){
        Integer id = (Integer)session.getAttribute("wid");
        return interViewService.queryInterViewOpen(id);
    }

    //查询打开详细数据查询答案
    @RequestMapping("addSessionOpenfile3")
    @ResponseBody
    public Interview addSessionOpenfile3(HttpSession session){
        Integer id = (Integer)session.getAttribute("wid");
        return interViewService.queryInterViewOpen2(id);
    }
}
