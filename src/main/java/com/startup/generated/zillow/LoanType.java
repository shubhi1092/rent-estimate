//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.15 at 03:46:31 PM PDT 
//


package com.startup.generated.zillow;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoanType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LoanType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="thirtyYearFixed"/>
 *     &lt;enumeration value="fifteenYearFixed"/>
 *     &lt;enumeration value="fiveOneARM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LoanType")
@XmlEnum
public enum LoanType {

    @XmlEnumValue("thirtyYearFixed")
    THIRTY_YEAR_FIXED("thirtyYearFixed"),
    @XmlEnumValue("fifteenYearFixed")
    FIFTEEN_YEAR_FIXED("fifteenYearFixed"),
    @XmlEnumValue("fiveOneARM")
    FIVE_ONE_ARM("fiveOneARM");
    private final String value;

    LoanType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LoanType fromValue(String v) {
        for (LoanType c: LoanType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
