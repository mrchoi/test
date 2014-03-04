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
    "start",
    "recvOrSendOrInvokeOrWaitOrSwitchOrLabel",
    "stop"
})
@XmlRootElement(name = "fsm")
public class Fsm {

    @XmlAttribute(name = "onerror")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String onerror;
    @XmlAttribute(name = "ontimeout")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String ontimeout;
    @XmlAttribute(name = "stat")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String stat;
    @XmlElement(required = true)
    protected Start start;
    @XmlElements({
        @XmlElement(name = "recv", type = Recv.class),
        @XmlElement(name = "send", type = Send.class),
        @XmlElement(name = "invoke", type = Invoke.class),
        @XmlElement(name = "wait", type = Wait.class),
        @XmlElement(name = "switch", type = Switch.class),
        @XmlElement(name = "label", type = Label.class)
    })
    protected List<Object> recvOrSendOrInvokeOrWaitOrSwitchOrLabel;
    @XmlElement(required = true)
    protected Stop stop;

    /**
     * onerror �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnerror() {
        return onerror;
    }

    /**
     * onerror �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnerror(String value) {
        this.onerror = value;
    }

    /**
     * ontimeout �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOntimeout() {
        return ontimeout;
    }

    /**
     * ontimeout �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOntimeout(String value) {
        this.ontimeout = value;
    }

    /**
     * stat �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStat() {
        return stat;
    }

    /**
     * stat �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStat(String value) {
        this.stat = value;
    }

    /**
     * start �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Start }
     *     
     */
    public Start getStart() {
        return start;
    }

    /**
     * start �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Start }
     *     
     */
    public void setStart(Start value) {
        this.start = value;
    }

    /**
     * Gets the value of the recvOrSendOrInvokeOrWaitOrSwitchOrLabel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recvOrSendOrInvokeOrWaitOrSwitchOrLabel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecvOrSendOrInvokeOrWaitOrSwitchOrLabel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Recv }
     * {@link Send }
     * {@link Invoke }
     * {@link Wait }
     * {@link Switch }
     * {@link Label }
     * 
     * 
     */
    public List<Object> getRecvOrSendOrInvokeOrWaitOrSwitchOrLabel() {
        if (recvOrSendOrInvokeOrWaitOrSwitchOrLabel == null) {
            recvOrSendOrInvokeOrWaitOrSwitchOrLabel = new ArrayList<Object>();
        }
        return this.recvOrSendOrInvokeOrWaitOrSwitchOrLabel;
    }

    /**
     * stop �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Stop }
     *     
     */
    public Stop getStop() {
        return stop;
    }

    /**
     * stop �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Stop }
     *     
     */
    public void setStop(Stop value) {
        this.stop = value;
    }

}
