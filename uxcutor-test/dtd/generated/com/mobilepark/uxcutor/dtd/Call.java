//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.10 at 09:48:02 AM KST 
//


package com.mobilepark.uxcutor.dtd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "call")
public class Call {

    @XmlAttribute(name = "type")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "dll")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String dll;
    @XmlAttribute(name = "function")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String function;
    @XmlAttribute(name = "mmf")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String mmf;
    @XmlAttribute(name = "store")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String store;
    @XmlAttribute(name = "checkerr")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String checkerr;
    @XmlValue
    protected String value;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the dll property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDll() {
        return dll;
    }

    /**
     * Sets the value of the dll property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDll(String value) {
        this.dll = value;
    }

    /**
     * Gets the value of the function property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunction() {
        return function;
    }

    /**
     * Sets the value of the function property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunction(String value) {
        this.function = value;
    }

    /**
     * Gets the value of the mmf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMmf() {
        return mmf;
    }

    /**
     * Sets the value of the mmf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMmf(String value) {
        this.mmf = value;
    }

    /**
     * Gets the value of the store property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStore() {
        return store;
    }

    /**
     * Sets the value of the store property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStore(String value) {
        this.store = value;
    }

    /**
     * Gets the value of the checkerr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckerr() {
        return checkerr;
    }

    /**
     * Sets the value of the checkerr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckerr(String value) {
        this.checkerr = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getvalue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setvalue(String value) {
        this.value = value;
    }

}