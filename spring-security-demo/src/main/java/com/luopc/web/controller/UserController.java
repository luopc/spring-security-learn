package com.luopc.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.luopc.web.model.User;
import com.luopc.web.query.UserQuery;
import com.luopc.web.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping
	@JsonView(User.UserSimpleView.class)
	public List<User> query(UserQuery query, @PageableDefault Pageable pageable) {
		System.out.println("userName:" + query.getUserName());
		System.out.println(pageable.getPageSize());
		System.out.println(pageable.getPageNumber());
		System.out.println(pageable.getSort());
		List<User> uList = new ArrayList<>();
		uList.add(new User("1", "zhang"));
		uList.add(new User("2", "li"));
		uList.add(new User("3", "wang"));
		// uList.add(new User("4","wang"));
		return uList;
	}

	@GetMapping(value = "/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public User getInfo(@PathVariable String id) {
		User u = new User("1", "TOM");
		System.out.println(" run getInfo ");
		return u;
	}

	@PostMapping
	public User create(@Valid @RequestBody User user) {
		System.out.println(user);
		user.setUserId("1");
		return user;		
	}
	
	@PutMapping("/{id}")
	public User update(@Valid @RequestBody User user ,BindingResult result) {
		if(result.hasErrors()) {
			result.getAllErrors().stream().forEach(rs -> {
				FieldError ferror =  (FieldError) rs;
				String message =  ferror.getField() + " " + rs.getDefaultMessage();
				System.out.println(message);
			});
		}
		
//		User user = userService.findUserByUserId(id);
//		System.out.println(user);
		return user;	
	}
	
	
	@DeleteMapping("/{userId}")
	public void delete(@PathVariable String userId) {
		System.out.println(userId);
	}
	
}
