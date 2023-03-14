package com.example.stujobs.pojo;

public class R_Send {
    private Integer id;

    private Integer sendId;

    private Integer toId;

    private Integer jobId;

    private Integer introduceId;

    private String result;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getIntroduceId() {
        return introduceId;
    }

    public void setIntroduceId(Integer introduceId) {
        this.introduceId = introduceId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}