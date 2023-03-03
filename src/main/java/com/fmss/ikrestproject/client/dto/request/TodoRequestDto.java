package com.fmss.ikrestproject.client.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TodoRequestDto {
    private String description;
    private String comment;
}
