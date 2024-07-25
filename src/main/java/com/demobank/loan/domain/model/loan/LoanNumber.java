package com.demobank.loan.domain.model.loan;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;
import org.jmolecules.ddd.types.Identifier;
import org.springframework.util.Assert;

import com.demobank.loan.domain.model.common.BaseValueObject;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@ValueObject
public class LoanNumber implements Serializable, Comparable<LoanNumber>, Identifier, BaseValueObject{

    private static final long serialVersionUID = 1L;
    private BigInteger number;
    private void setNumber(BigInteger id) {
        Objects.requireNonNull(id, "Account Id must not be empty");
        Assert.isTrue(id.compareTo(BigInteger.ZERO) > 0, "Account Id must be greater than zero");
        this.number = id;
    }
    public LoanNumber(BigInteger id) {
        super();
        this.setNumber(id);
    }
    @Override
    public int compareTo(LoanNumber loanNumber) {
        return this.getNumber().compareTo(loanNumber.getNumber());
    }
}
