package com.demobank.loan.domain.model.transfer;

import java.io.Serializable;
import java.util.UUID;

import org.jmolecules.ddd.annotation.ValueObject;
import org.jmolecules.ddd.types.Identifier;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.util.Assert;

import com.demobank.loan.domain.model.common.BaseValueObject;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@ValueObject
public class TransferId implements Serializable, Comparable<TransferId>, Identifier, BaseValueObject{

    private static final long serialVersionUID = 1L;
    private final UUID id;
    @PersistenceCreator
    public TransferId(UUID id) {
        super();
        Assert.hasLength(id.toString(), "Transfer Id must not be empty");
        this.id = id;
    }
    public TransferId() {
        super();
        this.id = UUID.randomUUID();
    }
    @Override
    public int compareTo(TransferId transferId) {
        return this.getId().compareTo(transferId.getId());
    }
}
