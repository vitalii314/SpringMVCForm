package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(value = "/greeting") also possible here instead of before method
public class GreetingController {
    @RequestMapping(value="/greeting", method= RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    // also possible to use Map instead of  Model:
//    @RequestMapping(method = RequestMethod.GET)
//    public String greetingForm(Map<String, Object> model) {
//        Greeting greeting = new Greeting();
//        model.put("greeting", greeting);  - key "greeting" to be used in view
//        return "greeting";
//    }

    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }

    // also possible
//    @RequestMapping(method = RequestMethod.POST)
//    public String processRegistration(@ModelAttribute("greeting") Greeting greeting,
//                                      Map<String, Object> model) {
//        because of @ModelAttribute("greeting")...
//        no need to write model.put("greeting", greeting);
//              (or model.addAttribute("greeting",greeting));
//
//
//
//        return "result";
//    }
}
