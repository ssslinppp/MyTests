package com.ssslinppp.model;

import jdk.nashorn.internal.runtime.regexp.joni.constants.TargetInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liulin on 2017/6/27.
 */
public class ReqModel {
    private String startTime;  //示例：2017-06-27 17:56:51
    private Date endTime;
    private int precision; //10s为单位

    private String funs;        //聚会类型：avg,min,max

    List<TargetInfo> targetInfos = new ArrayList<>();

    public ReqModel() {
    }

    /**
     *
     * @param startTime
     * @param endTime
     * @param precision
     * @param funs
     * @param targetInfos
     */
    public ReqModel(String startTime, Date endTime, int precision, String funs, List<TargetInfo> targetInfos) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.precision = precision;
        this.funs = funs;
        this.targetInfos = targetInfos;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public String getFuns() {
        return funs;
    }

    public void setFuns(String funs) {
        this.funs = funs;
    }

    public List<TargetInfo> getTargetInfos() {
        return targetInfos;
    }

    public void setTargetInfos(List<TargetInfo> targetInfos) {
        this.targetInfos = targetInfos;
    }

    /**
     * 具体target的确定由如下几个参数决定：
     * poolId ：不同的资源池，相同的性能参数，其target名称可能不同（正常情况下是相同的）；
     * group： group不同时，其hostId的形式不同；
     */
    static class TargetInfo {
        private String poolId;      //资源池ID，如 呼和浩特、哈尔滨、development等，正常情况用不到这个
        private String group;       //资源池类型,指标所属分类,vm,pm,net等
        private String hostId;      //pm时: 可以是ip或hostname，如果是ip，则需要使用“_”分割数字；vm: uuid等
        private String metricName; //真正的指标名，如cpu_system,cpu_idle,mem_free等，这个和具体的targe有一个映射关系

        public TargetInfo() {
        }

        public TargetInfo(String poolId, String group, String hostId, String metricName) {
            this.poolId = poolId;
            this.group = group;
            this.hostId = hostId;
            this.metricName = metricName;
        }

        public String getPoolId() {
            return poolId;
        }

        public void setPoolId(String poolId) {
            this.poolId = poolId;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getHostId() {
            return hostId;
        }

        public void setHostId(String hostId) {
            this.hostId = hostId;
        }

        public String getMetricName() {
            return metricName;
        }

        public void setMetricName(String metricName) {
            this.metricName = metricName;
        }

        @Override
        public String toString() {
            return "TargetInfo{" +
                    "poolId='" + poolId + '\'' +
                    ", group='" + group + '\'' +
                    ", hostId='" + hostId + '\'' +
                    ", metricName='" + metricName + '\'' +
                    '}';
        }

        public static TargetInfo newDefaultInfo() {
            String poolId = "development";      //资源池ID，如 呼和浩特、哈尔滨、development 等，正常情况用不到这个
            String group = "pm-pm-pm";       //资源池类型,指标所属分类,vm,pm,net等
            String hostId = "10_180_218_11";      //pm时: 可以是ip或hostname，如果是ip，则需要使用“_”分割数字；vm: uuid等
            String metricName = "cpu_system"; //真正的指标名，如cpu_system,cpu_idle,mem_free等，这个和具体的targe有一个映射关系

            TargetInfo targetInfo = new TargetInfo(poolId, group, hostId, metricName);

            return targetInfo;
        }
    }

    @Override
    public String toString() {
        return "ReqModel{" +
                "startTime='" + startTime + '\'' +
                ", endTime=" + endTime +
                ", precision=" + precision +
                ", funs='" + funs + '\'' +
                ", targetInfos=" + targetInfos +
                '}';
    }

    public static ReqModel newDefaultReqModel() {
        String startTime = "2016-06-20 17:56:51";
        Date endTime = new Date();
        int precision = 10; //10s为单位
        String funs = "fun-max";        //聚会类型：avg,min,max

        List<TargetInfo> targetInfos = new ArrayList<>();
        targetInfos.add(ReqModel.TargetInfo.newDefaultInfo());
        targetInfos.add(ReqModel.TargetInfo.newDefaultInfo());
        targetInfos.add(ReqModel.TargetInfo.newDefaultInfo());

        ReqModel requestModel = new ReqModel(startTime, endTime, precision, funs, targetInfos);
        return requestModel;
    }

}
