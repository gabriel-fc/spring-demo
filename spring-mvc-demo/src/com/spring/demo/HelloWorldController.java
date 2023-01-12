package src.com.spring.demo;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

@Controller
public class HelloWorldController{

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormV2")
    public String lestShout(HttpServletRequest request, Model model){
        String name = request.getParameter("studentName");
        name = name.toUpperCase();
        model.addAttribute("message", "Yo " + name);
        return "helloworld";
    }
}
