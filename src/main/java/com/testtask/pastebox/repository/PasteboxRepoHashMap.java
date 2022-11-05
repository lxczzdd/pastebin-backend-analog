package com.testtask.pastebox.repository;

import com.testtask.pastebox.api.status.PublicStatus;
import com.testtask.pastebox.entity.PasteboxEntity;
import com.testtask.pastebox.exception.PasteboxNotFoundException;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PasteboxRepoHashMap implements PasteboxRepo {

    private final Map<String, PasteboxEntity> vault = new HashMap<>();

    @Override
    public PasteboxEntity getByHash(String hash) {
        PasteboxEntity pasteboxEntity = vault.get(hash);

        if(pasteboxEntity == null) {
            throw new PasteboxNotFoundException("Paste with this hash does not exist = " + hash);
        }

        return pasteboxEntity;
    }

    @Override
    public List<PasteboxEntity> getPublicAndAlivePasteList(int amount) {
        return vault.values().stream()
                .filter(entity -> entity.getStatus() == PublicStatus.PUBLIC)
                .filter(entity -> entity.getLifecycle().isAfter(LocalDateTime.now()))
                .limit(amount)
                .toList();
    }

    @Override
    public void add(PasteboxEntity pasteboxEntity) {
        vault.put(pasteboxEntity.getHash(), pasteboxEntity);
    }
}
