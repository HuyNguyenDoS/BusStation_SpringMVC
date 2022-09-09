/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.formatter;

import com.btl.pojos.Bus;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Nguyen
 */
public class BusFormatter implements Formatter<Bus> {

    @Override
    public String print(Bus t, Locale locale) {
        return String.valueOf(t.getIdBus());
    }

    @Override
    public Bus parse(String string, Locale locale) throws ParseException {
        Bus b = new Bus();
        b.setIdBus(Integer.parseInt(string));
        return b;
    }

}
