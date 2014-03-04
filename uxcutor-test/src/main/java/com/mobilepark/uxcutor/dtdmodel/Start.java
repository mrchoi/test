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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "onentry",
    "onrecv",
    "_default"
})
@XmlRootElement(name = "start")
public class Start {

    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    protected Onentry onentry;
    protected List<Onrecv> onrecv;
    @XmlElement(name = "default")
    protected Default _default;

    /**
     * name �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * name �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * onentry �Ӽ��� ���� �����ɴϴ�.
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
     * onentry �Ӽ��� ���� �����մϴ�.
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
     * Gets the value of the onrecv property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the onrecv property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOnrecv().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Onrecv }
     * 
     * 
     */
    public List<Onrecv> getOnrecv() {
        if (onrecv == null) {
            onrecv = new ArrayList<Onrecv>();
        }
        return this.onrecv;
    }

    /**
     * default �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Default }
     *     
     */
    public Default getDefault() {
        return _default;
    }

    /**
     * default �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Default }
     *     
     */
    public void setDefault(Default value) {
        this._default = value;
    }

}
