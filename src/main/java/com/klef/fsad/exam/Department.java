package com.klef.fsad.exam;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;

    @SuppressWarnings("deprecation")
	@Temporal(TemporalType.DATE)
    private Date date;

    private String status;

    public Department() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}