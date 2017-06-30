package com.ssslinppp.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liulin on 2017/6/28.
 */
public class TargetDataModel {
    private String target;
    private List<List<Object>> datapoints;
    private List<DataPoint> datapointsList;

    public TargetDataModel() {
    }

    public List<DataPoint> getDatapointsList() {
        return datapointsList;
    }

    public void setDatapointsList() {
        if (StringUtils.isEmpty(datapointsList) && !StringUtils.isEmpty(datapoints)) {
            datapointsList = new ArrayList<>();
            for (int i = 0; i < datapoints.size(); i++) {
                List<Object> objects = datapoints.get(i);
                DataPoint dataPoint = new DataPoint(objects.get(0), new Date(Long.parseLong(objects.get(1).toString())));
                datapointsList.add(dataPoint);
            }
        }
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<List<Object>> getDatapoints() {
        return datapoints;
    }

    public void setDatapoints(List<List<Object>> datapoints) {
        this.datapoints = datapoints;
        setDatapointsList();
    }

    @Override
    public String toString() {
        return "TargetDataModel{" +
                "target='" + target + '\'' +
                ", datapoints=" + datapoints +
                ", datapointsList=" + datapointsList +
                '}';
    }

    public static class DataPoint {
        private Object value;
        private Date timestramp;

        public DataPoint() {
        }

        public DataPoint(Object value, Date timestramp) {
            this.value = value;
            this.timestramp = timestramp;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Date getTimestramp() {
            return timestramp;
        }

        public void setTimestramp(Date timestramp) {
            this.timestramp = timestramp;
        }

        @Override
        public String toString() {
            return "DataPoint{" +
                    "value=" + value +
                    ", timestramp=" + timestramp +
                    '}';
        }
    }

    public static void main(String[] args) {
        String jsonStringArr = "[{\"target\":\"clm.agg.pm.total-hosts\",\"datapoints\":[[11,1498625670],[null,1498625730]]},{\"target\":\"clm.stats.metric-count.total-pm-received\",\"datapoints\":[[5551,1498625670],[null,1498625680],[null,1498625690]]},{\"target\":\"clm.stats.metric-count.total-pm-submitted\",\"datapoints\":[[2279,1498625670]]}]";

        ObjectMapper mapper = new ObjectMapper();
        try {

            System.out.println("----------Json to Objects[] or List<>------------");
//            TargetDataModel[] targets = mapper.readValue(jsonStringArr, TargetDataModel[].class);
//            for (int i = 0; i < targets.length; i++) {
//                TargetDataModel target = targets[i];
//                System.out.println(target.toString());
//            }
            List<TargetDataModel> targets = mapper.readValue(jsonStringArr, new TypeReference<List<TargetDataModel>>() {
            });
            for (int i = 0; i < targets.size(); i++) {
                TargetDataModel targetDataModel = targets.get(i);
                System.out.println(targetDataModel.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


























