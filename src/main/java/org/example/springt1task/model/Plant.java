package org.example.springt1task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springt1task.annotation.Model;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Model
public class Plant {
    private String name;
    private String type;
}
