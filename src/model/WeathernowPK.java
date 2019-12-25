/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bill
 */
@Embeddable
public class WeathernowPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "CITYID")
    private int cityid;

    public WeathernowPK() {
    }

    public WeathernowPK(Date date, int cityid) {
        this.date = date;
        this.cityid = cityid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (date != null ? date.hashCode() : 0);
        hash += (int) cityid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WeathernowPK)) {
            return false;
        }
        WeathernowPK other = (WeathernowPK) object;
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        if (this.cityid != other.cityid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.WeathernowPK[ date=" + date + ", cityid=" + cityid + " ]";
    }
    
}
