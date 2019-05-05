package com.Aris.Esd_DocumentMov.Service.api.crudServices;

import com.Aris.Esd_DocumentMov.Service.internal.DocumentMovResponse;
import com.Aris.Esd_DocumentMov.Service.api.crudServices.internal.SaveDocumentMovRequest;
import com.Aris.Esd_DocumentMov.Service.api.crudServices.internal.UpdateDocumentMovRequest;
import com.Aris.Esd_DocumentMov.Service.internal.ResponseForDocSend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crudServices")
public class DocumentMovCrudServices {

    @Autowired
    DocumentMovCrudServiceInternal documentMovCrudServiceInternal;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @PostMapping("/add")
    public DocumentMovResponse saveDocMov(@RequestBody SaveDocumentMovRequest saveDocumentMovRequest) {

        logger.info("esd_document_mov->add->request : {}"+saveDocumentMovRequest.toString());

        return documentMovCrudServiceInternal.saveDocumentMov(saveDocumentMovRequest);

    }

    @PostMapping("/update")
    public DocumentMovResponse updateDoc(@RequestBody UpdateDocumentMovRequest updateDocumentMovRequest) {

        logger.info("esd_document_mov->update->request : {}"+updateDocumentMovRequest.toString());

        return documentMovCrudServiceInternal.updateDocumentMov(updateDocumentMovRequest);

    }


    @GetMapping("/delete/{idDocMov}")
    public DocumentMovResponse deleteDoc(@PathVariable("idDocMov")long idDocumentMov) {
        return documentMovCrudServiceInternal.deleteDocumentMov(idDocumentMov);
    }

    @GetMapping("/sendDoc/{idDoc}/{idEmpFrom}")
    public ResponseForDocSend sendingDocUpdate(@PathVariable("idDoc") long idDoc,
                                               @PathVariable("idEmpFrom") long idEmpFrom){
        return documentMovCrudServiceInternal.updateDocMoveForDocSend(idEmpFrom,idDoc);
    }

}
