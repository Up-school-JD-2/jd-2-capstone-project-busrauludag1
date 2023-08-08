package io.upschool.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
