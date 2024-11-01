package HibernateWeb.Controller;

import HibernateWeb.Models.User;
import HibernateWeb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsersController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/")
	public String printUsersTable(Model model) {
		List<User> userList = userService.userList();
		model.addAttribute("users", userList);
		return "index";
	}

	@GetMapping(value = "/new")
	public String newUser(@ModelAttribute("user") User user) {
		return "new";
	}

	@PostMapping(value = "/new")
	public String createUser(@ModelAttribute("user") User user) {
		userService.add(user);
		return "redirect:/";
	}

	@GetMapping(value = "/update")
	public String updateUser(@RequestParam("id") long id, Model model) {
		model.addAttribute("user", userService.find(id));
		return "update";
	}

	@PostMapping(value = "/update")
	public String editUser(@ModelAttribute("user") User user) {
		userService.update(user);
		return "redirect:/";
	}

	@GetMapping(value = "/delete")
	public String deleteUser(@RequestParam("id") long id) {
		userService.remove(id);
		return "redirect:/";
	}
}