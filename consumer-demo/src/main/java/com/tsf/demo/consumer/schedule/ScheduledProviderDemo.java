package com.tsf.demo.consumer.schedule;

import com.tsf.demo.consumer.proxy.ProviderDemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.tsf.core.TsfContext;

@Service
public class ScheduledProviderDemo {
	private static final Logger LOG = LoggerFactory.getLogger(ScheduledProviderDemo.class);

	@Autowired
	private ProviderDemoService providerDemoService;

	@Scheduled(fixedDelayString = "${consumer.auto.test.interval:1000}")
	public void doWork() throws InterruptedException {
		TsfContext.putTag("test", "123");
		String response = providerDemoService.echo("auto-test");
		LOG.info("consumer-demo auto test, response: [" + response + "]");
	}
}