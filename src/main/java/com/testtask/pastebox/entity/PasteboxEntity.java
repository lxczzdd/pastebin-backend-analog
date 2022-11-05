package com.testtask.pastebox.entity;

import com.testtask.pastebox.api.status.PublicStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PasteboxEntity {
    private String data;
    private String hash;
    private LocalDateTime lifecycle;
    private PublicStatus status;
}
