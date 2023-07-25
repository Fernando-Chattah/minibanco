package com.bbva.minibanco.presentation.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnableDisableRequest {
    private int id;
    private boolean active;
}
