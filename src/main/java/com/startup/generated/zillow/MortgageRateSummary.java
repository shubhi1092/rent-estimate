//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.15 at 03:46:31 PM PDT 
//


package com.startup.generated.zillow;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MortgageRateSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MortgageRateSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="today" type="{http://www.zillow.com/static/xsd/ZillowTypes.xsd}MortgageRateList"/>
 *         &lt;element name="lastWeek" type="{http://www.zillow.com/static/xsd/ZillowTypes.xsd}MortgageRateList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MortgageRateSummary", propOrder = {
    "today",
    "lastWeek"
})
public class MortgageRateSummary {

    @XmlElement(required = true)
    protected MortgageRateList today;
    @XmlElement(required = true)
    protected MortgageRateList lastWeek;

    /**
     * Gets the value of the today property.
     * 
     * @return
     *     possible object is
     *     {@link MortgageRateList }
     *     
     */
    public MortgageRateList getToday() {
        return today;
    }

    /**
     * Sets the value of the today property.
     * 
     * @param value
     *     allowed object is
     *     {@link MortgageRateList }
     *     
     */
    public void setToday(MortgageRateList value) {
        this.today = value;
    }

    /**
     * Gets the value of the lastWeek property.
     * 
     * @return
     *     possible object is
     *     {@link MortgageRateList }
     *     
     */
    public MortgageRateList getLastWeek() {
        return lastWeek;
    }

    /**
     * Sets the value of the lastWeek property.
     * 
     * @param value
     *     allowed object is
     *     {@link MortgageRateList }
     *     
     */
    public void setLastWeek(MortgageRateList value) {
        this.lastWeek = value;
    }

}
