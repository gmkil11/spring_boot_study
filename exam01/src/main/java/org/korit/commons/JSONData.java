package org.korit.commons;

import lombok.*;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class JSONData<T> {
    private HttpStatus status = HttpStatus.OK;
    private boolean success = true;

    @NonNull
    private T data;
    private String message;
}
