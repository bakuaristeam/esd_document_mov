package com.Aris.Esd_DocumentMov.Service.api.searchServices.internal;

public class ResponseDocCount {

    private int serverCode;
    private String serverMessage;
    private long myDocsCount;
    private long mySendDocCount;

    public ResponseDocCount(int serverCode, String serverMessage, long myDocsCount, long mySendDocCount) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.myDocsCount = myDocsCount;
        this.mySendDocCount = mySendDocCount;
    }

    public ResponseDocCount() {
    }

    @Override
    public String toString() {
        return "ResponseDocCount{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", myDocsCount=" + myDocsCount +
                ", mySendDocCount=" + mySendDocCount +
                '}';
    }

    public int getServerCode() {
        return serverCode;
    }

    public void setServerCode(int serverCode) {
        this.serverCode = serverCode;
    }

    public String getServerMessage() {
        return serverMessage;
    }

    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }

    public long getMyDocsCount() {
        return myDocsCount;
    }

    public void setMyDocsCount(long myDocsCount) {
        this.myDocsCount = myDocsCount;
    }

    public long getMySendDocCount() {
        return mySendDocCount;
    }

    public void setMySendDocCount(long mySendDocCount) {
        this.mySendDocCount = mySendDocCount;
    }
}
