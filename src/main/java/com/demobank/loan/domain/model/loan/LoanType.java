package com.demobank.loan.domain.model.loan;

import com.demobank.loan.domain.model.common.BaseValueObject;

public enum LoanType implements BaseValueObject{

    PERSONAL {
        public boolean isPersonal() {
            return true;
        }
    },

    CAR {
        public boolean isCar() {
            return true;
        }
    };

    public boolean isPersonal() {
        return false;
    }

    public boolean isCar() {
        return false;
    }

    public LoanType regress() {
        if (this.isPersonal()) {
            return PERSONAL;
        } else if (this.isCar()) {
            return CAR;
        }

        return PERSONAL;
    }
}
