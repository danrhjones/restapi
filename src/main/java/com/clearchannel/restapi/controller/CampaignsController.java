package com.clearchannel.restapi.controller;

import com.clearchannel.restapi.model.Campaign;
import com.clearchannel.restapi.service.CampaignsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/campaigns/")
@Api(value = "CampaignsControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class CampaignsController {

    private CampaignsService campaignsService;

    private Logger LOG = LoggerFactory.getLogger(CampaignsController.class);

    @Autowired
    public void setCampaignsService(CampaignsService campaignsService) {
        this.campaignsService = campaignsService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    @ApiOperation("Gets all of the campaigns")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Campaign.class)})
    public List<Campaign> getAllCampaigns() {
        return campaignsService.getCampaigns();
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    @ApiOperation("Gets the campaign with specific id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Campaign.class)})
    public Campaign getCampaign(@PathVariable(name = "id") String id) {
        return campaignsService.getCampaign(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ApiOperation("Creates a new campaign")
    @ApiResponses(value = {@ApiResponse(code = 409, message = "OK", response = Campaign.class)})
    public Campaign saveCampaign(@RequestBody Campaign campaignToSave) {
        return campaignsService.saveCampaign(campaignToSave);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Updates a specific campaign")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public Campaign updateCampaign(@RequestBody Campaign campaignToUpdate, @PathVariable(name = "id") String id) {
        return campaignsService.updateCampaign(campaignToUpdate, id);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    @ApiOperation("Deletes a specific campaign")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public void deleteCampaign(@PathVariable(name = "id") String id) {
        campaignsService.deleteCampaign(id);
    }
}
