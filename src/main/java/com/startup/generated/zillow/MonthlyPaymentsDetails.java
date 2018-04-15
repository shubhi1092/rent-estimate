//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.15 at 03:46:31 PM PDT 
//


package com.startup.generated.zillow;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MonthlyPaymentsDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MonthlyPaymentsDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="monthlyPrincipalAndInterest" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="monthlyPropertyTaxes" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="monthlyHazardInsurance" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="monthlyPmi" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="monthlyHoaDues" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="totalMonthlyPayment" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="totalPayments" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="totalInterest" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="totalPrincipal" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="totalTaxesFeesAndInsurance" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="amortizationSchedule" type="{http://www.zillow.com/static/xsd/ZillowTypes.xsd}AmortizationSchedule" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MonthlyPaymentsDetails", propOrder = {
    "monthlyPrincipalAndInterest",
    "monthlyPropertyTaxes",
    "monthlyHazardInsurance",
    "monthlyPmi",
    "monthlyHoaDues",
    "totalMonthlyPayment",
    "totalPayments",
    "totalInterest",
    "totalPrincipal",
    "totalTaxesFeesAndInsurance",
    "amortizationSchedule"
})
public class MonthlyPaymentsDetails {

    @XmlElement(required = true)
    protected BigInteger monthlyPrincipalAndInterest;
    @XmlElement(required = true)
    protected BigInteger monthlyPropertyTaxes;
    @XmlElement(required = true)
    protected BigInteger monthlyHazardInsurance;
    @XmlElement(required = true)
    protected BigInteger monthlyPmi;
    @XmlElement(required = true)
    protected BigInteger monthlyHoaDues;
    @XmlElement(required = true)
    protected BigInteger totalMonthlyPayment;
    @XmlElement(required = true)
    protected BigInteger totalPayments;
    @XmlElement(required = true)
    protected BigInteger totalInterest;
    @XmlElement(required = true)
    protected BigInteger totalPrincipal;
    @XmlElement(required = true)
    protected BigInteger totalTaxesFeesAndInsurance;
    @XmlElement(required = true)
    protected List<AmortizationSchedule> amortizationSchedule;

    /**
     * Gets the value of the monthlyPrincipalAndInterest property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMonthlyPrincipalAndInterest() {
        return monthlyPrincipalAndInterest;
    }

    /**
     * Sets the value of the monthlyPrincipalAndInterest property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMonthlyPrincipalAndInterest(BigInteger value) {
        this.monthlyPrincipalAndInterest = value;
    }

    /**
     * Gets the value of the monthlyPropertyTaxes property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMonthlyPropertyTaxes() {
        return monthlyPropertyTaxes;
    }

    /**
     * Sets the value of the monthlyPropertyTaxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMonthlyPropertyTaxes(BigInteger value) {
        this.monthlyPropertyTaxes = value;
    }

    /**
     * Gets the value of the monthlyHazardInsurance property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMonthlyHazardInsurance() {
        return monthlyHazardInsurance;
    }

    /**
     * Sets the value of the monthlyHazardInsurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMonthlyHazardInsurance(BigInteger value) {
        this.monthlyHazardInsurance = value;
    }

    /**
     * Gets the value of the monthlyPmi property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMonthlyPmi() {
        return monthlyPmi;
    }

    /**
     * Sets the value of the monthlyPmi property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMonthlyPmi(BigInteger value) {
        this.monthlyPmi = value;
    }

    /**
     * Gets the value of the monthlyHoaDues property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMonthlyHoaDues() {
        return monthlyHoaDues;
    }

    /**
     * Sets the value of the monthlyHoaDues property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMonthlyHoaDues(BigInteger value) {
        this.monthlyHoaDues = value;
    }

    /**
     * Gets the value of the totalMonthlyPayment property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalMonthlyPayment() {
        return totalMonthlyPayment;
    }

    /**
     * Sets the value of the totalMonthlyPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalMonthlyPayment(BigInteger value) {
        this.totalMonthlyPayment = value;
    }

    /**
     * Gets the value of the totalPayments property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalPayments() {
        return totalPayments;
    }

    /**
     * Sets the value of the totalPayments property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalPayments(BigInteger value) {
        this.totalPayments = value;
    }

    /**
     * Gets the value of the totalInterest property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalInterest() {
        return totalInterest;
    }

    /**
     * Sets the value of the totalInterest property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalInterest(BigInteger value) {
        this.totalInterest = value;
    }

    /**
     * Gets the value of the totalPrincipal property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalPrincipal() {
        return totalPrincipal;
    }

    /**
     * Sets the value of the totalPrincipal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalPrincipal(BigInteger value) {
        this.totalPrincipal = value;
    }

    /**
     * Gets the value of the totalTaxesFeesAndInsurance property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalTaxesFeesAndInsurance() {
        return totalTaxesFeesAndInsurance;
    }

    /**
     * Sets the value of the totalTaxesFeesAndInsurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalTaxesFeesAndInsurance(BigInteger value) {
        this.totalTaxesFeesAndInsurance = value;
    }

    /**
     * Gets the value of the amortizationSchedule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the amortizationSchedule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAmortizationSchedule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmortizationSchedule }
     * 
     * 
     */
    public List<AmortizationSchedule> getAmortizationSchedule() {
        if (amortizationSchedule == null) {
            amortizationSchedule = new ArrayList<AmortizationSchedule>();
        }
        return this.amortizationSchedule;
    }

}
