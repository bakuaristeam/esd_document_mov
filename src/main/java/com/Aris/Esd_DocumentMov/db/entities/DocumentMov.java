package com.Aris.Esd_DocumentMov.db.entities;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "documentMov")
public class DocumentMov{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDocumentMov", nullable = false, unique = true)

    private long idDocumentMov;
    private long idDocument;
    private long idEmployeeFrom;
    private long idEmployeeTo;
    private int isActive;
    private int isDeleted;
    private String note;
    private long  sendDate;
    private int isAccepted;
    private int isRead;
    private long readDate;
    private long finishDate;
    private int isMesul;
    private long parentId;
    @Nullable
    private String backNote;
    private int isBirlesme;
    private int isFinished;

    public DocumentMov(long idDocument, long idEmployeeFrom, long idEmployeeTo, int isActive, int isDeleted, String note, long sendDate, int isAccepted, int isRead, long readDate, long finishDate, int isMesul, long parentId, @Nullable String backNote, int isBirlesme, int isFinished) {
        this.idDocument = idDocument;
        this.idEmployeeFrom = idEmployeeFrom;
        this.idEmployeeTo = idEmployeeTo;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.note = note;
        this.sendDate = sendDate;
        this.isAccepted = isAccepted;
        this.isRead = isRead;
        this.readDate = readDate;
        this.finishDate = finishDate;
        this.isMesul = isMesul;
        this.parentId = parentId;
        this.backNote = backNote;
        this.isBirlesme = isBirlesme;
        this.isFinished = isFinished;
    }

    public DocumentMov() {
    }

    @Override
    public String toString() {
        return "DocumentMov{" +
                "idDocumentMov=" + idDocumentMov +
                ", idDocument=" + idDocument +
                ", idEmployeeFrom=" + idEmployeeFrom +
                ", idEmployeeTo=" + idEmployeeTo +
                ", isActive=" + isActive +
                ", isDeleted=" + isDeleted +
                ", note='" + note + '\'' +
                ", sendDate=" + sendDate +
                ", isAccepted=" + isAccepted +
                ", isRead=" + isRead +
                ", readDate=" + readDate +
                ", finishDate=" + finishDate +
                ", isMesul=" + isMesul +
                ", parentId=" + parentId +
                ", backNote='" + backNote + '\'' +
                ", isBirlesme=" + isBirlesme +
                ", isFinished=" + isFinished +
                '}';
    }

    public long getIdDocumentMov() {
        return idDocumentMov;
    }

    public void setIdDocumentMov(long idDocumentMov) {
        this.idDocumentMov = idDocumentMov;
    }

    public long getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(long idDocument) {
        this.idDocument = idDocument;
    }

    public long getIdEmployeeFrom() {
        return idEmployeeFrom;
    }

    public void setIdEmployeeFrom(long idEmployeeFrom) {
        this.idEmployeeFrom = idEmployeeFrom;
    }

    public long getIdEmployeeTo() {
        return idEmployeeTo;
    }

    public void setIdEmployeeTo(long idEmployeeTo) {
        this.idEmployeeTo = idEmployeeTo;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getSendDate() {
        return sendDate;
    }

    public void setSendDate(long sendDate) {
        this.sendDate = sendDate;
    }

    public int getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(int isAccepted) {
        this.isAccepted = isAccepted;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public long getReadDate() {
        return readDate;
    }

    public void setReadDate(long readDate) {
        this.readDate = readDate;
    }

    public long getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(long finishDate) {
        this.finishDate = finishDate;
    }

    public int getIsMesul() {
        return isMesul;
    }

    public void setIsMesul(int isMesul) {
        this.isMesul = isMesul;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    @Nullable
    public String getBackNote() {
        return backNote;
    }

    public void setBackNote(@Nullable String backNote) {
        this.backNote = backNote;
    }

    public int getIsBirlesme() {
        return isBirlesme;
    }

    public void setIsBirlesme(int isBirlesme) {
        this.isBirlesme = isBirlesme;
    }

    public int getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(int isFinished) {
        this.isFinished = isFinished;
    }
}
