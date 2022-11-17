package br.com.ren.server.dto;

import java.io.Serializable;

public class NameDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String first;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    @Override
    public String toString() {
        return "NameDTO{" +
                "first='" + first + '\'' +
                '}';
    }
}
