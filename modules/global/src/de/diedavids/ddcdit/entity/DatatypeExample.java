package de.diedavids.ddcdit.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "DDCDIT_DATATYPE_EXAMPLE")
@Entity(name = "ddcdit_DatatypeExample")
public class DatatypeExample extends StandardEntity {
    private static final long serialVersionUID = -5374723197455726341L;

    @Column(name = "LOCAL_DATE_TIME")
    protected LocalDateTime localDateTimeType;

    @Column(name = "STRING_TYPE")
    protected String stringType;

    public String getStringType() {
        return stringType;
    }

    public void setStringType(String stringType) {
        this.stringType = stringType;
    }

    public LocalDateTime getLocalDateTimeType() {
        return localDateTimeType;
    }

    public void setLocalDateTimeType(LocalDateTime localDateTimeType) {
        this.localDateTimeType = localDateTimeType;
    }
}