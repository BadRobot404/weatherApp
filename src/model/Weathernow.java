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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bill
 */
@Entity
@Table(name = "WEATHERNOW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Weathernow.findAll", query = "SELECT w FROM Weathernow w")
    , @NamedQuery(name = "Weathernow.findByDate", query = "SELECT w FROM Weathernow w WHERE w.weathernowPK.date = :date")
    , @NamedQuery(name = "Weathernow.findByCityid", query = "SELECT w FROM Weathernow w WHERE w.weathernowPK.cityid = :cityid")
    , @NamedQuery(name = "Weathernow.findByTemperature", query = "SELECT w FROM Weathernow w WHERE w.temperature = :temperature")
    , @NamedQuery(name = "Weathernow.findByFeelslike", query = "SELECT w FROM Weathernow w WHERE w.feelslike = :feelslike")
    , @NamedQuery(name = "Weathernow.findByWindspeed", query = "SELECT w FROM Weathernow w WHERE w.windspeed = :windspeed")
    , @NamedQuery(name = "Weathernow.findByRain", query = "SELECT w FROM Weathernow w WHERE w.rain = :rain")
    , @NamedQuery(name = "Weathernow.findBySnow", query = "SELECT w FROM Weathernow w WHERE w.snow = :snow")
    , @NamedQuery(name = "Weathernow.findByIcon", query = "SELECT w FROM Weathernow w WHERE w.icon = :icon")
    , @NamedQuery(name = "Weathernow.findByHumidity", query = "SELECT w FROM Weathernow w WHERE w.humidity = :humidity")
    , @NamedQuery(name = "Weathernow.findByDescription", query = "SELECT w FROM Weathernow w WHERE w.description = :description")
    , @NamedQuery(name = "Weathernow.findByWinddirection", query = "SELECT w FROM Weathernow w WHERE w.winddirection = :winddirection")})
public class Weathernow implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WeathernowPK weathernowPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TEMPERATURE")
    private Double temperature;
    @Column(name = "FEELSLIKE")
    private Double feelslike;
    @Column(name = "WINDSPEED")
    private Double windspeed;
    @Column(name = "RAIN")
    private Double rain;
    @Column(name = "SNOW")
    private Double snow;
    @Column(name = "ICON")
    private String icon;
    @Column(name = "HUMIDITY")
    private Double humidity;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "WINDDIRECTION")
    private Integer winddirection;
    @JoinColumn(name = "CITYID", referencedColumnName = "CITYID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private City city;

    public Weathernow() {
    }

    public Weathernow(WeathernowPK weathernowPK) {
        this.weathernowPK = weathernowPK;
    }

    public Weathernow(WeathernowPK weathernowPK, String description) {
        this.weathernowPK = weathernowPK;
        this.description = description;
    }

    public Weathernow(Date date, int cityid) {
        this.weathernowPK = new WeathernowPK(date, cityid);
    }

    public WeathernowPK getWeathernowPK() {
        return weathernowPK;
    }

    public void setWeathernowPK(WeathernowPK weathernowPK) {
        this.weathernowPK = weathernowPK;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(Double feelslike) {
        this.feelslike = feelslike;
    }

    public Double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(Double windspeed) {
        this.windspeed = windspeed;
    }

    public Double getRain() {
        return rain;
    }

    public void setRain(Double rain) {
        this.rain = rain;
    }

    public Double getSnow() {
        return snow;
    }

    public void setSnow(Double snow) {
        this.snow = snow;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWinddirection() {
        return winddirection;
    }

    public void setWinddirection(Integer winddirection) {
        this.winddirection = winddirection;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (weathernowPK != null ? weathernowPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Weathernow)) {
            return false;
        }
        Weathernow other = (Weathernow) object;
        if ((this.weathernowPK == null && other.weathernowPK != null) || (this.weathernowPK != null && !this.weathernowPK.equals(other.weathernowPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Weathernow[ weathernowPK=" + weathernowPK + " ]";
    }
    
}
