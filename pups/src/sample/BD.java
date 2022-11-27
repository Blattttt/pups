package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class BD {
    private Integer Id;
    private String Number;
    private String Name;
    private String Date;
    private String Days;
    private String Actions;
    private String DayNumber;
    private String Starts;
    private String Moder;
    private String Jury1;
    private String Jury2;
    private String Jury3;
    private String Jury4;
    private String Jury5;
    private String Winner;

    public BD(int Id ,String Number, String Name, String Date, String Days, String Actions,
              String DayNumber, String Starts, String Moder, String Jury1, String Jury2,
              String Jury3, String Jury4, String Jury5, String Winner) {
        this.Id = Id;
        this.Number = Number;
        this.Name = Name;
        this.Date = Date;
        this.Days = Days;
        this.Actions = Actions;
        this.DayNumber = DayNumber;
        this.Starts = Starts;
        this.Moder = Moder;
        this.Jury1 = Jury1;
        this.Jury2 = Jury2;
        this.Jury3 = Jury3;
        this.Jury4 = Jury4;
        this.Jury5 = Jury5;
        this.Winner = Winner;
    }

    public BD() {}

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String Days) {
        this.Days = Days;
    }

    public String getActions() {
        return Actions;
    }

    public void setActions(String Actions) {
        this.Actions = Actions;
    }

    public String getDayNumber() {
        return DayNumber;
    }

    public void setDayNumber(String DayNumber) {
        this.DayNumber = DayNumber;
    }

    public String getStarts() {
        return Starts;
    }

    public void setStarts(String Starts) {
        this.Starts = Starts;
    }

    public String getModer() {
        return Moder;
    }

    public void setModer(String Moder) {
        this.Moder = Moder;
    }

    public String getJury1() {
        return Jury1;
    }

    public void setJury1(String Jury1) {
        this.Jury1 = Jury1;
    }

    public String getJury2() {
        return Jury2;
    }

    public void setJury2(String Jury2) {
        this.Jury2 = Jury2;
    }

    public String getJury3() {
        return Jury3;
    }

    public void setJury3(String Jury3) {
        this.Jury3 = Jury3;
    }

    public String getJury4() {
        return Jury4;
    }

    public void setJury4(String Jury4) {
        this.Jury4 = Jury4;
    }

    public String getJury5() {
        return Jury5;
    }

    public void setJury5(String Jury5) {
        this.Jury5 = Jury5;
    }

    public String getWinner() {
        return Winner;
    }

    public void setWinner(String Winner) {
        this.Winner = Winner;
    }
}