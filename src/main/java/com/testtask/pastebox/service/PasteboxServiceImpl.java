package com.testtask.pastebox.service;

import com.testtask.pastebox.api.request.PasteboxRequest;
import com.testtask.pastebox.api.response.PasteboxResponse;
import com.testtask.pastebox.api.response.PasteboxResponseURL;
import com.testtask.pastebox.config.YAMLConfig;
import com.testtask.pastebox.entity.PasteboxEntity;
import com.testtask.pastebox.repository.PasteboxRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class PasteboxServiceImpl implements PasteboxService {

    private final YAMLConfig config;
    private final PasteboxRepo pasteboxRepository;
    private final AtomicInteger id = new AtomicInteger(0);

    @Override
    public PasteboxResponse getByHash(String hash) {
        PasteboxEntity entity = pasteboxRepository.getByHash(hash);
        return new PasteboxResponse(entity.getData(), entity.getStatus());
    }

    @Override
    public List<PasteboxResponse> getPublicPasteList() {
        List<PasteboxEntity> list = pasteboxRepository.getPublicAndAlivePasteList(config.getPublicListSize());

        return list.stream().map(pasteboxEntity ->
                        new PasteboxResponse(pasteboxEntity.getData(), pasteboxEntity.getStatus()))
                .toList();
    }

    @Override
    public PasteboxResponseURL create(PasteboxRequest request) {
        int hash = generateId();
        PasteboxEntity entity = new PasteboxEntity();
        entity.setData(request.getData());
        entity.setHash(Integer.toHexString(hash));
        entity.setStatus(request.getPublicStatus());
        entity.setLifecycle(LocalDateTime.now().plusSeconds(request.getExpirationTimeSeconds()));
        pasteboxRepository.add(entity);
        return new PasteboxResponseURL(config.getHost() + "/" + entity.getHash());
    }

    private int generateId() {
        return id.getAndIncrement();
    }
}
