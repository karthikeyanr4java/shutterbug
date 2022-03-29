package com.kk.project.shutterbug.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ShutterbugDto implements ResponseDto {
    private String message;
}
