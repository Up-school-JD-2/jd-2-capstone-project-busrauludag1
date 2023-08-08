package io.upschool.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class AirportSaveResponse extends BaseResponse{
    private Long id;
    private String nameAndLocation;
}
