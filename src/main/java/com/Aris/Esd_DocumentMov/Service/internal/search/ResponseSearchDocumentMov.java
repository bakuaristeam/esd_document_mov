package com.Aris.Esd_DocumentMov.Service.internal.search;

import com.Aris.Esd_DocumentMov.db.entities.DocumentMov;

public class ResponseSearchDocumentMov {

    private int serverCode;
    private String serverMessage;
    private DocumentMov documentMov;

    public ResponseSearchDocumentMov(int serverCode, String serverMessage, DocumentMov documentMov) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.documentMov = documentMov;
    }

    public ResponseSearchDocumentMov() {
    }

    @Override
    public String toString() {
        return "ResponseSearchDocumentMov{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", documentMov=" + documentMov +
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

    public DocumentMov getDocumentMov() {
        return documentMov;
    }

    public void setDocumentMov(DocumentMov documentMov) {
        this.documentMov = documentMov;
    }
}
