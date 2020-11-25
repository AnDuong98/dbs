package com.dbsfinal.store.controller;

import com.dbsfinal.store.dto.AppCodeDTO;
import com.dbsfinal.store.entity.APIResponse;
import com.dbsfinal.store.service.AppCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * fres-parent
 *
 * @author Namtt
 * @created_at 20/04/2020 - 5:58 PM
 * @created_by Namtt
 * @since 20/04/2020
 */

@RestController
@RequestMapping("/appCode")
public class AppCodeController {

    private final AppCodeService appCodeService;

    @Autowired
    public AppCodeController(AppCodeService appCodeService){
        this.appCodeService = appCodeService;
    }

    @GetMapping
    public ResponseEntity<APIResponse<Page<AppCodeDTO>>> getAllAppCode(
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "5", required = false) Integer size) {
        try {
            Pageable pageable = PageRequest.of(page,size);
            Page<AppCodeDTO> dtos = appCodeService.getAllAppCode(pageable);
            APIResponse<Page<AppCodeDTO>> responseData = new APIResponse<>();
            responseData.setStatus(HttpStatus.OK.value());
            responseData.setMessage("Fill all app code successful");
            responseData.setData(dtos);
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        } catch (Exception e) {
            APIResponse responseData = new APIResponse<>();
            responseData.setStatus(HttpStatus.NOT_FOUND.value());
            responseData.setMessage("Khong co du lieu");
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addAppCode(@RequestBody AppCodeDTO appCodeDTO) {

        try {
            appCodeService.addAppCode(appCodeDTO);
            APIResponse<AppCodeDTO> responseData = new APIResponse<>();
            responseData.setStatus(HttpStatus.OK.value());
            responseData.setMessage("Add successful");
            responseData.setData(appCodeDTO);
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        } catch (Exception e) {
            APIResponse responseData = new APIResponse<>();
            responseData.setStatus(HttpStatus.BAD_REQUEST.value());
            responseData.setMessage("Khong add duoc vao DB");
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        }
    }


    @GetMapping("/{searchvalue}")
    public ResponseEntity<Object> findByCodeOrDescription(@PathVariable("searchvalue") String searchValue) {
        try {
            APIResponse<List<AppCodeDTO>> responseData = new APIResponse<>();
            responseData.setMessage("Find by code or description successfull");
            responseData.setData(appCodeService.findByCodeOrDescription(searchValue));
            responseData.setStatus(HttpStatus.OK.value());
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody AppCodeDTO appCodeDTO) {
        try {
            APIResponse<AppCodeDTO> responseData = new APIResponse<>();
            responseData.setMessage("Update successfully");
            responseData.setData(appCodeService.save(appCodeDTO));
            responseData.setStatus(HttpStatus.OK.value());
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody AppCodeDTO appCodeDTO) {
        try {
            APIResponse<AppCodeDTO> responseData = new APIResponse<>();
            responseData.setMessage("Update successfully");
            responseData.setData(appCodeService.delete(appCodeDTO));
            responseData.setStatus(HttpStatus.OK.value());
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
