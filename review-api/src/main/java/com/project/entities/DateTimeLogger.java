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
@Builder
public class DateTimeLogger {
    @Builder.Default
    private LocalDateTime createdTp = LocalDateTime.now();

    @Builder.Default
    private LocalDateTime lastUpdatedTp = LocalDateTime.now();

}
