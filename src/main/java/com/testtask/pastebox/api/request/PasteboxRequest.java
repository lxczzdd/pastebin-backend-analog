package com.testtask.pastebox.api.request;

import com.testtask.pastebox.api.status.PublicStatus;
import lombok.Data;

@Data
public class PasteboxRequest {
    private String data;
    private long expirationTimeSeconds;
    private PublicStatus publicStatus;
}
