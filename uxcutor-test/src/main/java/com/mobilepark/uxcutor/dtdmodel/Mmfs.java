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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mmf"
})
@XmlRootElement(name = "mmfs")
public class Mmfs {

    protected List<Mmf> mmf;

    /**
     * Gets the value of the mmf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mmf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMmf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Mmf }
     * 
     * 
     */
    public List<Mmf> getMmf() {
        if (mmf == null) {
            mmf = new ArrayList<Mmf>();
        }
        return this.mmf;
    }

}
