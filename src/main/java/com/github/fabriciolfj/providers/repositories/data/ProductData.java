package com.github.fabriciolfj.providers.repositories.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product")
public class ProductData {

    @Id
    @SequenceGenerator(
            name = "productSeq",
            sequenceName = "product_id_seq",
            schema = "public",
            initialValue = 15,
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "productSeq")
    private Long id;
    private String code;
    private String describe;
    private BigDecimal price;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private CategoryData category;
}
