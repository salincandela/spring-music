package org.cloudfoundry.samples.music.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ApplicationInfo {
    private String[] profiles;
    private String[] services;
}
