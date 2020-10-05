package com.nvision.printstat.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "USER")
    private String user;

    @Column(name = "DEVICE")
    private String device;

    @Column(name = "AMOUNT")
    private Integer amount;

    @Column(name = "TIME")
    private LocalDateTime time;
}
