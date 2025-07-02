package kurs.programowania.webaplikacji.myownappbackend.models.records;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record CreateProductRequest(
    @NotBlank String name,
    @NotBlank String description,
    @Digits(integer = 5, fraction = 2) @PositiveOrZero BigDecimal price,
    @NotNull Boolean forSale
) {}
