/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.formatter;

import com.btl.pojos.CategoryBus;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Nguyen
 */
public class CategoryBusFormatter implements Formatter<CategoryBus> {

    @Override
    public String print(CategoryBus t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public CategoryBus parse(String cateString, Locale locale) throws ParseException {
        CategoryBus c = new CategoryBus();
        c.setId(Integer.parseInt(cateString));
        return c;
    }

}
