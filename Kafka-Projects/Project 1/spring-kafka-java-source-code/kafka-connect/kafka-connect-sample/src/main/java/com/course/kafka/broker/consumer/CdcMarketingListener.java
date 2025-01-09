package com.course.kafka.broker.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.course.kafka.broker.message.CdcMessage;
import com.course.kafka.broker.message.MarketingPromotionMessage;
import com.course.kafka.broker.message.MarketingSalesMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CdcMarketingListener {

	private static final Logger LOG = LoggerFactory.getLogger(CdcMarketingListener.class);

	@Autowired
	private ObjectMapper objectMapper;

	@KafkaListener(topics = "t-cdc-marketing.public.mkt_promotions")
	public void listenPromotion(String message) throws JsonMappingException, JsonProcessingException {
		var promotion = objectMapper.readValue(message, new TypeReference<CdcMessage<MarketingPromotionMessage>>() {
		});

		LOG.info("Marketing promotion message received : {}", promotion);
	}

	@KafkaListener(topics = "t-cdc-marketing.public.mkt_sales")
	public void listenSales(String message) throws JsonMappingException, JsonProcessingException {
		var sales = objectMapper.readValue(message, new TypeReference<CdcMessage<MarketingSalesMessage>>() {
		});

		LOG.info("Marketing sales message received : {}", sales);
	}

}
