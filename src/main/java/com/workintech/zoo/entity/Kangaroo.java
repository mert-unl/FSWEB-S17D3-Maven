package com.workintech.zoo.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kangaroo {

    private long id;
    private String name;
    private double height;
    private double weight;
    private String gender;
    private Boolean isAggressive;

/*
    public boolean getIsAggressive() {
        return isAggressive;
    }

    public void setIsAggressive(boolean aggressive) {
        isAggressive = aggressive;
    }
*/

}