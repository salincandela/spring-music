package org.cloudfoundry.samples.music.web.support;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such album")
public class NoAlbumFoundException extends RuntimeException {
}
