package com.dev4abyss.louvorsheknah.base;

import javax.persistence.Id;
import java.io.Serializable;

public interface EntityBase<I extends Serializable> {
    @Id
    Serializable getId();
}
