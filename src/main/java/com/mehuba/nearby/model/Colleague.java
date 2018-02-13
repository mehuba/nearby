package com.mehuba.nearby.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyibin on 16:52 13/02/2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Colleague {

    @Id
    public String id;

    public String name;
    public List<Recognition> recognitions;

    public Colleague() {
        this.recognitions = new ArrayList<>();
    }

    public Colleague(String name) {
        this.name = name;
        this.recognitions = new ArrayList<>();
    }

    public Colleague(String name, List<Recognition> recognitions) {
        this.name = name;
        this.recognitions = recognitions;
    }

    @Override
    public String toString() {
        return "Colleague{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", recognitions=" + recognitions +
            '}';
    }

    public static class Recognition {
        public String content;


        public Recognition(String content) {
            this.content = content;
        }

        public Recognition() {
        }

        @Override
        public String toString() {
            return "Recognition{" +
                "content='" + content + '\'' +
                '}';
        }
    }
}
