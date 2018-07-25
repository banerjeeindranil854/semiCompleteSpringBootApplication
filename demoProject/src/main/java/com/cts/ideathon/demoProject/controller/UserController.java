package com.cts.ideathon.demoProject.controller;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cts.ideathon.demoProject.bean.User;
import com.cts.ideathon.demoProject.exception.UserNotFoundException;
import com.cts.ideathon.demoProject.service.UserServices;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {
	@Autowired
	private UserServices userServices;
	@ApiOperation(value = "View a list of available users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/users",method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<User> retrieveAllUsers() {
		return userServices.findAllUser();
	}
	@ApiOperation(value = "Search a user with an ID")
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/users/{id}",method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
	public Resource<User> retrieveUser(@PathVariable long id) {
		Optional<User> user = userServices.findUser(id);
		if (!user.isPresent())
			throw new UserNotFoundException("id-" + id);
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-user"));
		return resource;
	}

	 @ApiOperation(value = "Delete a User")
	 @PreAuthorize("hasAnyRole('ADMIN')")
	 @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE,produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity deleteUser(@PathVariable long id) {
		 userServices.deleteUser(id);
		return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Add a User")
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/users",method = RequestMethod.POST,produces= {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = userServices.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	@ApiOperation(value = "Update a user")
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/users/{id}",method = RequestMethod.PUT,produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long id) {
		Optional<User> userOptional = userServices.findUser(id);
		if (!userOptional.isPresent())
			return ResponseEntity.notFound().build();
		User updateUser=userServices.updateUser(id,user);
		return new ResponseEntity("Product updated successfully", HttpStatus.OK);
	}
}
