//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.10 at 09:48:02 AM KST 
//


package com.mobilepark.uxcutor.dtd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "functionOrScript"
})
@XmlRootElement(name = "functions")
public class Functions {

    @XmlElements({
        @XmlElement(name = "function", type = Function.class),
        @XmlElement(name = "script", type = Script.class)
    })
    protected List<Object> functionOrScript;

    /**
     * Gets the value of the functionOrScript property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the functionOrScript property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFunctionOrScript().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Function }
     * {@link Script }
     * 
     * 
     */
    public List<Object> getFunctionOrScript() {
        if (functionOrScript == null) {
            functionOrScript = new ArrayList<Object>();
        }
        return this.functionOrScript;
    }

}
