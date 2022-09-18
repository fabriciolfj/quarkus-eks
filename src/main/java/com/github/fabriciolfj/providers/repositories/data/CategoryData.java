package com.github.fabriciolfj.providers.repositories.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "category")
@Entity
public class CategoryData {

    @Id
    @SequenceGenerator(
            name = "categorySeq",
            sequenceName = "category_id_seq",
            schema = "public",
            initialValue = 15,
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "categorySeq")
    private Long id;
    private String describe;
}
