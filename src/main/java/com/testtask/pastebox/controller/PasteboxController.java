package com.testtask.pastebox.controller;

import com.testtask.pastebox.api.request.PasteboxRequest;
import com.testtask.pastebox.api.response.PasteboxResponse;
import com.testtask.pastebox.api.response.PasteboxResponseURL;
import com.testtask.pastebox.service.PasteboxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PasteboxController {

    private final PasteboxService pasteboxService;

    @GetMapping("/")
    public List<PasteboxResponse> getPublicPasteList() {
        return pasteboxService.getPublicPasteList();
    }

    @GetMapping("/{hash}")
    public PasteboxResponse getByHash(@PathVariable String hash) {
        return pasteboxService.getByHash(hash);
    }

    @PostMapping("/")
    public PasteboxResponseURL createNewPaste(@RequestBody PasteboxRequest request) {
        return pasteboxService.create(request);
    }
}
