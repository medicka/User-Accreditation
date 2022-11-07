package io.swagger.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class UserAccreditation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accreditation_id;

    @ManyToOne
    private ClientUser clientUser;

    @Column(name = "accreditation_type")
    private String accreditationType;

    @ManyToOne
    private Document document;

    @Column(name = "status")
    private String status;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public UserAccreditation() {
    }

    public UserAccreditation(ClientUser clientUser, String accreditationType, Document document, String status, Timestamp lastUpdate) {
        this.clientUser = clientUser;
        this.accreditationType = accreditationType;
        this.document = document;
        this.status = status;
        this.lastUpdate = lastUpdate;
    }

    public int getAccreditation_id() {
        return accreditation_id;
    }

    public void setAccreditation_id(int accreditation_id) {
        this.accreditation_id = accreditation_id;
    }

    public ClientUser getUser() {
        return clientUser;
    }

    public void setUser(ClientUser clientUser) {
        this.clientUser = clientUser;
    }

    public String getAccreditationType() {
        return accreditationType;
    }

    public void setAccreditationType(String accreditationType) {
        this.accreditationType = accreditationType;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
