package com.Aris.Esd_DocumentMov.db.repo;

import com.Aris.Esd_DocumentMov.db.entities.DocumentMov;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepoDocumentMov extends CrudRepository<DocumentMov,Long> {

    DocumentMov findByIdDocumentMovAndIsActive(long idDocMov,int isActive);

    List<DocumentMov> findByIdDocumentAndIsActiveAndIsDeleted(long idDoc,int isActive,int isDelete);

    DocumentMov findByIdDocumentMov(long idDocMov);

    long countByIdEmployeeFromAndIsActiveAndIsDeleted(long idEmpFrom,int isActive,int isDelete);
    long countByIdEmployeeToAndIsActiveAndIsDeleted(long idEmpTo,int isActive,int isDelete);





    List<DocumentMov> findByIdDocumentAndIsActive(long idDoc,int isActive);

    DocumentMov findByIdDocumentMovAndIsDeleted(long idDocMov,int isDelete);
    List<DocumentMov> findByIdDocumentAndIsDeleted(long idDoc,int isDelete);

    List<DocumentMov> findByIdEmployeeFromAndIsActive(long idEmpFrom,int isActive);
    List<DocumentMov> findByIdEmployeeToAndIsActiveOrderByIdDocumentDesc(long idEmpTo,int isActive);
    DocumentMov findByIsAcceptedAndIsActive(int isAccepted,int isActive);
    List<DocumentMov>findByFinishDateAndIsActive(long finishDate,int isActive);

    List<DocumentMov>findByIsMesulAndIsActive(int isMesul,int isActive);

    DocumentMov findByIdDocumentMovAndIsActiveAndIsDeleted(long idDocMov,int isActive,int isDelete);

    List<DocumentMov> findByIdDocumentAndParentIdAndIsDeleted(long idDoc,long parentId,int isDelete);


    DocumentMov findByIdDocumentAndIsActiveAndIdEmployeeTo(long idDocument,int isActive,long employeeTo);

    List<DocumentMov> findByIdDocumentAndIdEmployeeFromAndIsDeleted(long idDoc,long idEmpFrom,int isDelete);

    List<DocumentMov> findByIdDocumentAndIdEmployeeToAndIsActiveAndIsDeleted(long idDoc,long idEmpTo,int isActive,int isDelete);





}
