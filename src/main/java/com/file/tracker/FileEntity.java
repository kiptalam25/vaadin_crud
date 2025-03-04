package com.file.tracker;

import jakarta.persistence.*;

@Entity
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String department;
    private String timestamp;

    // Constructors
    public FileEntity() {}
    public FileEntity(String fileName, String department, String timestamp) {
        this.fileName = fileName;
        this.department = department;
        this.timestamp = timestamp;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}
