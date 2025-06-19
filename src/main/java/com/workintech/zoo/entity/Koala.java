package com.workintech.zoo.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Koala {
    private long id;
    private String name;
    private double sleepHour;

    private double weight;
    private String gender;
}
