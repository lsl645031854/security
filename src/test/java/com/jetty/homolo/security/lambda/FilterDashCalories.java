package com.jetty.homolo.security.lambda;

import com.jetty.homolo.security.entity.Dash;

/**
 * @Author: lsl
 * @Description:
 * @Date: Created on 14:43 2019/10/16
 */
public class FilterDashCalories implements FilterDash<Dash> {

    @Override
    public boolean predicate(Dash dash) {
        return dash.getCalories() > 500;
    }
}
