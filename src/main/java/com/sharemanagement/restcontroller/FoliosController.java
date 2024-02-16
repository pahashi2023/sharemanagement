package com.sharemanagement.restcontroller;

import com.google.gson.Gson;
import com.sharemanagement.dto.AccountDetailDTO;
import com.sharemanagement.dto.FolioDTO;
import com.sharemanagement.dto.ResponseDto;
import com.sharemanagement.entities.Folio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FoliosController {
    public static final Logger logger = LoggerFactory.getLogger(FoliosController.class);

    @PostMapping(value = "/foliodetail/save", produces = "application/json", consumes = "application/json", headers = "Accept=application/json")
    public ResponseEntity<String> saveFolioDetails(@RequestBody List<FolioDTO> folioDto) {

        ResponseDto dto = new ResponseDto();
        dto.setMessage("success");
        return ResponseEntity.ok(new Gson().toJson(dto));
    }
}
