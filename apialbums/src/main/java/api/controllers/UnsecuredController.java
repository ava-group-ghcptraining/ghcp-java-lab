package AlbumAPI.Controllers;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/unsecured")
public class UnsecuredController {
//Identify vulnerabilities and suggest fixes

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the unsecured endpoint!";
    }

    @PostMapping("/echo")
    public String echo(@RequestBody String message) {
        return "Echo: " + message;
    }
}
