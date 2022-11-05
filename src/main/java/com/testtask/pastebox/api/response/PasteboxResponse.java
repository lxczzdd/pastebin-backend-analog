package com.testtask.pastebox.api.response;

import com.testtask.pastebox.api.status.PublicStatus;

public record PasteboxResponse(String data, PublicStatus status) {
}
