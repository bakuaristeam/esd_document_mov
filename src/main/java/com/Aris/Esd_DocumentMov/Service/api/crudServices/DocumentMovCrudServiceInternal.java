package com.Aris.Esd_DocumentMov.Service.api.crudServices;

import com.Aris.Esd_DocumentMov.Service.internal.*;
import com.Aris.Esd_DocumentMov.Service.api.crudServices.internal.SaveDocumentMovRequest;
import com.Aris.Esd_DocumentMov.Service.api.crudServices.internal.UpdateDocumentMovRequest;
import com.Aris.Esd_DocumentMov.db.entities.DocumentMov;
import com.Aris.Esd_DocumentMov.db.repo.RepoDocumentMov;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentMovCrudServiceInternal {

    @Autowired
    RepoDocumentMov repoDocumentMov;


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ResponseForDocSend updateDocMoveForDocSend(long idEmpTo, long idDocument){
        ResponseForDocSend response  =  new ResponseForDocSend();
        try{
            DocumentMov docMov = repoDocumentMov.findByIdDocumentAndIsActiveAndIdEmployeeTo(idDocument, 1, idEmpTo);
            if(docMov!=null){
                docMov.setIsActive(0);
                repoDocumentMov.save(docMov);
                response.setServerCode(200);
                response.setServerMessage("Doc send");
            }else{
                logger.info("doc move not found maybe its first move..");
                response.setServerCode(220);
                response.setServerMessage("its first time move");
            }
        }catch (Exception e){
            response.setServerCode(100);
            response.setServerMessage("Problem occurred when sending doc");
            logger.error("Error sending doc : ",e);
        }
        return response;
    }

    //    senedi geri cekme
    public ResponseForDocSend retractTheDocument(long idDoc,long idEmpFrom,int isDelete){
        ResponseForDocSend response=new ResponseForDocSend();
        try{
            DocumentMov documentMov=new DocumentMov();
            List<DocumentMov> docmov=repoDocumentMov.findByIdDocumentAndIdEmployeeFromAndIsDeleted(idDoc,idEmpFrom,0);

            if(docmov.size()>1){

            }

//                documentMov.setIdDocument(idDoc);
//                documentMov.setIdEmployeeFrom(idEmpFrom);
//                documentMov.setIsRead(1);
//                documentMov.setIsDeleted(1);
//                repoDocumentMov.save(documentMov);



        }catch (Exception e){
        response.setServerCode(100);
        response.setServerMessage("Problem occurred when sending doc");
        logger.error("Error sending doc : ",e);
    }
        return response;
    }



    public DocumentMovResponse saveDocumentMov(SaveDocumentMovRequest saveDocumentMovRequest) {
        DocumentMovResponse documentMovResponse= new DocumentMovResponse();
        try {
            DocumentMov documentMov = new DocumentMov();
            documentMov.setIdDocument(saveDocumentMovRequest.getIdDocument());
            documentMov.setIdEmployeeFrom(saveDocumentMovRequest.getIdEmployeeFrom());
            documentMov.setIdEmployeeTo(saveDocumentMovRequest.getIdEmployeeTo());
            documentMov.setIsActive(1);
            documentMov.setIsDeleted(0);
            documentMov.setNote(saveDocumentMovRequest.getNote());
            documentMov.setSendDate(saveDocumentMovRequest.getSendDate());
            documentMov.setIsAccepted(0);
            documentMov.setIsRead(0);
            documentMov.setReadDate(saveDocumentMovRequest.getReadDate());
            documentMov.setFinishDate(saveDocumentMovRequest.getFinishDate());
            documentMov.setIsMesul(saveDocumentMovRequest.getIsMesul());
            documentMov.setIsBirlesme(0);
            documentMov.setIsFinished(0);


            documentMov=repoDocumentMov.save(documentMov);
           documentMovResponse.setDocumentMov(documentMov);
            documentMovResponse.setServerCode(200);
            documentMovResponse.setServerMessage("OK");
            documentMovResponse.setStatusMessage("Saved");
            logger.info("saveDocument response : {}", saveDocumentMovRequest.toString());
        } catch (Exception e) {
            documentMovResponse.setServerCode(100);
            documentMovResponse.setServerMessage("error");
            documentMovResponse.setStatusMessage("No Saved");
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
                docMov.setIsAccepted(updateDocumentMovRequest.getIsAccepted());
                docMov.setIsRead(updateDocumentMovRequest.getIsRead());
                docMov.setReadDate(updateDocumentMovRequest.getReadDate());
                docMov.setIsMesul(updateDocumentMovRequest.getIsMesul());
                docMov.setFinishDate(updateDocumentMovRequest.getFinishDate());
                docMov.setIsBirlesme(0);
                docMov.setIsFinished(0);


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
            documentMovResponse.setServerMessage("error");
            documentMovResponse.setStatusMessage("No Update");
            logger.error("Error delete file text : {}", e);
        }
        return documentMovResponse;
    }



}



