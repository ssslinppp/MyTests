package com.sssppp.graphite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LIULIN on 2017/6/21.
 */
@RestController
@RequestMapping("/render")
public class GraphiteController {

    @Autowired
    private GraphiteService graphiteService;

    @RequestMapping("/memInfo/{metric}")
    public String getMemMetrics(@PathVariable("metric") String metric,
                                @RequestParam(value = "format", defaultValue = "json") String format,
                                @RequestParam(value="from", required = false) String from) {
        return graphiteService.getMemMetrics(metric, format, from);
    }
}
