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
 * <p>Java class for Investment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Investment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="result" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="breakEven" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="totalProfitLoss" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="downPayment" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="closingCosts" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="InvestmentcumulativeYearlyCostsTable" type="{http://www.zillow.com/static/xsd/ZillowTypes.xsd}investmentCumulativeYearlyCostsTable" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Investment", propOrder = {
    "result",
    "breakEven",
    "totalProfitLoss",
    "downPayment",
    "closingCosts",
    "investmentcumulativeYearlyCostsTable"
})
public class Investment {

    @XmlElement(required = true)
    protected String result;
    @XmlElement(required = true)
    protected BigInteger breakEven;
    @XmlElement(required = true)
    protected BigInteger totalProfitLoss;
    @XmlElement(required = true)
    protected BigInteger downPayment;
    @XmlElement(required = true)
    protected BigInteger closingCosts;
    @XmlElement(name = "InvestmentcumulativeYearlyCostsTable", required = true)
    protected List<InvestmentCumulativeYearlyCostsTable> investmentcumulativeYearlyCostsTable;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResult(String value) {
        this.result = value;
    }

    /**
     * Gets the value of the breakEven property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBreakEven() {
        return breakEven;
    }

    /**
     * Sets the value of the breakEven property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBreakEven(BigInteger value) {
        this.breakEven = value;
    }

    /**
     * Gets the value of the totalProfitLoss property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalProfitLoss() {
        return totalProfitLoss;
    }

    /**
     * Sets the value of the totalProfitLoss property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalProfitLoss(BigInteger value) {
        this.totalProfitLoss = value;
    }

    /**
     * Gets the value of the downPayment property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDownPayment() {
        return downPayment;
    }

    /**
     * Sets the value of the downPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDownPayment(BigInteger value) {
        this.downPayment = value;
    }

    /**
     * Gets the value of the closingCosts property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getClosingCosts() {
        return closingCosts;
    }

    /**
     * Sets the value of the closingCosts property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setClosingCosts(BigInteger value) {
        this.closingCosts = value;
    }

    /**
     * Gets the value of the investmentcumulativeYearlyCostsTable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the investmentcumulativeYearlyCostsTable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvestmentcumulativeYearlyCostsTable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InvestmentCumulativeYearlyCostsTable }
     * 
     * 
     */
    public List<InvestmentCumulativeYearlyCostsTable> getInvestmentcumulativeYearlyCostsTable() {
        if (investmentcumulativeYearlyCostsTable == null) {
            investmentcumulativeYearlyCostsTable = new ArrayList<InvestmentCumulativeYearlyCostsTable>();
        }
        return this.investmentcumulativeYearlyCostsTable;
    }

}
