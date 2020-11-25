package com.dbsfinal.store.controller;

import com.dbsfinal.store.dto.PageMetaData;
import com.dbsfinal.store.dto.ProductDTO;
import com.dbsfinal.store.entity.APIResponse;
import com.dbsfinal.store.entity.CartInfo;
import com.dbsfinal.store.service.ProductService;
import com.dbsfinal.store.utils.CartSupportUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class PromotionController {

    @Autowired
    private ProductService productService;

    @GetMapping("promotion")
    public String page(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                       @RequestParam(name = "size", required = false, defaultValue = "16") Integer size,
                       ModelMap modelMap, HttpServletRequest request) {
            APIResponse<List<ProductDTO>> responseDTO = productService.getAllpageProductHasPromotion(PageRequest.of(page, size));
            PageMetaData metaData = responseDTO.getPageMetadata();
            modelMap.addAttribute("listProduct", responseDTO.getData());
            if (metaData != null) {
                modelMap.addAttribute("pages", metaData);
            }
        CartInfo cartInfo = CartSupportUtils.getCartInSession(request);
        modelMap.addAttribute("sizeCart", cartInfo.getCartLines().size());
        return "promotion";
    }

}
