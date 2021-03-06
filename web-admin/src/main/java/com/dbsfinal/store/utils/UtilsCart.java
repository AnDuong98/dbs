package com.dbsfinal.store.utils;

import javax.servlet.http.HttpServletRequest;

import com.dbsfinal.store.entity.CartInfo;

public class UtilsCart {

    private UtilsCart() {
        throw new IllegalStateException("Utility class");
    }
    public static CartInfo getCartInSession(HttpServletRequest request) {

        CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("myCart");


        if (cartInfo == null) {
            cartInfo = new CartInfo();

            request.getSession().setAttribute("myCart", cartInfo);
        }

        return cartInfo;
    }
    public static void removeCartInSession(HttpServletRequest request) {
        request.getSession().removeAttribute("myCart");
    }
}

