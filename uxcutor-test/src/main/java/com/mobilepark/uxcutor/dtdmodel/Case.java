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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "callOrStatOrMapOrLoopOrSwitch"
})
@XmlRootElement(name = "case")
public class Case {

    @XmlAttribute(name = "value", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String value;
    @XmlAttribute(name = "cmpop")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cmpop;
    @XmlAttribute(name = "target", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String target;
    @XmlAttribute(name = "store")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String store;
    @XmlAttribute(name = "checkerr")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String checkerr;
    @XmlElements({
        @XmlElement(name = "call", type = Call.class),
        @XmlElement(name = "stat", type = Stat.class),
        @XmlElement(name = "map", type = Map.class),
        @XmlElement(name = "loop", type = Loop.class),
        @XmlElement(name = "switch", type = Switch.class)
    })
    protected List<Object> callOrStatOrMapOrLoopOrSwitch;

    /**
     * value �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * value �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * cmpop �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCmpop() {
        if (cmpop == null) {
            return "EQ";
        } else {
            return cmpop;
        }
    }

    /**
     * cmpop �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCmpop(String value) {
        this.cmpop = value;
    }

    /**
     * target �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarget() {
        return target;
    }

    /**
     * target �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarget(String value) {
        this.target = value;
    }

    /**
     * store �Ӽ��� ���� �����ɴϴ�.
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
     * store �Ӽ��� ���� �����մϴ�.
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
     * checkerr �Ӽ��� ���� �����ɴϴ�.
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
     * checkerr �Ӽ��� ���� �����մϴ�.
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
     * Gets the value of the callOrStatOrMapOrLoopOrSwitch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the callOrStatOrMapOrLoopOrSwitch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCallOrStatOrMapOrLoopOrSwitch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Call }
     * {@link Stat }
     * {@link Map }
     * {@link Loop }
     * {@link Switch }
     * 
     * 
     */
    public List<Object> getCallOrStatOrMapOrLoopOrSwitch() {
        if (callOrStatOrMapOrLoopOrSwitch == null) {
            callOrStatOrMapOrLoopOrSwitch = new ArrayList<Object>();
        }
        return this.callOrStatOrMapOrLoopOrSwitch;
    }

}
