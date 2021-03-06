package com.example.hospitalregistration.service.patientservice;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PatientForm {

    private final SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
    private static final Logger logger = LogManager.getLogger(PatientForm.class);

    //@Getter @Setter
    //private Long id;

    @Getter
    @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private int passportSerial;

    @Getter @Setter
    private String mail;

    @Getter @Setter
    private String doctorSpecialisation;

    @Getter @Setter
    private String toWhichDoctor;

    private Date dateOfVisitFormat_YYYY_MM_DD;

    private Date dateOfVisit;

    public void setDateOfVisit(String dateFromJson) { //свой сеттер ибо js возвращает строку и ее нужно парсить
        try{
            dateOfVisit = formater.parse(dateFromJson);
            dateOfVisitFormat_YYYY_MM_DD = formater1.parse(dateFromJson);
        }catch (Exception e){
            logger.warn(e.getMessage());
        }
    }
    public Date getDateOfVisit(){ //если свой сеттер то пусть будет свой геттер
        return dateOfVisit;
    }
    public Date getDateOfVisitFormat_YYYY_MM_DD(){return dateOfVisitFormat_YYYY_MM_DD;}

}
