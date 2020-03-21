package com.platform.oecp.admin.controller;

import com.platform.oecp.business.manager.OecpErrorInfoEsManager;
import com.platform.oecp.models.document.OecpErrorDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/esSearch")
public class OecpErrorSearchController {

    @Autowired
    private OecpErrorInfoEsManager service;

    @GetMapping("/test")
    public String test() {
        return "Success";
    }

    @PostMapping("/create/index")
    public ResponseEntity createIndex() throws Exception {
        return new ResponseEntity(service.createErrorCodeIndex(), HttpStatus.CREATED);
    }

    @PostMapping("/create")
    public ResponseEntity createErrorCode(@RequestBody OecpErrorDocument document) throws Exception {
        return new ResponseEntity(service.editErrorCode(document), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public OecpErrorDocument findById(@PathVariable String id) throws Exception {
        return service.findById(id);
    }

    @GetMapping(value = "/suggest")
    public List<OecpErrorDocument> suggest(@RequestParam(value = "info") String info) throws Exception {
        return service.suggestErrorCode(info);
    }

    @GetMapping(value = "/search")
    public List<OecpErrorDocument> searchByName(@RequestParam(value = "info") String info) throws Exception {
        return service.searchErrorCode(info);
    }

    @DeleteMapping("/{id}")
    public String deleteErrorCode(@PathVariable String id) throws Exception {
        return service.deleteErrorCode(id);
    }
}
