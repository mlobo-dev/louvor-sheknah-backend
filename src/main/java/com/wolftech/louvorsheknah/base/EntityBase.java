package com.wolftech.louvorsheknah.base;

import javax.persistence.Id;
import java.io.Serializable;

public interface EntityBase<I extends Serializable> {
    @Id
    Serializable getId();
}
