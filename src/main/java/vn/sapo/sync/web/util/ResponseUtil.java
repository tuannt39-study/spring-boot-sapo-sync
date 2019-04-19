package vn.sapo.sync.web.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ResponseUtil {

    static <X> ResponseEntity<X> wrapOrNotFound(Optional<X> maybeResponse) {
        return wrapOrNotFound(maybeResponse, null);
    }

    static <X> ResponseEntity<X> wrapOrNotFound(Optional<X> maybeResponse, HttpHeaders header) {
        if (maybeResponse.isPresent()) {
            return ResponseEntity.ok().headers(header).body(maybeResponse.get());
        } else {
            return ResponseEntity.notFound().headers(header).build();
        }
    }
}
