package com.sydads;

import com.sydads.tools.AcceptsVisitor;
import com.sydads.tools.Visitor;
import com.sydads.tools.VisitorTools;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 17/04/15
 */
@MappedSuperclass
public abstract class Guid implements Id, AcceptsVisitor {

    private String id;

    protected Guid() {
        id = generateUuid();
    }

    private String generateUuid() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("\\-", "");
    }

    @Override
    @javax.persistence.Id
    @Column(name = "id", length = 64)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void accept(Visitor visitor) {
        VisitorTools.doVisit(visitor, this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        boolean result = false;
        if (o instanceof Guid) {
            Guid guid = (Guid) o;

            if (this.getId() != null) {
                result = this.getId().equals(guid.getId());
            } else {
                if (guid.getId() == null) {
                    if (this.getClass().equals(guid.getClass())) {
                        result = super.equals(o);
                    }
                }
            }
        }
        return result;
    }
}