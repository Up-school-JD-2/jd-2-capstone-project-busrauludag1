package io.upschool.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponse<T> {

    private int status;

    @JsonProperty("isSuccess")
    private Boolean isSuccess;

    @Builder.Default
    private String message = "No message available.";

    private T data;
}
