package com.sharemanagement.repositories;

import com.sharemanagement.dto.FolioDTO;

import java.util.List;

public interface FolioRepo {
    void saveFolioDetails(List<FolioDTO> folioDtos);
}
