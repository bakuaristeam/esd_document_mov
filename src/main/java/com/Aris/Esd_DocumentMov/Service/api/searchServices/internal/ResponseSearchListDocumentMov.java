package com.Aris.Esd_DocumentMov.Service.api.searchServices.internal;

import com.Aris.Esd_DocumentMov.db.entities.DocumentMov;

import java.util.List;

public class ResponseSearchListDocumentMov {

    private int serverCode;
    private String serverMessage;
    private List<DocumentMov> listOfDocumentMov;

    public ResponseSearchListDocumentMov(int serverCode, String serverMessage, List<DocumentMov> listOfDocumentMov) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.listOfDocumentMov = listOfDocumentMov;
    }

    public ResponseSearchListDocumentMov() {
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

    public List<DocumentMov> getListOfDocumentMov() {
        return listOfDocumentMov;
    }

    public void setListOfDocumentMov(List<DocumentMov> listOfDocumentMov) {
        this.listOfDocumentMov = listOfDocumentMov;
    }

    @Override
    public String toString() {
        return "ResponseSearchListDocumentMov{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", listOfDocumentMov=" + listOfDocumentMov +
                '}';
    }
}
