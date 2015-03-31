package com.concur.service.api;

import com.concur.service.model.User;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.http.MediaType.*;

@Controller
@RequestMapping(value = "/user", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/user", description = "the user API")
public class UserApi {


    @ApiOperation(value = "Create user", notes = "This can only be done by the logged in user.", response = Void.class)
    @ApiResponses(value = { @ApiResponse(code = 0, message = "successful operation") })
    @RequestMapping(produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
    public ResponseEntity<Void> createUser(@ApiParam(value = "Created user object") User body)
            throws NotFoundException {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @RequestMapping(value = "/createWithArray", method = RequestMethod.POST,
            produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
    @ApiOperation(value = "Creates list of users with given input array", notes = "", response = Void.class)
    @ApiResponses(value = { @ApiResponse(code = 0, message = "successful operation") })

    public ResponseEntity<Void> createUsersWithArrayInput(@ApiParam(value = "List of user object") List<User> body)
            throws NotFoundException {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @RequestMapping(value = "/createWithList", method = RequestMethod.POST,
            produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
    @ApiOperation(value = "Creates list of users with given input array", notes = "", response = Void.class)
    @ApiResponses(value = { @ApiResponse(code = 0, message = "successful operation") })
    public ResponseEntity<Void> createUsersWithListInput(@ApiParam(value = "List of user object") List<User> body)
            throws NotFoundException {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET,
            produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
    @ApiOperation(value = "Logs user into the system", notes = "", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 400, message = "Invalid username/password supplied") })
    public ResponseEntity<String> loginUser(
            @ApiParam(value = "The user name for login")
            @RequestParam("username") String username,
            @ApiParam(value = "The password for login in clear text")
            @RequestParam("password") String password)
            throws NotFoundException {
        // do some magic!
        return new ResponseEntity<String>(HttpStatus.OK);
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET,
            produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
    @ApiOperation(value = "Logs out current logged in user session", notes = "", response = Void.class)
    @ApiResponses(value = { @ApiResponse(code = 0, message = "successful operation") })
    public ResponseEntity<Void> logoutUser()
            throws NotFoundException {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @RequestMapping(value = "/{username}", method = RequestMethod.GET,
            produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
    @ApiOperation(value = "Get user by user name", notes = "", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 400, message = "Invalid username supplied") })
    public ResponseEntity<User> getUserByName(
            @ApiParam(value = "The name that needs to be fetched. Use user1 for testing.", required = true)
            @PathVariable("username") String username)
            throws NotFoundException {
        // do some magic!
        return new ResponseEntity<User>(HttpStatus.OK);
    }


    @RequestMapping(value = "/{username}", method = RequestMethod.PUT,
            produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
    @ApiOperation(value = "Updated user", notes = "This can only be done by the logged in user.", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 400, message = "Invalid user supplied") })
    public ResponseEntity<Void> updateUser(
            @ApiParam(value = "name that need to be deleted", required = true)
            @PathVariable("username") String username,
            @ApiParam(value = "Updated user object") @RequestBody User body)
            throws NotFoundException {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE,
            produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
    @ApiOperation(value = "Delete user", notes = "This can only be done by the logged in user.", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 400, message = "Invalid username supplied") })
    public ResponseEntity<Void> deleteUser(
            @ApiParam(value = "The name that needs to be deleted", required = true)
            @PathVariable("username") String username)
            throws NotFoundException {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
