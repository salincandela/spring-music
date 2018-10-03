package org.cloudfoundry.samples.music.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Profile("cloud")
@Component
public class CloudServicesInfo implements ServicesInfo {

    private final Cloud cloud;

    @Autowired
    public CloudServicesInfo(Cloud cloud) {
        this.cloud = cloud;
    }

    @Override
    public Collection<ServiceInfo> getServices() {
        return cloud.getServiceInfos();
    }

    @Bean
    public static Cloud getCloud() {
        return new CloudFactory().getCloud();
    }

}
