package com.matc.entity;

import com.matc.persistence.LocalDateAttributeConverter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by student on 12/7/16.
 */
@Entity
@Table(name = "File")
public class SourceFile {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "f_id")
    private int fileId;

    @Column(name = "name")
    private String fileName;

    @Column(name = "source")
    private String source;

    @Column(name = "type")
    private String fileType;

    @Column(name = "date")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dateCreated;

    public SourceFile(String fileName, String source, String type) {
        this.fileName = fileName;
        this.fileType = type;
        this.source = source;
        this.dateCreated = LocalDate.now();
    }

    public SourceFile() {}

    public int getFileId() { return this.fileId; }
    public String getFileName() { return this.fileName; }
    public String getFileType() { return this.fileType; }
    public LocalDate getDateCreated() { return this.dateCreated; }
}
