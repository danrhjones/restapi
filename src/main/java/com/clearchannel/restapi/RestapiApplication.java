package com.clearchannel.restapi;

import com.clearchannel.restapi.model.Campaign;
import com.clearchannel.restapi.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestapiApplication implements CommandLineRunner {

	private CampaignRepository campaignRepository;

	@Autowired
	public void campaignRepository(CampaignRepository campaignRepository) {
		this.campaignRepository = campaignRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		Campaign testCampaign = new Campaign();
		testCampaign.setCampaignName("Clear Channel");
		testCampaign.setClient("Baloon Emporium");
		testCampaign.setStartDate("01/01/2019");
		testCampaign.setEndDate("02/02/2019");
		testCampaign.setStatus("APPROVED");

		campaignRepository.save(testCampaign);

	}
}
