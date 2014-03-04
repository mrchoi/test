//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.7 ������ ���� ��Ǿ���ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// �� ��¥: 2014.02.10 �ð� 09:12:47 AM KST 
//


package com.mobilepark.uxcutor.dtdmodel;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
    "onsend",
    "onrecv",
    "onsuccess",
    "onerror",
    "ontimeout"
})
@XmlRootElement(name = "invoke")
public class Invoke {

    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "protocol", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String protocol;
    @XmlAttribute(name = "operation")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String operation;
    @XmlAttribute(name = "type")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "timeout")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String timeout;
    protected Onentry onentry;
    protected Onsend onsend;
    protected Onrecv onrecv;
    protected Onsuccess onsuccess;
    protected Onerror onerror;
    protected Ontimeout ontimeout;

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
     * protocol �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * protocol �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocol(String value) {
        this.protocol = value;
    }

    /**
     * operation �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperation() {
        return operation;
    }

    /**
     * operation �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperation(String value) {
        this.operation = value;
    }

    /**
     * type �Ӽ��� ���� �����ɴϴ�.
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
     * type �Ӽ��� ���� �����մϴ�.
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
     * timeout �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeout() {
        return timeout;
    }

    /**
     * timeout �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeout(String value) {
        this.timeout = value;
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
     * onsend �Ӽ��� ���� �����ɴϴ�.
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
     * onsend �Ӽ��� ���� �����մϴ�.
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
     * onrecv �Ӽ��� ���� �����ɴϴ�.
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
     * onrecv �Ӽ��� ���� �����մϴ�.
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
     * onsuccess �Ӽ��� ���� �����ɴϴ�.
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
     * onsuccess �Ӽ��� ���� �����մϴ�.
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
     * onerror �Ӽ��� ���� �����ɴϴ�.
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
     * onerror �Ӽ��� ���� �����մϴ�.
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
     * ontimeout �Ӽ��� ���� �����ɴϴ�.
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
     * ontimeout �Ӽ��� ���� �����մϴ�.
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
