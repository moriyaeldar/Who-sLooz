package com.whoslooz.whoslooz.entities;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("looz")
public class LoozItem {
    @Id
    private String id;

    private String name;

    private String days;

    public LoozItem(String id, String name, String days) {
        super();
        this.id = id;
        this.name = name;
        this.days = days;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }


}
