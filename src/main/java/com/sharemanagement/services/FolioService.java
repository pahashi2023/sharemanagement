package com.sharemanagement.services;

import com.sharemanagement.dto.AccountDetailDTO;
import com.sharemanagement.dto.FolioDTO;

import java.util.List;

public interface FolioService {

    void saveFolioDetails(List<FolioDTO> folioDtos);
}
