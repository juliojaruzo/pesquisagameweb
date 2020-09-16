package com.pesquisa.pesquisa.dto;

import java.io.Serializable;

public class RecordInsertDTO implements Serializable {

    private Long gameId;
    private String name;
    private String age;

    public RecordInsertDTO(){
    }

    public RecordInsertDTO(Long gameId, String name, String age) {
        this.gameId = gameId;
        this.name = name;
        this.age = age;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
