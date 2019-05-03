package com.Aris.Esd_DocumentMov.Service.internalService;

import com.Aris.Esd_DocumentMov.Service.internal.*;
import com.Aris.Esd_DocumentMov.Service.internal.crud.SaveDocumentMovRequest;
import com.Aris.Esd_DocumentMov.Service.internal.crud.UpdateDocumentMovRequest;
import com.Aris.Esd_DocumentMov.db.entities.DocumentMov;
import com.Aris.Esd_DocumentMov.db.repo.RepoDocumentMov;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DocumentMovCrudServiceInternal {

    @Autowired
    RepoDocumentMov repoDocumentMov;


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public DocumentMovResponse saveDocumentMov(SaveDocumentMovRequest saveDocumentMovRequest) {
        DocumentMovResponse documentMovResponse= new DocumentMovResponse();
        try {
            DocumentMov documentMov = new DocumentMov();
            documentMov.setIdDocument(saveDocumentMovRequest.getIdDocument());
            documentMov.setIdEmployeeFrom(saveDocumentMovRequest.getIdEmployeeFrom());
            documentMov.setIdEmployeeTo(saveDocumentMovRequest.getIdEmployeeTo());
            documentMov.setIsActive(saveDocumentMovRequest.getIsActive());
            documentMov.setIsDeleted(saveDocumentMovRequest.getIsDeleted());
            documentMov.setNote(saveDocumentMovRequest.getNote());
            documentMov.setSendDate(saveDocumentMovRequest.getSendDate());
            documentMov.setIsAccepted(1);
            documentMov.setIsRead(0);
            documentMov.setReadDate(saveDocumentMovRequest.getReadDate());
            documentMov.setFinishDate(saveDocumentMovRequest.getFinishDate());
            documentMov.setIsMesul(saveDocumentMovRequest.getIsMesul());

           documentMov=repoDocumentMov.save(documentMov);
           documentMovResponse.setDocumentMov(documentMov);
            documentMovResponse.setServerCode(200);
            documentMovResponse.setServerMessage("OK");
            documentMovResponse.setStatusMessage("Saveeeeeeed");
            logger.info("saveDocument response : {}", saveDocumentMovRequest.toString());
        } catch (Exception e) {
            documentMovResponse.setServerCode(100);
            documentMovResponse.setServerMessage("erooor");
            documentMovResponse.setStatusMessage("No Saveeeeeeed");
            logger.error("Error save file text : {}", e);
        }
        return documentMovResponse;
    }

    public DocumentMovResponse updateDocumentMov(UpdateDocumentMovRequest updateDocumentMovRequest) {
        DocumentMovResponse documentMovResponse= new DocumentMovResponse();
        try {
            if (documentMovResponse != null) {


                DocumentMov docMov = repoDocumentMov.findByIdDocumentMovAndIsActive(updateDocumentMovRequest.getIdDocumentMov(),1);

                documentMovResponse.setServerCode(200);
                documentMovResponse.setServerMessage("OK");
                documentMovResponse.setStatusMessage("Update");
                logger.info("updateDocument response : {}", updateDocumentMovRequest.toString());

                docMov.setIdDocument(updateDocumentMovRequest.getIdDocument());
                docMov.setIdEmployeeFrom(updateDocumentMovRequest.getIdEmployeeFrom());
                docMov.setIdEmployeeTo(updateDocumentMovRequest.getIdEmployeeTo());
                docMov.setIsActive(updateDocumentMovRequest.getIsActive());
                docMov.setNote(updateDocumentMovRequest.getNote());
                docMov.setIsDeleted(updateDocumentMovRequest.getIsDeleted());
                docMov.setSendDate(updateDocumentMovRequest.getSendDate());
                docMov.setIsAccepted(1);
                docMov.setIsRead(0);
                docMov.setReadDate(updateDocumentMovRequest.getReadDate());
                docMov.setIsMesul(updateDocumentMovRequest.getIsMesul());
                docMov.setFinishDate(updateDocumentMovRequest.getFinishDate());


               docMov=repoDocumentMov.save(docMov);
               documentMovResponse.setDocumentMov(docMov);
            }else{
                documentMovResponse.setServerCode(200);
                documentMovResponse.setServerMessage("OK");
                documentMovResponse.setStatusMessage("file not found");
                logger.info("updateDocument response : {}", documentMovResponse.toString());
            }
        }
        catch (Exception e) {
            documentMovResponse.setServerCode(100);
            documentMovResponse.setServerMessage("erooor");
            documentMovResponse.setStatusMessage("No Update");
            logger.error("Error save file text : {}", e);
        }
        return documentMovResponse;
    }


     public DocumentMovResponse deleteDocumentMov(long idDocumentMov) {
        DocumentMovResponse documentMovResponse= new DocumentMovResponse();
        try {
            DocumentMov documentMov= repoDocumentMov.findByIdDocumentMovAndIsDeleted(idDocumentMov,1);
            if(documentMov!=null) {
                documentMovResponse.setServerCode(200);
                documentMovResponse.setServerMessage("OK");
                documentMovResponse.setStatusMessage("Deleted");
                logger.info("deleteDocument response : {}", documentMovResponse.toString());

                documentMov.setIsDeleted(0);
                documentMov=repoDocumentMov.save(documentMov);
                documentMovResponse.setDocumentMov(documentMov);
            }else {
                documentMovResponse.setServerCode(200);
                documentMovResponse.setServerMessage("OK");
                documentMovResponse.setStatusMessage("file not found");
                logger.info("updateDocument response : {}", documentMovResponse.toString());
            }
        } catch (Exception e) {
            documentMovResponse.setServerCode(100);
            documentMovResponse.setServerMessage("erooor");
            documentMovResponse.setStatusMessage("No Update");
            logger.error("Error delete file text : {}", e);
        }
        return documentMovResponse;
    }



}



