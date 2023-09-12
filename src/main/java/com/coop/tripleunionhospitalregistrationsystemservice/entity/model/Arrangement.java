package com.coop.tripleunionhospitalregistrationsystemservice.entity.Model;

public class Arrangement {
    private int arrangement_id;
    private String doctor_id;
    private String consulting_room_id;
    private int number_source_id;
    private int number;
    private String stop_state;

    public Arrangement() {
    }

    public Arrangement(int arrangement_id, String doctor_id, String consulting_room_id, int number_source_id, int number, String stop_state) {
        this.arrangement_id = arrangement_id;
        this.doctor_id = doctor_id;
        this.consulting_room_id = consulting_room_id;
        this.number_source_id = number_source_id;
        this.number = number;
        this.stop_state = stop_state;
    }

    public int getArrangement_id() {
        return arrangement_id;
    }

    public void setArrangement_id(int arrangement_id) {
        this.arrangement_id = arrangement_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getConsulting_room_id() {
        return consulting_room_id;
    }

    public void setConsulting_room_id(String consulting_room_id) {
        this.consulting_room_id = consulting_room_id;
    }

    public int getNumber_source_id() {
        return number_source_id;
    }

    public void setNumber_source_id(int number_source_id) {
        this.number_source_id = number_source_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStop_state() {
        return stop_state;
    }

    public void setStop_state(String stop_state) {
        this.stop_state = stop_state;
    }
}
