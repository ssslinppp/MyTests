package com.sssppp.graphite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by LIULIN on 2017/6/21.
 */
@Service
public class GraphiteService {

    @Autowired
    private RestTemplate restTemplate;

    public String getMemMetrics(String metric, String format, String from) {
        System.out.println("metric:" + metric + ",format:" + format + ", from:" + from);

        String url = "http://10.144.202.151:5000/render?";
//        String url = "http://10.144.202.151:5000/render";
//        String target = "target=clm.agg.pm.memory.buffered";
        String target = "target=clm.agg.pm." + metric + ".buffered";

        StringBuffer queryParams = new StringBuffer();
        if (format != null && !format.equals("")) {
            queryParams.append("&format=" + format);
        }
        if (from != null && !from.equals("")) {
            queryParams.append("&from=" + from);
        }

        String queryUrl = url + target + queryParams.toString();
        System.out.println("queryURL:" + queryUrl);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(queryUrl, String.class);
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, target, format, from);
        System.out.println("responseEntity.getBody():" + responseEntity.getBody());
        return responseEntity.getBody();
    }

    class MetricModel {
        private String target;
        private List<DataPoint> datapoints;

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public List<DataPoint> getDatapoints() {
            return datapoints;
        }

        public void setDatapoints(List<DataPoint> datapoints) {
            this.datapoints = datapoints;
        }

        @Override
        public String toString() {
            return "MetricModel{" +
                    "target='" + target + '\'' +
                    ", datapoints=" + datapoints +
                    '}';
        }
    }

    class DataPoint {
        private Float value;
        private Float timeStamp;

        public Float getValue() {
            return value;
        }

        public Float getTimeStamp() {
            return timeStamp;
        }

        public void setValue(Float value) {
            this.value = value;
        }

        public void setTimeStamp(Float timeStamp) {
            this.timeStamp = timeStamp;
        }
    }

}
