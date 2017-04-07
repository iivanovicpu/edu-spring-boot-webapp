package hr.edupsy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.edupsy.dao.AdaptiveRuleRepository;

@Controller
public class WelcomeController {

    @Autowired
    private AdaptiveRuleRepository adaptiveRuleRepository;

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        model.put("adaptiverules", adaptiveRuleRepository.findAll());
        return "welcome";
    }

    @RequestMapping("/hello")
    public String hello(Model model) {
        DeveloperResource[] devResources = {
                new DeveloperResource("Google",
                        "http://www.google.com"),
                new DeveloperResource("Stackoverflow",
                        "http://www.stackoverflow.com"),
                new DeveloperResource("W3Schools",
                        "http://www.w3schools.com")
        };
        model.addAttribute("resources", devResources);
        return "hello";    }

    public static final class DeveloperResource {
        private final String name;
        private final String url;

        public DeveloperResource(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }
}