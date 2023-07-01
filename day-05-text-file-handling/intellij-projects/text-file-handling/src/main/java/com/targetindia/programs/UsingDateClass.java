package com.targetindia.programs;

import com.targetindia.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class UsingDateClass {
    public static void main(String[] args) {
        Date dt;

        dt = new Date(); // current time

        log.trace("dt = {}", dt);

        SimpleDateFormat sdf = new SimpleDateFormat("MMMM MMM MM M");
        log.trace(sdf.format(dt));

        sdf.applyPattern("EEEE E");
        log.trace(sdf.format(dt));

        sdf.applyPattern("dd/MM/yy");
        log.trace(sdf.format(dt));

        sdf.applyPattern("d/M/y");
        log.trace(sdf.format(dt));

        sdf.applyPattern("yyyy-MM-dd hh:mm:ss a z");
        log.trace(sdf.format(dt));

        String dob = "20/01/1974";
        dt = DateUtil.toDate(dob);
        log.trace("DateUtil.toDate(dob) is {}", dt);
        log.trace("DateUtil.toString(dt) is {}", DateUtil.toString(dt));
    }
}
