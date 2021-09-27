package br.arungo.ecommerce.checkout.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Builder
@Data
@Entity
public class CheckoutEntity {

    @Id
    private Long id;

    @Column
    private String code;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Status status;

    public enum Status {
        CREATED,
        APPROVED
        }

}
