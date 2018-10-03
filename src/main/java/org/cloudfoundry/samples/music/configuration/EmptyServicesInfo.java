package org.cloudfoundry.samples.music.configuration;

import org.springframework.cloud.service.ServiceInfo;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Profile("!cloud")
@Component
public class EmptyServicesInfo implements ServicesInfo {

    public Collection<ServiceInfo> getServices() {
        return Collections.emptyList();
    }
}
