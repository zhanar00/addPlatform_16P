package com.example.buysell.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "images") // Maps to the "images" table in the database
@Data // Lombok annotation to generate getters, setters, etc.
@AllArgsConstructor // Generates constructor with all fields
@NoArgsConstructor // Generates default no-args constructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto-generates ID values
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "original_file_name")
    private String originalFileName;

    @Column(name = "size")
    private Long size;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "is_preview_image")
    private boolean isPreviewImage; // Flag to indicate if this is the preview image

    @Lob // Stores large binary data (image bytes)
    private byte[] bytes;

    // Many images can belong to one product
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Product product;
}
