package com.book.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(description = "Id of the Book", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String id;
    @Schema(description = "Title of the Book", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Title is required")
    private String title;
    @Schema(description = "Author of the Book", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Author is required")
    private String author;
    @Schema(description = "ISBN of the Book", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String isbn;
    @Schema(description = "PublicationYear of the Book", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "PublicationYear is required")
    private String publicationYear;
}
