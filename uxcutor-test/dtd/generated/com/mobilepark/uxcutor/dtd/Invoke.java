//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.10 at 09:48:02 AM KST 
//


package com.mobilepark.uxcutor.dtd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "onentry",
    "onsend",
    "onrecv",
    "onsuccess",
    "onerror",
    "ontimeout"
})
@XmlRootElement(name = "invoke")
public class Invoke {

    protected Onentry onentry;
    protected Onsend onsend;
    protected Onrecv onrecv;
    protected Onsuccess onsuccess;
    protected Onerror onerror;
    protected Ontimeout ontimeout;

    /**
     * Gets the value of the onentry property.
     * 
     * @return
     *     possible object is
     *     {@link Onentry }
     *     
     */
    public Onentry getOnentry() {
        return onentry;
    }

    /**
     * Sets the value of the onentry property.
     * 
     * @param value
     *     allowed object is
     *     {@link Onentry }
     *     
     */
    public void setOnentry(Onentry value) {
        this.onentry = value;
    }

    /**
     * Gets the value of the onsend property.
     * 
     * @return
     *     possible object is
     *     {@link Onsend }
     *     
     */
    public Onsend getOnsend() {
        return onsend;
    }

    /**
     * Sets the value of the onsend property.
     * 
     * @param value
     *     allowed object is
     *     {@link Onsend }
     *     
     */
    public void setOnsend(Onsend value) {
        this.onsend = value;
    }

    /**
     * Gets the value of the onrecv property.
     * 
     * @return
     *     possible object is
     *     {@link Onrecv }
     *     
     */
    public Onrecv getOnrecv() {
        return onrecv;
    }

    /**
     * Sets the value of the onrecv property.
     * 
     * @param value
     *     allowed object is
     *     {@link Onrecv }
     *     
     */
    public void setOnrecv(Onrecv value) {
        this.onrecv = value;
    }

    /**
     * Gets the value of the onsuccess property.
     * 
     * @return
     *     possible object is
     *     {@link Onsuccess }
     *     
     */
    public Onsuccess getOnsuccess() {
        return onsuccess;
    }

    /**
     * Sets the value of the onsuccess property.
     * 
     * @param value
     *     allowed object is
     *     {@link Onsuccess }
     *     
     */
    public void setOnsuccess(Onsuccess value) {
        this.onsuccess = value;
    }

    /**
     * Gets the value of the onerror property.
     * 
     * @return
     *     possible object is
     *     {@link Onerror }
     *     
     */
    public Onerror getOnerror() {
        return onerror;
    }

    /**
     * Sets the value of the onerror property.
     * 
     * @param value
     *     allowed object is
     *     {@link Onerror }
     *     
     */
    public void setOnerror(Onerror value) {
        this.onerror = value;
    }

    /**
     * Gets the value of the ontimeout property.
     * 
     * @return
     *     possible object is
     *     {@link Ontimeout }
     *     
     */
    public Ontimeout getOntimeout() {
        return ontimeout;
    }

    /**
     * Sets the value of the ontimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ontimeout }
     *     
     */
    public void setOntimeout(Ontimeout value) {
        this.ontimeout = value;
    }

}