package com.Aris.Esd_DocumentMov.Service.internal;

import com.Aris.Esd_DocumentMov.db.entities.DocumentMov;

public class DocumentMovResponse {

    private int serverCode;
    private String serverMessage;
    private String statusMessage;
    private DocumentMov documentMov;


    public DocumentMovResponse(int serverCode, String serverMessage, String statusMessage, DocumentMov documentMov) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.statusMessage = statusMessage;
        this.documentMov = documentMov;
    }

    public DocumentMovResponse() {
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

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public DocumentMov getDocumentMov() {
        return documentMov;
    }

    public void setDocumentMov(DocumentMov documentMov) {
        this.documentMov = documentMov;
    }

    @Override
    public String toString() {
        return "DocumentMovResponse{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                ", documentMov=" + documentMov +
                '}';
    }
}
