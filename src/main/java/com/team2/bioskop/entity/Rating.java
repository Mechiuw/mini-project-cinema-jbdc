package com.team2.bioskop.entity;
import com.team2.bioskop.service.RatingServiceImpl;

public class Rating {
    int id;
    String code;

    String description;
    public String codeUpdateOld;
    public String codeUpdateNew;
    public String descriptionUpdateOld;
    public String descriptionUpdateNew;


    public Rating(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public Rating(String codeUpdateOld, String descriptionUpdateOld, String codeUpdateNew, String descriptionUpdateNew) {
        this.codeUpdateOld = codeUpdateOld;
        this.descriptionUpdateOld = descriptionUpdateOld;
        this.codeUpdateNew = codeUpdateNew;
        this.descriptionUpdateNew = descriptionUpdateNew;
    }
    public String getCodeUpdateOld() {
        return codeUpdateOld;
    }

    public void setCodeUpdateOld(String codeUpdateOld) {
        this.codeUpdateOld = codeUpdateOld;
    }

    public String getCodeUpdateNew() {
        return codeUpdateNew;
    }

    public void setCodeUpdateNew(String codeUpdateNew) {
        this.codeUpdateNew = codeUpdateNew;
    }

    public String getDescriptionUpdateOld() {
        return descriptionUpdateOld;
    }

    public void setDescriptionUpdateOld(String descriptionUpdateOld) {
        this.descriptionUpdateOld = descriptionUpdateOld;
    }

    public String getDescriptionUpdateNew() {
        return descriptionUpdateNew;
    }

    public void setDescriptionUpdateNew(String descriptionUpdateNew) {
        this.descriptionUpdateNew = descriptionUpdateNew;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
