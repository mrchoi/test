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
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mapOrLoopOrSwitch"
})
@XmlRootElement(name = "loop")
public class Loop {

    @XmlAttribute(name = "mparam")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String mparam;
    @XmlAttribute(name = "value")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String value;
    @XmlAttribute(name = "isset")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String isset;
    @XmlAttribute(name = "length")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String length;
    @XmlAttribute(name = "mapper")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String mapper;
    @XmlAttribute(name = "counter")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String counter;
    @XmlAttribute(name = "max")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String max;
    @XmlElements({
        @XmlElement(name = "map", type = Map.class),
        @XmlElement(name = "loop", type = Loop.class),
        @XmlElement(name = "switch", type = Switch.class)
    })
    protected List<Object> mapOrLoopOrSwitch;

    /**
     * mparam �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMparam() {
        return mparam;
    }

    /**
     * mparam �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMparam(String value) {
        this.mparam = value;
    }

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
     * isset �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsset() {
        return isset;
    }

    /**
     * isset �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsset(String value) {
        this.isset = value;
    }

    /**
     * length �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLength() {
        return length;
    }

    /**
     * length �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLength(String value) {
        this.length = value;
    }

    /**
     * mapper �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMapper() {
        return mapper;
    }

    /**
     * mapper �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMapper(String value) {
        this.mapper = value;
    }

    /**
     * counter �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCounter() {
        return counter;
    }

    /**
     * counter �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCounter(String value) {
        this.counter = value;
    }

    /**
     * max �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMax() {
        return max;
    }

    /**
     * max �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMax(String value) {
        this.max = value;
    }

    /**
     * Gets the value of the mapOrLoopOrSwitch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapOrLoopOrSwitch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapOrLoopOrSwitch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Map }
     * {@link Loop }
     * {@link Switch }
     * 
     * 
     */
    public List<Object> getMapOrLoopOrSwitch() {
        if (mapOrLoopOrSwitch == null) {
            mapOrLoopOrSwitch = new ArrayList<Object>();
        }
        return this.mapOrLoopOrSwitch;
    }

}
