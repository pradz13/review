package com.project.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDateTime;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DateTimeLogger {

    private LocalDateTime createdTp = LocalDateTime.now();

    private LocalDateTime lastUpdatedTp = LocalDateTime.now();

}
