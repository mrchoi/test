//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.7 ������ ���� ��Ǿ���ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// �� ��¥: 2014.02.10 �ð� 09:12:47 AM KST 
//


package com.mobilepark.uxcutor.dtdmodel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "_enum",
    "struct",
    "union",
    "typedef"
})
@XmlRootElement(name = "ctypes")
public class Ctypes {

    @XmlElement(name = "enum")
    protected List<Enum> _enum;
    protected List<Struct> struct;
    protected List<Union> union;
    protected List<Typedef> typedef;

    /**
     * Gets the value of the enum property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enum property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnum().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Enum }
     * 
     * 
     */
    public List<Enum> getEnum() {
        if (_enum == null) {
            _enum = new ArrayList<Enum>();
        }
        return this._enum;
    }

    /**
     * Gets the value of the struct property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the struct property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStruct().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Struct }
     * 
     * 
     */
    public List<Struct> getStruct() {
        if (struct == null) {
            struct = new ArrayList<Struct>();
        }
        return this.struct;
    }

    /**
     * Gets the value of the union property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the union property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Union }
     * 
     * 
     */
    public List<Union> getUnion() {
        if (union == null) {
            union = new ArrayList<Union>();
        }
        return this.union;
    }

    /**
     * Gets the value of the typedef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the typedef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypedef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Typedef }
     * 
     * 
     */
    public List<Typedef> getTypedef() {
        if (typedef == null) {
            typedef = new ArrayList<Typedef>();
        }
        return this.typedef;
    }

}
