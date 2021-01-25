/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ccks
 */
@Entity
@Table(name = "questions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questions.findAll", query = "SELECT q FROM Questions q")
    , @NamedQuery(name = "Questions.findByIdquestions", query = "SELECT q FROM Questions q WHERE q.idquestions = :idquestions")
    , @NamedQuery(name = "Questions.findByContent", query = "SELECT q FROM Questions q WHERE q.content = :content")})
public class Questions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idquestions")
    
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    
    private Integer idquestions;
    @Column(name = "content")
    private String content;
    @JoinColumn(name = "idanswer", referencedColumnName = "idanswer")
    @ManyToOne(optional = false)
    private Answer idanswer;
    @JoinColumn(name = "idcategories", referencedColumnName = "idcategories")
    @ManyToOne(optional = false)
    private Categories idcategories;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idquestions")
    private Collection<QuestionChoice> questionChoiceCollection;

    public Questions() {
    }

    public Questions(Integer idquestions) {
        this.idquestions = idquestions;
    }

    public Integer getIdquestions() {
        return idquestions;
    }

    public void setIdquestions(Integer idquestions) {
        this.idquestions = idquestions;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Answer getIdanswer() {
        return idanswer;
    }

    public void setIdanswer(Answer idanswer) {
        this.idanswer = idanswer;
    }

    public Categories getIdcategories() {
        return idcategories;
    }

    public void setIdcategories(Categories idcategories) {
        this.idcategories = idcategories;
    }

    @XmlTransient
    public Collection<QuestionChoice> getQuestionChoiceCollection() {
        return questionChoiceCollection;
    }

    public void setQuestionChoiceCollection(Collection<QuestionChoice> questionChoiceCollection) {
        this.questionChoiceCollection = questionChoiceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idquestions != null ? idquestions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questions)) {
            return false;
        }
        Questions other = (Questions) object;
        if ((this.idquestions == null && other.idquestions != null) || (this.idquestions != null && !this.idquestions.equals(other.idquestions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return content;
    }
    
}
