package org.cloudfoundry.samples.music.web;

import org.cloudfoundry.samples.music.configuration.ServicesInfo;
import org.cloudfoundry.samples.music.domain.ApplicationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class InfoController {

    private final Environment springEnvironment;

    private final ServicesInfo servicesInfo;

    @Autowired
    public InfoController(Environment springEnvironment, ServicesInfo servicesInfo) {
        this.springEnvironment = springEnvironment;
        this.servicesInfo = servicesInfo;
    }

    @RequestMapping(value = "/appinfo")
    public ApplicationInfo info() {
        return new ApplicationInfo(springEnvironment.getActiveProfiles(), getServiceNames());
    }

    private String[] getServiceNames() {
        Collection<ServiceInfo> services = servicesInfo.getServices();
        String[] response = new String[services.size()];
        return services.stream()
                .map(ServiceInfo::getId)
                .collect(Collectors.toCollection(ArrayList::new))
                .toArray(response);
    }

    @RequestMapping(value = "/service")
    public Collection<ServiceInfo> showServiceInfo() {
        return servicesInfo.getServices();
    }

}