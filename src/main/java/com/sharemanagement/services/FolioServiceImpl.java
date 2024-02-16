package com.sharemanagement.services;

import com.sharemanagement.dto.FolioDTO;
import com.sharemanagement.repositories.FolioRepo;
import com.sharemanagement.utils.StringHelperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class FolioServiceImpl implements FolioService {

    @Autowired
    private FolioRepo folioRepo;
    @Autowired
    private StringHelperUtils stringHelperUtils;

    @Autowired
    ModelMapper mapper;
    @Override
    @Transactional
    public void saveFolioDetails(List<FolioDTO> folioDtos) {

    }
}
