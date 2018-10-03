package org.cloudfoundry.samples.music.configuration;

import org.springframework.cloud.service.ServiceInfo;

import java.util.Collection;

public interface ServicesInfo {

    Collection<ServiceInfo> getServices();
}
