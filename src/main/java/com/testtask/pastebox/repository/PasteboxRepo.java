package com.testtask.pastebox.repository;

import com.testtask.pastebox.entity.PasteboxEntity;

import java.util.List;

public interface PasteboxRepo {
    PasteboxEntity getByHash (String hash);
    List<PasteboxEntity> getPublicAndAlivePasteList(int amount);
    void add(PasteboxEntity pasteboxEntity);
}
