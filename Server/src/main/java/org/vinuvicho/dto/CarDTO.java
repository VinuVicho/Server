package org.vinuvicho.dto;

public class CarDTO {
    private Long id;
    private String type;
    private String name;

    public CarDTO() {
    }

    public CarDTO(final Long id, final String type, final String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}