package com.clearchannel.restapi.service;

import com.clearchannel.restapi.model.Campaign;
import com.clearchannel.restapi.repository.CampaignRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignsService {

    private Logger LOG = LoggerFactory.getLogger(CampaignsService.class);

    private CampaignRepository campaignRepository;

    @Autowired
    public void setCampaignRepository(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public List<Campaign> getCampaigns() {
        LOG.info("getting all campaigns");
        return campaignRepository.findAll();
    }

    public Campaign getCampaign(String id) {
        LOG.info("Getting the campaign with given id:" + id);
        return campaignRepository.findOne(id);
    }

    public Campaign saveCampaign(Campaign campaign) {
        Campaign campaignToSave;
        try {
            LOG.info("Saving campaign...");
            campaignToSave = campaignRepository.save(campaign);
            return campaignToSave;
        } catch (Exception e) {
            LOG.error("An error occurred during campaign saving:" + e.getMessage());
        }
        return new Campaign();
    }

    public Campaign updateCampaign(Campaign campaignToUpdate, String id) {
        Campaign foundCampaign = campaignRepository.findOne(id);
        try {
            foundCampaign.setCampaignName(campaignToUpdate.getCampaignName());
            foundCampaign.setClient(campaignToUpdate.getClient());
            foundCampaign.setStartDate(campaignToUpdate.getStartDate());
            foundCampaign.setEndDate(campaignToUpdate.getEndDate());
            foundCampaign.setStatus(campaignToUpdate.getStatus());
            return campaignRepository.save(foundCampaign);
        } catch (Exception e) {
            LOG.error("An error occurred during update of campaign" + e.getMessage());
        }
        return campaignToUpdate;
    }

    public void deleteCampaign(String id) {
        try {
            campaignRepository.delete(id);
        } catch (Exception e) {
            LOG.error("An error occurred during deleting of campaign:" + e.getMessage());
        }
    }


}
