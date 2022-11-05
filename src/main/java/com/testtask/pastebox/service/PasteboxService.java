package com.testtask.pastebox.service;

import com.testtask.pastebox.api.request.PasteboxRequest;
import com.testtask.pastebox.api.response.PasteboxResponse;
import com.testtask.pastebox.api.response.PasteboxResponseURL;

import java.util.List;

public interface PasteboxService {
     PasteboxResponse getByHash(String hash);
     List<PasteboxResponse> getPublicPasteList();
     PasteboxResponseURL create(PasteboxRequest request);

}
