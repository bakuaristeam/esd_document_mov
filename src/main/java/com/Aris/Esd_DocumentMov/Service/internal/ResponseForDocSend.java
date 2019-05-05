package com.Aris.Esd_DocumentMov.Service.internal;

public class ResponseForDocSend {
    private String serverMessage;
    private int serverCode;

    public ResponseForDocSend(String serverMessage, int serverCode) {
        this.serverMessage = serverMessage;
        this.serverCode = serverCode;
    }

    public ResponseForDocSend() {
    }

    @Override
    public String toString() {
        return "ResponseForDocSend{" +
                "serverMessage='" + serverMessage + '\'' +
                ", serverCode=" + serverCode +
                '}';
    }

    public String getServerMessage() {
        return serverMessage;
    }

    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }

    public int getServerCode() {
        return serverCode;
    }

    public void setServerCode(int serverCode) {
        this.serverCode = serverCode;
    }
}
