package com.concur.service.api;

import com.concur.service.model.*;

import com.concur.service.model.User;
import java.util.*;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.http.MediaType.*;

@Controller
@RequestMapping("/user",produces = {APPLICATION_JSON_VALUE})
@Api(value = "/user", description = "the user API")
public class UserApi {
  

  @ApiOperation(value = "Create user", notes = "This can only be done by the logged in user.", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 0, message = "successful operation") })
  @RequestMapping(value = "", produces = { "application/json", "application/xml" }, , method =
    RequestMethod.POST)
  public Response createUser(@ApiParam(value = "Created user object"  ) User body)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  

  @ApiOperation(value = "Creates list of users with given input array", notes = "", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 0, message = "successful operation") })
  @RequestMapping(value = "/createWithArray", produces = { "application/json", "application/xml" }, , method =
    RequestMethod.POST)
  public Response createUsersWithArrayInput(@ApiParam(value = "List of user object"  ) List<User> body)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  

  @ApiOperation(value = "Creates list of users with given input array", notes = "", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 0, message = "successful operation") })
  @RequestMapping(value = "/createWithList", produces = { "application/json", "application/xml" }, , method =
    RequestMethod.POST)
  public Response createUsersWithListInput(@ApiParam(value = "List of user object"  ) List<User> body)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  

  @ApiOperation(value = "Logs user into the system", notes = "", response = String.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid username/password supplied") })
  @RequestMapping(value = "/login", produces = { "application/json", "application/xml" }, , method =
    RequestMethod.GET)
  public Response loginUser(@ApiParam(value = "The user name for login") @QueryParam("username") String username,
    @ApiParam(value = "The password for login in clear text") @QueryParam("password") String password)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  

  @ApiOperation(value = "Logs out current logged in user session", notes = "", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 0, message = "successful operation") })
  @RequestMapping(value = "/logout", produces = { "application/json", "application/xml" }, , method =
    RequestMethod.GET)
  public Response logoutUser()
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  

  @ApiOperation(value = "Get user by user name", notes = "", response = User.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 404, message = "User not found"),
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid username supplied") })
  @RequestMapping(value = "/{username}", produces = { "application/json", "application/xml" }, , method =
    RequestMethod.GET)
  public Response getUserByName(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ",required=true ) @PathParam("username") String username)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  

  @ApiOperation(value = "Updated user", notes = "This can only be done by the logged in user.", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 404, message = "User not found"),
    @ApiResponse(code = 400, message = "Invalid user supplied") })
  @RequestMapping(value = "/{username}", produces = { "application/json", "application/xml" }, , method =
    RequestMethod.PUT)
  public Response updateUser(@ApiParam(value = "name that need to be deleted",required=true ) @PathParam("username") String username,
    @ApiParam(value = "Updated user object"  ) User body)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  

  @ApiOperation(value = "Delete user", notes = "This can only be done by the logged in user.", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 404, message = "User not found"),
    @ApiResponse(code = 400, message = "Invalid username supplied") })
  @RequestMapping(value = "/{username}", produces = { "application/json", "application/xml" }, , method =
    RequestMethod.DELETE)
  public Response deleteUser(@ApiParam(value = "The name that needs to be deleted",required=true ) @PathParam("username") String username)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  
}
