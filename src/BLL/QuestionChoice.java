/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ccks
 */
@Entity
@Table(name = "question_choice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuestionChoice.findAll", query = "SELECT q FROM QuestionChoice q")
    , @NamedQuery(name = "QuestionChoice.findByChoiceId", query = "SELECT q FROM QuestionChoice q WHERE q.choiceId = :choiceId")
    , @NamedQuery(name = "QuestionChoice.findByOptionA", query = "SELECT q FROM QuestionChoice q WHERE q.optionA = :optionA")
    , @NamedQuery(name = "QuestionChoice.findByOptionB", query = "SELECT q FROM QuestionChoice q WHERE q.optionB = :optionB")
    , @NamedQuery(name = "QuestionChoice.findByOptionC", query = "SELECT q FROM QuestionChoice q WHERE q.optionC = :optionC")
    , @NamedQuery(name = "QuestionChoice.findByOptionD", query = "SELECT q FROM QuestionChoice q WHERE q.optionD = :optionD")})
public class QuestionChoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "choiceId")
    
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    
    
    private Integer choiceId;
    @Column(name = "optionA")
    private String optionA;
    @Column(name = "optionB")
    private String optionB;
    @Column(name = "optionC")
    private String optionC;
    @Column(name = "optionD")
    private String optionD;
    @JoinColumn(name = "idquestions", referencedColumnName = "idquestions")
    @ManyToOne(optional = false)
    private Questions idquestions;

    public QuestionChoice() {
    }

    public QuestionChoice(Integer choiceId) {
        this.choiceId = choiceId;
    }

    public Integer getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(Integer choiceId) {
        this.choiceId = choiceId;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public Questions getIdquestions() {
        return idquestions;
    }

    public void setIdquestions(Questions idquestions) {
        this.idquestions = idquestions;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (choiceId != null ? choiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionChoice)) {
            return false;
        }
        QuestionChoice other = (QuestionChoice) object;
        if ((this.choiceId == null && other.choiceId != null) || (this.choiceId != null && !this.choiceId.equals(other.choiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.QuestionChoice[ choiceId=" + choiceId + " ]";
    }
    
}
