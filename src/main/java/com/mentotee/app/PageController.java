package com.mentotee.app;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mentotee.app.service.AccountsService;
import com.mentotee.app.service.MagazineService;
import com.mentotee.app.vo.AccountsVO;
import com.mentotee.app.vo.MagazineVO;

@Controller
public class PageController {
	@Autowired
	AccountsService accounts_service;

	@Autowired
	MagazineService magazine_service;

	@RequestMapping(value = "/", method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String home1(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/admin", method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String admin(Locale locale, Model model) {
		return "admin_login";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(Locale locale, Model model) {
		return "insert";
	}

	@RequestMapping(value = "/board/insert", method = RequestMethod.POST)
	public String insert(Locale locale, Model model, HttpServletRequest request) {
		String a_num = request.getParameter("num");
		String title = request.getParameter("title");
		String contents = request.getParameter("ir1");

		int n = magazine_service.insert(new MagazineVO(0, Integer.parseInt(a_num), title, contents, false, null));

		return "redirect:/web/login";
	}

	@RequestMapping(value = "/web/login", method = RequestMethod.GET)
	public String Main(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("id") != null) {
			return "main";
		} else {
			return "home";
		}

	}

	@RequestMapping(value = "/web/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();

		if (session.getAttribute("id") != null) {
			return "main";
		}

		String id = request.getParameter("email");
		String pwd = request.getParameter("password");
		AccountsVO vo = new AccountsVO();
		boolean state = false;

		if (id.equals("admin")) {

			// model.addAttribute("mvo", arg1);
			return "redirect:/admin/profit/list";
		} else {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("id", id);
			map.put("pwd", pwd);

			vo = this.accounts_service.getInfo(id);
			if (vo != null) {
				BCryptPasswordEncoder bcr = new BCryptPasswordEncoder();
				boolean res = bcr.matches(pwd, vo.getPassword());
				if (vo.getState() == 1) {
					request.setAttribute("errMsg", "아이디와 비밀번호가 일치하지 않습니다.");
				} else if (res) {
					vo = accounts_service.getInfo(id);
					session.setAttribute("num", vo.getAccounts_num());
					session.setAttribute("id", id);
					state = true;
				} else {
					request.setAttribute("errMsg", "아이디와 비밀번호가 일치하지 않습니다.");
				}
			} else {
				request.setAttribute("errMsg", "아이디와 비밀번호가 일치하지 않습니다.");
			}

			if (state) {
				return "main";
			} else {
				return "home";
			}

		}
	}
	
	@RequestMapping(value = "/web/admin/login", method = RequestMethod.POST)
	public String admin_login(HttpServletRequest request, Model model) {
		List<MagazineVO> list = magazine_service.getList();
		model.addAttribute("mlist", list);
		return "admin";
	}
}
