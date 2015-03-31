package com.concur.service.api;

import com.concur.service.model.Order;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

import static org.springframework.http.MediaType.*;

@Controller
@RequestMapping(value = "/store", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/store", description = "the store API")
public class StoreApi {


    @RequestMapping(value = "/inventory", method = RequestMethod.GET,
            produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
    @ApiOperation(value = "Returns pet inventories by status", notes = "Returns a map of status codes to quantities",
            response = Integer.class, responseContainer = "map")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation") })
    public ResponseEntity<Map<String, Integer>> getInventory()
            throws NotFoundException {
        // do some magic!
        return new ResponseEntity<Map<String, Integer>>(HttpStatus.OK);
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST,
            produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
    @ApiOperation(value = "Place an order for a pet", notes = "", response = Order.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 400, message = "Invalid Order") })
    public ResponseEntity<Order> placeOrder(@ApiParam(value = "order placed for purchasing the pet") Order body)
            throws NotFoundException {
        // do some magic!
        return new ResponseEntity<Order>(HttpStatus.OK);
    }


    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET,
            produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
    @ApiOperation(value = "Find purchase order by ID", notes = "For valid response try integer IDs with value <= 5 or"
            + " > 10. Other values will generated exceptions", response = Order.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Order not found"),
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 400, message = "Invalid ID supplied") })
    public ResponseEntity<Order> getOrderById(
            @ApiParam(value = "ID of pet that needs to be fetched", required = true)
            @PathVariable("orderId") String orderId)
            throws NotFoundException {
        // do some magic!
        return new ResponseEntity<Order>(HttpStatus.OK);
    }


    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.DELETE,
            produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
    @ApiOperation(value = "Delete purchase order by ID", notes = "For valid response try integer IDs with value < "
            + "1000. Anything above 1000 or nonintegers will generate API errors", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Order not found"),
            @ApiResponse(code = 400, message = "Invalid ID supplied") })
    public ResponseEntity<Void> deleteOrder(
            @ApiParam(value = "ID of the order that needs to be deleted", required = true)
            @PathVariable("orderId") String orderId)
            throws NotFoundException {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
