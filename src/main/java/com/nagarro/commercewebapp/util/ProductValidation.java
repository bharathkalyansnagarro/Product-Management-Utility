package com.nagarro.commercewebapp.util;


import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import com.nagarro.commercewebapp.constants.Constants;

public class ProductValidation {
    private final HttpSession session;

    public ProductValidation(HttpSession session) {
        this.session = session;
    }

    // Method to validate id for product
    public boolean validateID(String id) {
        // check if title is not empty
        if (id == null || id.trim().equals("")) {
            session.setAttribute(Constants.ID_ERROR_ATTRIBUTE, Constants.FIELD_CANNOT_BE_EMPTY);
            return false;
        }
        // handle invalid size value error
        try {
            if (Integer.parseInt(id) < 1) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            session.setAttribute(Constants.ID_ERROR_ATTRIBUTE, Constants.INVALID_VALUE);
            return false;
        }

        return true;
    }

    // Method to validate title for product
    public boolean validateTitle(String title) {
        // check if title is not empty
        if (title == null || title.trim().equals("")) {
            session.setAttribute(Constants.TITLE_ERROR_ATTRIBUTE, Constants.FIELD_CANNOT_BE_EMPTY);
            return false;
        }

        return true;
    }

    public boolean validateQuantity(String quantity) {
        // check if quantity is not empty
        if (quantity == null || quantity.trim().equals("")) {
            session.setAttribute(Constants.QUANTITY_ERROR_ATTRIBUTE, Constants.FIELD_CANNOT_BE_EMPTY);
            return false;
        }

        // handle invalid quantity value error
        try {
            if (Integer.parseInt(quantity) < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            session.setAttribute(Constants.QUANTITY_ERROR_ATTRIBUTE, Constants.INVALID_VALUE);
            return false;
        }

        return true;
    }

    public boolean validateSize(String size) {
        // check if size is not empty
        if (size == null || size.trim().equals("")) {
            session.setAttribute(Constants.SIZE_ERROR_ATTRIBUTE, Constants.FIELD_CANNOT_BE_EMPTY);
            return false;
        }

        // handle invalid size value error
        try {
            if (Integer.parseInt(size) < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            session.setAttribute(Constants.SIZE_ERROR_ATTRIBUTE, Constants.INVALID_VALUE);
            return false;
        }

        return true;
    }

    public boolean validateImgUrl(String imgUrl) {
        // check if image field is not empty
        if (imgUrl == null || imgUrl.trim().equals("")) {
            session.setAttribute(Constants.IMAGE_URL_ERROR_ATTRIBUTE, Constants.FIELD_CANNOT_BE_EMPTY);
            return false;
        }

        // check if the url is a valid image url
        if (!Pattern.matches(Constants.IMAGE_URL_PATTERN, imgUrl)) {
            session.setAttribute(Constants.IMAGE_URL_ERROR_ATTRIBUTE, Constants.INVALID_IMAGE_URL);
            return false;
        }

        return true;
    }

}

