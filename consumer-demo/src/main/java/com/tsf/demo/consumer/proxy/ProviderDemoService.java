package com.tsf.demo.consumer.proxy;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.tsf.core.TsfContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "provider-demo")
public interface ProviderDemoService {
	@RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
	String echo(@PathVariable("str") String str);
}