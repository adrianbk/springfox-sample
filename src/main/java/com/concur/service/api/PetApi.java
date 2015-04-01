package com.concur.service.api;

import com.concur.service.model.*;

import com.concur.service.model.Pet;
import java.io.File;

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
@RequestMapping("/pet",produces = {APPLICATION_JSON_VALUE})
@Api(value = "/pet", description = "the pet API")
public class PetApi {
  

  @ApiOperation(value = "Update an existing pet", notes = "", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 405, message = "Validation exception"),
    @ApiResponse(code = 404, message = "Pet not found"),
    @ApiResponse(code = 400, message = "Invalid ID supplied") })
  @RequestMapping(value = "", produces = { "application/json", "application/xml" }, consumes = { "application/json", "application/xml" }, method =
    RequestMethod.PUT)
  public Response updatePet(@ApiParam(value = "Pet object that needs to be added to the store"  ) Pet body)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  

  @ApiOperation(value = "Add a new pet to the store", notes = "", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 405, message = "Invalid input") })
  @RequestMapping(value = "", produces = { "application/json", "application/xml" }, consumes = { "application/json", "application/xml" }, method =
    RequestMethod.POST)
  public Response addPet(@ApiParam(value = "Pet object that needs to be added to the store"  ) Pet body)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  

  @ApiOperation(value = "Finds Pets by status", notes = "Multiple status values can be provided with comma seperated strings", response = Pet.class, responseContainer = "List")
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid status value") })
  @RequestMapping(value = "/findByStatus", produces = { "application/json", "application/xml" }, , method =
    RequestMethod.GET)
  public Response findPetsByStatus(@ApiParam(value = "Status values that need to be considered for filter") @QueryParam("status") List<String> status)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  

  @ApiOperation(value = "Finds Pets by tags", notes = "Muliple tags can be provided with comma seperated strings. Use tag1, tag2, tag3 for testing.", response = Pet.class, responseContainer = "List")
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid tag value") })
  @RequestMapping(value = "/findByTags", produces = { "application/json", "application/xml" }, , method =
    RequestMethod.GET)
  public Response findPetsByTags(@ApiParam(value = "Tags to filter by") @QueryParam("tags") List<String> tags)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  

  @ApiOperation(value = "Find pet by ID", notes = "Returns a pet when ID < 10.  ID > 10 or nonintegers will simulate API error conditions", response = Pet.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 404, message = "Pet not found"),
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid ID supplied") })
  @RequestMapping(value = "/{petId}", produces = { "application/json", "application/xml" }, , method =
    RequestMethod.GET)
  public Response getPetById(@ApiParam(value = "ID of pet that needs to be fetched",required=true ) @PathParam("petId") Long petId)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  

  @ApiOperation(value = "Updates a pet in the store with form data", notes = "", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 405, message = "Invalid input") })
  @RequestMapping(value = "/{petId}", produces = { "application/json", "application/xml" }, consumes = { "application/x-www-form-urlencoded" }, method =
    RequestMethod.POST)
  public Response updatePetWithForm(@ApiParam(value = "ID of pet that needs to be updated",required=true ) @PathParam("petId") String petId,
    @ApiParam(value = "Updated name of the pet" )@FormParam("name")  String name,
    @ApiParam(value = "Updated status of the pet" )@FormParam("status")  String status)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  

  @ApiOperation(value = "Deletes a pet", notes = "", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 400, message = "Invalid pet value") })
  @RequestMapping(value = "/{petId}", produces = { "application/json", "application/xml" }, , method =
    RequestMethod.DELETE)
  public Response deletePet(@ApiParam(value = ""  )@HeaderParam("apiKey") String apiKey,
    @ApiParam(value = "Pet id to delete",required=true ) @PathParam("petId") Long petId)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  

  @ApiOperation(value = "uploads an image", notes = "", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 0, message = "successful operation") })
  @RequestMapping(value = "/{petId}/uploadImage", produces = { "application/json", "application/xml" }, consumes = { "multipart/form-data" }, method =
    RequestMethod.POST)
  public Response uploadFile(@ApiParam(value = "ID of pet to update",required=true ) @PathParam("petId") Long petId,
    @ApiParam(value = "Additional data to pass to server" )@FormParam("additionalMetadata")  String additionalMetadata,
    @ApiParam(value = "file to upload") @FormDataParam("file") InputStream inputStream,
    @ApiParam(value = "file detail") @FormDataParam("file") FormDataContentDisposition fileDetail)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  
}
