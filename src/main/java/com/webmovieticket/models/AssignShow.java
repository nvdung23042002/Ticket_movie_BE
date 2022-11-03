package com.webmovieticket.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignShow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long show_id;

    private String morning;

    private String matney;

    private String firstShow;

    private String secondShow;

    private Date addShowDate;

    private Date toDate;
}
