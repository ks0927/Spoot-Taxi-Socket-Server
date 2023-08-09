package com.capstone.smutaxi.domain;

import com.capstone.smutaxi.domain.Message;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SystemMessage extends Message {
    private Boolean isSystem;
}