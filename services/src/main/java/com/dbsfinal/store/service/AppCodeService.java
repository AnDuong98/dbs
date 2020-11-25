package com.dbsfinal.store.service;

import com.dbsfinal.store.dto.AppCodeDTO;
import com.dbsfinal.store.entity.AppCode;
import com.dbsfinal.store.repositories.AppCodeRepository;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class AppCodeService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AppCodeRepository appCodeRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final int INACTIVE = 0;

    public Page<AppCodeDTO> getAllAppCode(Pageable pageable){
        try {
            Page<AppCode> appCodes = appCodeRepository.findAll(pageable);
            logger.info("Get All AppCode ...",appCodes);
            Page<AppCodeDTO> dtos = null;
            logger.info("Get App Success ...");
            List<AppCodeDTO> appCodeDTOS = new ArrayList<>();
            for(AppCode appCode: appCodes){
                AppCodeDTO appCodeDTO = modelMapper.map(appCode,AppCodeDTO.class);
                appCodeDTOS.add(appCodeDTO);
            }
            logger.info("Map Success AppCode to AppCodeDTO",appCodeDTOS);
            dtos = new PageImpl<>(appCodeDTOS,pageable,appCodes.getTotalElements());
            logger.info("Get Success All AppCode With Paging",dtos);
            return dtos;
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }


    public void addAppCode(AppCodeDTO appCodeDTO) {
        try {
            logger.info("Get Data ...", appCodeDTO);
            AppCode appCode = modelMapper.map(appCodeDTO, AppCode.class);
            appCode.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
            logger.info("Add data to database....");
            appCodeRepository.save(appCode);
            logger.info("save data success");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<AppCodeDTO> findByCodeOrDescription(String searchValue){
        List<AppCode> appCodes = appCodeRepository.findByCodeOrDescription(searchValue,null);
        List<AppCodeDTO> appCodeDTOS = new ArrayList<>();
        for(AppCode appCode : appCodes){
            appCodeDTOS.add(modelMapper.map(appCode,AppCodeDTO.class));
        }
        return appCodeDTOS;
    }

    public AppCodeDTO save(AppCodeDTO appCodeDTO){
        if(appCodeDTO.getAppCodeId()!=null&&appCodeDTO.getAppCodeId()>0){
            Optional<AppCode> appCode = appCodeRepository.findById(appCodeDTO.getAppCodeId());
            if(appCode.isPresent()){
                AppCode appCodeNew = appCode.get();
                modelMapper.map(appCodeDTO,appCodeNew);
                return modelMapper.map(appCodeRepository.save(appCodeNew),AppCodeDTO.class);
            }
            return null;
        }else{
            AppCode appCode1 = modelMapper.map(appCodeDTO, AppCode.class);
            return modelMapper.map(appCodeRepository.save(appCode1),AppCodeDTO.class);
        }
    }

    public AppCodeDTO delete(AppCodeDTO appCodeDTO){
        if(appCodeDTO.getAppCodeId()!=null&&appCodeDTO.getAppCodeId()>0){
            Optional<AppCode> appCode = appCodeRepository.findById(appCodeDTO.getAppCodeId());
            if(appCode.isPresent()){
                AppCode appCodeNew = appCode.get();
                appCodeNew.setStatus(INACTIVE);
                return modelMapper.map(appCodeRepository.save(appCodeNew),AppCodeDTO.class);
            }
        }
        return null;
    }
}
