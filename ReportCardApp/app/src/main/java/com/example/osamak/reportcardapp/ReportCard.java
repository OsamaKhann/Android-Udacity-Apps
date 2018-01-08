package com.example.osamak.reportcardapp;

/**
 * Created by osamak on 9/1/17.
 */

public class ReportCard {

   private String studentName;
   private String operatingSystemGrade;
   private String designPatternGrade;
   private String computerArcitectureGrade;
   private String digitalLogicDesignGrade;

    public ReportCard(String studentName, String operatingSystemGrade, String designPatternGrade, String computerArcitectureGrade, String digitalLogicDesignGrade) {
        this.studentName = studentName;
        this.operatingSystemGrade = operatingSystemGrade;
        this.designPatternGrade = designPatternGrade;
        this.computerArcitectureGrade = computerArcitectureGrade;
        this.digitalLogicDesignGrade = digitalLogicDesignGrade;
    }

    public String getOperatingSystemGrade() {
        return operatingSystemGrade;
    }

    public void setOperatingSystemGrade(String operatingSystemGrade) {
        this.operatingSystemGrade = operatingSystemGrade;
    }

    public String getDesignPatternGrade() {
        return designPatternGrade;
    }

    public void setDesignPatternGrade(String designPatternGrade) {
        this.designPatternGrade = designPatternGrade;
    }

    public String getComputerArcitectureGrade() {
        return computerArcitectureGrade;
    }

    public void setComputerArcitectureGrade(String computerArcitectureGrade) {
        this.computerArcitectureGrade = computerArcitectureGrade;
    }

    public String getDigitalLogicDesignGrade() {
        return digitalLogicDesignGrade;
    }

    public void setDigitalLogicDesignGrade(String digitalLogicDesignGrade) {
        this.digitalLogicDesignGrade = digitalLogicDesignGrade;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public String toString() {
        return "Name: "+studentName + ","+ "     DesignPattern: "+designPatternGrade+","+
                "   Computer Arcitecture: "+computerArcitectureGrade+","+"  Design Logic Design: "+digitalLogicDesignGrade+
                ","+ "   Operating System: "+operatingSystemGrade;
    }
}
